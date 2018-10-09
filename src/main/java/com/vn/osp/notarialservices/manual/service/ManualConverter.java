package com.vn.osp.notarialservices.manual.service;

import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.manual.domain.ManualBo;
import com.vn.osp.notarialservices.manual.dto.Manual;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by minh on 11/18/2016.
 */

@Service
public class ManualConverter implements Converter<ManualBo,Manual> {

    @Override
    public Manual convert(final ManualBo source) {
        return new Manual(
                source.getId(),
                source.getTitle(),
                source.getContent(),
                source.getFile_name(),
                source.getFile_path(),
                source.getEntry_user_id(),
                source.getEntry_user_name(),
                convertTimeStampToString(source.getEntry_date_time()),
                source.getUpdate_user_id(),
                source.getUpdate_user_name(),
                convertTimeStampToString(source.getUpdate_date_time()));
    }
    public Timestamp convertStringToTimeStamp(String dateString){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        if(date==null){
            return null;
        }
        else {
            String result = dateFormat.format(date);
            return result;
        }
    }
    @Override
    public ManualBo convert(final Manual source) {
        ManualBo manualBo = new ManualBo();
        manualBo.setId(source.getMid());
        manualBo.setTitle(source.getTitle());
        manualBo.setContent(source.getContent());
        manualBo.setFile_name(source.getFile_name());
        manualBo.setFile_path(source.getFile_path());
        manualBo.setEntry_user_id(source.getEntry_user_id());
        manualBo.setEntry_user_name(source.getEntry_user_name());
        manualBo.setEntry_date_time(convertStringToTimeStamp(source.getEntry_date_time()));
        manualBo.setUpdate_user_id(source.getUpdate_user_id());
        manualBo.setUpdate_user_name(source.getUpdate_user_name());
        manualBo.setUpdate_date_time(convertStringToTimeStamp(source.getUpdate_date_time()));
        return manualBo;
        }

}

