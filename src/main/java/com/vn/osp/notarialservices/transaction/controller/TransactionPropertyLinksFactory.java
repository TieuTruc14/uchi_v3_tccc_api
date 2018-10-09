package com.vn.osp.notarialservices.transaction.controller;

import com.vn.osp.notarialservices.common.hateos.ExtendedLink;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by minh on 11/24/2016.
 */
@Service
public class TransactionPropertyLinksFactory {
    private static final TransactionPropertyController CONTROLLER = methodOn(TransactionPropertyController.class);

    public ExtendedLink getFindTransactionByFilter(final String stringFilter, final String rel) {
        final Link link = linkTo(CONTROLLER.findTransactionByFilter(stringFilter)).withRel(rel);

        return ExtendedLink.extend(link)
                .withName("findTransactionByFilter")
                .withMethods("POST")
                .withDescription("Filter Transaction");
    }
}
