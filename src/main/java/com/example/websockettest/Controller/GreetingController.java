package com.example.websockettest.Controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.example.websockettest.dto.Greeting;
import com.example.websockettest.dto.HelloMessage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class GreetingController {

	private final RabbitTemplate template;
	@MessageMapping("/hello")
	//@SendTo("/topic/greetings")
	public void greeting(HelloMessage message) throws Exception {
		log.info("message = {}",message);
		Greeting greeting = new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
//		template.convertAndSend("/topic/greetings/"+message.getRoomId(),greeting);
		template.convertAndSend("chat.exchange","room." + message.getRoomId(),message.getName());
	}
	
	@RabbitListener
	public void test(String test) {
		
	}
}
