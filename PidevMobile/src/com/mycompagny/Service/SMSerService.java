/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;
import java.io.IOException;

/**
 *
 * @author CorpseRoot
 */
public class SMSerService {

public void SendSMS(String Message) throws IOException, NexmoClientException
    {
        AuthMethod auth = new TokenAuthMethod("8c1e0913", "UWyrzSlv907LeYdM");
        NexmoClient client = new NexmoClient(auth);
        TextMessage message = new TextMessage("MySoulMate", "21656127616", Message);
        SmsSubmissionResult[] responses = client.getSmsClient().submitMessage(message);
    }
}
