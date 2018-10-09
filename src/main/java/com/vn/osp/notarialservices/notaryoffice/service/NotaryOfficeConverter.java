package com.vn.osp.notarialservices.notaryoffice.service;


import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.notaryoffice.domain.NotaryOfficeBO;
import com.vn.osp.notarialservices.notaryoffice.dto.NotaryOffice;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by manhtran on 02/11/2016.
 */

@Service
public class NotaryOfficeConverter implements Converter<NotaryOfficeBO, NotaryOffice> {

    @Override
    public NotaryOffice convert(final NotaryOfficeBO source) {
        return new NotaryOffice(
                source.getId(),
                source.getOfficeType(),
                source.getName(),
                source.getAddress(),
                source.getPhone(),
                source.getFax(),
                source.getEmail(),
                source.getWebsite(),
                source.getOtherInfo(),
                source.getMacAddress(),
                source.getAuthenticationId(),
                source.getAuthenticationCode(),
                source.getActiveFlg(),
                source.getHiddenFlg(),
                convertTimeStampToString(source.getLastConnectionTime()),
                source.getSynchronizeType(),
                source.getEntryUserId(),
                source.getEntryUserName(),
                convertTimeStampToString(source.getEntryDateTime()),
                source.getUpdateUserId(),
                source.getUpdateUserName(),
                convertTimeStampToString(source.getUpdateDateTime()),
                source.getProvince_id()
        );
    }

    public Timestamp convertStringToTimeStamp(String dateString){
        try {
            if(dateString == "" || dateString == null) return null;
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
        if(date == null) return "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String result  = dateFormat.format(date);
        return result;
    }
    public List<NotaryOffice> converts(final List<NotaryOfficeBO> source) {
        return source.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
    @Override
    public NotaryOfficeBO convert(final NotaryOffice source) {

        NotaryOfficeBO notaryOfficeBO = new NotaryOfficeBO();
        notaryOfficeBO.setId(source.getNoid());
        notaryOfficeBO.setOfficeType(source.getOffice_type());
        notaryOfficeBO.setName(source.getName());
        notaryOfficeBO.setAddress(source.getAddress());
        notaryOfficeBO.setPhone(source.getPhone());
        notaryOfficeBO.setFax(source.getFax());
        notaryOfficeBO.setEmail(source.getEmail());
        notaryOfficeBO.setWebsite(source.getWebsite());
        notaryOfficeBO.setOtherInfo(source.getOther_info());
        notaryOfficeBO.setMacAddress(source.getMac_address());
        notaryOfficeBO.setAuthenticationId((source.getAuthentication_id()));
        notaryOfficeBO.setAuthenticationCode(source.getAuthentication_code());
        notaryOfficeBO.setActiveFlg(source.getActive_flg());
        notaryOfficeBO.setHiddenFlg(source.getHidden_flg());
        notaryOfficeBO.setLastConnectionTime(convertStringToTimeStamp(source.getLast_connection_time()));
        notaryOfficeBO.setSynchronizeType(source.getSynchronize_type());
        notaryOfficeBO.setEntryUserId(source.getEntry_user_id());
        notaryOfficeBO.setEntryUserName(source.getEntry_user_name());
        notaryOfficeBO.setEntryDateTime(convertStringToTimeStamp(source.getEntry_date_time()));
        notaryOfficeBO.setUpdateUserId(source.getUpdate_user_id());
        notaryOfficeBO.setUpdateUserName(source.getUpdate_user_name());
        notaryOfficeBO.setUpdateDateTime(convertStringToTimeStamp(source.getUpdate_date_time()));
        notaryOfficeBO.setProvince_id(source.getProvince_id());


        return notaryOfficeBO;
    }
}