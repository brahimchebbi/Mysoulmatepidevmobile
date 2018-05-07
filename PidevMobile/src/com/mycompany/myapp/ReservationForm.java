/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.FloatingActionButton;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.mycompagny.Service.RdvService;
import com.mycompany.Entite.reservation;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.DatePicker;

/**
 *
 * @author USER
 */
public class ReservationForm extends Form{
    Container home;
 public ReservationForm(Resources res) {
         
        super("Liste Des Reservations");
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
    
    RdvService prc = new RdvService();
             ArrayList<reservation> list = prc.getListR(RdvForm.ListResid);
          Container root = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                            for (reservation pr : list) {
                                 Container root5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                                 Container CAff = new Container(new BoxLayout(BoxLayout.X_AXIS));
                                        
                            Label idenca = new Label("id reservation:" + pr.getIdreservation());

                                String strr = idenca.getText();

                                List<String> part = StringUtil.tokenize(strr, ":");
                                final String idstaache;
                                idstaache = part.get(1).substring(0);
                                int idt = Integer.parseInt(idstaache);
                                Label Titre = new Label(
                                        "--|--|--|Reservation|--|--|--"
                                
                                
                                );
                                                                                    
                                Titre.setUIID("CommTitre");
                                String datestring = "Date : "+pr.getDatedebut();
            Label Commlab = new Label(datestring);
            Container Cnb = new Container(new BoxLayout(BoxLayout.X_AXIS));
            String nbplace = "Nombre De Place :  "+pr.getNbrplacereserver();
                                Label place = new Label(nbplace);
            Button DelBu = new Button("supprimer");
              DelBu.setUIID("delete");
              DelBu.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent evt) {
                                           Dialog d = new Dialog();

                    if (Dialog.show("Confirmation", "Supprimez Cette Reservation??", "oui", "Annuler")) {
                        ConnectionRequest req = new ConnectionRequest();

                        req.setUrl("http://localhost/webservice/web/app_dev.php/Service/Publication/DeletRES/"
                                + pr.getIdreservation());
                        System.out.println(pr.getIdreservation());
                        NetworkManager.getInstance().addToQueue(req);
                        home.revalidate();
//                       PubliciteController pc = new PubliciteController(theme);
//                        pc.getForm().show();
                    new ReservationForm(res).show();

                    }
                                     }
                                 });
            
            CAff.add(Commlab);
            Cnb.add(place);
             root5.add(Titre);
            root5.add(CAff);
            root5.add(Cnb);
            Container btn = new Container(new BoxLayout(BoxLayout.X_AXIS));

            btn.add(DelBu);
            root5.add(btn);
            root.add(root5);
    
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

        this.setBackCommand(new Command("Matching") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                MatchingGUI M = new MatchingGUI();
                M.AfficherMatchingMenu();
            }

        });

        this.setBackCommand(new Command("Mon Profile") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                ProfileGUI P = new ProfileGUI();
                P.ShowProfil();
            }

        });

        this.setBackCommand(new Command("Ajouter Publication") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                AjouterPublicationForm Ajout = new AjouterPublicationForm(res);
                Ajout.show();

            }

        });

        this.setBackCommand(new Command("Rendez-vous Liste") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                RdvForm RDV = new RdvForm(res);
                RDV.show();
            }

        });

        this.setBackCommand(new Command("Deconnexion") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                LoginGUI L = new LoginGUI();
                L.LoginInterfaceShow();
            }

        });

 }
 
}