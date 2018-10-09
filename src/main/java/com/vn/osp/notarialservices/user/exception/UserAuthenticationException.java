package com.vn.osp.notarialservices.user.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by longtran on 20/10/2016.
 */
public class UserAuthenticationException extends AuthenticationException {

    private static final long serialVersionUID = 8032566286692538282L;

    public UserAuthenticationException(final String message) {
        super(message);
    }
}
