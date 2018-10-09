package com.vn.osp.notarialservices.bank.service;

import com.vn.osp.notarialservices.bank.domain.BankBo;
import com.vn.osp.notarialservices.bank.dto.Bank;
import com.vn.osp.notarialservices.common.converter.Converter;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by minh on 2/22/2016.
 */
@Service
public class BankConverter implements Converter<BankBo, Bank> {
    @Override
    public Bank convert (final BankBo source) {
        return new Bank (
                source.getSid(),
                source.getCode(),
                source.getName(),
                source.getOrder_number(),
                source.getEntry_user_id(),
                source.getEntry_user_name(),
                source.getEntry_date_time(),
                source.getUpdate_user_id(),
                source.getUpdate_user_name(),
                source.getUpdate_date_time(),
                source.getActive()
        );


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
    public BankBo convert(final Bank source) {
        BankBo bankBo = new BankBo();
        bankBo.setSid(source.getSid());
        bankBo.setName(source.getName());
        bankBo.setOrder_number(source.getOrder_number());
        bankBo.setEntry_user_id(source.getEntry_user_id());
        bankBo.setEntry_user_name(source.getEntry_user_name());
        bankBo.setEntry_date_time(source.getEntry_date_time());
        bankBo.setUpdate_user_id(source.getUpdate_user_id());
        bankBo.setUpdate_user_name(source.getUpdate_user_name());
        bankBo.setUpdate_date_time(source.getUpdate_date_time());
        bankBo.setCode(source.getCode());
        bankBo.setActive(source.getActive());
        return bankBo;
    }

}

