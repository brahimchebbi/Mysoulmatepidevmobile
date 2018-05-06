/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompagny.Service.MailerService;

/**
 *
 * @author CorpseRoot
 */
public class SignupGUI extends Form {

    public void SignupInterfaceShow() {
        Form F = new Form("Sign up", new BoxLayout(BoxLayout.Y_AXIS));
        F.setUIID("AjoutForm");
        Toolbar tb = new Toolbar();
        tb = F.getToolbar();
        tb.setUIID("toolbar");
        Container topBar = new Container();
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);

        tb.addMaterialCommandToSideMenu("Register", FontImage.MATERIAL_ADD_BOX, e -> { SignupGUI S = new SignupGUI(); S.SignupInterfaceShow();
        });
        tb.addMaterialCommandToSideMenu("Login", FontImage.MATERIAL_WEB, e -> { LoginGUI L = new LoginGUI(); L.LoginInterfaceShow();
        });
        Container C = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        C.setUIID("Form");
        TextField NomTF = new TextField();
        NomTF.setHint("Entrez votre nom");
        TextField AgeTF = new TextField();
        AgeTF.setHint("Entrez votre age");
        Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label SexLab = new Label("Sexe");
        ComboBox Sexe = new ComboBox();
        Sexe.addItem("Homme");
        Sexe.addItem("Femme");
        C1.add(SexLab).add(Sexe);
        TextField MailTF = new TextField();
        MailTF.setHint("Entrez votre mail");
        TextField PhoneTF = new TextField();
        PhoneTF.setHint("Entrez votre telephone");
        TextField AddresseTF = new TextField();
        AddresseTF.setHint("Entrez votre adresse");
        TextField MDPTF = new TextField();
        MDPTF.setHint("Entrez votre mdp");
        MDPTF.setConstraint(TextField.PASSWORD);
        TextField ConfirmMDP = new TextField();
        ConfirmMDP.setHint("confirmer votre mdp");
        ConfirmMDP.setConstraint(TextField.PASSWORD);
        Button BT = new Button("S'inscrire");
        BT.setUIID("AjouterButton");

        BT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (NomTF.getText() == "") {
                    NomTF.requestFocus();
                    Dialog.show("Error", "Veuillez entrer votre nom", "OK", "Cancel");
                } else if (AgeTF.getText() == "") {
                    AgeTF.requestFocus();
                    Dialog.show("Error", "Veuillez entrer votre age", "OK", "Cancel");
                } else if (MailTF.getText() == "") {
                    MailTF.requestFocus();
                    Dialog.show("Error", "Veuillez entrer votre mail", "OK", "Cancel");
                } else if (PhoneTF.getText() == "") {
                    PhoneTF.requestFocus();
                    Dialog.show("Error", "Veuillez entrer votre phone", "OK", "Cancel");
                } else if (AddresseTF.getText() == "") {
                    AddresseTF.requestFocus();
                    Dialog.show("Error", "Veuillez entrer votre adresse", "OK", "Cancel");
                } else if (MDPTF.getText() == "") {
                    MDPTF.requestFocus();
                    Dialog.show("Error", "Veuillez entrer votre mdp", "OK", "Cancel");
                } else {
                    if (!MDPTF.getText().equals(ConfirmMDP.getText())) {
                        Dialog.show("Error", "Les mots de passes ne sont pas identiques", "OK", "Cancel");

                    } else {
                        String S = null;
                        switch (Sexe.getCurrentSelected()) {
                            case 0:
                                S = "homme";
                            case 1:
                                S = "femme";
                        }
                        ConnectionRequest con = new ConnectionRequest();
                        String Url = "http://localhost/symfonypidev/web/app_dev.php/API/user/new?nom=" + NomTF.getText() + "&sexe=" + S + "&age=" + AgeTF.getText() + "&mail=" + MailTF.getText() + "&tel=" + PhoneTF.getText() + "&addresse=" + AddresseTF.getText() + "&mdp=" + MDPTF.getText();
                        con.setUrl(Url);
                        con.addResponseListener((e) -> {
                            String str = new String(con.getResponseData());
                            System.out.println(str);

                        });
                        NetworkManager.getInstance().addToQueueAndWait(con);
                        MailerService M = new MailerService();
                        M.SendMailViaWebService(MailTF.getText());
                        Dialog.show("Welcome", "Bienvenu dans notre application!", "OK", "Cancel");
                        LoginGUI l = new LoginGUI();
                        l.LoginInterfaceShow();
                    }
                }
            }
        }
        );
        C.add(NomTF).add(AgeTF).add(C1).add(MailTF).add(PhoneTF).add(AddresseTF).add(MDPTF).add(ConfirmMDP).add(BT);
        F.add(C);

        F.show();

    }

}
