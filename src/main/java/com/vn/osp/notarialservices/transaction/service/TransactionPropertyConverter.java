
package com.vn.osp.notarialservices.transaction.service;

import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.transaction.domain.TransactionPropertyBo;
import com.vn.osp.notarialservices.transaction.dto.TransactionProperty;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by minh on 11/23/2016.
 */
@Service
public class TransactionPropertyConverter implements Converter<TransactionPropertyBo, TransactionProperty> {
    @Override
    public TransactionProperty convert (final TransactionPropertyBo source) {
        return new TransactionProperty (
                source.getTpid(),
                source.getSynchronize_id(),
                source.getType(),
                source.getProperty_info(),
                source.getLand_street(),
                source.getLand_district(),
                source.getLand_province(),
                source.getLand_full_of_area(),
                source.getTransaction_content(),
                convertTimeStampToString(source.getNotary_date()),
                source.getNotary_office_name(),
                source.getContract_id(),
                source.getContract_number(),
                source.getContract_name(),
                source.getContract_kind(),
                source.getCode_template(),
                source.getContract_value(),
                source.getRelation_object(),
                source.getNotary_person(),
                source.getNotary_place(),
                source.getNotary_fee(),
                source.getRemuneration_cost(),
                source.getNotary_cost_total(),
                source.getNote(),
                source.getContract_period(),
                source.getMortage_cancel_flag(),
                source.getMortage_cancel_date(),
                source.getMortage_cancel_note(),
                source.getCancel_status(),
                source.getCancel_description(),
                source.getEntry_user_id(),
                source.getEntry_user_name(),
                convertTimeStampToString(source.getEntry_date_time()),
                source.getUpdate_user_id(),
                source.getUpdate_user_name(),
                convertTimeStampToString(source.getUpdate_date_time()),
                source.getBank_id(),
                source.getBank_name(),
                source.getBank_code(),
                source.getSyn_status(),
                source.getJson_property(),
                source.getJson_person());
    }

    public Timestamp convertStringToTimeStamp(String dateString){
        try {
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

    public Timestamp convertStringToTimeStampSpecial(String dateString){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String result = dateFormat.format(date);
            return result;
        }catch (Exception e){
            return "";
        }
    }

    public String convertTimeStampToStringSpecial(Timestamp date){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String result = dateFormat.format(date);
            return result;
        }catch (Exception e){
            return "";
        }
    }

    @Override
    public TransactionPropertyBo convert(final TransactionProperty source) {
        TransactionPropertyBo transactionPropertyBo = new TransactionPropertyBo();
        transactionPropertyBo.setTpid(source.getTpid());
        transactionPropertyBo.setSynchronize_id(source.getSynchronize_id());
        transactionPropertyBo.setType(source.getType());
        transactionPropertyBo.setProperty_info(source.getProperty_info());
        transactionPropertyBo.setLand_street(source.getLand_street());
        transactionPropertyBo.setLand_district(source.getLand_district());
        transactionPropertyBo.setLand_province(source.getLand_province());
        transactionPropertyBo.setLand_full_of_area(source.getLand_full_of_area());
        transactionPropertyBo.setTransaction_content(source.getTransaction_content());
        transactionPropertyBo.setNotary_date(convertStringToTimeStamp(source.getNotary_date()));
        transactionPropertyBo.setNotary_office_name(source.getNotary_office_name());
        transactionPropertyBo.setContract_id(source.getContract_id());
        transactionPropertyBo.setContract_number(source.getContract_number());
        transactionPropertyBo.setContract_name(source.getContract_name());
        transactionPropertyBo.setContract_kind(source.getContract_kind());
        transactionPropertyBo.setCode_template(source.getCode_template());
        transactionPropertyBo.setContract_value(source.getContract_value());
        transactionPropertyBo.setRelation_object(source.getRelation_object());
        transactionPropertyBo.setNotary_person(source.getNotary_person());
        transactionPropertyBo.setNotary_place(source.getNotary_place());
        transactionPropertyBo.setNotary_fee(source.getNotary_fee());
        transactionPropertyBo.setRemuneration_cost(source.getRemuneration_cost());
        transactionPropertyBo.setNotary_cost_total(source.getNotary_cost_total());
        transactionPropertyBo.setNote(source.getNote());
        transactionPropertyBo.setContract_period(source.getContract_period());
        transactionPropertyBo.setMortage_cancel_flag(source.getMortage_cancel_flag());
        transactionPropertyBo.setMortage_cancel_date(source.getMortage_cancel_date());
        transactionPropertyBo.setMortage_cancel_note(source.getMortage_cancel_note());
        transactionPropertyBo.setCancel_status(source.getCancel_status());
        transactionPropertyBo.setCancel_description(source.getCancel_description());
        transactionPropertyBo.setEntry_user_id(source.getEntry_user_id());
        transactionPropertyBo.setEntry_user_name(source.getEntry_user_name());
        transactionPropertyBo.setEntry_date_time(convertStringToTimeStampSpecial(source.getEntry_date_time()));
        transactionPropertyBo.setUpdate_user_id(source.getUpdate_user_id());
        transactionPropertyBo.setUpdate_user_name(source.getUpdate_user_name());
        transactionPropertyBo.setUpdate_date_time(convertStringToTimeStampSpecial(source.getUpdate_date_time()));
        transactionPropertyBo.setBank_id(source.getBank_id());
        transactionPropertyBo.setBank_name(source.getBank_name());
        transactionPropertyBo.setBank_code(source.getBank_code());
        transactionPropertyBo.setSyn_status(source.getSyn_status());
        transactionPropertyBo.setJson_property(source.getJson_property());
        transactionPropertyBo.setJson_person(source.getJson_person());
        return transactionPropertyBo;
        }
}

