package org.example.taltree.global.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // User
    PASSWORD_MISMATCHES(403, "비밀번호가 맞지 않습니다"),
    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다"),

    // General
    BAD_REQUEST(500, "서버 오류"),
    INTERNATIONAL_SERVER_ERROR(500, "서버 오류");

    private final Integer errorCode;
    private final String errorMessage;
}
