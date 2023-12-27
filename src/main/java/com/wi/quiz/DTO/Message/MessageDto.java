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
public class MessageDto {
    private long id;
    private String content;
    private Long room_id;
    private Person sender_id;
    private LocalTime time;
}
