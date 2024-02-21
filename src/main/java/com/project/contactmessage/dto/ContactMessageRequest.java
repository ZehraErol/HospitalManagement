package com.project.contactmessage.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;




@Data //Data transfer objesi olduğu için loomboktan gelen @data kütüphanesının kullanıp getter-setter otomatık gelmesıni sağlıyorum.
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
//özelliği, Lombok tarafından otomatik olarak oluşturulan
// Builder sınıflarının bir kopyasını oluşturmak için kullanılır, böylece mevcut bir nesnenin durumundan yola çıkarak yeni bir nesne oluşturmak kolaylaşır.
// True ya çekme sebebim klonlama işlemini gerçekleştirmek için.
public class ContactMessageRequest { //anonim sınıf


    // id'yi burada kullanmamıza gerek yok. Çünkü bu istek kullanıcıdan json dosya ile gelecek eğer kullanıcıdan gelmesini istiyorsak service katında muhakkak setlememiz lazım. Bu yüzden gerek yok

    //Datetime vermemize de gerek yok kullanıcı ileri tarihli bir mesaj atarsa gelcekten bize mesaj mı atacak ?

    //Bu sınıfta validation yapılması gerekıyor çünkü isteği bu sınıf karşılıyor bilgi olmazsa response verilemez.

    @NotNull(message = "Please enter name")
    @Size(min = 4, max = 16, message = "Your name should be at least 4 chars")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+",message = "Your message must consist of the character.")
    private Long id;
    private String name;


    @Email(message = "Please enter valid email")
    @NotNull(message = "Please enter your email")
    @Size(min = 4, max = 20, message = "Your email should be at least 4 chars")
    private String email;


    @NotNull(message = "Please enter message")
    @Size(min = 4, max = 50, message = "Your name should be at least 4 chars")
    @Pattern(regexp = "\\A(?!\\s*\\Z).+",message = "Your message must consist of the character.")
    private String message;



}

//Regular Expression (Regex) string arama pattern'idir.
// Arama pattern'i tek bir karakter olabileceği gibi harf, rakam ve özel karakterlerden oluşan karakter grubu da olabilir.
// Regex, String arama ve String üzerinde değişiklik yapmak için kullanılır.