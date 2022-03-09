package com.example.websockettest.config;

import com.example.websockettest.handler.HandshakeInterceptor;
import com.example.websockettest.handler.MyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

//@Configuration
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer {
//
//
//	@Override
//	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//		registry.addHandler(webSocketHandler(), "/chat")
//			.addInterceptors(new HandshakeInterceptor())
//			.withSockJS();
//	}
//	@Bean
//	public WebSocketHandler webSocketHandler(){
//		return new MyHandler();
//	}
//}
public class WebSocketConfig{

}