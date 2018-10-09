package com.vn.osp.notarialservices.bank.repository;

import com.vn.osp.notarialservices.bank.domain.BankBo;
import com.vn.osp.notarialservices.bank.dto.AddBank;
import com.vn.osp.notarialservices.bank.dto.Bank;
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
 * Created by minh on 2/22/2017.
 */
public class BankRepositoryImpl implements BankRepositoryCustom {
    private static final Logger LOG = Logger.getLogger(BankRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public BankRepositoryImpl(JpaContext context) {
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
    public Optional<List<BankBo>> selectBank(String stringFilter) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("selectBank");
            storedProcedure
                    .setParameter("stringFilter", stringFilter);
            storedProcedure.execute();
            List<BankBo> result = storedProcedure.getResultList();

            return Optional.of((List<BankBo>)(result));
        } catch (Exception e) {
            LOG.error("Have an error in method selectBank:"+e.getMessage());
            return Optional.of(new ArrayList<BankBo>());
        }
    }

    @Override
    public Optional<List<BankBo>> getAllBank() {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("stp_npo_bank_getAll");
            storedProcedure.execute();
            List<BankBo> result = storedProcedure.getResultList();
            //nmha for test

            return Optional.of((List<BankBo>)(result));
        } catch (Exception e) {
            LOG.error("Have an error in method getAllBank:"+e.getMessage());
            return Optional.of(new ArrayList<BankBo>());
        }
    }

    @Override
    public Optional<BigInteger> countBank(String stringFiltler) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_bank_count");
            storedProcedureQuery.setParameter("stringFilter", stringFiltler);
            // execute StoredProcedureQuery
            storedProcedureQuery.execute();
            BigInteger result = (BigInteger) storedProcedureQuery.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            LOG.error("Have an error in method countBank:"+e.getMessage());
            return Optional.of(BigInteger.valueOf(0));
        }
    }

    @Override
    public Optional<Boolean> addBank(String name , Long entryUserId, String entryUserName, String code, Long active) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("addBank");
            storedProcedureQuery
                    .setParameter("name", name)
                    .setParameter("entry_user_id", entryUserId)
                    .setParameter("entry_user_name", entryUserName)
                    .setParameter("code", code)
                    .setParameter("active", active);

            storedProcedureQuery.execute();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method addBank:"+e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }

    @Override
    public Optional<Boolean> updateBank(Bank bank) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_bank_update");
            storedProcedureQuery.setParameter("id", bank.getSid());
            storedProcedureQuery.setParameter("name", bank.getName());
            storedProcedureQuery.setParameter("order_number", bank.getOrder_number()==null?0:bank.getOrder_number());
            storedProcedureQuery.setParameter("update_user_id", bank.getUpdate_user_id());
            storedProcedureQuery.setParameter("update_user_name", bank.getUpdate_user_name());
            storedProcedureQuery.setParameter("update_date_time", bank.getUpdate_date_time());
            storedProcedureQuery.setParameter("active", bank.getActive());


            storedProcedureQuery.execute();
            return Optional.of(true);
        } catch (Exception e) {
            LOG.error("Have an error in method updateBank:"+e.getMessage());
        }
        return Optional.of(false);
    }

    @Override
    public  Optional<BankBo> getById(String id){
        try{
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_bank_get_by_id");
            storedProcedure
                    .setParameter("id", id);
            storedProcedure.execute();
            return Optional.ofNullable((BankBo)storedProcedure.getSingleResult());
        }catch (Exception e){
            LOG.error("Have an error in method getById:"+e.getMessage());
            return Optional.ofNullable(new BankBo());
        }

    }

    @Override
    public  Optional<BankBo> getByCode(String code){
        try{
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_bank_get_by_code");
            storedProcedure
                    .setParameter("code", code);
            storedProcedure.execute();
            return Optional.ofNullable((BankBo)storedProcedure.getSingleResult());
        }catch (Exception e){
            LOG.error("Have an error in method getByCode:"+e.getMessage());
            return Optional.ofNullable(new BankBo());
        }

    }
}
