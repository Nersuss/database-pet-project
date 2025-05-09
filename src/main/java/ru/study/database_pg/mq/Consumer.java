package ru.study.database_pg.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
//simple messages listener
public class Consumer {

    @JmsListener(destination = "base")
    public void messageListener(String msg) {
        System.out.println("Receive message: " + msg);
    }

}
