package com.messenger.controller;

import com.messenger.model.controller.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessengerController {

    @MessageMapping("/sendMessage") // Maps websocket message to destination(endpoint)
    @SendTo("/topic/messages") // Function return to specific chat room/client who subscribed to the endpoint
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }

    // For thymeleaf template whoever accessing the root url will get this message
    // (or any fixed template if you give the endpoint)
    @GetMapping("/message")
    public String chat() {
        return "message";
    }
}
