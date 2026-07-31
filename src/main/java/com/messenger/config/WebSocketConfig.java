package com.messenger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration   // Defining this as a configuration class
@EnableWebSocketMessageBroker   // Tell spring that this class is enabling web socket for real time communication
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
                .setAllowedOrigins("http://localhost:8080") //Security to prevent unauthorized sources
                .withSockJS(); // Adds compatibility for clients that don't support web sockets
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Set message broker
        registry.enableSimpleBroker("/topic");
        // Tell server when it needs to expect a message
        registry.setApplicationDestinationPrefixes("/messenger");
    }
}
