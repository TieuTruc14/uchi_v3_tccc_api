package com.vn.osp.notarialservices.common.exception;

public abstract class ObjectExpiredException extends Exception {
    public ObjectExpiredException(final String message) {
        super(message);
    }
}
