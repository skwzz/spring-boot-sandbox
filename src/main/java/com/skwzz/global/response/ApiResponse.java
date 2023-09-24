package com.skwzz.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean result;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T body;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;
}
