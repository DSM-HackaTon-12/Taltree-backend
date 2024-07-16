package org.example.taltree.domain.user.exception;

import org.example.taltree.global.exception.error.BusinessException;
import org.example.taltree.global.exception.error.ErrorCode;

public class EmailAlreadyExistsException  extends BusinessException {
    public static EmailAlreadyExistsException Exception = new EmailAlreadyExistsException();
    public EmailAlreadyExistsException() { super(ErrorCode.EMAIL_ALREADY_EXIST); }
}
