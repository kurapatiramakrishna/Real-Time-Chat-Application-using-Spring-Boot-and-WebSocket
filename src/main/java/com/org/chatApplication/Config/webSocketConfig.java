package com.org.chatApplication.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class webSocketConfig implements WebSocketMessageBrokerConfigurer 
{
	
	 @Override
	    public void configureMessageBroker(MessageBrokerRegistry config) {
	        config.enableSimpleBroker("/topic"); // Enable a simple message broker
	        config.setApplicationDestinationPrefixes("/app");
	    }

	    @Override
	    public void registerStompEndpoints(StompEndpointRegistry registry)
	    {
	        registry.addEndpoint("/chatHomePage").withSockJS(); // Register a WebSocket endpoint
	    }
}
