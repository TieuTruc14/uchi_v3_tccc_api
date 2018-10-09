package com.vn.osp.notarialservices.user.exception;

import com.vn.osp.notarialservices.common.exception.ObjectNotFoundException;

/**
 * Created by longtran on 20/10/2016.
 */
public class NoSuchUserPasswordTokenException extends ObjectNotFoundException {
    public NoSuchUserPasswordTokenException(final Long userId, final String token) {
        super("ContractHistoryInfor password token for user [ " + userId + " ] and token [ " + token + " ] not found");
    }
}
