package com.vn.osp.notarialservices.province.repository;

import com.vn.osp.notarialservices.province.domain.ProvinceBo;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 6/5/2017.
 */
public interface ProvinceRepositoryCustom {
    Optional<Boolean> AddProvince(String name, Long entryUserId, String entryUserName, String code);
    Optional<List<ProvinceBo>> findProvinceByFilter (String stringFilter);
    Optional<BigInteger> countProvinceByFilter(String stringFilter);

}
