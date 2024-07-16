package org.example.taltree.domain.user.exception;

import org.example.taltree.global.exception.error.BusinessException;
import org.example.taltree.global.exception.error.ErrorCode;

public class PasswordMismatchesException extends BusinessException {
    public static PasswordMismatchesException Exception = new PasswordMismatchesException();
    public PasswordMismatchesException() { super(ErrorCode.PASSWORD_MISMATCHES); }
}
