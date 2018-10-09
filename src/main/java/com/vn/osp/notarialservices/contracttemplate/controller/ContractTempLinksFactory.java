package com.vn.osp.notarialservices.contracttemplate.controller;

import org.springframework.stereotype.Service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Admin on 7/6/2017.
 */
@Service
public class ContractTempLinksFactory {
    private static final ContractTempController CONTROLLER = methodOn(ContractTempController.class);
}
