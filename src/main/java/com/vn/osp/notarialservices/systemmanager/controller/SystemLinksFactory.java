package com.vn.osp.notarialservices.systemmanager.controller;

import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by manhtran on 20/10/2016.
 */
@Component
public class SystemLinksFactory {

    private static final SystemController CONTROLLER = methodOn(SystemController.class);


}
