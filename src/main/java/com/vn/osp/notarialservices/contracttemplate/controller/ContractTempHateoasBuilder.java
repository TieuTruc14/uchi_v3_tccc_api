package com.vn.osp.notarialservices.contracttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 7/6/2017.
 */
@Service
public class ContractTempHateoasBuilder {
    private final ContractTempLinksFactory contractTempLinksFactory;

    @Autowired
    public ContractTempHateoasBuilder(final ContractTempLinksFactory contractTempLinksFactory) {
        this.contractTempLinksFactory = contractTempLinksFactory;
    }
}
