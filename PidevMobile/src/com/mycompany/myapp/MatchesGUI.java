/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Client;
import java.util.ArrayList;

/**
 *
 * @author CorpseRoot
 */
public class MatchesGUI  extends Form  {

    Container home;
    EncodedImage enc;
    Image imgs;
    ImageViewer imgv;

    public void ShowMatches() {
        Form f = new Form("Start talking now!!", new BoxLayout(BoxLayout.Y_AXIS));
        f.setUIID("AjoutForm");
        Toolbar tb = f.getToolbar();
        tb.setUIID("toolbar");
        tb.addCommandToRightBar("Back", null, (ev)->{ MatchingGUI M = new MatchingGUI(); M.AfficherMatchingMenu(); });
        Container topBar = new Container();
       // topBar.add(BorderLayout.SOUTH, new Label("Cool App Tagline...", "SidemenuTagline"));
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);

        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {
        });
        tb.addMaterialCommandToSideMenu("Website", FontImage.MATERIAL_WEB, e -> { 
        });
        tb.addMaterialCommandToSideMenu("Settings", FontImage.MATERIAL_SETTINGS, e -> {
        });
        tb.addMaterialCommandToSideMenu("About", FontImage.MATERIAL_INFO, e -> {
        });
        
        Container root = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        for (Client t : MatchingGUI.ListClients) {
            Container root2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label label = new Label();
            int deviceWidth = Display.getInstance().getDisplayWidth() / 4;
            Image placeholder = Image.createImage(deviceWidth, deviceWidth); //square image set to 10% of screen width
            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
            label.setIcon(URLImage.createToStorage(encImage,
                    "Large_" + "http://localhost/symfonypidev/web/assets/images/profile/" + t.getPhoto()
                    + "", "http://localhost/symfonypidev/web/assets/images/profile/" + t.getPhoto()
                    + "", URLImage.RESIZE_SCALE_TO_FILL));

            Label l = new Label(t.getNom());
            Label label1 = new Label(t.getAge()+" ans");

            C1.add(label);
            C1.add(l);
            C1.add(label1);
            //C1.setLeadComponent(l);
            root2.add(C1);

            Container btn = new Container(new BoxLayout(BoxLayout.X_AXIS));
            root2.add(btn);
            root.add(root2);

        }
        f.add(root);
        f.show();
    }

}
