package com.logical.bork.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Endpoint clients connect to
        registry.addEndpoint("/bork").withSockJS();
    }

    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Name of broker
        registry.enableSimpleBroker("/topic");
        // Prefixes for all controllers receiving messages
        registry.setApplicationDestinationPrefixes("/api");
    }
}