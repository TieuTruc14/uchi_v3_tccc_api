package com.vn.osp.notarialservices.contracttemplate.service;

import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.contracttemplate.domain.ContractTempBo;
import com.vn.osp.notarialservices.contracttemplate.dto.ContractTemp;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 7/6/2017.
 */
@Service
public class ContractTempConverter implements Converter<ContractTempBo,ContractTemp> {
    @Override
    public ContractTemp convert(final ContractTempBo source) {
        return new ContractTemp(
                source.getSid(),
                source.getName(),
                source.getKind_id(),
                source.getKind_id_tt08(),
                source.getCode(),
                source.getDescription(),
                source.getFile_name(),
                source.getFile_path(),
                source.getActive_flg(),
                source.getRelate_object_number(),
                source.getRelate_object_a_display(),
                source.getRelate_object_b_display(),
                source.getRelate_object_c_display(),
                source.getPeriod_flag(),
                source.getPeriod_req_flag(),
                source.getMortage_cancel_func(),
                source.getSync_option(),
                source.getEntry_user_id(),
                source.getEntry_user_name(),
                convertTimeStampToString(source.getEntry_date_time()),
                source.getUpdate_user_id(),
                source.getUpdate_user_name(),
                convertTimeStampToString(source.getUpdate_date_time()),
                source.getKind_html(),
                source.getOffice_code(),
                source.getCode_template());


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
    @Override
    public ContractTempBo convert(final ContractTemp source) {
        ContractTempBo contractTempBo = new ContractTempBo();
        contractTempBo.setSid(source.getSid());
        contractTempBo.setName(source.getName());
        contractTempBo.setKind_id(source.getKind_id());
        contractTempBo.setKind_id_tt08(source.getKind_id_tt08());
        contractTempBo.setCode(source.getCode());
        contractTempBo.setDescription(source.getDescription());
        contractTempBo.setFile_name(source.getFile_name());
        contractTempBo.setFile_path(source.getFile_path());
        contractTempBo.setActive_flg(source.getActive_flg());
        contractTempBo.setRelate_object_number(source.getRelate_object_number());
        contractTempBo.setPeriod_flag(source.getPeriod_flag());
        contractTempBo.setPeriod_req_flag(source.getPeriod_req_flag());
        contractTempBo.setMortage_cancel_func(source.getMortage_cancel_func());
        contractTempBo.setSync_option(source.getSync_option());
        contractTempBo.setEntry_user_id(source.getEntry_user_id());
        contractTempBo.setEntry_user_name(source.getEntry_user_name());
        contractTempBo.setEntry_date_time(convertStringToTimeStamp(source.getEntry_date_time()));
        contractTempBo.setUpdate_user_id(source.getUpdate_user_id());
        contractTempBo.setUpdate_user_name(source.getUpdate_user_name());
        contractTempBo.setUpdate_date_time(convertStringToTimeStamp(source.getUpdate_date_time()));
        contractTempBo.setKind_html(source.getKind_html());
        contractTempBo.setOffice_code(source.getOffice_code());
        contractTempBo.setCode_template(source.getCode_template());


        return contractTempBo;
    }
}
