package com.vn.osp.notarialservices.province.service;

import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.province.domain.ProvinceBo;
import com.vn.osp.notarialservices.province.dto.Province;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by TienManh on 5/10/2017.
 */
@Service
public class ProvinceConverter implements Converter<ProvinceBo,Province> {
    @Override
    public Province convert(final ProvinceBo source) {
        return new Province (
                source.getSid(),
                source.getName(),
                source.getOrder_number(),
                source.getEntry_user_id(),
                source.getEntry_user_name(),
                convertTimeStampToString(source.getEntry_date_time()),
                source.getUpdate_user_id(),
                source.getUpdate_user_name(),
                convertTimeStampToString(source.getUpdate_date_time()),
                source.getCode(),
                source.getNotary_index());

    }
    public Timestamp convertStringToTimeStamp(String dateString){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date parsedDate = null;
            parsedDate = dateFormat.parse(dateString);
            Timestamp timestamp = new Timestamp(parsedDate.getTime());
            return  timestamp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String convertTimeStampToString(Timestamp date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        if(date==null){
            return null;
        }
        else {
            String result = dateFormat.format(date);
            return result;
        }
    }
    @Override
    public ProvinceBo convert(final Province source) {
        ProvinceBo provinceBo = new ProvinceBo();
        provinceBo.setSid(source.getSid());
        provinceBo.setName(source.getName());
        provinceBo.setOrder_number(source.getOrder_number());
        provinceBo.setEntry_user_id(source.getEntry_user_id());
        provinceBo.setEntry_user_name(source.getEntry_user_name());
        provinceBo.setEntry_date_time(convertStringToTimeStamp(source.getEntry_date_time()));
        provinceBo.setUpdate_user_id(source.getUpdate_user_id());
        provinceBo.setUpdate_user_name(source.getUpdate_user_name());
        provinceBo.setUpdate_date_time(convertStringToTimeStamp(source.getUpdate_date_time()));
        provinceBo.setCode(source.getCode());
        provinceBo.setNotary_index(source.getNotary_index());



        return provinceBo;
    }

}
