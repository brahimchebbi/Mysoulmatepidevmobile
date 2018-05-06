/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;
import com.codename1.capture.Capture;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.InteractionDialog;
import com.codename1.components.ToastBar;
import com.codename1.maps.Coord;
import com.codename1.notifications.LocalNotification;
 import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompagny.Service.PublicationService;
import com.mycompany.Entite.Publication;
import rest.file.uploader.tn.FileUploader;

/**
 *
 * @author shannah
 */
public class AjouterPublicationForm extends Form {
    final Resources res;
    String imgPath; 
    String fileNameInServer;
     private static final String HTML_API_KEY = "AIzaSyDUiPfabJtrpjjj1Ix1vBsl1fKG_kzmeMw";
    public AjouterPublicationForm(Resources res) {
        super("Ajouter Publication");
         Toolbar tb = getToolbar();
        tb.setUIID("toolbar");
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);     
        fab.addActionListener(e -> {          
//            AddPublicite add= new AddPublicite(theme);
//            add.getForm().show();
             // new AddPublicite(theme).show();
        });
        this.setUIID("AjoutForm");
        this.res = res;
        setLayout(new BorderLayout());
        Container north = new Container(new FlowLayout(Component.CENTER));
        
      
        Button photoButton = new Button("Ajouter Photo");
       photoButton.setUIID("AjouterButton");
        north.addComponent(photoButton);
        photoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        imgPath = Capture.capturePhoto();
                       // img = Image.createImage(imgPath);    
                      // iv.setImage(img);
                       // file = new FileUploader(imgPath);
                        System.out.println(imgPath);
                        String link = imgPath.toString();
                        int pod= link.indexOf("/", 2);
                        String news = link.substring(pod+2, link.length());
                        System.out.println("------------"+news);
                     
      FileUploader fu = new FileUploader("http://localhost/images/products/");
        
        //Upload
        fileNameInServer = fu.upload(news);
                        System.out.println("-----------"+fileNameInServer+"---------------");
                        System.out.println("photo ajouter");
                                
        
       
                     
                    
                    } catch (Exception ex) {
                        System.out.println("merci");
                  
                }

          
                
            }
            });
        this.addComponent(BorderLayout.NORTH, north);
        
        Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        
        
         center.setUIID("AjoutFormCenter");
        
        Container row1 = new Container(new GridLayout(1));
        TextField text = new TextField();
        text.setHint("Exprimez-vous");
         text.setUIID("AjoutFormField");
        row1.addComponent(text);
        center.addComponent(row1);
        center.setScrollableY(true);
        
        TextField adresse = new TextField();
        
        center.addComponent(adresse);
        adresse.setHint(" Addresse");
         adresse.setUIID("AjoutFormField");
        TextField altitude = new TextField();
        
        center.addComponent(altitude);
        altitude.setHint(" Altitude");
                 altitude.setUIID("AjoutFormField");
altitude.setHidden(true);
      TextField longitude = new TextField();
        
        center.addComponent(longitude);
        longitude.setHint(" Longitude");
                         longitude.setUIID("AjoutFormField");

       longitude.setHidden(true);
       
        
        this.addComponent(BorderLayout.CENTER, center);

        Button AjouterB = new Button("Ajouter Publication");
AjouterB.setUIID("AjouterButton");
        AjouterB.setTextPosition(Component.LEFT);
        
        this.addComponent(BorderLayout.SOUTH, AjouterB);
         AjouterB.addActionListener((e) -> {
                 if (text.getText().equals(" ") || text.getText().equals("")){
               
                    Dialog.show("Ajout Publication"," champ est vide " ,"ok",null);
                 
             }
             else{
            PublicationService ser = new PublicationService();
            Publication t = new Publication();
            t.setAdresse(adresse.getText());
            t.setText(text.getText());
            t.setImage(fileNameInServer);
            ser.ajoutPub(t);
           
             FilForm fil = new FilForm(res);
             fil.show();
            
            System.out.println(text.getText() + " " + adresse.getText()+""+fileNameInServer);
                 }
        });
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