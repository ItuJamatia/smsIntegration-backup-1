package com.sms.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    public void sendSMS(String to, String from, String body) {
        Twilio.init(accountSid, authToken);
        Message message = Message.creator(new PhoneNumber(to), new PhoneNumber(from), body).create();
        System.out.println("SMS sent with SID: " + message.getSid());
    }
}

