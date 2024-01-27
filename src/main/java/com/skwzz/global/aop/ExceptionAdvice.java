package com.skwzz.global.aop;

import com.skwzz.global.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        FieldError fieldError = e.getBindingResult().getFieldErrors().get(0);
        String errorMessage = fieldError.getDefaultMessage();
        log.error(e.toString(), e);
        return ErrorResponse.builder()
                .errorCode("INVALID_PARAMETER")
                .errorMessage(errorMessage)
                .e(e)
                .build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ErrorResponse exceptionHandler(NoSuchElementException e){
        log.error(e.toString(), e);
        return ErrorResponse.builder()
                .errorCode(e.getClass().getName())
                .errorMessage(e.getMessage())
                .e(e)
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ErrorResponse exceptionHandler(Exception e){
        log.error(e.toString(), e);
        return ErrorResponse.builder()
                .errorCode(e.getClass().getName())
                .errorMessage(e.toString())
                .e(e)
                .build();
    }
}
