package com.dhyanesh.chat.application.Controller;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private  String content;
    private String sender;
    private MessageType type;
}
