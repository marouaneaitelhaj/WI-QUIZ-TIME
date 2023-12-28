package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Message.MessageDto;
import com.wi.quiz.Entities.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ChatController {
    @MessageMapping("/chat")
    @SendTo("/topic/public")
    public MessageDto chat(@Payload MessageDto message){
        System.out.println(message);
        return message;
    }
}
