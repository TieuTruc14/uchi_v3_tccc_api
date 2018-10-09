package com.vn.osp.notarialservices.systemmanager.service;


import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.systemmanager.domain.AccessHistoryBO;
import com.vn.osp.notarialservices.systemmanager.dto.AccessHistory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by manhtran on 02/11/2016.
 */

@Service
public class AccessHistoryConverter implements Converter<AccessHistoryBO, AccessHistory> {

    @Override
    public AccessHistory convert(final AccessHistoryBO source) {
        return new AccessHistory(
                source.getId(),
                source.getUsid(),
                source.getExecutePerson(),
                source.getClientInfo(),
                convertTimeStampToString(source.getExecuteDateTime()),
                source.getAccessType(),
                source.getDescription());
    }

    public Timestamp convertStringToTimeStamp(String dateString){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
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
        DateFormat writeFormat = new SimpleDateFormat( "dd-MM-yyyy kk:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");
        if(date==null){
            return null;
        }
        else {
            String result = writeFormat.format(date);
            return result;
        }
    }

    @Override
    public AccessHistoryBO convert(final AccessHistory source) {
        AccessHistoryBO accessHistoryBO= new AccessHistoryBO();
        accessHistoryBO.setId(source.getHid());
        accessHistoryBO.setUsid(source.getUsid());
        accessHistoryBO.setExecutePerson(source.getExecute_person());
        accessHistoryBO.setClientInfo(source.getClient_info());
        accessHistoryBO.setExecuteDateTime(convertStringToTimeStamp(source.getExecute_date_time()));
        accessHistoryBO.setAccessType(source.getAccess_type());
        accessHistoryBO.setDescription(source.getDescription());
        return accessHistoryBO;
    }

}