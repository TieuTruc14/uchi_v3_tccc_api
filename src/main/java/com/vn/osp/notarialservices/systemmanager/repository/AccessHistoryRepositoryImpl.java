/*
 * Copyright 2008-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vn.osp.notarialservices.systemmanager.repository;

//import com.vn.osp.notarialservices.user.domain.UserBO;

import com.vn.osp.notarialservices.systemmanager.domain.AccessHistoryBO;
import com.vn.osp.notarialservices.systemmanager.domain.SystemConfigBO;
import com.vn.osp.notarialservices.systemmanager.dto.AccessHistory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Dummy implementation to allow check for invoking a custom implementation.
 *
 * @author manhtran on 27/10/2016
 */
public class AccessHistoryRepositoryImpl implements AccessHistoryRepositoryCustom {

    private static final Logger LOG = Logger.getLogger(AccessHistoryRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public AccessHistoryRepositoryImpl(JpaContext context) {
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
    public Optional<List<AccessHistoryBO>> selectByFilter(String stringFilter) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("stp_npo_access_history_select_by_filter");
            storedProcedure
                    .setParameter("stringFilter", stringFilter);
            storedProcedure.execute();
            List<AccessHistoryBO> accessHistoryBO = (List<AccessHistoryBO>)storedProcedure.getResultList();
            return Optional.of(accessHistoryBO);
        } catch (Exception e){
            //e.printStackTrace();
            LOG.error("Have an error in method  AccessHistoryRepositoryImpl.selectByFilter()::"+e.getMessage());
            return Optional.of(new ArrayList<AccessHistoryBO>());
        }
    }


    @Override
    public Optional<String> getConfigValue(String key) {
        try {
            /*Query query = entityManager.createNativeQuery("select * from npo_system_config where config_key = :config_key");
            query.setParameter("config_key",key);
            Object o = query.getSingleResult();*/
            List<SystemConfigBO> list=entityManager.createQuery("select c from SystemConfigBO c where c.config_key =:config_key",
                    SystemConfigBO.class).setParameter("config_key", key).getResultList();
            if(list!=null && list.size()>0){
                SystemConfigBO item=list.get(0);
                return Optional.ofNullable(item.getConfig_value());
            }

            return Optional.of("error");
        } catch (Exception e){
            LOG.error("Have an error in method  getConfigValue():"+e.getMessage());
            //e.printStackTrace();
            return Optional.of("error");
        }
    }

    @Override
    public Optional<BigInteger> countTotalAccess(String stringFilter) {
        BigInteger result = BigInteger.valueOf(0);
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("stp_npo_access_history_count_total");
            storedProcedure.setParameter("stringFilter", stringFilter);
            storedProcedure.execute();
            result = (BigInteger) storedProcedure.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            LOG.error("Have an error in method  countTotalAccess:"+e.getMessage());
            return Optional.of(result);
        }
    }

    @Override
    public Boolean setAccessHistory(AccessHistory accessHistory) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("stp_npo_access_history_add");
            storedProcedure.setParameter("usid", accessHistory.getUsid());
            storedProcedure.setParameter("execute_person", accessHistory.getExecute_person());
            storedProcedure.setParameter("client_info", accessHistory.getClient_info());
            storedProcedure.setParameter("access_type", accessHistory.getAccess_type());
            storedProcedure.setParameter("description", accessHistory.getDescription());
            storedProcedure.execute();
            return true;
        } catch (Exception e) {
            LOG.error("Have an error in method  setAccessHistory::"+e.getMessage());
            return false;
        }
    }
}
