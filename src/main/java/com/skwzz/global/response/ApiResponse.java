package com.skwzz.global.response;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean result;
    private T body;
    private String errorCode;
    private String errorMessage;
}
