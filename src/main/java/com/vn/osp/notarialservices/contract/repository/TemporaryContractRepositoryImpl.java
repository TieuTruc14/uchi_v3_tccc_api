package com.vn.osp.notarialservices.contract.repository;

import com.vn.osp.notarialservices.contract.domain.ContractBO;
import com.vn.osp.notarialservices.contract.domain.ContractHistoryInfoBO;
import com.vn.osp.notarialservices.contract.domain.ContractNumberBO;
import com.vn.osp.notarialservices.contract.domain.TemporaryContractBO;
import com.vn.osp.notarialservices.transaction.domain.TransactionPropertyBo;
import com.vn.osp.notarialservices.utils.SystemProperties;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by TienManh on 5/13/2017.
 */
public class TemporaryContractRepositoryImpl implements TemporaryContractRepositoryCustom {
    private static final Logger LOG = Logger.getLogger(TemporaryContractRepositoryImpl.class);
    @PersistenceContext
    private EntityManager entityManager;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public TemporaryContractRepositoryImpl(JpaContext context) {
        Assert.notNull(context, "JpaContext must not be null!");
    }

    @Override
    public Optional<List<TemporaryContractBO>> getAllTemporaryContract(){
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_temporary_contract_getAll");
            storedProcedure.execute();
            List<TemporaryContractBO> result = storedProcedure.getResultList();
            return Optional.of((List<TemporaryContractBO>)(result));
        } catch (Exception e) {
            LOG.error("Have an error in method getAllTemporaryContract:"+e.getMessage());
            return Optional.of(new ArrayList<TemporaryContractBO>());
        }
    }


    @Override
    public Optional<List<TemporaryContractBO>> getTemporaryByType(String type){
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_temporary_contract_get_by_type");
            storedProcedure.setParameter("type", type);
            storedProcedure.execute();
            List<TemporaryContractBO> result = storedProcedure.getResultList();
            return Optional.of(result);
        } catch (Exception e) {
            LOG.error("Have an error in method getTemporaryByType:"+e.getMessage());
            return Optional.of(new ArrayList<TemporaryContractBO>());
        }
    }

    @Override
    public Optional<List<TemporaryContractBO>> getTemporaryByFilter(String filter){
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_temporary_contract_by_filter");
            storedProcedure.setParameter("stringFilter", filter);
            storedProcedure.execute();
            List<TemporaryContractBO> result = storedProcedure.getResultList();
            return Optional.of(result);
        } catch (Exception e) {
            LOG.error("Have an error in method getTemporaryByFiler:"+e.getMessage());
            return Optional.of(new ArrayList<TemporaryContractBO>());
        }
    }

    @Override
    public Optional<BigInteger> countTemporaryByFilter(String filter) {
        BigInteger result = BigInteger.valueOf(0);
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_temporary_contract_count_by_filter");
            storedProcedure.setParameter("stringFilter", filter);
            storedProcedure.execute();
            result = (BigInteger) storedProcedure.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            LOG.error("Have an error in method countTemporaryByFilter:"+e.getMessage());
            return Optional.of(result);
        }
    }

    @Override
    public Optional<BigInteger> countTemporaryByType(String type){
        BigInteger result = BigInteger.valueOf(0);
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_temporary_contract_count_by_type");
            storedProcedure.setParameter("type", type);
            storedProcedure.execute();
            result = (BigInteger) storedProcedure.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            LOG.error("Have an error in method countTemporaryByType:"+e.getMessage());
            return Optional.of(result);
        }
    }

    @Override
    public Optional<Integer> addTemporary(TemporaryContractBO item) {
        EntityManager entityManagerCurrent = entityManagerFactory.createEntityManager();
        try {
            entityManagerCurrent.getTransaction().begin();
            //update contract_number cho npo_contract_number theo tccc hay phuong xa
            String key="";
            Calendar ca=Calendar.getInstance();
            ca.setTimeInMillis(item.getNotary_date().getTime());
            int year = Calendar.getInstance().get(Calendar.YEAR);
            if(SystemProperties.getProperty("org_type").equals("1")){
                if(item.getEntry_user_id()!=null) key=year+"/"+item.getEntry_user_id();
            }else{
                key=String.valueOf(year);
            }
            ContractNumberBO contractNumberBO=entityManagerCurrent.find(ContractNumberBO.class,key);
            if(contractNumberBO==null){
                contractNumberBO=new ContractNumberBO();
                contractNumberBO.setKind_id(key);
                contractNumberBO.setContract_number(2);
                entityManagerCurrent.persist(contractNumberBO);
                entityManagerCurrent.flush();
            }else{
                contractNumberBO.setContract_number(contractNumberBO.getContract_number()+1);
                entityManagerCurrent.merge(contractNumberBO);
            }

            entityManagerCurrent.persist(item);
            entityManagerCurrent.flush();
            entityManagerCurrent.getTransaction().commit();

        } catch (Exception e) {
            LOG.error("Have an error in method  addTemporary.add():"+e.getMessage());
            entityManagerCurrent.getTransaction().rollback();
        }finally {
            entityManagerCurrent.close();
        }
        return Optional.of(item.getId().intValue());
    }

    @Override
    public Optional<Integer> editTemporary(TemporaryContractBO item) {
        try {
            TemporaryContractBO itemadd=entityManager.find(TemporaryContractBO.class,item.getId());
            if(itemadd!=null){
                itemadd=genInfo(item,itemadd);
                entityManager.merge(itemadd);
                entityManager.flush();
                return Optional.ofNullable(itemadd.getId().intValue());
            }
            return Optional.ofNullable(0);
        } catch (Exception e){
            LOG.error("Have an error in method ediTemporary:"+e.getMessage());
            return Optional.ofNullable(0);
        }
    }

    private TemporaryContractBO genInfo(TemporaryContractBO item,TemporaryContractBO itemResult){
        itemResult.setType(item.getType());
        itemResult.setContract_template_id(item.getContract_template_id());
        itemResult.setContract_number(item.getContract_number());
        itemResult.setContract_value(item.getContract_value());
        itemResult.setRelation_object_a(item.getRelation_object_a());
        itemResult.setRelation_object_b(item.getRelation_object_b());
        itemResult.setRelation_object_c(item.getRelation_object_c());
        itemResult.setNotary_id(item.getNotary_id());
        itemResult.setDrafter_id(item.getDrafter_id());
        itemResult.setReceived_date(item.getReceived_date());
        itemResult.setNotary_date(item.getNotary_date());
        itemResult.setUser_require_contract(item.getUser_require_contract());
        itemResult.setNumber_copy_of_contract(item.getNumber_copy_of_contract());
        itemResult.setNumber_of_page(item.getNumber_of_page());
        itemResult.setCost_tt91(item.getCost_tt91());
        itemResult.setCost_draft(item.getCost_draft());
        itemResult.setCost_notary_outsite(item.getCost_notary_outsite());
        itemResult.setCost_other_determine(item.getCost_other_determine());
        itemResult.setCost_total(item.getCost_total());
        itemResult.setNotary_place_flag(item.getNotary_place_flag());
        itemResult.setNotary_place(item.getNotary_place());
        itemResult.setBank_id(item.getBank_id());
        itemResult.setBank_service_fee(item.getBank_service_fee());
        itemResult.setCrediter_name(item.getCrediter_name());
        itemResult.setFile_name(item.getFile_name());
        itemResult.setFile_path(item.getFile_path());
        itemResult.setOriginal_store_place(item.getOriginal_store_place());
        itemResult.setNote(item.getNote());
        itemResult.setSummary(item.getSummary());
        itemResult.setUpdate_user_id(item.getUpdate_user_id());
        itemResult.setUpdate_user_name(item.getUpdate_user_name());
        itemResult.setUpdate_date_time(item.getUpdate_date_time());
        itemResult.setJsonstring(item.getJsonstring());
        itemResult.setKindhtml(item.getKindhtml());
        itemResult.setJson_property(item.getJson_property());
        itemResult.setJson_person(item.getJson_person());
        itemResult.setBank_code(item.getBank_code());

        return itemResult;
    }


    @Override
    public Optional<TemporaryContractBO> getTemporaryById(String id) {
        TemporaryContractBO result = null;
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_temporary_get_by_id");
            storedProcedure
                    .setParameter("id", id);
            storedProcedure.execute();
            result = (TemporaryContractBO) storedProcedure.getSingleResult();
            return Optional.ofNullable(result);
        } catch (Exception e){
            LOG.error("Have an error in method getTemporaryById:"+e.getMessage());
            return Optional.ofNullable(result);
        }
    }

    @Override
    public Optional<Long> addTemporaryMark(Long tcid, ContractBO contract, TransactionPropertyBo tran, ContractHistoryInfoBO his) {
        Long result = Long.valueOf(0);
        EntityManager entityManagerCurrent = entityManagerFactory.createEntityManager();
        try{
            entityManagerCurrent.getTransaction().begin();

            TemporaryContractBO temporaryContractBO=entityManagerCurrent.find(TemporaryContractBO.class,tcid);
            if(temporaryContractBO!=null ){
                temporaryContractBO.setType(Long.valueOf(4));
                entityManagerCurrent.merge(temporaryContractBO);
                entityManagerCurrent.persist(contract);
                entityManagerCurrent.flush();
                his.setContract_id(contract.getId().intValue());
                tran.setContract_id(contract.getId());
                entityManagerCurrent.persist(his);
                entityManagerCurrent.persist(tran);

                entityManagerCurrent.flush();
                result=tran.getTpid();
            }

            entityManagerCurrent.getTransaction().commit();
        }catch (Exception e){
           LOG.error("Have an error in method addTemporaryMark:"+e.getMessage());
            entityManagerCurrent.getTransaction().rollback();
        }finally {
            entityManagerCurrent.close();
        }
        return Optional.ofNullable(result);
    }

    @Override
    public Boolean deleteTemporary(Long id){
        try{
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_temporary_delete");
            storedProcedure
                    .setParameter("id", id);
            storedProcedure.execute();
            return true;
        }catch (Exception e){
          LOG.error("Have an error in method deleteTemporary:"+e.getMessage());
            return false;
        }

    }

    @Override
    public Boolean updateContractNumberValue() {
        try{
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_contract_number_update");
            storedProcedure.execute();
            return true;
        }catch (Exception e){
           LOG.error("Have an error in method updateContractNumberValue:"+e.getMessage());
            return false;
        }

    }

    @Override
    public Optional<Integer> getContractNumberValue() {
        Integer result = Integer.valueOf(0);
        try {
            ContractNumberBO item=entityManager.find(ContractNumberBO.class,"0");
            if(item!=null){
                return Optional.of(Integer.valueOf((int)item.getContract_number()));
            }
            return Optional.of(result);
        } catch (Exception e){
            LOG.error("Have an error in method getContractNumberValue:"+e.getMessage());
            return Optional.of(result);
        }

    }

    @Override
    public Optional<Integer> getContractNumber(String key) {
        Integer result = Integer.valueOf(0);
        try {
            ContractNumberBO item=entityManager.find(ContractNumberBO.class,key);

            if(item!=null){
                return Optional.of(Integer.valueOf((int)item.getContract_number()));
            }else{
                item=new ContractNumberBO();
                item.setKind_id(key);
                item.setContract_number(1);
                entityManager.persist(item);
                entityManager.flush();
                return Optional.of(Integer.valueOf(1));
            }

        } catch (Exception e){
            LOG.error("Have an error in method getContractNumber:"+e.getMessage());
            return Optional.of(result);
        }
    }
}
