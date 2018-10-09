package com.vn.osp.notarialservices.announcement.service;

import com.vn.osp.notarialservices.announcement.domain.AnnouncementBo;
import com.vn.osp.notarialservices.announcement.dto.Announcement;
import com.vn.osp.notarialservices.common.converter.Converter;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by minh on 11/7/2016.
 */
@Service
public class AnnouncementConverter implements Converter<AnnouncementBo, Announcement> {
    @Override
    public Announcement convert (final AnnouncementBo source) {
        return new Announcement (
                source.getId(),
                source.getSynchronize_id(),
                source.getKind(),
                source.getConfirm_request(),
                source.getImportance_type(),
                source.getPopup_display_flg(),
                source.getPopup_display_day(),
                source.getTitle(),
                source.getContent(),
                //convertTimeStampToString(source.getSend_date_time()),
                source.getSend_date_time().toString(),
                source.getAttach_file_name(),
                source.getAttach_file_path(),
                source.getEntry_user_id(),
                source.getEntry_user_name(),
                convertTimeStampToStringMinutes(source.getEntry_date_time()),
                source.getUpdate_user_id(),
                source.getUpdate_user_name(),
                convertTimeStampToString(source.getUpdate_date_time()),
                source.getSender_info(),
                source.getAnouncement_type(),
                null);


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
    public static String convertTimeStampToStringMinutes(Timestamp date){

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if(date==null){
            return null;
        }
        else {
            String result = dateFormat.format(date);
            return result;
        }
    }
    @Override
    public AnnouncementBo convert(final Announcement source) {
            AnnouncementBo announcementBo = new AnnouncementBo();
            announcementBo.setId(source.getAid());
            announcementBo.setAttach_file_name(source.getAttach_file_name());
            announcementBo.setConfirm_request(source.getConfirm_request());
            announcementBo.setAttach_file_path(source.getAttach_file_path());
            announcementBo.setContent(source.getContent());
            announcementBo.setSynchronize_id(source.getSynchronize_id());
            announcementBo.setImportance_type(source.getImportance_type());
            announcementBo.setPopup_display_day(source.getPopup_display_day());
            announcementBo.setPopup_display_flg(source.getPopup_display_flg());
            announcementBo.setKind(source.getKind());
            announcementBo.setSend_date_time(convertStringToTimeStamp(source.getSend_date_time()));
            announcementBo.setSender_info(source.getSender_info());
            announcementBo.setTitle(source.getTitle());
            announcementBo.setEntry_user_id(source.getEntry_user_id());
            announcementBo.setEntry_user_name(source.getEntry_user_name());
            announcementBo.setEntry_date_time(convertStringToTimeStamp(source.getEntry_date_time()));
            announcementBo.setUpdate_user_id(source.getUpdate_user_id());
            announcementBo.setUpdate_user_name(source.getUpdate_user_name());
            announcementBo.setUpdate_date_time(convertStringToTimeStamp(source.getUpdate_date_time()));
            announcementBo.setAnouncement_type(source.getAnnouncement_type());

        return announcementBo;
    }


}

