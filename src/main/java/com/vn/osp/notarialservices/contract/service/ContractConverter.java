package com.vn.osp.notarialservices.contract.service;

import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.contract.domain.ContractBO;
import com.vn.osp.notarialservices.contract.dto.Contract;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by TienManh on 5/11/2017.
 */
@Service
public class ContractConverter implements Converter<ContractBO, Contract> {

    @Override
    public Contract convert(ContractBO source){
        return new Contract(
                source.getId(),
                source.getContract_template_id(),
                source.getContract_number(),
                source.getContract_value(),
                source.getRelation_object_a(),
                source.getRelation_object_b(),
                source.getRelation_object_c(),
                source.getNotary_id(),
                source.getDrafter_id(),
                convertTimeStampToString(source.getReceived_date()),
                convertTimeStampToString(source.getNotary_date()),
                source.getUser_require_contract(),
                source.getNumber_copy_of_contract(),
                source.getNumber_of_page(),
                source.getCost_tt91(),
                source.getCost_draft(),
                source.getCost_notary_outsite(),
                source.getCost_other_determine(),
                source.getCost_total(),
                source.getNotary_place_flag(),
                source.getNotary_place(),
                source.getBank_id(),
                source.getBank_service_fee(),
                source.getCrediter_name(),
                source.getFile_name(),
                source.getFile_path(),
                source.getError_status(),
                source.getError_user_id(),
                source.getError_description(),
                source.getAddition_status(),
                source.getAddition_description(),
                source.getCancel_status(),
                source.getCancel_description(),
                source.getCancel_relation_contract_id(),
                source.getContract_period(),
                source.getMortage_cancel_flag(),
                source.getMortage_cancel_date(),
                source.getMortage_cancel_note(),
                source.getOriginal_store_place(),
                source.getNote(),
                source.getSummary(),
                source.getEntry_user_id(),
                source.getEntry_user_name(),
                source.getEntry_date_time(),
                source.getUpdate_user_id(),
                source.getCrediter_name(),
                source.getUpdate_date_time(),
                source.getBank_name(),
                source.getJsonstring(),
                source.getKindhtml(),
                source.getContent(),
                source.getTitle(),
                source.getBank_code(),
                source.getJson_property(),
                source.getJson_person()
        );
    }
    @Override
    public ContractBO convert(Contract source){
        return new ContractBO(
                source.getid(),
                source.getContract_template_id(),
                source.getContract_number(),
                source.getContract_value(),
                source.getRelation_object_a(),
                source.getRelation_object_b(),
                source.getRelation_object_c(),
                source.getNotary_id(),
                source.getDrafter_id(),
                convertStringToTimeStamp(source.getReceived_date()),
                convertStringToTimeStamp(source.getNotary_date()),
                source.getUser_require_contract(),
                source.getNumber_copy_of_contract(),
                source.getNumber_of_page(),
                source.getCost_tt91(),
                source.getCost_draft(),
                source.getCost_notary_outsite(),
                source.getCost_other_determine(),
                source.getCost_total(),
                source.getNotary_place_flag(),
                source.getNotary_place(),
                source.getBank_id(),
                source.getBank_service_fee(),
                source.getCrediter_name(),
                source.getFile_name(),
                source.getFile_path(),
                source.getError_status(),
                source.getError_user_id(),
                source.getError_description(),
                source.getAddition_status(),
                source.getAddition_description(),
                source.getCancel_status(),
                source.getCancel_description(),
                source.getCancel_relation_contract_id(),
                source.getContract_period(),
                source.getMortage_cancel_flag(),
                source.getMortage_cancel_date(),
                source.getMortage_cancel_note(),
                source.getOriginal_store_place(),
                source.getNote(),
                source.getSummary(),
                source.getEntry_user_id(),
                source.getEntry_user_name(),
                source.getEntry_date_time(),
                source.getUpdate_user_id(),
                source.getCrediter_name(),
                source.getUpdate_date_time(),
                source.getBank_name(),
                source.getJsonstring(),
                source.getKindhtml(),
                source.getContent(),
                source.getTitle(),
                source.getBank_code(),
                source.getJson_property(),
                source.getJson_person()
        );
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
