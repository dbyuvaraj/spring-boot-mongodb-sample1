package com.sample.springboot.mongodb.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    private HttpStatus httpStatusCode;
    private List<Error> errorList;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Error {
        private int errorCode;
        private String errorMessage;
    }
}


