package com.sample.springboot.mongodb.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends Exception {
    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode){
        this.errorCode = errorCode;
    }

    public AppException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }

}
