package com.org.chatApplication.ChatController;

import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.org.chatApplication.WebSocket.chatMessage;

@Controller
public class chatController 
{
	@MessageMapping("/chatMessage")
    @SendTo("/topic/public")
    public chatMessage sendMessage(chatMessage incomingMessage) 
    {
        // Create a time stamp for the message
        LocalDateTime timestamp = LocalDateTime.now();
        
        // Create a new chatMessage instance to send
        chatMessage outgoingMessage = new chatMessage();
        outgoingMessage.setContent(incomingMessage.getContent());
        outgoingMessage.setSender(incomingMessage.getSender());
        outgoingMessage.setReceiver(incomingMessage.getReceiver());
        outgoingMessage.setTimestamp(timestamp);
        
        return outgoingMessage;
    }
}