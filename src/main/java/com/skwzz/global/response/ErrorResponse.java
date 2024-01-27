package com.skwzz.global.response;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ErrorResponse {
    private String errorCode;
    private String errorMessage;
    private Exception e;
}
