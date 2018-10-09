package com.vn.osp.notarialservices.contract.repository;

import com.vn.osp.notarialservices.bank.repository.BankRepositoryImpl;
import com.vn.osp.notarialservices.contract.domain.ContractKindBO;
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
 * Created by Admin on 5/8/2017.
 */
public class ContractKindRepositoryImpl implements ContractKindRepositoryCustom {
    private static final Logger LOG = Logger.getLogger(BankRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ContractKindRepositoryImpl(JpaContext context) {
        Assert.notNull(context, "JpaContext must not be null!");
    }

    public void findByOverridingMethod() {
        LOG.info("A method overriding a finder was invoked!");
    }

    @Override
    public Optional<List<ContractKindBO>> getAllContractKind() {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("stp_npo_contract_kind_getAll");
            storedProcedure.execute();
            List<ContractKindBO> result = storedProcedure.getResultList();
            return Optional.of((List<ContractKindBO>)(result));
        } catch (Exception e) {
           LOG.error("Have an error in method getAllContractKind:"+e.getMessage());
            return Optional.of(new ArrayList<ContractKindBO>());
        }
    }
    @Override
    public Optional<Boolean> ContractKindAdd(String id,String name , Long updateUserId, String updateUserName , String code){
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("osp_contract_kind_add");
            storedProcedure
                    .setParameter("id", id)
                    .setParameter("name", name)
                    .setParameter("update_user_id", updateUserId)
                    .setParameter("update_user_name", updateUserName)
                    .setParameter("contract_kind_code", code);

            storedProcedure.execute();

            return Optional.of(Boolean.valueOf(true));

        }catch(Exception e){
            LOG.error("Have an error in method  ContractKindAdd:"+e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }




    }
    @Override
    public Optional<Boolean> UpdateContractKind(Long id,String name , Long updateUserId, String updateUserName , String contract_kind_code){
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("osp_contract_kind_update");
            storedProcedure
                    .setParameter("id", id)
                    .setParameter("name", name)
                    .setParameter("update_user_id", updateUserId)
                    .setParameter("update_user_name", updateUserName)
                    .setParameter("contract_kind_code", contract_kind_code);

            storedProcedure.execute();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
           LOG.error("Have an error in method UpdateContractKind:"+e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }
    @Override
    public Optional<Boolean> deleteContractKind(Long id){
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("osp_contract_kind_delete");
            storedProcedure
                    .setParameter("id", id);
            storedProcedure.execute();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method deleteContractKind:"+e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }
    @Override
    public Optional<List<ContractKindBO>> findContractKindByFilter(String stringFilter){
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("osp_contract_kind_select_filter");
            storedProcedure
                    .setParameter("stringFilter", stringFilter);
            storedProcedure.execute();
            List<ContractKindBO> contractKindBos = (List<ContractKindBO>) storedProcedure.getResultList();
            return Optional.of(contractKindBos);
        } catch (Exception e) {
            LOG.error("Have an error in method findContractKindByFilter:"+e.getMessage());
            return Optional.of(new ArrayList<ContractKindBO>());
        }
    }
    @Override
    public Optional<BigInteger> countContractKindByFilter(String stringFilter){
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("osp_contract_kind_count_filter");
            storedProcedure
                    .setParameter("stringFilter", stringFilter);


            storedProcedure.execute();
            BigInteger result =(BigInteger)storedProcedure.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            LOG.error("Have an error in method countContractKindByFilter:"+e.getMessage());
            return Optional.of(BigInteger.valueOf(0));
        }
    }

    @Override
    public Optional<ContractKindBO> getContractKindById(String id) {
        try {
//            ContractKindBO item=entityManager.find(ContractKindBO.class,2);

            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_contract_kind_get_by_id");
            storedProcedure
                    .setParameter("id", id);

            storedProcedure.execute();
            ContractKindBO result =(ContractKindBO)storedProcedure.getSingleResult();
            return Optional.ofNullable(result);
        } catch (Exception e) {
            LOG.error("Have an error in method getContractKindBYId:"+e.getMessage());
            return Optional.of(new ContractKindBO());
        }
    }

}
