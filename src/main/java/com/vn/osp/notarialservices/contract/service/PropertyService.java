package com.vn.osp.notarialservices.contract.service;

import com.vn.osp.notarialservices.contract.dto.Property;
import com.vn.osp.notarialservices.contract.dto.PropertyType;

import java.util.List;
import java.util.Optional;

/**
 * Created by TienManh on 5/12/2017.
 */
public interface PropertyService {
    Optional<List<Property>> getAllProperty();
    Optional<List<PropertyType>> listPropertyType();

    Optional<Property> getPropertyByContractId(String id);
}
