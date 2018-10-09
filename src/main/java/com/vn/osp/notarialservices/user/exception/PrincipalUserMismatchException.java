package com.vn.osp.notarialservices.user.exception;

/**
 * Created by longtran on 20/10/2016.
 */
public class PrincipalUserMismatchException extends Exception {

    private static final long serialVersionUID = -5464030706060936824L;

    public PrincipalUserMismatchException(final String message) {
        super(message);
    }
}
