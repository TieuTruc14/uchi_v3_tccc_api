package com.vn.osp.notarialservices.contracttemplate.repository;


import com.vn.osp.notarialservices.contracttemplate.domain.PropertyTemplateBO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by TienManh on 8/5/2017.
 */
@Component
public class PropertyTemplateRepositoryImpl implements PropertyTemplateRepositoryCustom {
    private static final Logger LOG = Logger.getLogger(PropertyTemplateRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    public PropertyTemplateRepositoryImpl(JpaContext context) {
        Assert.notNull(context, "JpaContext must not be null!");
    }

    @Override
    public Optional<List<PropertyTemplateBO>> list() {
        try {
            List<PropertyTemplateBO> list=entityManager.createQuery("select pr from PropertyTemplateBO pr ORDER BY entry_time DESC",PropertyTemplateBO.class).getResultList();
            return Optional.ofNullable(list);
        } catch (Exception e) {
            LOG.error("Have an error in method  PropertyTemplateRepositoryImpl.list()::"+e.getMessage());
            return Optional.ofNullable(new ArrayList<PropertyTemplateBO>());
        }
    }

    @Override
    public Optional<List<PropertyTemplateBO>> listItemPage(int offset, int number) {
        try {
            List<PropertyTemplateBO> list=entityManager.createQuery("select pr from PropertyTemplateBO pr ORDER BY entry_time DESC",
                    PropertyTemplateBO.class).setFirstResult(offset).setMaxResults(number).getResultList();
            return Optional.ofNullable(list);
        } catch (Exception e) {
            LOG.error("Have an error in method  PropertyTemplateRepositoryImpl.listItemPage()::" +e.getMessage());
            return Optional.ofNullable(new ArrayList<PropertyTemplateBO>());
        }
    }
    @Override
    public Optional<List<PropertyTemplateBO>> listItemPageByType(String type, int offset, int number) {
        try {
            List<PropertyTemplateBO> list=entityManager.createQuery("select pr from PropertyTemplateBO pr where pr.type=:type ORDER BY entry_time DESC",
                    PropertyTemplateBO.class).setParameter("type", type).setFirstResult(offset).setMaxResults(number).getResultList();
            return Optional.ofNullable(list);
        } catch (Exception e) {
            LOG.error("Have an error in method  PropertyTemplateRepositoryImpl.listItemPage()::"+e.getMessage());
            return Optional.ofNullable(new ArrayList<PropertyTemplateBO>());
        }
    }

    @Override
    public Optional<List<PropertyTemplateBO>> getByType(String type) {
        try {
            List<PropertyTemplateBO> list=entityManager.createQuery("select pr from PropertyTemplateBO pr where pr.type = :type ORDER BY entry_time",
                    PropertyTemplateBO.class).setParameter("type", type).getResultList();
            return Optional.ofNullable(list);
        } catch (Exception e) {
            LOG.error("Have an error in method PropertyTemplateRepositoryImpl.getByType()::"+e.getMessage());
            return Optional.ofNullable(new ArrayList<PropertyTemplateBO>());
        }
    }

    @Override
    public Optional<List<PropertyTemplateBO>> getByName(String type) {
        try {
            List<PropertyTemplateBO> list=entityManager.createQuery("select pr from PropertyTemplateBO pr where pr.name = :type ORDER BY entry_time",
                    PropertyTemplateBO.class).setParameter("type", type).getResultList();
            return Optional.ofNullable(list);
        } catch (Exception e) {
            LOG.error("Have an error in method PropertyTemplateRepositoryImpl.getByType()::"+e.getMessage());
            return Optional.ofNullable(new ArrayList<PropertyTemplateBO>());
        }
    }

    @Override
    public Optional<List<PropertyTemplateBO>> getByCode(String code) {
        try {
            List<PropertyTemplateBO> list=entityManager.createQuery("select pr from PropertyTemplateBO pr where pr.code = :code ORDER BY entry_time",
                    PropertyTemplateBO.class).setParameter("code", code).getResultList();
            return Optional.ofNullable(list);
        } catch (Exception e) {
            LOG.error("Have an error in method PropertyTemplateRepositoryImpl.getByType()::"+e.getMessage());
            return Optional.ofNullable(new ArrayList<PropertyTemplateBO>());
        }
    }

    @Override
    public Optional<Long> countByType(String type) {
        try {
            long count=(long)entityManager.createQuery("select count(pr.id) from PropertyTemplateBO pr where pr.type = :type").setParameter("type", type).getSingleResult();
            return Optional.ofNullable(count);
        } catch (Exception e) {
            LOG.error("Have an error in method PropertyTemplateRepositoryImpl.countByType()::"+e.getMessage());
            return Optional.ofNullable(null);
        }
    }

    @Override
    public Optional<Long> total() {
        try {
            long count=(long)entityManager.createQuery("select count(pr.id) from PropertyTemplateBO pr").getSingleResult();
            return Optional.ofNullable(count);
        } catch (Exception e) {
            LOG.error("Have an error in method PropertyTemplateRepositoryImpl.total()::"+e.getMessage());
            return Optional.ofNullable(null);
        }
    }

    @Override
    public Optional<PropertyTemplateBO> getById(int id) {
        try {
            PropertyTemplateBO itemadd=new PropertyTemplateBO();

            PropertyTemplateBO item=entityManager.find(PropertyTemplateBO.class,id);
            return Optional.ofNullable(item);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("Have an error in method  PropertyTemplateRepositoryImpl.getById()::"+e.getMessage());
            return Optional.ofNullable(new PropertyTemplateBO());
        }
    }

    @Override
    public Optional<Boolean> add(PropertyTemplateBO item) {
        try {
            entityManager.persist(item);
            entityManager.flush();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method  PropertyTemplateRepositoryImpl.add()::"+e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }

    @Override
    public Optional<Boolean> update(PropertyTemplateBO item) {
        try {
            PropertyTemplateBO itemDB=entityManager.find(PropertyTemplateBO.class,item.getId());
            itemDB.setName(item.getName());
            itemDB.setDescription(item.getDescription());
            itemDB.setHtml(item.getHtml());
            itemDB.setUpdate_user(item.getUpdate_user());
            itemDB.setUpdate_time(item.getUpdate_time());
            entityManager.merge(itemDB);
            entityManager.flush();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method  PropertyTemplateRepositoryImpl.update()::"+e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }

    @Override
    public Boolean deleteItem(int id) {
        try {
            PropertyTemplateBO item=entityManager.find(PropertyTemplateBO.class,id);
            if(item!=null){
                entityManager.remove(item);
            }
            return Boolean.valueOf(true);
        } catch (Exception e) {
            LOG.error("Have an error in method PropertyTemplateRepositoryImpl.delete()::"+e.getMessage());
            return Boolean.valueOf(false);
        }
    }
}
