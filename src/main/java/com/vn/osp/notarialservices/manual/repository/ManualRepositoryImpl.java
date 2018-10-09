package com.vn.osp.notarialservices.manual.repository;

import com.vn.osp.notarialservices.manual.domain.ManualBo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 11/19/2016.
 */
public class ManualRepositoryImpl implements ManualRepositoryCustom {
    private static final Logger LOG = Logger.getLogger(ManualRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired

    public ManualRepositoryImpl(JpaContext context) {
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
    public Optional<ManualBo> findManualByID(Long id) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("findManualByID");
            storedProcedure.setParameter("id", id);
            storedProcedure.execute();
            ManualBo manualBo = (ManualBo) storedProcedure.getSingleResult();
            return Optional.of(manualBo);
        } catch (Exception e) {
            LOG.error("Have an error in method findManualByID:" + e.getMessage());
            return Optional.of(new ManualBo());
        }
    }

    @Override
    public Optional<Boolean> deleteManualById(Long id) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("deleteManualByID");
            storedProcedure
                    .setParameter("manual_id", id);

            storedProcedure.execute();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method deleteManualByID:" + e.getMessage());
            return Optional.of(new Boolean(Boolean.valueOf(false)));
        }
    }

    @Override
    public Optional<List<ManualBo>> findManualByFilter(String stringFilter) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("findManualByFilter");
            storedProcedure
                    .setParameter("stringFilter", stringFilter);
            storedProcedure.execute();
            //String sql = "select * from npo_manual " + stringFilter;
            List<ManualBo> manualBo = (List<ManualBo>) storedProcedure.getResultList();
            //List<ManualBo> manualBoList = entityManager.createNativeQuery(sql, ManualBo.class).getResultList();

            return Optional.of(manualBo);
        } catch (Exception e) {
            LOG.error("Have an error in method findManualByFilter:" + e.getMessage());
            return Optional.of(new ArrayList<ManualBo>());
        }
    }

    @Override
    public Optional<BigInteger> countTotalManual() {
        BigInteger result = BigInteger.valueOf(0);
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("countTotalManual");
            storedProcedure.execute();
            result = (BigInteger) storedProcedure.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            LOG.error("Have an error in method countTotalManual:" + e.getMessage());
            return Optional.of(result);
        }
    }

    @Override
    public Optional<Boolean> AddManual(String title, String content, String file_name, String file_path, Long entryUserId, String entryUserName, Long updateUserId, String updateUserName) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("addManual");
            storedProcedure
                    .setParameter("title", title)
                    .setParameter("content", content)
                    .setParameter("file_name", file_name)
                    .setParameter("file_path", file_path)
                    .setParameter("entry_user_id", entryUserId)
                    .setParameter("entry_user_name", entryUserName)
                    .setParameter("update_user_id", updateUserId)
                    .setParameter("update_user_name", updateUserName);
            storedProcedure.execute();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method addManual:" + e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }

    public Optional<BigInteger> countTotalByFilter(String stringFilter) {
        BigInteger result = BigInteger.valueOf(0);
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("countTotalManualByFilter");
            storedProcedure.setParameter("stringFilter", stringFilter);
            storedProcedure.execute();
            result = (BigInteger) storedProcedure.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            LOG.error("Have an error in method countTotalManualByFilter:" + e.getMessage());
            return Optional.of(result);
        }
    }

    @Override
    public Optional<Boolean> updateManual(Long id, String title, String content, String file_name, String file_path, Long updateUserId, String updateUserName) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("updateManual");
            storedProcedure
                    .setParameter("id", id)
                    .setParameter("title", title)
                    .setParameter("content", content)
                    .setParameter("file_name", file_name)
                    .setParameter("file_path", file_path)
                    .setParameter("update_user_id", updateUserId)
                    .setParameter("update_user_name", updateUserName);
            storedProcedure.execute();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method updateManual:" + e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }

    @Override
    public Optional<Boolean> removeFile(Long id, String file_name, String file_path) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("removeFileManual");
            storedProcedure
                    .setParameter("id", id)
                    .setParameter("file_name", file_name)
                    .setParameter("file_path", file_path);
            storedProcedure.execute();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.of(Boolean.valueOf(false));
        }
    }

}