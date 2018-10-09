package com.vn.osp.notarialservices.manual.controller;

import com.vn.osp.notarialservices.common.hateos.ExtendedLink;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by minh on 11/19/2016.
 */
@Service
public class ManualLinksFactory {
    private static final ManualController CONTROLLER = methodOn(ManualController.class);
    public ExtendedLink getFindByManualID(final Long id, final String rel)  {
        final Link link = linkTo(CONTROLLER.findManualByID(id)).withRel(rel);

        return ExtendedLink.extend(link)
                .withName("findManualById")
                .withMethods("POST")
                .withDescription("Id Manual");
    }
    public ExtendedLink getDeleteManualById(final Long id, final String rel)  {
        final Link link = linkTo(CONTROLLER.findManualByID(id)).withRel(rel);

        return ExtendedLink.extend(link)
                .withName("deleteManualById")
                .withMethods("POST")
                .withDescription("Id Manual");
    }
    public ExtendedLink getFindManualByFilter(final String stringFilter, final String rel) {
        final Link link = linkTo(CONTROLLER.findManualByFilter(stringFilter)).withRel(rel);

        return ExtendedLink.extend(link)
                .withName("findManualByFilter")
                .withMethods("POST")
                .withDescription("Filter Announcement");
    }
    public ExtendedLink getcountTotalManual( final String rel)  {
        final Link link = linkTo(CONTROLLER.countTotalManual()).withRel(rel);

        return ExtendedLink.extend(link)
                .withName("countTotalManual")
                .withMethods("POST")
                .withDescription("Count Total Manual");
    }

}
