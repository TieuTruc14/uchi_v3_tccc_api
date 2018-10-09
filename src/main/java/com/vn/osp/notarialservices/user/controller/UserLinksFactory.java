package com.vn.osp.notarialservices.user.controller;

import com.vn.osp.notarialservices.user.dto.User;
import com.vn.osp.notarialservices.common.hateos.ExtendedLink;
import com.vn.osp.notarialservices.user.exception.NoSuchUserException;
import com.vn.osp.notarialservices.user.exception.UserAlreadyExistsException;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import java.security.Principal;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by longtran on 20/10/2016.
 */
@Component
public class UserLinksFactory {

    private static final UserController CONTROLLER = methodOn(UserController.class);


}
