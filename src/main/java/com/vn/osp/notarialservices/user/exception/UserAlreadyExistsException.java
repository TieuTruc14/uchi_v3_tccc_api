package com.vn.osp.notarialservices.user.exception;

import com.vn.osp.notarialservices.common.exception.ObjectAlreadyExistsException;

/**
 * Created by longtran on 20/10/2016.
 */
public class UserAlreadyExistsException extends ObjectAlreadyExistsException {
    public UserAlreadyExistsException(final String username) {
        super("ContractHistoryInfor [ " + username + " ] already exists");
    }
}
