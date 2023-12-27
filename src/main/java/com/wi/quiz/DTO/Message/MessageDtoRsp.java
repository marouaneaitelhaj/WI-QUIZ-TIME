package com.wi.quiz.DTO.Message;

import com.wi.quiz.Entities.Person;
import com.wi.quiz.Entities.Room;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageDtoRsp {
    private long id;
    private String content;
    private Room room;
    private Person sender;
    private LocalTime time;
}
