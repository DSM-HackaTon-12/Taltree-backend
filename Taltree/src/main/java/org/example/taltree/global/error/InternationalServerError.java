package org.example.taltree.global.error;

import org.example.taltree.global.exception.error.BusinessException;
import org.example.taltree.global.exception.error.ErrorCode;

public class InternationalServerError extends BusinessException {
    public static InternationalServerError Exception = new InternationalServerError();
    public InternationalServerError() { super(ErrorCode.INTERNATIONAL_SERVER_ERROR); }
}
