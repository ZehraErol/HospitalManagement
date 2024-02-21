package com.project.contactmessage.mapper;


import com.project.contactmessage.dto.ContactMessageRequest;
import com.project.contactmessage.dto.ContactMessageResponse;
import com.project.contactmessage.entity.ContactMessage;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class ContactMessageMapper {

    //!!! bu classı pojoya cevricem  Request --> POJO

    public ContactMessage requestToContactMessage(ContactMessageRequest contactMessageRequest) {
        return ContactMessage.builder()
                .name(contactMessageRequest.getName())
                .message(contactMessageRequest.getMessage())
                .email(contactMessageRequest.getEmail())
                .dateTime(LocalDate.now())
                .build();


    }

    //!! pojoyu ---> responce çevireceğiz

    public ContactMessageResponse contactMessageToResponse(ContactMessage contactMessage){
        return ContactMessageResponse.builder()
                .name(contactMessage.getName())
                .message(contactMessage.getMessage())
                .email(contactMessage.getEmail())
                .dateTime(LocalDateTime.now())
                .build();

    }

}
