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
import com.mycompany.Entite.Publication;
import com.mycompany.myapp.LoginGUI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author USER
 */
public class PublicationService {
     public void ajoutPub(Publication ta) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfonypidev/web/app_dev.php/API/Publication/AjouterPub?id="+LoginGUI.connectedUser.getID()+"&adresse="+ta.getAdresse()+"&text="+ta.getText()+"&imageName="+ta.getImage() ;
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
 
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
     public ArrayList<Publication> getListPub() {
        ArrayList<Publication> listpub = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfonypidev/web/app_dev.php/API/Publication/Showpub");
        con.addResponseListener(new ActionListener<NetworkEvent>() 
        {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                  
                    
                List<Map<String, Object>> lists = (List<Map<String, Object>>) tasks.get("root");

                    for (Map<String, Object> obj : list) {
                        Publication E = new Publication();
                          float id = Float.parseFloat(obj.get("idPub").toString());

                           
                           
                        E.setId_pub((int) id);

                         E.setText(obj.get("text").toString()); 
                       
                         E.setAdresse(obj.get("adresse").toString()); 
                         E.setImage(obj.get("imageName").toString()); 
                        System.out.println(E);
                       listpub.add(E);

                    }
                } catch (IOException ex) {
                    
                } 
               
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listpub;
    }
     

}