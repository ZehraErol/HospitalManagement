package com.project.contactmessage.controller;


import com.project.contactmessage.dto.ContactMessageRequest;
import com.project.contactmessage.dto.ContactMessageResponse;
import com.project.contactmessage.entity.ContactMessage;
import com.project.contactmessage.service.ContactMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/contactMessages")
@RequiredArgsConstructor
public class ContactMessageController {

private final ContactMessageService contactMessageService;


@PostMapping("/save")//http://localhost:8080/ontactMessages/save + POST + JSON
     public ResponseEntity<ContactMessage> save(@Valid @RequestBody ContactMessageRequest contactMessageRequest){

     return contactMessageService.save(contactMessageRequest);

}
@GetMapping("/getAll")// http.//localhost:8080/contactMessage/getAll + GET
 public Page<ContactMessageResponse> getAll(
    //pageable yapılarda requestparam ile yazarız.
    @RequestParam(value = "page", defaultValue = "0") int page,
    @RequestParam(value = "size", defaultValue = "10") int size,
    @RequestParam(value = "sort", defaultValue = "dateTime") String sort,
    @RequestParam( value = "type", defaultValue = "desc") String type
){

    return contactMessageService.getAll(page, size, sort, type);
    }

}
