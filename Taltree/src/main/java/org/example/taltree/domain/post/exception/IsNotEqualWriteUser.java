package org.example.taltree.domain.post.exception;

import org.example.taltree.global.exception.error.BusinessException;
import org.example.taltree.global.exception.error.ErrorCode;

public class IsNotEqualWriteUser extends BusinessException {
    public static IsNotEqualWriteUser NotEqualException = new IsNotEqualWriteUser();
    public IsNotEqualWriteUser() {
        super(ErrorCode.POST_WRITER_IS_NOT_MATCH);
    }
}
