package com.wi.quiz.Controllers;

import com.wi.quiz.DTO.Message.MessageDto;
import com.wi.quiz.DTO.Message.MessageDtoRsp;
import com.wi.quiz.DTO.Person.PersonDtoLogin;
import com.wi.quiz.Services.Impl.PersonServiceImpl;
import com.wi.quiz.Services.Inter.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ChatController {
    private final MessageService messageService;
    private  final PersonServiceImpl personService;


    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public MessageDtoRsp chat(@DestinationVariable String roomId, MessageDto message) {
        return messageService.save(message);
    }

    @MessageMapping("/login")
    @SendTo("/topic/login")
    public boolean login(PersonDtoLogin dtoLogin) {
        return personService.login(dtoLogin);
    }
}
