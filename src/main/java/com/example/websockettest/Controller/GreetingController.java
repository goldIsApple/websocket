package com.example.websockettest.Controller;

import com.example.websockettest.dto.Greeting;
import com.example.websockettest.dto.HelloMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
@Slf4j
@RequiredArgsConstructor
public class GreetingController {

	private final SimpMessagingTemplate template;
	@MessageMapping("/hello")
	//@SendTo("/topic/greetings")
	public void greeting(HelloMessage message) throws Exception {
		log.info("message = {}",message);
		Greeting greeting = new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
		template.convertAndSend("/sub/chat/room/"+message.getRoomId(),greeting);
	}
}
