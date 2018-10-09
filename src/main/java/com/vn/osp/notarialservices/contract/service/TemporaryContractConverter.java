package com.vn.osp.notarialservices.contract.service;

import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.contract.domain.TemporaryContractBO;
import com.vn.osp.notarialservices.contract.dto.TemporaryContract;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by TienManh on 5/13/2017.
 */
@Service
public class TemporaryContractConverter implements Converter<TemporaryContractBO, TemporaryContract> {

    @Override
    public TemporaryContract convert(TemporaryContractBO source){
        TemporaryContract object=new TemporaryContract();
        object.setTcid(source.getId());
        object.setType(source.getType());
        object.setContract_template_id(source.getContract_template_id());
        object.setContract_number(source.getContract_number());
        object.setContract_value(source.getContract_value());
        object.setRelation_object_a(source.getRelation_object_a());
        object.setRelation_object_b(source.getRelation_object_b());
        object.setRelation_object_c(source.getRelation_object_c());
        object.setNotary_id(source.getNotary_id());
        object.setDrafter_id(source.getDrafter_id());
        object.setReceived_date(convertTimeStampToString(source.getReceived_date()));
        object.setNotary_date(convertTimeStampToString(source.getNotary_date()));
        object.setUser_require_contract(source.getUser_require_contract());
        object.setProperty_type(source.getProperty_type());
        object.setProperty_info(source.getProperty_info());
        object.setOwner_info(source.getOwner_info());
        object.setOther_info(source.getOther_info());
        object.setLand_certificate(source.getLand_certificate());
        object.setLand_issue_place(source.getLand_issue_place());
        object.setLand_issue_date(convertTimeStampToString(source.getLand_issue_date()));
        object.setLand_map_number(source.getLand_map_number());
        object.setLand_number(source.getLand_number());
        object.setLand_address(source.getLand_address());
        object.setLand_area(source.getLand_area());
        object.setLand_private_area(source.getLand_private_area());
        object.setLand_public_area(source.getLand_public_area());
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
        object.setNumber_copy_of_contract(source.getNumber_copy_of_contract());
        object.setNumber_of_page(source.getNumber_of_page());
        object.setCost_tt91(source.getCost_tt91());
        object.setCost_draft(source.getCost_draft());
        object.setCost_notary_outsite(source.getCost_notary_outsite());
        object.setCost_other_determine(source.getCost_other_determine());
        object.setCost_total(source.getCost_total());
        object.setNotary_place_flag(source.getNotary_place_flag());
        object.setNotary_place(source.getNotary_place());
        object.setBank_id(source.getBank_id());
        object.setBank_service_fee(source.getBank_service_fee());
        object.setCrediter_name(source.getCrediter_name());
        object.setFile_name(source.getFile_name());
        object.setFile_path(source.getFile_path());
        object.setOriginal_store_place(source.getOriginal_store_place());
        object.setNote(source.getNote());
        object.setSummary(source.getSummary());
        object.setEntry_user_id(source.getEntry_user_id());
        object.setEntry_user_name(source.getEntry_user_name());
        object.setEntry_date_time(source.getEntry_date_time());
        object.setUpdate_user_id(source.getUpdate_user_id());
        object.setUpdate_user_name(source.getUpdate_user_name());
        object.setUpdate_date_time(source.getUpdate_date_time());
        object.setJsonstring(source.getJsonstring());
        object.setKindhtml(source.getKindhtml());
        object.setJson_property(source.getJson_property());
        object.setJson_person(source.getJson_person());
        object.setBank_code(source.getBank_code());

        return object;
    }
    @Override
    public TemporaryContractBO convert(TemporaryContract source){
        TemporaryContractBO object=new TemporaryContractBO();
        object.setId(source.getTcid());
        object.setType(source.getType());
        object.setContract_template_id(source.getContract_template_id());
        object.setContract_number(source.getContract_number());
        object.setContract_value(source.getContract_value());
        object.setRelation_object_a(source.getRelation_object_a());
        object.setRelation_object_b(source.getRelation_object_b());
        object.setRelation_object_c(source.getRelation_object_c());
        object.setNotary_id(source.getNotary_id());
        object.setDrafter_id(source.getDrafter_id());
        object.setReceived_date(convertStringToTimeStamp(source.getReceived_date()));
        object.setNotary_date(convertStringToTimeStamp(source.getNotary_date()));
        object.setUser_require_contract(source.getUser_require_contract());
        object.setProperty_type(source.getProperty_type());
        object.setProperty_info(source.getProperty_info());
        object.setOwner_info(source.getOwner_info());
        object.setOther_info(source.getOther_info());
        object.setLand_certificate(source.getLand_certificate());
        object.setLand_issue_place(source.getLand_issue_place());
        object.setLand_issue_date(convertStringToTimeStamp(source.getLand_issue_date()));
        object.setLand_map_number(source.getLand_map_number());
        object.setLand_number(source.getLand_number());
        object.setLand_address(source.getLand_address());
        object.setLand_area(source.getLand_area());
        object.setLand_private_area(source.getLand_private_area());
        object.setLand_public_area(source.getLand_public_area());
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
        object.setCar_issue_date(convertStringToTimeStamp(source.getCar_issue_date()));
        object.setCar_frame_number(source.getCar_frame_number());
        object.setCar_machine_number(source.getCar_machine_number());
        object.setNumber_copy_of_contract(source.getNumber_copy_of_contract());
        object.setNumber_of_page(source.getNumber_of_page());
        object.setCost_tt91(source.getCost_tt91());
        object.setCost_draft(source.getCost_draft());
        object.setCost_notary_outsite(source.getCost_notary_outsite());
        object.setCost_other_determine(source.getCost_other_determine());
        object.setCost_total(source.getCost_total());
        object.setNotary_place_flag(source.getNotary_place_flag());
        object.setNotary_place(source.getNotary_place());
        object.setBank_id(source.getBank_id());
        object.setBank_service_fee(source.getBank_service_fee());
        object.setCrediter_name(source.getCrediter_name());
        object.setFile_name(source.getFile_name());
        object.setFile_path(source.getFile_path());
        object.setOriginal_store_place(source.getOriginal_store_place());
        object.setNote(source.getNote());
        object.setSummary(source.getSummary());
        object.setEntry_user_id(source.getEntry_user_id());
        object.setEntry_user_name(source.getEntry_user_name());
        object.setEntry_date_time(source.getEntry_date_time());
        object.setUpdate_user_id(source.getUpdate_user_id());
        object.setUpdate_user_name(source.getUpdate_user_name());
        object.setUpdate_date_time(source.getUpdate_date_time());
        object.setJsonstring(source.getJsonstring());
        object.setKindhtml(source.getKindhtml());
        object.setJson_property(source.getJson_property());
        object.setJson_person(source.getJson_person());
        object.setBank_code(source.getBank_code());

        return object;
    }

    public Timestamp convertStringToTimeStamp(String dateString){
        try {
            if(dateString == "" || dateString == null) return null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String result  = dateFormat.format(date);
        return result;
    }
}
