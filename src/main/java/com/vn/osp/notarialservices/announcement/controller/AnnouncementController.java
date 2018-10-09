package com.vn.osp.notarialservices.announcement.controller;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.vn.osp.notarialservices.announcement.dto.Announcement;
import com.vn.osp.notarialservices.announcement.dto.NotaryOfficeByAnnouncement;
import com.vn.osp.notarialservices.announcement.service.AnnouncementService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by minh on 11/8/2016.
 */
@Controller
@RequestMapping(value="/announcement")
public class AnnouncementController {
    private static final Logger LOGGER = Logger.getLogger(AnnouncementController.class);

    private final AnnouncementService announcementService;
    private final AnnouncementControllerHateoasBuilder announcementControllerHateoasBuilder;

    @Autowired
    public AnnouncementController(final AnnouncementService announcementService, final AnnouncementControllerHateoasBuilder announcementControllerHateoasBuilder){
        this.announcementService = announcementService;
        this.announcementControllerHateoasBuilder = announcementControllerHateoasBuilder;
    }
    @RequestMapping(value="/findbyID", method = RequestMethod.POST)
    public ResponseEntity<Announcement> findAnnouncementByID(@RequestParam final Long aid) {
        Announcement announcementOptional = announcementService.findAnnouncementByID(aid).orElse(new Announcement());
        return new ResponseEntity<Announcement>(announcementOptional, HttpStatus.OK);
    }
    @RequestMapping(value="/findAnnouncement", method = RequestMethod.POST)
    public ResponseEntity<List<Announcement>> findAnnouncement(@RequestParam final Long numOffset,@RequestParam final Long numLimit ){
        List<Announcement> announcement = announcementService.findAnnouncement(numOffset, numLimit).orElse(new ArrayList<Announcement>());

        return new ResponseEntity<List<Announcement>>(announcement, HttpStatus.OK);
    }
    @RequestMapping(value="/findAnnouncementByFilter", method = RequestMethod.POST)
        public ResponseEntity<List<Announcement>> findAnnouncementByFilter(@RequestBody final String stringFilter ){
            List<Announcement> announcement = announcementService.findAnnouncementByFilter(stringFilter).orElse(null);

            return new ResponseEntity<List<Announcement>>(announcement, HttpStatus.OK);
    }
    @RequestMapping(value = "/countTotal", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countTotalAnnouncement()  {
        BigInteger result = announcementService.countTotalAnnouncement().orElse(BigInteger.valueOf(0));

        return new ResponseEntity<BigInteger>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/countTotalByFilter", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countTotalAnnouncementByFilter(@RequestBody String stringFilter)  {
        BigInteger result = announcementService.countTotalAnnouncementByFilter(stringFilter).orElse(BigInteger.valueOf(0));

        return new ResponseEntity<BigInteger>(result, HttpStatus.OK);

    }
    @RequestMapping(value = "/AddAnnouncement", method = RequestMethod.POST)
    public ResponseEntity<Boolean> AddAnnouncement(@RequestBody @Valid  Announcement announcement)  {
        XmlFriendlyReplacer replacer = new XmlFriendlyReplacer("ddd", "_");
        XStream xXStream = new XStream(new DomDriver("UTF-8", replacer));
        xXStream.autodetectAnnotations(true);
        // OBJECT --> XML
        String announcement_content = xXStream.toXML(announcement);
        return new ResponseEntity<Boolean>((Boolean)announcementService.AddAnnouncement(announcement_content).orElse(false), HttpStatus.OK);
    }
    @RequestMapping(value = "/UpdateAnnouncement", method = RequestMethod.POST)
    public ResponseEntity<Boolean> UpdateAnnouncement(@RequestBody @Valid final Announcement announcement)  {
        XmlFriendlyReplacer replacer = new XmlFriendlyReplacer("ddd", "_");
        XStream xXStream = new XStream(new DomDriver("UTF-8", replacer));
        xXStream.autodetectAnnotations(true);
        // OBJECT --> XML
        String announcement_content = xXStream.toXML(announcement);
        return new ResponseEntity<Boolean>((Boolean) announcementService.UpdateAnnouncement(announcement_content).orElse(false), HttpStatus.OK);
    }
    @RequestMapping(value = "/removeFile", method = RequestMethod.POST)
    public ResponseEntity<Boolean> removeFile(@RequestBody @Valid final String input)  {

        return new ResponseEntity<Boolean>((Boolean) announcementService.removeFile(input).orElse(false), HttpStatus.OK);
    }
    @RequestMapping(value="/deleteByID", method = RequestMethod.POST)
    public ResponseEntity<Boolean> deleteAnnouncementById(@RequestBody final Long aid)  {
        Boolean result = announcementService.deleteAnnouncementById(aid).orElse(Boolean.valueOf(false));
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }
    @RequestMapping(value = "/findLatestAnnouncement", method = RequestMethod.POST)
    public ResponseEntity<List<Announcement>> findLatestAnnouncement(@RequestBody final Long countNumber)  {
        List<Announcement> announcement = announcementService.findLatestAnnouncement(countNumber).orElse(new ArrayList<Announcement>());

        return new ResponseEntity<List<Announcement>>(announcement, HttpStatus.OK);
    }
    @RequestMapping(value="/popupAnnouncement", method = RequestMethod.POST)
    public ResponseEntity<List<Announcement>> popupAnnouncement()  {
        List<Announcement> announcement = announcementService.popupAnnouncement().orElse(new ArrayList<Announcement>());
        return new ResponseEntity<List<Announcement>>(announcement, HttpStatus.OK);
    }
    @RequestMapping(value="/selectNotaryByAnnouncement", method = RequestMethod.POST)
    public ResponseEntity<List<NotaryOfficeByAnnouncement>> selectNotaryByAnnouncement(@RequestBody String stringFilter)  {
        List<NotaryOfficeByAnnouncement> notaryOfficeByAnnouncement = announcementService.selectNotaryOfficeByAnnouncement(stringFilter);
        return new ResponseEntity<List<NotaryOfficeByAnnouncement>>(notaryOfficeByAnnouncement, HttpStatus.OK);
    }




}