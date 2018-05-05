/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.DateSpinner;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.mycompagny.Service.RdvService;
import com.mycompany.Entite.Commentaire;
import com.mycompany.Entite.rdv;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author USER
 */
public class RdvForm extends Form{
    
    
      Container home;
    EncodedImage enc;
    Image imgs;
    ImageViewer imgv;
    public static int modifid = -1 ;
    public static int RdvId = -1;
    public RdvForm(Resources res) {
         
        super("RDV Liste");
        Toolbar tb = getToolbar();
        tb.setUIID("toolbar");
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);     
        fab.addActionListener(e -> {          
//            AddPublicite add= new AddPublicite(theme);
//            add.getForm().show();
             // new AddPublicite(theme).show();
        });
          this.setUIID("AjoutForm");
          
          home = new Container(new BoxLayout(BoxLayout.Y_AXIS));

      
    
         RdvService service = new RdvService();
         ArrayList<rdv> lis = service.getListRdv();
          Container root = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         for (rdv t : lis) {
             Label idRdv = new Label("id RDV:" + t.getIdrdv());
              String str = idRdv.getText();
              List<String> parts = StringUtil.tokenize(str, ":");
               final String idRendezvous;
                idRendezvous = parts.get(1).substring(0);
                 int ids = Integer.parseInt(idRendezvous);
            Container root2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label label = new Label();
            int deviceWidth = Display.getInstance().getDisplayWidth() / 4;
            Image placeholder = Image.createImage(deviceWidth, deviceWidth); //square image set to 10% of screen width
            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
            label.setIcon(URLImage.createToStorage(encImage,
                    "Large_" + "http://localhost/images/products/" + t.getImage_name()
                    + "", "http://localhost/images/products/" + t.getImage_name()
                    + "", URLImage.RESIZE_SCALE_TO_FILL));

            Label l = new Label(t.getNomrdv());
            Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label label1 = new Label(t.getAdresse());
 
             Container root3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                TextField nbp = new TextField();
                nbp.setHint("Nombre De Place");
                nbp.setUIID("AjoutFormField");
                Container C5 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                DateSpinner datedeb=new DateSpinner();
               
                         datedeb.setUIID("AjoutFormField");

             Container root4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
          
            Container C4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Commentaire c = new Commentaire(); 
          
            
       Button reserve = new Button("Reservez");
            reserve.setUIID("delete");
      
           reserve.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                     int day = datedeb.getCurrentDay();
                int month =datedeb.getCurrentMonth();
                int year = datedeb.getCurrentYear();
                Date date = null;
                
                    System.out.println(day + " "+ month + " "+ year);
                    String datestring = year+"/"+month+"/"+day;
                    System.out.println(datestring);
                    DateFormat Format = new SimpleDateFormat("yyyy/MM/dd");
                    try {
                         date = Format.parse(datestring);
                         System.out.println("datedate"+date);
                    } catch (ParseException ex) {
                        
                    }
                           System.out.println(idRendezvous);

                                System.out.println("PubId:" + ids);
                              
                                RdvService pre = new RdvService();

                                if (Dialog.show("Confirmer", "Voulez vous Ajouter ce commentaire ?", "Oui", "Non")) {
                                    int nombre = Integer.parseInt(nbp.getText());
                                    pre.ajoutres(ids,date, nombre);

                                    Message m = new Message("Vous avez reservez ce rendez-vous" + t.getNomrdv());

                                      Dialog d = new Dialog("--Rendez-vouz--");

                                    TextArea popupBody = new TextArea("l'adminstrateur  est notifie ", 4, 12);

                                    popupBody.setUIID("PopupBody");
                                    popupBody.setEditable(false);
                                    d.setLayout(new BorderLayout());
                                    d.add(BorderLayout.CENTER, popupBody);

                                    d.showPopupDialog(reserve);
                                    LocalNotification n = new LocalNotification();
                                    n.setId("AFK-notifications");
                                    n.setAlertBody("Vous avez une reservation!");
                                    n.setAlertTitle("AFK Comment System!");
                                    Display.getInstance().scheduleLocalNotification(
                                            n,
                                            System.currentTimeMillis() + 10, // fire date/time
                                            LocalNotification.REPEAT_NONE // Whether to repeat and what frequency
                                    );

                                }
                 
             FilForm fil = new FilForm(res);
             fil.show();
                  
                    
                }
            });
       
             
        
            C1.add(label);
            C1.add(l);
            C2.add(label1);
            C3.add(nbp);
            C5.add(datedeb);
           
          
            root2.add(C1);
            root2.add(C2);
            root3.add(C3);
            root3.add(C4);
          root3.add(C5);
            
            Container btn = new Container(new BoxLayout(BoxLayout.X_AXIS));

            
          Container btn1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
          btn1.add(reserve);
            root2.add(btn);
            root3.add(btn1);
            root.add(root2);
            root.add(root3);
           

        }
         home.add(root);
            add(home);
        
        
        
        
         this.addCommand(new Command("Fil Actualite") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                FilForm Fil = new FilForm(res);
                Fil.show();
                
            }
            
        });
        
        this.setBackCommand(new Command("Ajouter Publication") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                AjouterPublicationForm Ajout =new AjouterPublicationForm(res);
                Ajout.show();
            }
            
        });
        
       this.setBackCommand(new Command("Rendez-vous Liste") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                RdvForm RDV =new RdvForm(res);
                RDV.show();
            }
            
        });
        
    
}
}
