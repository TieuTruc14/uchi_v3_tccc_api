package com.vn.osp.notarialservices.user.controller;

import com.vn.osp.notarialservices.user.dto.User;
import com.vn.osp.notarialservices.user.exception.NoSuchUserException;
import com.vn.osp.notarialservices.user.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by longtran on 20/10/2016.
 */
@Service
class UserControllerHateoasBuilder {

    private final UserLinksFactory userLinksFactory;

    @Autowired
    public UserControllerHateoasBuilder(final UserLinksFactory userLinksFactory) {
        this.userLinksFactory = userLinksFactory;
    }


}
