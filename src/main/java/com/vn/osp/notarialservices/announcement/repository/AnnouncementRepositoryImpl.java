package com.vn.osp.notarialservices.announcement.repository;

import com.vn.osp.notarialservices.announcement.domain.AnnouncementBo;
import com.vn.osp.notarialservices.announcement.dto.NotaryOfficeByAnnouncement;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 11/7/2016.
 */
public class AnnouncementRepositoryImpl implements AnnouncementRepositoryCustom {
    private static final Logger LOG = Logger.getLogger(AnnouncementRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired

    public AnnouncementRepositoryImpl(JpaContext context) {
        Assert.notNull(context, "JpaContext must not be null!");
    }

    public void findByOverridingMethod() {
        LOG.info("A method overriding a finder was invoked!");
    }

    @Override
    public void delete(Integer id) {
        LOG.info("A method overriding a finder was invoked!");
    }


    @Override
    public Optional<AnnouncementBo> findAnnouncementByID(Long aid) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("findAnnouncementByID");
            storedProcedure.execute();
            AnnouncementBo announcementBo = (AnnouncementBo) storedProcedure.getSingleResult();
            return Optional.of(announcementBo);
        } catch (Exception e) {
            LOG.error("Have an error in method findAnnouncementByID:"+e.getMessage());
            return Optional.of(new AnnouncementBo());
        }
    }


    @Override
    public Optional<List<AnnouncementBo>> findAnnouncement(Long numOffset, Long numLimit) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("findAnnouncement");
            storedProcedure
                    .setParameter("numOffset", numOffset)
                    .setParameter("numLimit", numLimit);
            storedProcedure.execute();
            List<AnnouncementBo> announcementBo = (List<AnnouncementBo>) storedProcedure.getResultList();
            return Optional.of(announcementBo);
        } catch (Exception e) {
            LOG.error("Have an error in method findAnnouncement:"+e.getMessage());
            return Optional.of(new ArrayList<AnnouncementBo>());
        }
    }

    @Override
    public Optional<List<AnnouncementBo>> findAnnouncementByFilter(String stringFilter) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("findAnnouncementByFilter");
            storedProcedure
                    .setParameter("stringFilter", stringFilter);
            storedProcedure.execute();
           return Optional.of((List<AnnouncementBo>)storedProcedure.getResultList());
        } catch (Exception e) {
            LOG.error("Have an error in method  findAnnouncementByFilter:"+e.getMessage());
            return Optional.of(new ArrayList<AnnouncementBo>());
        }
    }

    @Override
    public Optional<BigInteger> countTotalAnnouncement() {
        BigInteger result = BigInteger.valueOf(0);
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("countTotalAnnouncement");
            storedProcedure.execute();
            result = (BigInteger) storedProcedure.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            LOG.error("Have an error in method  countTotalAnnouncement:"+e.getMessage());
            return Optional.of(result);
        }
    }

    @Override
    public Optional<BigInteger> countTotalAnnouncementByFilter(String stringFilter) {
        BigInteger result = BigInteger.valueOf(0);
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("countTotalAnnouncementByFilter")
                    .setParameter("stringFilter", stringFilter);
            storedProcedure.execute();
            result = (BigInteger) storedProcedure.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
           LOG.error("Have an error in method countTotalAnnouncementByFilter:"+e.getMessage());
            return Optional.of(result);
        }
    }


    @Override
    public Optional<Boolean> AddAnnouncement(String xml_content) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("AddAnnouncement");
            storedProcedure
                    .setParameter("announcement_content", xml_content);
            storedProcedure.execute();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method AddAnouncement:"+e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }

    @Override
    public Optional<Boolean> UpdateAnnouncement(String xml_content) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("UpdateAnnouncement");
            storedProcedure
                    .setParameter("announcement_content", xml_content);
            storedProcedure.execute();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method UpdateAnnouncement:"+e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }

    @Override
    public Optional<Boolean> deleteAnnouncementById(Long aid) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("DeleteAnnouncement");
            storedProcedure
                    .setParameter("aid", aid);
            storedProcedure.execute();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method deleteAnnouncementById:"+e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }

    @Override
    public Optional<Boolean> removeFile(Long aid, String filename, String filepath) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_announcement_remove_file");
            storedProcedure
                    .setParameter("aid", aid)
                    .setParameter("file_name",filename)
                    .setParameter("file_path",filepath);
            storedProcedure.execute();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method removeFile:"+e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }

    @Override
    public Optional<List<AnnouncementBo>> findLatestAnnouncement(Long countNumber) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("FindLatestAnnouncement");
            storedProcedure
                    .setParameter("countNumber", countNumber);
            storedProcedure.execute();
            List<AnnouncementBo> announcementBo = (List<AnnouncementBo>) storedProcedure.getResultList();
            return Optional.of(announcementBo);
        } catch (Exception e) {
            LOG.error("Have an error in method  FindLatestAnnouncement:"+e.getMessage());
            return Optional.of(new ArrayList<AnnouncementBo>());
        }
    }

    @Override
    public Optional<List<AnnouncementBo>> popupAnnouncement() {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("PopupAnnouncement");
            storedProcedure.execute();
            List<AnnouncementBo> announcementBo = (List<AnnouncementBo>) storedProcedure.getResultList();
            return Optional.of(announcementBo);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.of(new ArrayList<AnnouncementBo>());
        }
    }
    @Override
    public List<NotaryOfficeByAnnouncement> selectNotaryOfficeByAnnouncement(String stringFilter) {
        try {
            List<NotaryOfficeByAnnouncement> notaryOfficeByAnnouncements = new ArrayList<NotaryOfficeByAnnouncement>();
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("stp_npo_select_notary_office_by_announcement");
            storedProcedure.setParameter("stringFilter", stringFilter);
            storedProcedure.execute();
            List<Object[]> results = storedProcedure.getResultList();

            results.stream().forEach((record) -> {
                NotaryOfficeByAnnouncement notaryOfficeByAnnouncement = new NotaryOfficeByAnnouncement();

                notaryOfficeByAnnouncement.setName                           (record[0]==null?null:((String)record[0]));
                notaryOfficeByAnnouncement.setAid                              (record[1]==null?null:((Integer)record[1]).intValue());
                notaryOfficeByAnnouncement.setOffice_type                    (record[2]==null?null:((Byte)record[2]).byteValue());
                notaryOfficeByAnnouncement.setAuthentication_id              (record[3]==null?null:((String)record[3]));
                notaryOfficeByAnnouncements.add(notaryOfficeByAnnouncement);
            });

            return notaryOfficeByAnnouncements;
        } catch (Exception e) {
           LOG.error("Have an error in method selecdtNotaryOfficeByAnnouncement:"+e.getMessage());
            return new ArrayList<NotaryOfficeByAnnouncement>();
        }
    }

}