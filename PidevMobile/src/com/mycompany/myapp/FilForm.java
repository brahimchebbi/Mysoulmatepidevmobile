/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.RSSReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompagny.Service.PublicationService;
import com.mycompany.Entite.Commentaire;
import com.mycompany.Entite.Publication;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class FilForm extends Form {
   // final Resources res;
    Container home;
    EncodedImage enc;
    Image imgs;
    ImageViewer imgv;
    public static int modifid = -1 ;
    public FilForm(Resources res) {
         
        super("Fil Actualite");
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

      
    
         PublicationService serviceTask = new PublicationService();
         ArrayList<Publication> lis = serviceTask.getListPub();
          Container root = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         for (Publication t : lis) {
            Container root2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label label = new Label();
            int deviceWidth = Display.getInstance().getDisplayWidth() / 4;
            Image placeholder = Image.createImage(deviceWidth, deviceWidth); //square image set to 10% of screen width
            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
            label.setIcon(URLImage.createToStorage(encImage,
                    "Large_" + "http://localhost/images/products/uploads/" + t.getImage()
                    + "", "http://localhost/images/products/uploads/" + t.getImage()
                    + "", URLImage.RESIZE_SCALE_TO_FILL));

            Label l = new Label(t.getText());
            Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label label1 = new Label(t.getAdresse());
             

            Button partage = new Button("Partager sur FB");
            partage.setUIID("Partage");
          
            partage.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    String accessToken = "EAACEdEose0cBAO0atOpWDZCZC0dcMQUzss2nHDSRcA6idrrU1FMGHRwAcaFOZBhGSiloXSxt1jnzwZAqU9ogK2z2saQ286RoPRfHI90xQIw8c1IPmaHogaQORllQsssCsxjmCpAAQV6REFAuu1SVxDahFxC6S8uyqkJeXrgCoJbEE3PWdHTpsko2NWFblQHYWk4kiqZCrXcpZCRn2aH4eZC";

                    FacebookClient fbClient = new DefaultFacebookClient(accessToken);
                    FacebookType response = fbClient.publish("me/feed", FacebookType.class,
                            Parameter.with("message", t.getText() + "\n" + t.getAdresse()));
                    Dialog.show("Confirmation", "votre publication a ete partager sur facebook", "Ok", null);

                }

            });
            Button del = new Button("Supprimer");
            del.setUIID("delete");
          
            del.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    Dialog d = new Dialog();

                    if (Dialog.show("Confirmation", "delete this product??", "oui", "Annuler")) {
                        ConnectionRequest req = new ConnectionRequest();

                        req.setUrl("http://localhost/webservice/web/app_dev.php/Service/Publication/DeletePub/"
                                + t.getId_pub());
                        System.out.println(t.getId_pub());
                        NetworkManager.getInstance().addToQueue(req);
                        home.revalidate();
//                       PubliciteController pc = new PubliciteController(theme);
//                        pc.getForm().show();
                    new FilForm(res).show();

                    }
                }
            });
               Button Modif = new Button("Modifier");
            Modif.setUIID("delete");
          
            Modif.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    
              modifid= t.getId_pub();
              System.out.println(modifid);
              ModifierPublicationForm modif = new ModifierPublicationForm(res);
              modif.show();
                  //  System.out.println(modifid);

                    }
                
            });
             Container root3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
              TextField Comm = new TextField();
        
      
        Comm.setHint("Commentez");
         Comm.setUIID("AjoutFormField");
         
             Container root4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Commentaire c = new Commentaire(); 
            Label lab = new Label(c.getCommentaire());
        
       Button Comment = new Button("Commentez");
            Comment.setUIID("delete");
      
           
       
       
        
            C1.add(label);
            C1.add(l);
            C2.add(label1);
            C3.add(Comm);
           C4.add(lab);
          
            root2.add(C1);
            root2.add(C2);
            root3.add(C3);
            root3.add(C4);
          
            
            Container btn = new Container(new BoxLayout(BoxLayout.X_AXIS));

            btn.add(partage);
            btn.add(del);
            btn.add(Modif);
          Container btn1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
          btn1.add(Comment);
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
        
    }
    
    
}
