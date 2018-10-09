package com.vn.osp.notarialservices.user.exception;

import com.vn.osp.notarialservices.common.exception.ObjectExpiredException;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by longtran on 20/10/2016.
 */
public class UserPasswordTokenExpiredException extends ObjectExpiredException {
    public UserPasswordTokenExpiredException(final Long userId, final String token, final LocalDateTime createdTs) {
        super("ContractHistoryInfor password token for user [ " + userId + " ] and token [ " + token + " ] expired at [ " + createdTs + " ]");
    }
}
