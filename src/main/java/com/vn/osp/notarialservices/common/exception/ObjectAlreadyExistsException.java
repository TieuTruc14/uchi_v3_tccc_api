package com.vn.osp.notarialservices.common.exception;

public abstract class ObjectAlreadyExistsException extends Exception {
    public ObjectAlreadyExistsException(final String message) {
        super(message);
    }
}
