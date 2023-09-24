package com.skwzz.global.aop;

import com.skwzz.global.response.ApiResponse;
import com.skwzz.global.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("--- RESPONSE ADVICE ---");
        if(body instanceof ErrorResponse){
            return ApiResponse.<Object>builder()
                    .result(false)
                    .errorCode(((ErrorResponse) body).getErrorCode())
                    .errorMessage(((ErrorResponse) body).getErrorMessage())
                    .build();
        }else{
            return ApiResponse.<Object>builder()
                    .result(true)
                    .body(body)
                    .build();
        }
    }
}
