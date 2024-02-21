package com.project.payload.response.business;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponceMessage <E>{

    private  E object;
    private String message;
    private HttpStatus httpStatus;

}
