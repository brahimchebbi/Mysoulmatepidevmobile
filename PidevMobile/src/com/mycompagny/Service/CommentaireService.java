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
import com.mycompany.Entite.Commentaire;
import com.mycompany.myapp.FilForm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author USER
 */
public class CommentaireService {
    

    
    
      public void ajoutcomm(int id, int ids,String commentaire) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfonypidev/web/app_dev.php/API/Publication/CommentAdd/"+id+"/"+ids+"/"+commentaire;
        con.setUrl(Url);

        System.out.println("comment done");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
      
       public ArrayList<Commentaire> getListComm(int ids) {
        ArrayList<Commentaire> listTach = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/symfonypidev/web/app_dev.php/API/Publication/CommShow/"+ids);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> taches = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(taches);
                    
                    List<Map<String, Object>> list = (List<Map<String, Object>>) taches.get("root");
                    for (Map<String, Object> obj : list) {
                        Commentaire Com = new Commentaire();
                        float id = Float.parseFloat(obj.get("id").toString());
                        
                        
                                              
                        Com.setId((int) id);
                        Com.setCommentaire(obj.get("commentaire").toString());

                        listTach.add(Com);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTach;
    }
      
}
