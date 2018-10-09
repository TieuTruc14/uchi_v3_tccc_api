package com.vn.osp.notarialservices.contract.repository;

import com.vn.osp.notarialservices.contract.domain.PropertyBO;
import com.vn.osp.notarialservices.contract.domain.PropertyTypeBO;

import java.util.List;
import java.util.Optional;

/**
 * Created by TienManh on 5/12/2017.
 */
public interface PropertyRepositoryCustom  {
    Optional<List<PropertyBO>> getAllProperty();
    Optional<List<PropertyTypeBO>> listPropertyType();
    Optional<PropertyBO> getPropertyByContractId(String id);
}
