/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author CorpseRoot
 */
public class DateProfile {

    public void ShowDateInfo() {
        Form h = new Form(MatchesGUI.UserToShow.getNom(), new BorderLayout());
        h.setUIID("AjoutForm");
        Toolbar tb = h.getToolbar();
        tb.setUIID("toolbar");
        Container topBar = new Container();
        // topBar.add(BorderLayout.SOUTH, new Label("Cool App Tagline...", "SidemenuTagline"));
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);
        tb.addCommandToRightBar("Back", null, (ev) -> {
            MatchesGUI M = new MatchesGUI();
            M.ShowMatches();
        });

        tb.addMaterialCommandToSideMenu("Fil Actualite", FontImage.MATERIAL_HOME, e -> {
            Resources theme = UIManager.initFirstTheme("/theme");
            FilForm Fil = new FilForm(theme);
            Fil.show();
        });
        tb.addMaterialCommandToSideMenu("Matching", FontImage.MATERIAL_WEB, e -> {
            MatchingGUI M = new MatchingGUI();
            M.AfficherMatchingMenu();
        });

        tb.addMaterialCommandToSideMenu("Mon Profil", FontImage.MATERIAL_ACCOUNT_BOX, e -> {
            ProfileGUI P = new ProfileGUI();
            P.ShowProfil();
        });

        tb.addMaterialCommandToSideMenu("Ajouter Publication", FontImage.MATERIAL_ADD, e -> {
            Resources res = UIManager.initFirstTheme("/theme");
            AjouterPublicationForm Ajout = new AjouterPublicationForm(res);
            Ajout.show();
        });
        tb.addMaterialCommandToSideMenu("Rendez-vous Liste", FontImage.MATERIAL_INFO, e -> {
            Resources res = UIManager.initFirstTheme("/theme");
            RdvForm RDV = new RdvForm(res);
            RDV.show();
        });
        tb.addMaterialCommandToSideMenu("Deconnexion", FontImage.MATERIAL_INFO, e -> {
            LoginGUI L = new LoginGUI();
            L.LoginInterfaceShow();
        });

        Container hi = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label label = new Label();
        Image placeholder = Image.createImage(150, 150);
        EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
        label.setIcon(URLImage.createToStorage(encImage,
                "Large_" + "http://localhost/symfonypidev/web/assets/images/profile/" + MatchesGUI.UserToShow.getPhoto()
                + "", "http://localhost/symfonypidev/web/assets/images/profile/" + MatchesGUI.UserToShow.getPhoto()
                + "", URLImage.RESIZE_SCALE_TO_FILL));

        Label L = new Label("Nom: " + MatchesGUI.UserToShow.getNom());
        Label L1 = new Label("Age: " + MatchesGUI.UserToShow.getAge());
        Label L2 = new Label("Sexe: " + MatchesGUI.UserToShow.getSexe());
        Label L3 = new Label("                     ");
        Container S = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Button Facebook = new Button("Facebook");
        Facebook.setUIID("Partage");
        Button Instagram = new Button("Instagram");
        Instagram.setUIID("delete");
        S.add(Facebook).add(Instagram);
        hi.add(label).add(L).add(L1).add(L2).add(L3).add(S);
        h.add(BorderLayout.NORTH, hi);
        h.show();

    }

}
