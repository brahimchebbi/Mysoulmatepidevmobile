/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompagny.Service.QuestionService;
import com.mycompany.Entite.Question;
import java.util.ArrayList;

/**
 *
 * @author CorpseRoot
 */
public class QuizGUI {

    QuestionService QS = new QuestionService();
    ArrayList<Question> ListVieCouple = QS.QuestionsVieCouple();
    ArrayList<Question> ListPhysique = QS.QuestionsPhysique();
    ArrayList<Question> ListPersonalite = QS.QuestionsPersonalite();
    ArrayList<Question> ListSociale = QS.QuestionsSociale();

    public static int ScorePe;
    public static int ScoreVC;
    public static int ScorePH;
    public static int ScoreSO;

    public void AfficherQuiz() {
        Form hi = new Form("Quiz", new BorderLayout());
        hi.setUIID("formbackground");

        Tabs t = new Tabs();
        Style s = UIManager.getInstance().getComponentStyle("Tab");
        FontImage icon1 = FontImage.createMaterial(FontImage.MATERIAL_QUESTION_ANSWER, s);

        Container ContainerQuestVieCouple = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container ContainerQuestPhysique = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container ContainerQuestSociale = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container ContainerQuestPersonalite = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        for (Question Q : ListVieCouple) {

            Container CS = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            CS.addComponent(new Label(Q.getQuestion()));
            CheckBox RB1 = new CheckBox(Q.getReponse1());
            CheckBox RB2 = new CheckBox(Q.getReponse2());
            CheckBox RB3 = new CheckBox(Q.getReponse3());
            RB1.setUIID("checkbox1");
            RB2.setUIID("checkbox1");
            RB3.setUIID("checkbox1");
            RB1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (RB1.isSelected()) {
                        ScoreVC += Q.getScoreRep1();
                    }
                }
            });
            RB2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (RB2.isSelected()) {
                        ScoreVC += Q.getScoreRep2();
                    }
                }
            });
            RB3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (RB3.isSelected()) {
                        ScoreVC += Q.getScoreRep3();
                    }
                }
            });
            CS.addComponent(RB1);
            CS.addComponent(RB2);
            CS.addComponent(RB3);
            ContainerQuestVieCouple.add(CS);
            ContainerQuestVieCouple.setUIID("ContainerTabs");

        }

        for (Question Q : ListPhysique) {

            Container CS = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            CS.addComponent(new Label(Q.getQuestion()));
            CheckBox RB1 = new CheckBox(Q.getReponse1());
            CheckBox RB2 = new CheckBox(Q.getReponse2());
            CheckBox RB3 = new CheckBox(Q.getReponse3());
            RB1.setUIID("checkbox1");
            RB2.setUIID("checkbox1");
            RB3.setUIID("checkbox1");
            RB1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (RB1.isSelected()) {
                        ScorePH += Q.getScoreRep1();
                    }
                }
            });
            RB2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (RB2.isSelected()) {
                        ScorePH += Q.getScoreRep2();
                    }
                }
            });
            RB3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (RB3.isSelected()) {
                        ScorePH += Q.getScoreRep3();
                    }
                }
            });
            CS.addComponent(RB1);
            CS.addComponent(RB2);
            CS.addComponent(RB3);
            ContainerQuestPhysique.add(CS);
            ContainerQuestPhysique.setUIID("ContainerTabs");

        }

        for (Question Q : ListPersonalite) {

            Container CS = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            CS.addComponent(new Label(Q.getQuestion()));
            CheckBox RB1 = new CheckBox(Q.getReponse1());
            CheckBox RB2 = new CheckBox(Q.getReponse2());
            CheckBox RB3 = new CheckBox(Q.getReponse3());
            RB1.setUIID("checkbox1");
            RB2.setUIID("checkbox1");
            RB3.setUIID("checkbox1");
            RB1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (RB1.isSelected()) {
                        ScorePe += Q.getScoreRep1();
                    }
                }
            });
            RB2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (RB2.isSelected()) {
                        ScorePe += Q.getScoreRep2();
                    }
                }
            });
            RB3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (RB3.isSelected()) {
                        ScorePe += Q.getScoreRep3();
                    }
                }
            });
            CS.addComponent(RB1);
            CS.addComponent(RB2);
            CS.addComponent(RB3);
            ContainerQuestPersonalite.add(CS);
            ContainerQuestPersonalite.setUIID("ContainerTabs");

        }

        for (Question Q : ListSociale) {

            Container CS = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            CS.addComponent(new Label(Q.getQuestion()));
            CheckBox RB1 = new CheckBox(Q.getReponse1());
            CheckBox RB2 = new CheckBox(Q.getReponse2());
            CheckBox RB3 = new CheckBox(Q.getReponse3()); 
            RB1.setUIID("checkbox1");
            RB2.setUIID("checkbox1");
            RB3.setUIID("checkbox1");
            RB1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (RB1.isSelected()) {
                        ScoreSO += Q.getScoreRep1();
                    }
                }
            });
            RB2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (RB2.isSelected()) {
                        ScoreSO += Q.getScoreRep2();
                    }
                }
            });
            RB3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (RB3.isSelected()) {
                        ScoreSO += Q.getScoreRep3();
                    }
                }
            });
            CS.addComponent(RB1);
            CS.addComponent(RB2);
            CS.addComponent(RB3);
            ContainerQuestSociale.add(CS);
            ContainerQuestSociale.setUIID("ContainerTabs");

        }

        t.addTab("Vie Couple", ContainerQuestVieCouple);
        t.addTab("Sociale", ContainerQuestSociale);
        t.addTab("Physique", ContainerQuestPhysique);
        t.addTab("Personalite", ContainerQuestPersonalite);

        Container c = new Container(new FlowLayout(Component.CENTER));
        c.setUIID("ContainerTabs");

        c.setScrollableY(true);
        c.add(t);
        Button B = new Button("VALIDER");
        
        B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Score VIE COUPLE: " + ScoreVC);
                System.out.println("Score SOCIALE: " + ScoreSO);
                System.out.println("Score PERSONALITE: " + ScorePe);
                System.out.println("Score PHYSIQUE: " + ScorePH);
                ConnectionRequest con = new ConnectionRequest();
                String Url = "http://localhost/symfonypidev/web/app_dev.php/API/score/update?id="+LoginGUI.connectedUser.getID()+"&vc=" + ScoreVC + "&ph=" + ScorePH + "&pe=" + ScorePe + "&so=" + ScoreSO;
                con.setUrl(Url);
                con.addResponseListener((e) -> {
                    String str = new String(con.getResponseData());
                    System.out.println(str);
                });
                NetworkManager.getInstance().addToQueueAndWait(con);
                MatchingGUI m = new  MatchingGUI();
                m.AfficherMatchingMenu();
            }

        }
        );
        c.add(B);
        hi.add(BorderLayout.SOUTH, c);
        hi.show();
    }

}
