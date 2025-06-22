package com.example.demo.model;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-bid")
                .setAllowedOrigins(
                        "http://localhost:4200",
                        "http://127.0.0.1:5500",
                        "http://localhost:5500",
                     "https://real-estate-8i16-kkn06gb9w-sudan1234-sys-projects.vercel.app/"
                )
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // for broadcasting
        config.setApplicationDestinationPrefixes("/app"); // prefix for messages from client
    }
}

