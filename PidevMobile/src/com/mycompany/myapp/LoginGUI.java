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
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.Client;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author CorpseRoot
 */
public class LoginGUI {

    public static Client connectedUser;

    public void LoginInterfaceShow() {
        Form F = new Form("Sign up");
        Container welcome = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        TextField EmailTF = new TextField();
        EmailTF.setHint("Email");
        TextField PassTF = new TextField();
        PassTF.setConstraint(TextField.PASSWORD);
        PassTF.setHint("Mot de passe");
        Button BT = new Button("s'authentifier");
        welcome.add(EmailTF).add(PassTF).add(BT);

        BT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ConnectionRequest con = new ConnectionRequest();
                String mail = EmailTF.getText();
                String pswd = PassTF.getText();
                String Url = "http://localhost/symfonypidev/web/app_dev.php/API/user/login?email=" + mail + "&pass=" + pswd;
                con.setUrl(Url);
                con.addResponseListener((e) -> {
                    JSONParser jsonp = new JSONParser();
                    try {
                        Map<String, Object> obj = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
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

                        connectedUser = Q;
                        if (connectedUser.getVerifié().equals("true")) {
                            MatchingGUI m = new MatchingGUI();
                            m.AfficherMatchingMenu();
                        } else if (connectedUser.getVerifié().equals("false")) {
                            QuizGUI QGUI = new QuizGUI();
                            QGUI.AfficherQuiz();

                        }

                    } catch (IOException ex) {

                    }

                });
                NetworkManager.getInstance().addToQueueAndWait(con);

            }

        });
        F.add(welcome);
        F.show();
    }
}