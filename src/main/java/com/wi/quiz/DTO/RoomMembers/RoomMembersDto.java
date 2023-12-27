package com.wi.quiz.DTO.RoomMembers;

import com.wi.quiz.Entities.Person;
import com.wi.quiz.Entities.Room;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomMembersDto {
    private Long id;
    private Long member_id;

    private Long room_id;
}
