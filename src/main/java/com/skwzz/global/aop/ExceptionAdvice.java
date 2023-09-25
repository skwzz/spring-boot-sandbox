package com.skwzz.global.aop;

import com.skwzz.global.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ErrorResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        FieldError fieldError = e.getBindingResult().getFieldErrors().get(0);
        String errorMessage = fieldError.getDefaultMessage();
        log.error(e.toString(), e);
        return ErrorResponse.builder()
                .errorCode("INVALID_PARAMETER")
                .errorMessage(errorMessage)
                .build();
    }

    @ExceptionHandler(Exception.class)
    protected ErrorResponse exceptionHandler(Exception e){
        log.error(e.toString(), e);
        return ErrorResponse.builder()
                .errorCode(e.getClass().getName())
                .errorMessage(e.toString())
                .build();
    }
}
