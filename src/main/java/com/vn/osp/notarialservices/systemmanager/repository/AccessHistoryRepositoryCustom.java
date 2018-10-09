/*
 * Copyright 2008-2011 the original author or authors.
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

import com.vn.osp.notarialservices.systemmanager.domain.AccessHistoryBO;
import com.vn.osp.notarialservices.systemmanager.dto.AccessHistory;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Simple interface for custom methods on the repository for {@code ContractHistoryInfor}s.
 *
 * @author manhtran on 27/10/2016.
 */
public interface AccessHistoryRepositoryCustom {

    void findByOverridingMethod();

    void delete(Integer id);

    Optional<List<AccessHistoryBO>> selectByFilter(String stringFilter);

    Optional<String> getConfigValue(String key);

    Optional<BigInteger> countTotalAccess(String stringFilter);

    Boolean setAccessHistory(AccessHistory accessHistory);


}
