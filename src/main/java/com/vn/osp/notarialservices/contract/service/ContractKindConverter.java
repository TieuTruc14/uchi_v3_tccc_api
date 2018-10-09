package com.vn.osp.notarialservices.contract.service;


import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.contract.domain.ContractKindBO;
import com.vn.osp.notarialservices.contract.dto.ContractKind;
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
public class ContractKindConverter implements Converter<ContractKindBO, ContractKind> {

    @Override
    public ContractKind convert(final ContractKindBO source) {
        return new ContractKind(
                source.getId(),
                source.getName(),
                source.getParent_kind_id(),
                source.getOrder_number(),
                source.getEntry_user_id(),
                source.getEntry_user_name(),
                convertTimeStampToString(source.getEntry_date_time()),
                source.getUpdate_user_id(),
                source.getUpdate_user_name(),
                convertTimeStampToString(source.getUpdate_date_time()),
                source.getContract_kind_code()
        );
    }

    @Override
    public ContractKindBO convert(final ContractKind source) {
        ContractKindBO contractKindBO = new ContractKindBO();
        contractKindBO.setId(source.getContractKindId());
        contractKindBO.setName(source.getName());
        contractKindBO.setParent_kind_id(source.getParent_kind_id());
        contractKindBO.setOrder_number(source.getOrder_number());
        contractKindBO.setEntry_user_id(source.getEntry_user_id());
        contractKindBO.setEntry_user_name(source.getEntry_user_name());
        contractKindBO.setEntry_date_time(convertStringToTimeStamp(source.getEntry_date_time()));
        contractKindBO.setUpdate_user_id(source.getUpdate_user_id());
        contractKindBO.setUpdate_user_name(source.getUpdate_user_name());
        contractKindBO.setUpdate_date_time(convertStringToTimeStamp(source.getUpdate_date_time()));
        contractKindBO.setContract_kind_code(source.getContract_kind_code());
        return contractKindBO;
    }
    /***
     *
     * @param source
     * @return
     */
    public List<ContractKind> converts(final List<ContractKindBO> source) {
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