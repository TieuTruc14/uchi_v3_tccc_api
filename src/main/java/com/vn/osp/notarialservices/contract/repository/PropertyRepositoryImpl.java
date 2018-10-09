package com.vn.osp.notarialservices.contract.repository;

import com.vn.osp.notarialservices.contract.domain.PropertyBO;
import com.vn.osp.notarialservices.contract.domain.PropertyTypeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by TienManh on 5/12/2017.
 */

public class PropertyRepositoryImpl implements PropertyRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Autowired
    public PropertyRepositoryImpl(JpaContext context) {
        Assert.notNull(context, "JpaContext must not be null!");
    }

    @Override
    public Optional<List<PropertyBO>> getAllProperty(){
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_property_getAll");

            storedProcedure.execute();
            List<PropertyBO> result = storedProcedure.getResultList();
            return Optional.of((List<PropertyBO>)(result));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.of(new ArrayList<PropertyBO>());
        }

    }

    @Override
    public Optional<List<PropertyTypeBO>> listPropertyType(){
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_property_type_list");

            storedProcedure.execute();
            List<PropertyTypeBO> result = storedProcedure.getResultList();
            return Optional.of(result);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.of(new ArrayList<PropertyTypeBO>());
        }

    }

    @Override
    public Optional<PropertyBO> getPropertyByContractId(String id){
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_property_by_contractId");
            storedProcedure.setParameter("id", id);
            storedProcedure.execute();
            PropertyBO result = (PropertyBO) storedProcedure.getSingleResult();
            return Optional.ofNullable(result);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.of(new PropertyBO());
        }

    }
}
