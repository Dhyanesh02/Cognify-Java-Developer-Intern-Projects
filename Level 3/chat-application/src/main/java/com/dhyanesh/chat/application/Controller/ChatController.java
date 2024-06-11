package com.dhyanesh.chat.application.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {

        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    // add username in websocket session
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor heraderAccessor) {
        heraderAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
