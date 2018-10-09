package com.vn.osp.notarialservices.announcement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minh on 11/8/2016.
 */
@Service
public class AnnouncementControllerHateoasBuilder {
    private final AnnouncementLinksFactory announcementLinksFactory;

    @Autowired
    public AnnouncementControllerHateoasBuilder(final AnnouncementLinksFactory announcementLinksFactory) {
        this.announcementLinksFactory = announcementLinksFactory;
    }
    List<Link> buildlinksforFindAnnouncementID(final Long id)  {
        List<Link> links = new ArrayList<Link>();
        links.add(announcementLinksFactory.getFindByAnnouncementID(id, Link.REL_SELF));
        return links;
    }
    List<Link> buildlinksforFindAnnouncement(final Long numOffset, final Long numLimit)  {
        List<Link> links = new ArrayList<Link>();
        links.add(announcementLinksFactory.getFindAnnouncement(numOffset,numLimit, Link.REL_SELF));
        return links;
    }
    List<Link> buildlinksforFindAnnouncementByFilter(final String stringFilter)  {
        List<Link> links = new ArrayList<Link>();
        links.add(announcementLinksFactory.getFindAnnouncementByFilter(stringFilter , Link.REL_SELF));
        return links;
    }
    List<Link> buildlinkscountTotalAnnoucement()  {
        List<Link> links = new ArrayList<Link>();
        links.add(announcementLinksFactory.getcountTotalAnnouncement(Link.REL_SELF));
        return links;
    }
    List<Link> buildlinksforDeleteAnnouncementByID(final Long aid)  {
        List<Link> links = new ArrayList<Link>();
        links.add(announcementLinksFactory.getDeleteAnnouncementById(aid, Link.REL_SELF));
        return links;
    }
    List<Link> buildlinksforFindLatestAnnouncement(final Long countNumber)  {
        List<Link> links = new ArrayList<Link>();
        links.add(announcementLinksFactory.getFindLatestAnnouncement(countNumber, Link.REL_SELF));
        return links;
    }
}
