package com.vn.osp.notarialservices.contracttemplate.repository;

import com.vn.osp.notarialservices.contract.domain.ContractTemplateBO;
import com.vn.osp.notarialservices.contracttemplate.domain.ContractTempBo;
import com.vn.osp.notarialservices.contracttemplate.dto.ContractTempList;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Admin on 7/6/2017.
 */
@Component
public class ContractTempRepositoryImpl implements ContractTempRepositoryCustom {
    private static final Logger LOG = Logger.getLogger(ContractTempRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Autowired

    public ContractTempRepositoryImpl(JpaContext context) {
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
    public Optional<Boolean> addContractTemp(String id ,String name,Long kind_id,Long kind_id_tt08, String code , String description, String file_name,String file_path, Long active_flg, Long relate_object_number,String relate_object_A_display,String relate_object_B_display,String relate_object_C_display, Long period_flag,Long period_req_flag, Long mortage_cancel_func,Long sync_option, Long entry_user_id, String entry_user_name,Long update_user_id, String update_user_name, String kind_html, String office_code, String code_template ){
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("addContractTemp");
            storedProcedure
                    .setParameter("id", id)
                    .setParameter("name", name)
                    .setParameter("kind_id", kind_id)
                    .setParameter("kind_id_tt08", kind_id_tt08)
                    .setParameter("code", code)
                    .setParameter("description", description)
                    .setParameter("file_name", file_name)
                    .setParameter("file_path", file_path)
                    .setParameter("active_flg", active_flg)
                    .setParameter("relate_object_number", relate_object_number)
                    .setParameter("relate_object_A_display", relate_object_A_display)
                    .setParameter("relate_object_B_display", relate_object_B_display)
                    .setParameter("relate_object_C_display", relate_object_C_display)
                    .setParameter("period_flag", period_flag)
                    .setParameter("period_req_flag", period_req_flag)
                    .setParameter("mortage_cancel_func", mortage_cancel_func)
                    .setParameter("sync_option", sync_option)
                    .setParameter("entry_user_id", entry_user_id)
                    .setParameter("entry_user_name", entry_user_name)
                    .setParameter("update_user_id", entry_user_id)
                    .setParameter("update_user_name", entry_user_name)
                    .setParameter("kind_html", kind_html)
                    .setParameter("office_code", office_code)
                    .setParameter("code_template", code_template);


            storedProcedure.execute();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method addContracdtTemp:"+e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }
    @Override
    public Optional<Boolean> updateContractTemp(String id ,String name,Long kind_id,Long kind_id_tt08, String code , String description, String file_name,String file_path, Long active_flg, Long relate_object_number,String relate_object_A_display,String relate_object_B_display,String relate_object_C_display, Long period_flag,Long period_req_flag, Long mortage_cancel_func,Long sync_option, Long entry_user_id, String entry_user_name,Long update_user_id, String update_user_name, String kind_html, String office_code, String code_template  ){
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("updateContractTemp");
            storedProcedure
                    .setParameter("id", id)
                    .setParameter("name", name)
                    .setParameter("kind_id", kind_id)
                    .setParameter("kind_id_tt08", kind_id_tt08)
                    .setParameter("code", code)
                    .setParameter("description", description)
                    .setParameter("file_name", file_name)
                    .setParameter("file_path", file_path)
                    .setParameter("active_flg", active_flg)
                    .setParameter("relate_object_number", relate_object_number)
                    .setParameter("relate_object_A_display", relate_object_A_display)
                    .setParameter("relate_object_B_display", relate_object_B_display)
                    .setParameter("relate_object_C_display", relate_object_C_display)
                    .setParameter("period_flag", period_flag)
                    .setParameter("period_req_flag", period_req_flag)
                    .setParameter("mortage_cancel_func", mortage_cancel_func)
                    .setParameter("sync_option", sync_option)
                    .setParameter("entry_user_id", entry_user_id)
                    .setParameter("entry_user_name", entry_user_name)
                    .setParameter("update_user_id", entry_user_id)
                    .setParameter("update_user_name", entry_user_name)
                    .setParameter("kind_html", kind_html)
                    .setParameter("office_code", office_code)
                    .setParameter("code_template", code_template);

            storedProcedure.execute();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method updateContractTemp:"+e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }
    @Override
    public Optional<List<ContractTempBo>> findContractTempByFilter(String stringFilter) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("findContractTempByFilter");
            storedProcedure
                    .setParameter("stringFilter", stringFilter);
            storedProcedure.execute();
            List<ContractTempBo> contractTempBo = (List<ContractTempBo>) storedProcedure.getResultList();
            return Optional.of(contractTempBo);
        } catch (Exception e) {
            LOG.error("Have an error in method findContractTempByFilter:"+e.getMessage());
            return Optional.of(new ArrayList<ContractTempBo>());
        }
    }
    @Override
    public Optional<BigInteger> countContractTempByFilter(String stringFilter){
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("countContractTempByFilter");
            storedProcedure
                    .setParameter("stringFilter", stringFilter);


            storedProcedure.execute();
            BigInteger result =(BigInteger)storedProcedure.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            LOG.error("Have an error in method countContractTempByFilter:"+e.getMessage());
            return Optional.of(BigInteger.valueOf(0));
        }
    }
    @Override
    public List<ContractTempList> findContractTempListByFilter(String stringFilter) {
        try {
            List<ContractTempList> contractTempListList = new ArrayList<ContractTempList>();
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("findContractTempListByFilter");
            storedProcedure.setParameter("stringFilter", stringFilter);
            storedProcedure.execute();
            List<Object[]> results = storedProcedure.getResultList();

            results.stream().forEach((record) -> {
                ContractTempList contractTempList = new ContractTempList();

                contractTempList.setId                           (record[0]==null?null:((Integer)record[0]).intValue());
                contractTempList.setName                              (record[1]==null?null:((String)record[1]));
                contractTempList.setCode                         (record[2]==null?null:((String)record[2]));
                contractTempList.setActive_flg                    (record[3]==null?null:((Boolean)record[3]).booleanValue());
                contractTempList.setContractKindName              (record[4]==null?null:((String)record[4]));
                contractTempListList.add(contractTempList);
            });

            return contractTempListList;
        } catch (Exception e) {
            LOG.error("Have an error in method findContractTemListByFilter:"+e.getMessage());
            return new ArrayList<ContractTempList>();
        }
    }

    /*create by manhpt */

    @Override
    public Optional<Boolean> add(ContractTemplateBO item) {
        if(item==null || item.getId()==null){
            return Optional.ofNullable(false);
        }
        try{
            entityManager.persist(item);
            entityManager.flush();
            return Optional.ofNullable(true);
        }catch (Exception e){
            LOG.error("Have an error in method ContractTempRepositoryImpl.add():"+e.getMessage());
        }
        return Optional.ofNullable(false);
    }

    @Override
    public Optional<Boolean> update(ContractTemplateBO item) {
        if(item==null || item.getId()==null){
            return Optional.ofNullable(false);
        }
        try{
            ContractTemplateBO itemUpdate=entityManager.find(ContractTemplateBO.class,item.getId());
            itemUpdate=genInfo(item,itemUpdate);
            entityManager.merge(itemUpdate);
            entityManager.flush();
            return Optional.ofNullable(true);
        }catch (Exception e){
            LOG.error("Have an error in ContractTempRepositoryImpl.update():"+e.getMessage());
        }
        return Optional.ofNullable(false);
    }

    @Override
    public Optional<Boolean> saveOrUpdates(List<ContractTemplateBO> items) {
        if(items==null) return Optional.ofNullable(false);
        Boolean result=false;
        EntityManager entityManagerCurrent=entityManagerFactory.createEntityManager();
        try{
            entityManagerCurrent.getTransaction().begin();
            for(ContractTemplateBO item:items){
                ContractTemplateBO itemUpdate=entityManagerCurrent.find(ContractTemplateBO.class,item.getId());
                if(itemUpdate!=null){
                    itemUpdate=genInfo(item,itemUpdate);
                    entityManagerCurrent.merge(itemUpdate);
                    entityManagerCurrent.flush();
                }else{
                    entityManagerCurrent.persist(item);
                    entityManagerCurrent.flush();
                }
            }

            entityManagerCurrent.getTransaction().commit();
            result=true;
        }catch (Exception e){
            LOG.error("Have an error in ContractTempRepositoryImpl.saveOrUpdates():"+e.getMessage());
            entityManagerCurrent.getTransaction().rollback();
        }finally {
            entityManagerCurrent.close();
        }
        return Optional.ofNullable(result);
    }

    @Override
    public Optional<List<ContractTemplateBO>> list() {
        try {
            List<ContractTemplateBO> list=entityManager.createQuery("select pr from ContractTemplateBO pr ORDER BY entry_date_time DESC",ContractTemplateBO.class).getResultList();
            return Optional.ofNullable(list);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("Have an error in method ContractTempRepositoryImpl.list():"+e.getMessage());
            return Optional.ofNullable(new ArrayList<ContractTemplateBO>());
        }
    }

    @Override
    public Optional<ContractTemplateBO> getById(Long id) {
        try{
            if(id.intValue()>0){
                ContractTemplateBO item=entityManager.find(ContractTemplateBO.class,id);
                if(item!=null) return Optional.of(item);
            }
        }catch (Exception e){
            LOG.info("Have an error in method ContractTempRepositoryImpl.getById: "+e.getMessage());
        }
        return null;
    }

    @Override
    public Optional<List<ContractTemplateBO>> listItemPage(int offset, int number) {
        try {
            List<ContractTemplateBO> list=entityManager.createQuery("select pr from ContractTemplateBO pr ORDER BY entry_date_time DESC",
                    ContractTemplateBO.class).setFirstResult(offset).setMaxResults(number).getResultList();
            return Optional.ofNullable(list);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("Have an error in method ContractTempRepositoryImpl.listItemPage():"+e.getMessage());
            return Optional.ofNullable(new ArrayList<ContractTemplateBO>());
        }
    }

    @Override
    public Optional<Long> total() {
        try {
            long count=(long)entityManager.createQuery("select count(pr.id) from ContractTemplateBO pr").getSingleResult();
            return Optional.ofNullable(count);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("Have an error in method ContractTempRepositoryImpl.total():"+e.getMessage());
            return Optional.ofNullable(null);
        }
    }

    private ContractTemplateBO genInfo(ContractTemplateBO item,ContractTemplateBO itemResult){
        itemResult.setName(item.getName());
        itemResult.setKind_id(item.getKind_id());
        itemResult.setCode(item.getCode());
        itemResult.setDescription(item.getDescription());
        itemResult.setFile_name(item.getFile_name());
        itemResult.setFile_path(item.getFile_path());
        itemResult.setActive_flg(item.getActive_flg());
        itemResult.setUpdate_user_name(item.getUpdate_user_name());
        itemResult.setUpdate_date_time(item.getUpdate_date_time());
        itemResult.setKind_html(item.getKind_html());

        return itemResult;
    }
}
