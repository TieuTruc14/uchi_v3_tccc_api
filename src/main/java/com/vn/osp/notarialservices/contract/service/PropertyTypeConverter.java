package com.vn.osp.notarialservices.contract.service;

import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.contract.domain.PropertyTypeBO;
import com.vn.osp.notarialservices.contract.dto.PropertyType;
import org.springframework.stereotype.Service;

/**
 * Created by TienManh on 5/26/2017.
 */
@Service
public class PropertyTypeConverter implements Converter<PropertyTypeBO, PropertyType> {

    @Override
    public PropertyType convert(PropertyTypeBO source){
        return new PropertyType(
                source.getId(),
                source.getName(),
                source.getDescription()
        );
    }

    @Override
    public PropertyTypeBO convert(PropertyType source){return null;}
}
