package com.example.gateway.command;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CommandListener {

    @RabbitListener(queues = "command-create-client-queue")
    public void listen(String message) {
        System.out.println("Recebido: " + message);
    }

}
