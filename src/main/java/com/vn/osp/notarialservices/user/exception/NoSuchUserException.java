package com.vn.osp.notarialservices.user.exception;

import com.vn.osp.notarialservices.common.exception.ObjectNotFoundException;

/**
 * Created by longtran on 20/10/2016.
 */
public class NoSuchUserException extends ObjectNotFoundException {

    public NoSuchUserException(final Long userId) {
        super("ContractHistoryInfor [ " + userId + " ] not found");
    }

    public NoSuchUserException(final String username) {
        super("ContractHistoryInfor [ " + username + " ] not found");
    }
}
