package org.example.taltree.domain.post.exception;

import org.example.taltree.global.exception.error.BusinessException;
import org.example.taltree.global.exception.error.ErrorCode;

public class IsNullPostElement extends BusinessException {
    public static IsNullPostElement NullPostException = new IsNullPostElement();
    public IsNullPostElement() {
        super(ErrorCode.POST_ELEMENT_IS_NULL);
    }
}
