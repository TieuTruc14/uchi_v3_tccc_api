package com.vn.osp.notarialservices.contract.service;

import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.contract.domain.ContractHistoryInfoBO;
import com.vn.osp.notarialservices.contract.dto.ContractHistory;
import com.vn.osp.notarialservices.contract.dto.ContractHistoryInfor;
import org.springframework.stereotype.Service;

/**
 * Created by TienManh on 8/14/2017.
 */
@Service
public class ContractHistoryConverter implements Converter<ContractHistoryInfoBO, ContractHistoryInfor> {
    @Override
    public ContractHistoryInfor convert(ContractHistoryInfoBO source){
        return new ContractHistoryInfor(
                source.getHid(),
                source.getContract_id(),
                source.getContract_number(),
                source.getClient_info(),
                source.getExecute_date_time(),
                source.getExecute_person(),
                source.getExecute_content(),
                source.getContract_content()
        );

    }
    @Override
    public ContractHistoryInfoBO convert(ContractHistoryInfor source){
        return new ContractHistoryInfoBO(
                source.getHid(),
                source.getContract_id(),
                source.getContract_number(),
                source.getClient_info(),
                source.getExecute_date_time(),
                source.getExecute_person(),
                source.getExecute_content(),
                source.getContract_content()
        );

    }
}
