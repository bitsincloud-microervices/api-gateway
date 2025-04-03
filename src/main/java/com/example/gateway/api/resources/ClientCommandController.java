package com.example.gateway.api.resources;

import com.example.gateway.command.CommandSender;
import com.example.gateway.command.CreateClientCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientCommandController {

    private final CommandSender sender;

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody CreateClientCommand command) {
        sender.sendCommand(command);
        return ResponseEntity.ok("Comando enviado com sucesso via RabbitMQ!");
    }
}
