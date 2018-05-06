/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.mycompagny.Service.CommentaireService;
import com.mycompany.Entite.Commentaire;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class ListCommentaireForm extends Form{
    Container home;
 public ListCommentaireForm(Resources res) {
         
        super("Liste Des Commentaires");
        Toolbar tb = getToolbar();
        tb.setUIID("toolbar");
        
        tb.addCommandToRightBar("Back", null, (ev)->{ });
         tb.addCommandToRightBar("Back", null, (ev)->{ Resources theme = UIManager.initFirstTheme("/theme"); FilForm F = new FilForm(theme); F.show(); });
        
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);     
        fab.addActionListener(e -> {          
//            AddPublicite add= new AddPublicite(theme);
//            add.getForm().show();
             // new AddPublicite(theme).show();
        });
          this.setUIID("AjoutForm");
          
          home = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    
    CommentaireService prc = new CommentaireService();
             ArrayList<Commentaire> list = prc.getListComm(FilForm.CommPubId);
          Container root = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                            for (Commentaire pr : list) {
                                 Container root5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                                 Container CAff = new Container(new BoxLayout(BoxLayout.X_AXIS));
                                        
                            Label idenca = new Label("id commentaire:" + pr.getId());

                                String strr = idenca.getText();

                                List<String> part = StringUtil.tokenize(strr, ":");
                                final String idstaache;
                                idstaache = part.get(1).substring(0);
                                int idt = Integer.parseInt(idstaache);
                                Label Titre = new Label(
                                        "--|--|--|Commentaire|--|--|--"
                                
                                
                                );
                                                                                    
                                Titre.setUIID("CommTitre");
            Label Commlab = new Label(pr.getCommentaire());
            
            
            CAff.add(Commlab);
             root5.add(Titre);
            root5.add(CAff);
           
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
               MatchingGUI  M = new MatchingGUI();
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
         
           this.setBackCommand(new Command("Deconnexion") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                LoginGUI L = new LoginGUI();
                L.LoginInterfaceShow();
            }
            
        });
         
         
 }
 
}