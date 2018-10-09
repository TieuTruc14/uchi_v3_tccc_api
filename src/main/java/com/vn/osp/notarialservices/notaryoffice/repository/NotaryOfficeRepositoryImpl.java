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
package com.vn.osp.notarialservices.notaryoffice.repository;

import com.vn.osp.notarialservices.notaryoffice.domain.NotaryOfficeBO;
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
 * Dummy implementation to allow check for invoking a custom implementation.
 *
 * @author manhtran on 27/10/2016
 */
public class NotaryOfficeRepositoryImpl implements NotaryOfficeRepositoryCustom {

    private static final Logger LOG = Logger.getLogger(NotaryOfficeRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public NotaryOfficeRepositoryImpl(JpaContext context) {
        Assert.notNull(context, "JpaContext must not be null!");
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.jpa.repository.sample.AccessHistoryRepositoryCustom#findByOverrridingMethod()
     */
    public void findByOverridingMethod() {
        LOG.info("A method overriding a finder was invoked!");
    }

    @Override
    public void delete(Integer id) {
        LOG.info("A method overriding a finder was invoked!");
    }

    @Override
    public Optional<Boolean> insert(String xml_content) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("stp_npo_notary_office_insert");
            storedProcedure
                    .setParameter("xml_content", xml_content);
            storedProcedure.execute();
            return Optional.of(true);
        } catch (Exception e){
            LOG.error("Have an error in method insert()::"+e.getMessage());
            return Optional.of(false);
        }
    }

    @Override
    public Optional<Boolean> update(String xml_content) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("stp_npo_notary_office_update");
            storedProcedure
                    .setParameter("xml_content", xml_content);
            storedProcedure.execute();
            return Optional.of(true);
        } catch (Exception e){
            LOG.error("Have an error in method  update()::"+e.getMessage());
            return Optional.of(false);
        }
    }

    @Override
    public Optional<Boolean> deleteById(Long id) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("stp_npo_notary_office_delete_by_id");
            storedProcedure
                    .setParameter("noid", id);
            storedProcedure.execute();
            return Optional.of(true);
        } catch (Exception e){
            LOG.error("Have an error in method deleteById()::"+e.getMessage());
            return Optional.of(false);
        }
    }

    @Override
    public Optional<List<NotaryOfficeBO>> selectByFilter(String stringFilter) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("stp_npo_notary_office_select_by_filter");
            storedProcedure
                    .setParameter("stringFilter", stringFilter);
            storedProcedure.execute();
            return Optional.of((List<NotaryOfficeBO>)storedProcedure.getResultList());
        } catch (Exception e) {
            LOG.error("Have an error in method selectByFilter() :: "+e.getMessage());
            return Optional.of(new ArrayList<NotaryOfficeBO>());
        }
    }

    @Override
    public Optional<List<NotaryOfficeBO>> selectByAccount(String account) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("stp_npo_notary_office_select_by_account");
            storedProcedure
                    .setParameter("account", account);
            storedProcedure.execute();
            return Optional.of((List<NotaryOfficeBO>)storedProcedure.getResultList());
        } catch (Exception e) {
            LOG.error("Have an error in method  selectByAccount::"+e.getMessage());
            return Optional.of(new ArrayList<NotaryOfficeBO>());
        }
    }
    @Override
    public Optional<BigInteger> countTotalNotaryOffice(String stringFilter) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("stp_npo_notary_office_count_total");
            storedProcedure
                    .setParameter("stringFilter", stringFilter);
            storedProcedure.execute();
            BigInteger result = (BigInteger) storedProcedure.getSingleResult();
            return Optional.of(result);
        } catch (Exception e){
           LOG.error("Have an error in method countTotalNotaryOffice()::"+e.getMessage());
            return Optional.of(BigInteger.valueOf(0));
        }
    }


}
