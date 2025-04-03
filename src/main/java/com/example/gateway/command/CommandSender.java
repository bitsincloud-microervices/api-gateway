package com.example.gateway.command;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandSender {

    private final RabbitTemplate rabbitTemplate;

    public void sendCommand(CreateClientCommand command) {
        rabbitTemplate.convertAndSend("command-client-exchange", "client.create", command);
    }
}