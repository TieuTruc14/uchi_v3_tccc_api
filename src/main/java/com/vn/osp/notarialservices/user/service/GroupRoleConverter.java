package com.vn.osp.notarialservices.user.service;


import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.user.domain.GroupRoleBO;
import com.vn.osp.notarialservices.user.dto.GroupRole;
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
public class GroupRoleConverter implements Converter<GroupRoleBO, GroupRole> {

    @Override
    public GroupRole convert(final GroupRoleBO source) {
        return new GroupRole(
                source.getId(),
                source.getGrouprolename(),
                source.getDescription(),
                source.getActive_flg(),
                source.getEntry_user_id(),
                source.getEntry_user_name(),
                convertTimeStampToString(source.getEntry_date_time()),
                source.getUpdate_user_id(),
                source.getUpdate_user_name(),
                convertTimeStampToString(source.getUpdate_date_time())
        );
    }

    @Override
    public GroupRoleBO convert(final GroupRole source) {
        GroupRoleBO groupRoleBO = new GroupRoleBO();
        groupRoleBO.setId(source.getGroupRoleId());
        groupRoleBO.setGrouprolename(source.getGrouprolename());
        groupRoleBO.setDescription(source.getDescription());
        groupRoleBO.setActive_flg(source.getActive_flg());
        groupRoleBO.setEntry_user_id(source.getEntry_user_id());
        groupRoleBO.setEntry_user_name(source.getEntry_user_name());
        groupRoleBO.setEntry_date_time(convertStringToTimeStamp(source.getEntry_date_time()));
        groupRoleBO.setUpdate_user_id(source.getUpdate_user_id());
        groupRoleBO.setUpdate_user_name(source.getUpdate_user_name());
        groupRoleBO.setUpdate_date_time(convertStringToTimeStamp(source.getUpdate_date_time()));
        return groupRoleBO;
    }

    /***
     *
     * @param source
     * @return
     */
    public List<GroupRole> converts(final List<GroupRoleBO> source) {
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