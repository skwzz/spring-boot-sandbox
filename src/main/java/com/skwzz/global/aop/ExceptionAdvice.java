package com.skwzz.global.aop;

import com.skwzz.global.response.ApiResponse;
import com.skwzz.global.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    protected ErrorResponse exceptionHandler(Exception e){
        return ErrorResponse.builder()
                .errorCode(e.getClass().getName())
                .errorMessage(e.toString())
                .build();
    }
}
