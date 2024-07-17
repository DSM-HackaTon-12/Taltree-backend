package org.example.taltree.global.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // User
    PASSWORD_MISMATCHES(403, "비밀번호가 맞지 않습니다"),
    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다"),
    EMAIL_ALREADY_EXIST(409, "이미 가입된 이메일"),

    //Post
    POST_ELEMENT_NOT_FOUND(404,"게시물을 찾을 수 없습니다"),
    POST_ELEMENT_IS_NULL(400,"필수 입력은 반드시 입력되어야 합니다"),
    POST_WRITER_IS_NOT_MATCH(403,"권한이 없거나, 게시물이 존재하지 않습니다"),

    // General
    BAD_REQUEST(500, "서버 오류"),
    INTERNATIONAL_SERVER_ERROR(500, "서버 오류");

    private final Integer errorCode;
    private final String errorMessage;
}
