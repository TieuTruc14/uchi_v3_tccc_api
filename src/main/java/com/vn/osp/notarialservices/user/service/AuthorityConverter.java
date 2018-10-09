package com.vn.osp.notarialservices.user.service;


import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.user.domain.AuthorityBO;
import com.vn.osp.notarialservices.user.dto.Authority;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by longtran on 02/11/2016.
 */

@Service
public class AuthorityConverter implements Converter<AuthorityBO, Authority> {

    @Override
    public Authority convert(final AuthorityBO source) {
        return new Authority(
                source.getCode(),
                source.getName(),
                source.getEntry_user_id(),
                source.getEntry_user_name(),
                convertTimeStampToString(source.getEntry_date_time()),
                source.getUpdate_user_id(),
                source.getUpdate_user_name(),
                convertTimeStampToString(source.getUpdate_date_time()),
                source.getType()
        );
    }

    @Override
    public AuthorityBO convert(final Authority source) {
        AuthorityBO authorityBO = new AuthorityBO();
        authorityBO.setCode(source.getCode());
        authorityBO.setName(source.getName());
        authorityBO.setEntry_user_id(source.getEntry_user_id());
        authorityBO.setEntry_user_name(source.getEntry_user_name());
        authorityBO.setEntry_date_time(convertStringToTimeStamp(source.getEntry_date_time()));
        authorityBO.setUpdate_user_id(source.getUpdate_user_id());
        authorityBO.setUpdate_user_name(source.getUpdate_user_name());
        authorityBO.setUpdate_date_time(convertStringToTimeStamp(source.getUpdate_date_time()));
        authorityBO.setType(source.getType());
        return authorityBO;
    }

    /***
     *
     * @param source
     * @return
     */
    public List<Authority> converts(final List<AuthorityBO> source) {
        return source.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public Timestamp convertStringToTimeStamp(String dateString) {
        try {
            if (dateString == "" || dateString == null) return null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date parsedDate = null;
            parsedDate = dateFormat.parse(dateString);
            Timestamp timestamp = new Timestamp(parsedDate.getTime());
            return timestamp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String convertTimeStampToString(Timestamp date) {
        if (date == null) return "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String result = dateFormat.format(date);
        return result;
    }
}