package com.eAuction.eAuction.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
public class JmsConsumer implements MessageListener {

    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            String messageData = objectMessage.toString();
            //do additional processing
            System.out.println("Received Message: "+ messageData);
        } catch(Exception e) {
            System.out.println("Received Exception : "+ e);
        }
    }
}
