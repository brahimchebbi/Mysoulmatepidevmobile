///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.myapp;
//
//import com.codename1.components.FloatingActionButton;
//import com.codename1.components.ImageViewer;
//import com.codename1.io.ConnectionRequest;
//import com.codename1.io.NetworkManager;
//import com.codename1.messaging.Message;
//import com.codename1.notifications.LocalNotification;
//import com.codename1.ui.Button;
//import com.codename1.ui.Command;
//import com.codename1.ui.Container;
//import com.codename1.ui.Dialog;
//import com.codename1.ui.Display;
//import com.codename1.ui.EncodedImage;
//import com.codename1.ui.FontImage;
//import com.codename1.ui.Form;
//import com.codename1.ui.Image;
//import com.codename1.ui.Label;
//import com.codename1.ui.TextArea;
//import com.codename1.ui.TextField;
//import com.codename1.ui.Toolbar;
//import com.codename1.ui.URLImage;
//import com.codename1.ui.events.ActionEvent;
//import com.codename1.ui.events.ActionListener;
//import com.codename1.ui.layouts.BorderLayout;
//import com.codename1.ui.layouts.BoxLayout;
//import com.codename1.ui.util.Resources;
//import com.codename1.util.StringUtil;
//import com.mycompagny.Service.CommentaireService;
//import com.mycompagny.Service.PublicationService;
//import com.mycompagny.Service.RdvService;
//import com.mycompany.Entite.Commentaire;
//import com.mycompany.Entite.Publication;
//import com.mycompany.Entite.reservation;
//import com.restfb.DefaultFacebookClient;
//import com.restfb.FacebookClient;
//import com.restfb.Parameter;
//import com.restfb.types.FacebookType;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author USER
// */
//public class ReservationForm extends Form{
//     Container home;
//    EncodedImage enc;
//    Image imgs;
//    ImageViewer imgv;
//    public static int modifid = -1 ;
//    public static int CommPubId = -1;
//    public ReservationForm(Resources res) {
//         
//        super("Liste Des Reservation");
//        Toolbar tb = getToolbar();
//        tb.setUIID("toolbar");
//        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);     
//        fab.addActionListener(e -> {          
////            AddPublicite add= new AddPublicite(theme);
////            add.getForm().show();
//             // new AddPublicite(theme).show();
//        });
//          this.setUIID("AjoutForm");
//          
//          home = new Container(new BoxLayout(BoxLayout.Y_AXIS));
//
//      
//     
//            
//              
//               String str = idsta.getText();
//             List<String> parts = StringUtil.tokenize(str, ":");
//            final String idstage;
//            idstage = parts.get(1).substring(0);
//            int ids = Integer.parseInt(idstage);
//         RdvService service = new RdvService();
//         ArrayList<reservation> lis = service.getListR(ids);
//          Container root = new Container(new BoxLayout(BoxLayout.Y_AXIS));
//         for (reservation t : lis) {
//            Label idsta = new Label("id stage:" + t.getIdreservation());
//          
//            Container root2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
//            Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
//            
//            Label l = new Label(t.getText());
//            Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
//            Label label1 = new Label(t.getAdresse());
//             
//
//           
//            Button del = new Button("Supprimer");
//            del.setUIID("delete");
//          
//            del.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent evt) {
//
//                    Dialog d = new Dialog();
//
//                    if (Dialog.show("Confirmation", "delete this product??", "oui", "Annuler")) {
//                        ConnectionRequest req = new ConnectionRequest();
//
//                        req.setUrl("http://localhost/webservice/web/app_dev.php/Service/Publication/DeletePub/"
//                                + t.getId_pub());
//                        System.out.println(t.getId_pub());
//                        NetworkManager.getInstance().addToQueue(req);
//                        home.revalidate();
////                       PubliciteController pc = new PubliciteController(theme);
////                        pc.getForm().show();
//                    new FilForm(res).show();
//
//                    }
//                }
//            });
//               
//             Container root3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
//            Container C3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
//              TextField Comm = new TextField();
//        
//      
//        Comm.setHint("Commentez");
//         Comm.setUIID("AjoutFormField");
//         
//
//       
//       
//        
//            
//            C1.add(l);
//            C2.add(label1);
//            C3.add(Comm);
//           
//          
//            root2.add(C1);
//            root2.add(C2);
//            root3.add(C3);
//            
//          
//            
//            Container btn = new Container(new BoxLayout(BoxLayout.X_AXIS));
//
//          
//            btn.add(del);
//          Container btn1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
//         
//            root2.add(btn);
//            root3.add(btn1);
//            root.add(root2);
//            root.add(root3);
//           
//
//        }
//         home.add(root);
//            add(home);
//        
//        
//        
//        
//         this.addCommand(new Command("Fil Actualite") {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                FilForm Fil = new FilForm(res);
//                Fil.show();
//                
//            }
//            
//        });
//        
//        this.setBackCommand(new Command("Ajouter Publication") {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                AjouterPublicationForm Ajout =new AjouterPublicationForm(res);
//                Ajout.show();
//            }
//            
//        });
//        
//        
//         this.setBackCommand(new Command("Rendez-vous Liste") {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                RdvForm RDV =new RdvForm(res);
//                RDV.show();
//            }
//            
//        });
//        
//    }
//    
//}
