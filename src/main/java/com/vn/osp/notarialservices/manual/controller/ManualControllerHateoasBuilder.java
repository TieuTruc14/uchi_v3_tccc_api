package com.vn.osp.notarialservices.manual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minh on 11/19/2016.
 */
@Service
public class ManualControllerHateoasBuilder {  private final ManualLinksFactory manualLinksFactory;

    @Autowired
    public ManualControllerHateoasBuilder(final ManualLinksFactory manualLinksFactory) {
        this.manualLinksFactory = manualLinksFactory;
    }
    List<Link> buildlinksforFindManualById(final Long id)  {
        List<Link> links = new ArrayList<Link>();
        links.add(manualLinksFactory.getFindByManualID(id, Link.REL_SELF));
        return links;
    }
    List<Link> buildlinksforDeleteManualById(final Long id)  {
        List<Link> links = new ArrayList<Link>();
        links.add(manualLinksFactory.getDeleteManualById(id, Link.REL_SELF));
        return links;
    }

    List<Link> buildlinksforCountTotalManual()  {
        List<Link> links = new ArrayList<Link>();
        links.add(manualLinksFactory.getcountTotalManual(Link.REL_SELF));
        return links;
    }
}
