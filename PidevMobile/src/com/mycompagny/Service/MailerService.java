/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.messaging.Message;
import com.codename1.ui.Display;

/**
 *
 * @author CorpseRoot
 */
public class MailerService {

    public void SendMailViaAPI(String Destination) {
        Message m = new Message("Thank you for registering.. You can start dating right away after answering the quiz!! Good luck!");
        Display.getInstance().sendMessage(new String[]{Destination}, "My Soulmate Staff", m);
    }
    
    public void SendMailViaWebService(String Destination)
    {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfonypidev/web/app_dev.php/API/mail/send?to=" + Destination;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
 
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

}
