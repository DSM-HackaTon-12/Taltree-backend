package org.example.taltree.domain.post.exception;

import org.example.taltree.global.exception.error.BusinessException;
import org.example.taltree.global.exception.error.ErrorCode;

public class NoExistPostElement extends BusinessException {
    public static NoExistPostElement Exception = new NoExistPostElement();
    public NoExistPostElement() {
        super(ErrorCode.POST_ELEMENT_NOT_FOUND);
    }
}
