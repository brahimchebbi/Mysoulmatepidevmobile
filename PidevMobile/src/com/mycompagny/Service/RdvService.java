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
import com.mycompany.Entite.rdv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class RdvService {
    
    
     public ArrayList<rdv> getListRdv() {
        ArrayList<rdv> listrdv = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/webservice/web/app_dev.php/Service/Publication/RdvShow");
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
                        rdv E = new rdv();
                          float id = Float.parseFloat(obj.get("id").toString());
                          float nbrplacedis = Float.parseFloat(obj.get("nbrplacedispo").toString());
                      //     float pr = Float.parseFloat(obj.get("prix").toString());
                           
                        E.setIdrdv((int) id);

                         E.setNomrdv(obj.get("nomrdv").toString()); 
                       
                         E.setAdresse(obj.get("adresse").toString()); 
                         E.setImage_name(obj.get("nomImage").toString()); 
                         E.setNbrplacedispo((int)nbrplacedis);
                      //   E.setPrix((float)pr);
                        System.out.println(E);
                       listrdv.add(E);

                    }
                } catch (IOException ex) {
                    
                } 
               
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listrdv;
    }
     
    
}
