package com.vn.osp.notarialservices.systemmanager.service;

import com.vn.osp.notarialservices.systemmanager.domain.AccessHistoryBO;
import com.vn.osp.notarialservices.systemmanager.dto.AccessHistory;
import com.vn.osp.notarialservices.systemmanager.repository.AccessHistoryRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by manhtran on 20/10/2016.
 */
@Component
public class AccessHistoryServiceImpl implements AccessHistoryService {

    private static final Logger LOGGER = Logger.getLogger(AccessHistoryServiceImpl.class);

    private final AccessHistoryRepository accessHistoryRepository;
    private final AccessHistoryConverter accessHistoryConverter;

    @Autowired
    public AccessHistoryServiceImpl(final AccessHistoryRepository accessHistoryRepository, final AccessHistoryConverter accessHistoryConverter) {
        this.accessHistoryRepository = accessHistoryRepository;
        this.accessHistoryConverter = accessHistoryConverter;
    }

    @Override
    public Optional<List<AccessHistory>> selectByFilter(String stringFilter) {
        List<AccessHistoryBO> boList = accessHistoryRepository.selectByFilter(stringFilter).orElse(new ArrayList<AccessHistoryBO>());
        ArrayList<AccessHistory> resultList = new ArrayList<AccessHistory>();
        if(boList != null && boList.size() >0) {
            for(int i=0; i<boList.size(); i++){
                resultList.add(Optional.ofNullable(boList.get(i)).map(accessHistoryConverter::convert).orElse(new AccessHistory()));
            }
        }
        return Optional.of(resultList);
    }

    @Override
    public Optional<String> getConfigValue(String key) {
        String value = accessHistoryRepository.getConfigValue(key).orElse("error");
        return Optional.of(value);
    }

    @Override
    public Optional<BigInteger> countTotalAccess(String stringFilter)  {
        return accessHistoryRepository.countTotalAccess(stringFilter);

    }

    @Override
    public Boolean setAccessHistory(AccessHistory accessHistory) {
        return accessHistoryRepository.setAccessHistory(accessHistory);
    }
}
