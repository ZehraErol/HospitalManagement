package com.project.contactmessage.service;



import com.project.contactmessage.dto.ContactMessageRequest;
import com.project.contactmessage.dto.ContactMessageResponse;
import com.project.contactmessage.entity.ContactMessage;
import com.project.contactmessage.mapper.ContactMessageMapper;
import com.project.contactmessage.repository.ContactMessageRepository;
import com.project.payload.response.business.ResponceMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;
    private final ContactMessageMapper contactMessageMapper;
    public ResponceMessage<ContactMessageResponse> save (ContactMessageRequest contactMessageRequest) {//tür dönüşümü yapıp dto dan pojoya cevırecegız (bu tur donusumunu sureklı yapmamız lazım)

        ContactMessage contactMessage = contactMessageMapper.requestToContactMessage(contactMessageRequest);
        //id bilgisi yok.contactmessage db ye gitmeden önce ki halini return edıyor
        ContactMessage savedData = contactMessageRepository.save(contactMessage);
        //id bilgisi var.Savedata ise; db den dönen nesneyi return ediyor.

        return ResponceMessage.<ContactMessageResponse>builder()
                .message("Contact Message Created Successfully ")
                .httpStatus(HttpStatus.CREATED) //201
                .object(contactMessageMapper.contactMessageToResponse(savedData))
                .build();


/*nesnenin değerini döndürürken(return ederken ) responce message donduruyor buıld dıye yazdırır
 normal sınıf olsa nokta buılder derdık
ama bu sınıf generıc bır sınıf buılder methodu kullanacaksak <> diomand operaturunu kullanırız.
 contactmessageresponce dondurecegı ıcın ıcıne yazarız
sonrasında buılder. generıc oldugu ıcın bu yapılır */


    }


}
