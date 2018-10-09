package com.vn.osp.notarialservices.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by minh on 11/24/2016.
 */
@Service
public class TransactionPropertyControllerHateoasBuilder {
    private final TransactionPropertyLinksFactory transactionLinksFactory;

    @Autowired
    public TransactionPropertyControllerHateoasBuilder(final TransactionPropertyLinksFactory transactionLinksFactory) {
        this.transactionLinksFactory = transactionLinksFactory;
    }
}
