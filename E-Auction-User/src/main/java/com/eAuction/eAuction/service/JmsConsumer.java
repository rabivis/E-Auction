package com.eAuction.eAuction.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

@Component
public class JmsConsumer implements MessageListener {

    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message message) {
        try{
           TextMessage testMessage = (TextMessage) message;
           String payload = testMessage.getText();
            System.out.println("Received payload : "+ payload);
        } catch(Exception e) {
            System.out.println("Received Exception : "+ e);
        }
    }
}
