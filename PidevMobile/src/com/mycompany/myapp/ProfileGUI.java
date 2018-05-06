/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
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
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import static com.mycompany.myapp.QuizGUI.ScorePH;
import static com.mycompany.myapp.QuizGUI.ScorePe;
import static com.mycompany.myapp.QuizGUI.ScoreSO;
import static com.mycompany.myapp.QuizGUI.ScoreVC;

/**
 *
 * @author CorpseRoot
 */
public class ProfileGUI {

    public void ShowProfil() {
        Form F = new Form("Mon Profil", new BoxLayout(BoxLayout.Y_AXIS));
        F.setUIID("AjoutForm");
        Toolbar tb = new Toolbar();
        tb = F.getToolbar();
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
        
        Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label label = new Label();
        int deviceWidth = Display.getInstance().getDisplayWidth() / 2;
        Image placeholder = Image.createImage(Display.getInstance().getDisplayWidth(), deviceWidth); //square image set to 10% of screen width
        EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
        label.setIcon(URLImage.createToStorage(encImage,
                "Large_" + "http://localhost/symfonypidev/web/assets/images/profile/" + LoginGUI.connectedUser.getPhoto()
                + "", "http://localhost/symfonypidev/web/assets/images/profile/" + LoginGUI.connectedUser.getPhoto()
                + "", URLImage.RESIZE_SCALE_TO_FILL));
        TextField NameTF = new TextField();
        NameTF.setEditable(false);
        NameTF.setHint(LoginGUI.connectedUser.getNom());
        TextField AgeTF = new TextField();
        AgeTF.setEditable(false);
        AgeTF.setHint(Integer.toString(LoginGUI.connectedUser.getAge()));
        TextField EmailTF = new TextField();
        EmailTF.setEditable(true);
        EmailTF.setHint(LoginGUI.connectedUser.getMail());
        TextField PhoneTF = new TextField();
        PhoneTF.setEditable(true);
        PhoneTF.setHint(LoginGUI.connectedUser.getTelephone());
        Button BT = new Button("Modifier");
        BT.setUIID("AjouterButton");
        BT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String Mail = null, Phone = null, Addresse = null;
                if(EmailTF.getText().equals(""))
                {
                    Mail = EmailTF.getHint();
                    LoginGUI.connectedUser.setMail(Mail);
                    System.out.println(Mail);
                }
                else    
                {
                    Mail = EmailTF.getText();
                    LoginGUI.connectedUser.setMail(Mail);
                }
               
                if(PhoneTF.getText().equals(""))
                {
                     Phone = PhoneTF.getHint();
                     LoginGUI.connectedUser.setTelephone(Phone);
                     System.out.println(Phone);
                }
                else
                {
                    Phone = PhoneTF.getText();
                    LoginGUI.connectedUser.setTelephone(Phone);
                    
                }
            
                
                ConnectionRequest con = new ConnectionRequest();
                String Url = "http://localhost/symfonypidev/web/app_dev.php/API/user/update?id=" + LoginGUI.connectedUser.getID() + "&mail=" + Mail + "&phone=" + Phone;
                con.setUrl(Url);
                
                con.addResponseListener((e) -> {
                    String str = new String(con.getResponseData());
                    System.out.println(str);
                });
                NetworkManager.getInstance().addToQueueAndWait(con);
                ProfileGUI P = new ProfileGUI();
                P.ShowProfil();
            }
        });
        
        C1.add(label).add(NameTF).add(AgeTF).add(EmailTF).add(PhoneTF).add(BT);
        F.add(C1);
        F.show();
        
                
        

    }

}
