package ru.study.database_pg.mq;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Autowired
    JmsTemplate jmsTemplate;

    public void send(String queueName, String msg) {
        try {
            jmsTemplate.convertAndSend(queueName, msg);
        } catch (JmsException e) {
            throw new RuntimeException(e);
        }
    }
}
