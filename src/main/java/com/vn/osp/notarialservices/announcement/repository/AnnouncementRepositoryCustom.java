package com.vn.osp.notarialservices.announcement.repository;

import com.vn.osp.notarialservices.announcement.domain.AnnouncementBo;
import com.vn.osp.notarialservices.announcement.dto.Announcement;
import com.vn.osp.notarialservices.announcement.dto.NotaryOfficeByAnnouncement;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 11/7/2016.
 */
public interface AnnouncementRepositoryCustom {
    /**
     * Method actually triggering a finder but being overridden.
     */
    void findByOverridingMethod();

    /***
     *
     * @param id
     */
    void delete(Integer id);

    Optional<AnnouncementBo> findAnnouncementByID(Long aid);

    Optional<List<AnnouncementBo>> findAnnouncement(Long numOffset, Long numLimit);

    Optional<List<AnnouncementBo>> findAnnouncementByFilter(String stringFilter);

    Optional<BigInteger> countTotalAnnouncement() ;

    Optional<Boolean> AddAnnouncement(String xml_content) ;

    Optional<Boolean> UpdateAnnouncement(String xml_content) ;

    Optional<Boolean> deleteAnnouncementById(Long aid);

    Optional<Boolean> removeFile(Long aid, String filename, String filepath);

    Optional<List<AnnouncementBo>> findLatestAnnouncement(Long countNumber);

    Optional<List<AnnouncementBo>> popupAnnouncement();

    Optional<BigInteger> countTotalAnnouncementByFilter(String stringFilter) ;

    List<NotaryOfficeByAnnouncement> selectNotaryOfficeByAnnouncement(String stringFilter);






}
