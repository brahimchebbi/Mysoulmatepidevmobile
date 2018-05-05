/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entite.Question;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CorpseRoot
 */
public class QuestionService {
    
    
    public ArrayList<Question> QuestionsVieCouple() {
        ArrayList<Question> ListQuestions = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfonypidev/web/app_dev.php/API/questions/viecouple");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> Questions = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(Questions);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Questions.get("root");
                    for (Map<String, Object> obj : list) {
                        Question Q = new Question();
                        float id = Float.parseFloat(obj.get("id").toString());
                        float scorerep1 = Float.parseFloat(obj.get("scorerep1").toString());
                        float scorerep2 = Float.parseFloat(obj.get("scorerep2").toString());
                        float scorerep3 = Float.parseFloat(obj.get("scorerep3").toString());
                        
                        Q.setID((int) id);
                        Q.setQuestion(obj.get("question").toString());
                        Q.setReponse1(obj.get("reponse1").toString());
                        Q.setReponse2(obj.get("reponse2").toString());
                        Q.setReponse3(obj.get("reponse3").toString());
                        Q.setScoreRep1((int) scorerep1);
                        Q.setScoreRep2((int) scorerep2);
                        Q.setScoreRep3((int) scorerep3);
                        
                   
                        ListQuestions.add(Q);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return ListQuestions;
    }
    
     public ArrayList<Question> QuestionsSociale() {
        ArrayList<Question> ListQuestions = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfonypidev/web/app_dev.php/API/questions/sociale");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> Questions = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(Questions);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Questions.get("root");
                    for (Map<String, Object> obj : list) {
                        Question Q = new Question();
                        float id = Float.parseFloat(obj.get("id").toString());
                        float scorerep1 = Float.parseFloat(obj.get("scorerep1").toString());
                        float scorerep2 = Float.parseFloat(obj.get("scorerep2").toString());
                        float scorerep3 = Float.parseFloat(obj.get("scorerep3").toString());
                        
                        Q.setID((int) id);
                        Q.setQuestion(obj.get("question").toString());
                        Q.setReponse1(obj.get("reponse1").toString());
                        Q.setReponse2(obj.get("reponse2").toString());
                        Q.setReponse3(obj.get("reponse3").toString());
                        Q.setScoreRep1((int) scorerep1);
                        Q.setScoreRep2((int) scorerep2);
                        Q.setScoreRep3((int) scorerep3);
                        
                   
                        ListQuestions.add(Q);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return ListQuestions;
    }
    
      public ArrayList<Question> QuestionsPhysique() {
        ArrayList<Question> ListQuestions = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfonypidev/web/app_dev.php/API/questions/physique");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> Questions = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(Questions);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Questions.get("root");
                    for (Map<String, Object> obj : list) {
                        Question Q = new Question();
                        float id = Float.parseFloat(obj.get("id").toString());
                        float scorerep1 = Float.parseFloat(obj.get("scorerep1").toString());
                        float scorerep2 = Float.parseFloat(obj.get("scorerep2").toString());
                        float scorerep3 = Float.parseFloat(obj.get("scorerep3").toString());
                        
                        Q.setID((int) id);
                        Q.setQuestion(obj.get("question").toString());
                        Q.setReponse1(obj.get("reponse1").toString());
                        Q.setReponse2(obj.get("reponse2").toString());
                        Q.setReponse3(obj.get("reponse3").toString());
                        Q.setScoreRep1((int) scorerep1);
                        Q.setScoreRep2((int) scorerep2);
                        Q.setScoreRep3((int) scorerep3);
                        
                   
                        ListQuestions.add(Q);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return ListQuestions;
    }
    
       public ArrayList<Question> QuestionsPersonalite() {
        ArrayList<Question> ListQuestions = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfonypidev/web/app_dev.php/API/questions/personalite");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> Questions = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(Questions);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Questions.get("root");
                    for (Map<String, Object> obj : list) {
                        Question Q = new Question();
                        float id = Float.parseFloat(obj.get("id").toString());
                        float scorerep1 = Float.parseFloat(obj.get("scorerep1").toString());
                        float scorerep2 = Float.parseFloat(obj.get("scorerep2").toString());
                        float scorerep3 = Float.parseFloat(obj.get("scorerep3").toString());
                        
                        Q.setID((int) id);
                        Q.setQuestion(obj.get("question").toString());
                        Q.setReponse1(obj.get("reponse1").toString());
                        Q.setReponse2(obj.get("reponse2").toString());
                        Q.setReponse3(obj.get("reponse3").toString());
                        Q.setScoreRep1((int) scorerep1);
                        Q.setScoreRep2((int) scorerep2);
                        Q.setScoreRep3((int) scorerep3);
                        
                   
                        ListQuestions.add(Q);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return ListQuestions;
    }
    
    
}
