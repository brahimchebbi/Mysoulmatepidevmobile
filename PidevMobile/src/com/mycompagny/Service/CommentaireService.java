/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.mycompany.Entite.Publication;
import com.mycompany.Entite.Commentaire;
import com.mycompany.myapp.FilForm;
/**
 *
 * @author USER
 */
public class CommentaireService {
    
    public void ajoutComm(Commentaire ta) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/webservice/web/app_dev.php/Service/Publication/Commentt?id="+FilForm.CommPubId+"&comment="+ta.getCommentaire();
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
 
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
}
