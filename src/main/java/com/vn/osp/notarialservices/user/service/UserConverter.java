package com.vn.osp.notarialservices.user.service;


import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.user.domain.UserBO;
import com.vn.osp.notarialservices.user.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserConverter implements Converter<UserBO, User> {

    @Override
    public User convert(final UserBO source) {
        return new User(
                source.getId(),
                source.getOffice_id(),
                source.getFamily_name(),
                source.getFirst_name(),
                source.getAccount(),
                source.getPassword(),
                source.getSex(),
                source.getActive_flg(),
                source.getActive_ccv(),
                source.getHidden_flg(),
                source.getRole(),
                source.getBirthday(),
                source.getTelephone(),
                source.getMobile(),
                source.getEmail(),
                source.getAddress(),
                convertTimeStampToString(source.getLast_login_date()),
                source.getEntry_user_id(),
                source.getEntry_user_name(),
                convertTimeStampToString(source.getEntry_date_time()),
                source.getUpdate_user_id(),
                source.getUpdate_user_name(),
                convertTimeStampToString(source.getUpdate_date_time()),
                source.getFile_path(),
                source.getFile_name());
    }

    @Override
    public UserBO convert(final User source) {
        UserBO userBO = new UserBO();
        userBO.setId(source.getUserId());
        userBO.setOffice_id(source.getOffice_id());
        userBO.setFamily_name(source.getFamily_name());
        userBO.setFirst_name(source.getFirst_name());
        userBO.setAccount(source.getAccount());
        userBO.setPassword(source.getPassword());
        userBO.setSex(source.getSex());
        userBO.setActive_flg(source.getActive_flg());
        userBO.setHidden_flg(source.getHidden_flg());
        userBO.setRole(source.getRole());
        userBO.setBirthday(source.getBirthday());
        userBO.setTelephone(source.getTelephone());
        userBO.setMobile(source.getMobile());
        userBO.setEmail(source.getEmail());
        userBO.setAddress(source.getAddress());
        userBO.setLast_login_date(convertStringToTimeStamp(source.getLast_login_date()));
        userBO.setEntry_user_id(source.getEntry_user_id());
        userBO.setEntry_user_name(source.getEntry_user_name());
        userBO.setEntry_date_time(convertStringToTimeStamp(source.getEntry_date_time()));
        userBO.setUpdate_user_id(source.getUpdate_user_id());
        userBO.setUpdate_user_name(source.getUpdate_user_name());
        userBO.setUpdate_date_time(convertStringToTimeStamp(source.getUpdate_date_time()));
        userBO.setFile_path(source.getFile_path());
        userBO.setFile_name(source.getFile_name());
        return userBO;
    }

    /***
     *
     * @param source
     * @return
     */
    public List<User> converts(final List<UserBO> source) {
        return source.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
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