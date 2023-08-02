package com.org.chatApplication.WebSocket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class chatMessage 
{
    private String content;
    private String sender;
    private String receiver;
    private LocalDateTime timestamp; // Add this field for time stamp

    // Constructors, getters, setters, and other methods go here...

    public String formatMessage() {
        return "[" + timestamp.toString() + "] " + sender + ": " + content;
    }
}