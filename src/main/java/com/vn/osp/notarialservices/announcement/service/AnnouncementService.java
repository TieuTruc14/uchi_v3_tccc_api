package com.vn.osp.notarialservices.announcement.service;

import com.vn.osp.notarialservices.announcement.dto.Announcement;
import com.vn.osp.notarialservices.announcement.dto.NotaryOfficeByAnnouncement;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 11/7/2016.
 */
public interface AnnouncementService {

    Optional<Announcement> findAnnouncementByID(Long aid) ;

    Optional<List<Announcement>> findAnnouncement(Long numOffset, Long numLimit);

    Optional<List<Announcement>> findAnnouncementByFilter(String stringFilter) ;

    Optional<BigInteger> countTotalAnnouncement() ;

    Optional<Boolean> AddAnnouncement(String xml_content) ;

    Optional<Boolean> UpdateAnnouncement(String xml_content) ;

    Optional<Boolean> deleteAnnouncementById(Long aid);

    Optional<Boolean> removeFile(String input);

    Optional<List<Announcement>> findLatestAnnouncement(Long countNumber) ;

    Optional<List<Announcement>> popupAnnouncement() ;

    Optional<BigInteger> countTotalAnnouncementByFilter(String stringFilter) ;

    List<NotaryOfficeByAnnouncement> selectNotaryOfficeByAnnouncement(String stringFilter);


}

