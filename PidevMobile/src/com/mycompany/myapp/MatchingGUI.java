/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entite.Client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CorpseRoot
 */
public class MatchingGUI extends Form {

    public static ArrayList<Client> ListClients = new ArrayList<>();

    public void AfficherMatchingMenu() {
        Form h = new Form("Find Your Match!!", new BorderLayout());
        h.setUIID("AjoutForm");
        Toolbar tb = h.getToolbar();
        tb.setUIID("toolbar");
        Container topBar = new Container();
       // topBar.add(BorderLayout.SOUTH, new Label("Cool App Tagline...", "SidemenuTagline"));
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);

       
        tb.addMaterialCommandToSideMenu("Fil Actualite", FontImage.MATERIAL_HOME, e -> { Resources theme = UIManager.initFirstTheme("/theme");  FilForm Fil = new FilForm(theme);
                Fil.show();
        });
        tb.addMaterialCommandToSideMenu("Matching", FontImage.MATERIAL_WEB, e -> {  MatchingGUI  M = new MatchingGUI();
               M.AfficherMatchingMenu();
        });
        
         tb.addMaterialCommandToSideMenu("Mon Profil", FontImage.MATERIAL_ACCOUNT_BOX, e -> { ProfileGUI P = new ProfileGUI(); P.ShowProfil();
        });
        
        tb.addMaterialCommandToSideMenu("Ajouter Publication", FontImage.MATERIAL_ADD, e -> { Resources res = UIManager.initFirstTheme("/theme");   AjouterPublicationForm Ajout =new AjouterPublicationForm(res);
                Ajout.show();
        });
        tb.addMaterialCommandToSideMenu("Rendez-vous Liste", FontImage.MATERIAL_INFO, e -> {   Resources res = UIManager.initFirstTheme("/theme"); RdvForm RDV =new RdvForm(res);
                RDV.show();
        });
        tb.addMaterialCommandToSideMenu("Deconnexion", FontImage.MATERIAL_INFO, e -> { LoginGUI L = new LoginGUI();
                L.LoginInterfaceShow();
        });
        
        Container hi = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        hi.addComponent(new Label("Sexe"));
        ComboBox SexCB = new ComboBox();
        SexCB.addItem("Homme");
        SexCB.addItem("Femme");
        hi.addComponent(SexCB);
        hi.addComponent(new Label("From"));
        TextField FromTF = new TextField();
        FromTF.setHint("Age Starting From");
        hi.addComponent(FromTF);
        hi.addComponent(new Label("To"));
        TextField ToTF = new TextField();
        ToTF.setHint("Age Starting From");
        hi.addComponent(ToTF);
        Button BT = new Button("Search");
        BT.setUIID("AjouterButton");
        BT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println(SexCB.getCurrentSelected() + FromTF.getText() + ToTF.getText());

                ConnectionRequest con = new ConnectionRequest();
                String sexSelected = null;
                switch (SexCB.getCurrentSelected()) {
                    case 0:
                        sexSelected = "homme";
                        break;
                    case 1:
                        sexSelected = "femme";
                        break;
                }
                String Url = "http://localhost/symfonypidev/web/app_dev.php/API/matches/find?id=" + LoginGUI.connectedUser.getID() + "&sexe=" + sexSelected + "&from=" + FromTF.getText() + "&to=" + ToTF.getText();
                con.setUrl(Url);
                System.out.println("test 1");
                con.addResponseListener((e) -> {
                    try {
                        JSONParser jsonp = new JSONParser();

                        Map<String, Object> Clients;
                        Clients = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                        List<Map<String, Object>> list = (List<Map<String, Object>>) Clients.get("root");
                        for (Map<String, Object> obj : list) {
                            Client Q = new Client();
                            float id = Float.parseFloat(obj.get("id").toString());
                            float age = Float.parseFloat(obj.get("Age").toString());
                            float vc = Float.parseFloat(obj.get("VieCouplePercent").toString());
                            float ph = Float.parseFloat(obj.get("PhysiquePercent").toString());
                            float pe = Float.parseFloat(obj.get("PersonalitePercent").toString());
                            float so = Float.parseFloat(obj.get("SocialePercent").toString());

                            Q.setID((int) id);
                            Q.setNom(obj.get("username").toString());
                            Q.setAge((int) age);
                            Q.setSexe(obj.get("type").toString());
                            Q.setVerifié(obj.get("enabled").toString());
                            Q.setEtat(0);
                            Q.setAdresse("Unknown");
                            Q.setIP("0");
                            Q.setMDP(obj.get("password").toString());
                            Q.setMail(obj.get("email").toString());
                            Q.setTelephone(obj.get("phone").toString());
                            Q.setPhoto(obj.get("imageName").toString());
                            Q.setPourcentagePerso((int) pe);
                            Q.setPourcentagePhy((int) ph);
                            Q.setPourcentageSoc((int) so);
                            Q.setPourcentageVieC((int) vc);

                            ListClients.add(Q);

                        }
                    } catch (IOException ex) {

                    }
                });
                NetworkManager.getInstance().addToQueueAndWait(con);

                MatchesGUI mg = new MatchesGUI();
                mg.ShowMatches();
            }

        });
        hi.addComponent(BT);
        h.add(BorderLayout.NORTH, hi);
        h.show();

    }

}
