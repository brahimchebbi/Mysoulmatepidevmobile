/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
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
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.mycompagny.Service.CommentaireService;
import com.mycompagny.Service.PublicationService;
import com.mycompagny.Service.RdvService;
import com.mycompany.Entite.Commentaire;
import com.mycompany.Entite.Publication;
import com.mycompany.Entite.rdv;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import java.util.ArrayList;
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
    public static int CommPubId = -1;
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
             Label idRdv = new Label("id Pub:" + t.getIdrdv());
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
                TextField Comm = new TextField();
                Comm.setHint("Nombre De Place");
                Comm.setUIID("AjoutFormField");
                
         
             Container root4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
          
            Container C4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Commentaire c = new Commentaire(); 
          
            
       Button reserve = new Button("Reservez");
            reserve.setUIID("delete");
      
           reserve.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    
                    
                           System.out.println(idRendezvous);

                                System.out.println("PubId:" + ids);
                              
                                CommentaireService pre = new CommentaireService();

                                if (Dialog.show("Confirmer", "Voulez vous Ajouter ce commentaire ?", "Oui", "Non")) {
                                    pre.ajoutcomm(ids, Comm.getText());

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
//                    CommPubId= t.getId_pub();
//                     CommentaireService ser = new CommentaireService();
//            Commentaire comment = new Commentaire();
//            comment.setIdPub(CommPubId);
//            comment.setCommentaire(Comm.getText());
//                               System.out.println(CommPubId);
//
//            ser.ajoutComm(comment);
             FilForm fil = new FilForm(res);
             fil.show();
                  //  System.out.println(comment.getIdPub()+""+comment.getCommentaire());
                    
                }
            });
       
       
        
            C1.add(label);
            C1.add(l);
            C2.add(label1);
            C3.add(Comm);
           
          
            root2.add(C1);
            root2.add(C2);
            root3.add(C3);
            root3.add(C4);
          
            
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
