/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.codename1.messaging.Message;
import com.codename1.ui.Display;

/**
 *
 * @author CorpseRoot
 */
public class MailerService {

    public void SendMail(String Destination, String Message) {
        Message m = new Message(Message);
        Display.getInstance().sendMessage(new String[]{Destination}, "Subject of message", m);
    }

}
