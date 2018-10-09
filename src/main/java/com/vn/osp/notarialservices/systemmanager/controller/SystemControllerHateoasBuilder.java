package com.vn.osp.notarialservices.systemmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by manhtran on 20/10/2016.
 */
@Service
class SystemControllerHateoasBuilder {

    private final SystemLinksFactory systemLinksFactory;

    @Autowired
    public SystemControllerHateoasBuilder(final SystemLinksFactory systemLinksFactory) {
        this.systemLinksFactory = systemLinksFactory;
    }


}
