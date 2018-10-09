package com.vn.osp.notarialservices.contract.service;

import com.vn.osp.notarialservices.contract.domain.PropertyBO;
import com.vn.osp.notarialservices.contract.domain.PropertyTypeBO;
import com.vn.osp.notarialservices.contract.dto.Property;
import com.vn.osp.notarialservices.contract.dto.PropertyType;
import com.vn.osp.notarialservices.contract.repository.PropertyRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by TienManh on 5/12/2017.
 */
@Component
public class PropertyServiceImpl implements PropertyService {
    private static final Logger LOGGER = Logger.getLogger(PropertyServiceImpl.class);
    private PropertyConverter propertyConverter;
    private PropertyRepository propertyRepository;
    private PropertyTypeConverter propertyTypeConverter;

    @Autowired
    public PropertyServiceImpl(PropertyConverter propertyConverter,PropertyRepository propertyRepository,PropertyTypeConverter propertyTypeConverter){
        this.propertyConverter=propertyConverter;
        this.propertyRepository=propertyRepository;
        this.propertyTypeConverter=propertyTypeConverter;
    }

    @Override
    public Optional<List<Property>> getAllProperty(){
        List<PropertyBO> listBO= propertyRepository.getAllProperty().orElse(new ArrayList<>());
        ArrayList<Property> lst=new ArrayList<>();
        if(listBO!=null && listBO.size()>0){
            for(int i=0;i<listBO.size();i++)
                lst.add(Optional.ofNullable(listBO.get(i)).map(propertyConverter::convert).orElse(new Property()));
        }

        return Optional.of(lst);
    }
    @Override
    public Optional<List<PropertyType>> listPropertyType(){
        List<PropertyTypeBO> listBO= propertyRepository.listPropertyType().orElse(new ArrayList<>());
        ArrayList<PropertyType> lst=new ArrayList<>();
        if(listBO!=null && listBO.size()>0){
            for(int i=0;i<listBO.size();i++)
                lst.add(Optional.ofNullable(listBO.get(i)).map(propertyTypeConverter::convert).orElse(new PropertyType()));
        }

        return Optional.of(lst);
    }


    @Override
    public Optional<Property> getPropertyByContractId(String id){
        Property property=propertyRepository.getPropertyByContractId(id).map(propertyConverter::convert).orElse(null);
        return Optional.of(property);
    }
}
