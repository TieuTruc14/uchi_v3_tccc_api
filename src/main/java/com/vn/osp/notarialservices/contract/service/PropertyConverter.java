package com.vn.osp.notarialservices.contract.service;

import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.contract.domain.PropertyBO;
import com.vn.osp.notarialservices.contract.dto.Property;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by TienManh on 5/12/2017.
 */
@Service
public class PropertyConverter implements Converter<PropertyBO, Property> {

    @Override
    public Property convert(PropertyBO source){
        Property object=new Property();
        object.setPid(source.getId());
        object.setType(source.getType());
        object.setProperty_info(source.getProperty_info());
        object.setOwner_info(source.getOwner_info());
        object.setOther_info(source.getOther_info());
        object.setLand_certificate(source.getLand_certificate());
        object.setLand_issue_place(source.getLand_issue_place());
        object.setLand_issue_date(convertTimeStampToString(source.getLand_issue_date()));
        object.setLand_map_number(source.getLand_map_number());
        object.setType(source.getType());
        object.setLand_number(source.getLand_number());
        object.setLand_address(source.getLand_address());
        object.setLand_area(source.getLand_area());
        object.setLand_public_area(source.getLand_public_area());
        object.setLand_private_area(source.getLand_private_area());
        object.setLand_use_purpose(source.getLand_use_purpose());
        object.setLand_use_period(source.getLand_use_period());
        object.setLand_use_origin(source.getLand_use_origin());
        object.setLand_associate_property(source.getLand_associate_property());
        object.setLand_street(source.getLand_street());
        object.setLand_district(source.getLand_district());
        object.setLand_province(source.getLand_province());
        object.setLand_full_of_area(source.getLand_full_of_area());
        object.setCar_license_number(source.getCar_license_number());
        object.setCar_regist_number(source.getCar_regist_number());
        object.setCar_issue_place(source.getCar_issue_place());
        object.setCar_issue_date(convertTimeStampToString(source.getCar_issue_date()));
        object.setCar_frame_number(source.getCar_frame_number());
        object.setCar_machine_number(source.getCar_machine_number());

        return object;
    }
    @Override
    public PropertyBO convert(Property source){return null;}

    public Timestamp convertStringToTimeStamp(String dateString){
        try {
            if(dateString == "" || dateString == null) return null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date parsedDate = null;
            parsedDate = dateFormat.parse(dateString);
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            return  timestamp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String convertTimeStampToString(Timestamp date){
        if(date == null) return "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String result  = dateFormat.format(date);
        return result;
    }
}
