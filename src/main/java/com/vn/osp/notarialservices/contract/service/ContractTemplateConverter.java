package com.vn.osp.notarialservices.contract.service;


import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.contract.domain.ContractTemplateBO;
import com.vn.osp.notarialservices.contract.dto.ContractTemplate;
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
public class ContractTemplateConverter implements Converter<ContractTemplateBO, ContractTemplate> {

    @Override
    public ContractTemplate convert(final ContractTemplateBO source) {
        return new ContractTemplate(
                source.getId(),
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
                source.getCode_template()
        );
    }

    @Override
    public ContractTemplateBO convert(final ContractTemplate source) {
        ContractTemplateBO contractTemplateBO = new ContractTemplateBO();
        contractTemplateBO.setId(source.getContractTemplateId());
        contractTemplateBO.setName(source.getName());
        contractTemplateBO.setKind_id(source.getKind_id());
        contractTemplateBO.setKind_id_tt08(source.getKind_id_tt08());
        contractTemplateBO.setCode(source.getCode());
        contractTemplateBO.setDescription(source.getDescription());
        contractTemplateBO.setFile_name(source.getFile_name());
        contractTemplateBO.setFile_path(source.getFile_path());
        contractTemplateBO.setActive_flg(source.getActive_flg());
        contractTemplateBO.setRelate_object_number(source.getRelate_object_number());
        contractTemplateBO.setRelate_object_a_display(source.getRelate_object_a_display());
        contractTemplateBO.setRelate_object_b_display(source.getRelate_object_b_display());
        contractTemplateBO.setRelate_object_c_display(source.getRelate_object_c_display());
        contractTemplateBO.setPeriod_flag(source.getPeriod_flag());
        contractTemplateBO.setPeriod_req_flag(source.getPeriod_req_flag());
        contractTemplateBO.setMortage_cancel_func(source.getMortage_cancel_func());
        contractTemplateBO.setSync_option(source.getSync_option());
        contractTemplateBO.setEntry_user_id(source.getEntry_user_id());
        contractTemplateBO.setEntry_user_name(source.getEntry_user_name());
        contractTemplateBO.setEntry_date_time(convertStringToTimeStamp(source.getEntry_date_time()));
        contractTemplateBO.setUpdate_user_id(source.getUpdate_user_id());
        contractTemplateBO.setUpdate_date_time(convertStringToTimeStamp(source.getUpdate_date_time()));
        contractTemplateBO.setUpdate_user_name(source.getUpdate_user_name());
        contractTemplateBO.setKind_html(source.getKind_html());
        contractTemplateBO.setCode_template(source.getCode_template());


        return contractTemplateBO;
    }
    /***
     *
     * @param source
     * @return
     */
    public List<ContractTemplate> converts(final List<ContractTemplateBO> source) {
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

    public String convertTimeStampToString(Date date) {
        if (date == null) return "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String result = dateFormat.format(date);
        return result;
    }
}