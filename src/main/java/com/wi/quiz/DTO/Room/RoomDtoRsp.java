package com.wi.quiz.DTO.Room;

import com.wi.quiz.DTO.RoomMembers.RoomMembersDto;
import com.wi.quiz.DTO.RoomMembers.RoomMembersDtoForRoom;
import com.wi.quiz.Entities.Message;
import com.wi.quiz.Entities.Person;
import com.wi.quiz.Entities.RoomMembers;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDtoRsp {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Person owner;
    private List<RoomMembersDtoForRoom> members;
    private List<Message> messages;
}
