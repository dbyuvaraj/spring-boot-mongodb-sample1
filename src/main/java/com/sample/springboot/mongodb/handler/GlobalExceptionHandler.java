package com.sample.springboot.mongodb.handler;

import com.sample.springboot.mongodb.exception.AppException;
import com.sample.springboot.mongodb.model.response.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST);
        ErrorResponse.Error error = new ErrorResponse.Error(
                10000, "Error while reading request json"
        );
        errorResponse.setErrorList(new ArrayList<ErrorResponse.Error>() {{
            add(error);
        }});
        return buildResponseEntity(errorResponse);
    }

    @ExceptionHandler(AppException.class)
    protected ResponseEntity<Object> handleAppException(
            AppException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        ErrorResponse.Error error = new ErrorResponse.Error(
                ex.getErrorCode().getErrorCode(), ex.getErrorCode().getErrorMessage()
        );
        errorResponse.setErrorList(new ArrayList<ErrorResponse.Error>() {{
            add(error);
        }});
        return buildResponseEntity(errorResponse);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatusCode());
    }

}
