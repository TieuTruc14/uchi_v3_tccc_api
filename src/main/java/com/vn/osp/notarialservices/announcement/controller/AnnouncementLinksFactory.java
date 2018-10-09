package com.vn.osp.notarialservices.announcement.controller;

import com.vn.osp.notarialservices.common.hateos.ExtendedLink;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by minh on 11/8/2016.
 */
@Service
public class AnnouncementLinksFactory {
    private static final AnnouncementController CONTROLLER = methodOn(AnnouncementController.class);

    public ExtendedLink getFindByAnnouncementID(final Long aid, final String rel)  {
        final Link link = linkTo(CONTROLLER.findAnnouncementByID(aid)).withRel(rel);

        return ExtendedLink.extend(link)
                .withName("findAnnouncementID")
                .withMethods("POST")
                .withDescription("Id Announcement");
    }
    public ExtendedLink getFindAnnouncement(final Long numOffset, final Long numLimit, final String rel) {
        final Link link = linkTo(CONTROLLER.findAnnouncement(numOffset,numLimit)).withRel(rel);

        return ExtendedLink.extend(link)
                .withName("findAnnouncement")
                .withMethods("POST")
                .withDescription("Announcement");
    }
    public ExtendedLink getFindAnnouncementByFilter(final String stringFilter, final String rel) {
        final Link link = linkTo(CONTROLLER.findAnnouncementByFilter(stringFilter)).withRel(rel);

        return ExtendedLink.extend(link)
                .withName("findAnnouncementByFilter")
                .withMethods("POST")
                .withDescription("Filter Announcement");
    }
    public ExtendedLink getcountTotalAnnouncement(final String rel)  {
        final Link link = linkTo(CONTROLLER.countTotalAnnouncement()).withRel(rel);

        return ExtendedLink.extend(link)
                .withName("countTotalAnnouncement")
                .withMethods("POST")
                .withDescription("Filter Announcement");
    }
    public ExtendedLink getDeleteAnnouncementById(final Long aid, final String rel)  {
        final Link link = linkTo(CONTROLLER.deleteAnnouncementById(aid)).withRel(rel);

        return ExtendedLink.extend(link)
                .withName("deleteAnnouncementById")
                .withMethods("POST")
                .withDescription("Id Announcement");
    }
    public ExtendedLink getFindLatestAnnouncement(final Long countNumber, final String rel)  {
        final Link link = linkTo(CONTROLLER.findLatestAnnouncement(countNumber)).withRel(rel);

        return ExtendedLink.extend(link)
                .withName("findLatestAnnouncement")
                .withMethods("POST")
                .withDescription("Announcement");
    }
}
