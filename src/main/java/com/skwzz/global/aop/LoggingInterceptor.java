package com.skwzz.global.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Slf4j
@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private final ObjectMapper objectMapper;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(request.getClass().getName().contains("SecurityContextHolderAwareRequestWrapper")) {
            return;
        }

        final ContentCachingRequestWrapper wRequest = (ContentCachingRequestWrapper) request;
        final ContentCachingResponseWrapper wResponse = (ContentCachingResponseWrapper) response;
        StringBuilder logMsg = new StringBuilder("\n");
        logMsg.append("====================================================================================================").append("\n");
        logMsg.append("===============================").append("\n");
        logMsg.append("----------- REQUEST -----------").append("\n");
        logMsg.append("===============================").append("\n");
        logMsg.append("HEADER : ").append("\n");
        logMsg.append("\tURL : ").append(wRequest.getRequestURL()).append("\n");
        logMsg.append("\tURI : ").append(wRequest.getRequestURI()).append("\n");
        logMsg.append("\tMETHOD : ").append(wRequest.getMethod()).append("\n");
        logMsg.append("\tREMOTE ADDR : ").append(wRequest.getRemoteAddr()).append("\n");
        logMsg.append("BODY :").append("\n");
        if (wRequest.getContentType() != null && (wRequest.getContentType().contains("application/json") || !wRequest.getContentType().contains("multipart/form-data"))) {
            if (wRequest.getContentAsByteArray() != null && wRequest.getContentAsByteArray().length != 0){
                logMsg.append(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectMapper.readTree(wRequest.getContentAsByteArray()))).append("\n");
            }
        }
        logMsg.append("================================").append("\n");
        logMsg.append("----------- RESPONSE -----------").append("\n");
        logMsg.append("================================").append("\n");
        logMsg.append("HEADER : ").append("\n");
        logMsg.append("\tSTATUS : ").append(wResponse.getStatus()).append("\n");
        // TODO: BODY는 값이 너무 커질 수 있어 다시 생각해야할듯
        logMsg.append("BODY : ").append("\n");
        if (wResponse.getContentType() != null && (wResponse.getContentType().contains("application/json") || wResponse.getContentType().contains("multipart/form-data"))) {
            if (wResponse.getContentAsByteArray() != null && wResponse.getContentAsByteArray().length != 0) {
                logMsg.append(objectMapper.readTree(wResponse.getContentAsByteArray())).append("\n");
            }
        }
        logMsg.append("====================================================================================================").append("\n");
        log.info(logMsg.toString());
    }
}
