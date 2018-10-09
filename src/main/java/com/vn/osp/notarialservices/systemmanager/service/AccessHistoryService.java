package com.vn.osp.notarialservices.systemmanager.service;


import com.vn.osp.notarialservices.systemmanager.dto.AccessHistory;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by manhtran on 20/10/2016.
 */
public interface AccessHistoryService {

    Optional<List<AccessHistory>> selectByFilter(String stringFilter);

    Optional<String> getConfigValue(String key);

    Optional<BigInteger> countTotalAccess(String stringFilter);

    Boolean setAccessHistory(AccessHistory accessHistory);

}
