package org.example.taltree.domain.user.exception;

import org.example.taltree.global.exception.error.BusinessException;
import org.example.taltree.global.exception.error.ErrorCode;

public class UserNotExistException extends BusinessException {
    public static UserNotExistException Exception = new UserNotExistException();
    public UserNotExistException() { super(ErrorCode.USER_NOT_FOUND); }
}
