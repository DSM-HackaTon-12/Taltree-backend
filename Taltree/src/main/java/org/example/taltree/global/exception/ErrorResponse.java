package org.example.taltree.global.exception;

import org.example.taltree.global.exception.error.ErrorCode;

import java.time.LocalDateTime;
import java.util.Date;

public record ErrorResponse (
        int statusCode,
        String statusMessage,
        String description,
        LocalDateTime timeStamp
) {
    public static ErrorResponse of (ErrorCode errorCode) {
        return new ErrorResponse(errorCode.getErrorCode(), errorCode.getErrorMessage(), errorCode.getErrorMessage(), LocalDateTime.now());
    }
}
