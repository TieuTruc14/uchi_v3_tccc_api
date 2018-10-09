package com.vn.osp.notarialservices.contract.repository;

import com.vn.osp.notarialservices.contract.domain.ContractBO;
import com.vn.osp.notarialservices.contract.domain.ContractKindBO;
import com.vn.osp.notarialservices.contract.dto.Contract;
import com.vn.osp.notarialservices.contract.dto.ContractHistoryInfor;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by Admin on 5/8/2017.
 */
public interface ContractKindRepositoryCustom {
    Optional<List<ContractKindBO>> getAllContractKind();
    Optional<Boolean> ContractKindAdd(String id,String name, Long updateUserId, String updateUserName, String code);
    Optional<List<ContractKindBO>> findContractKindByFilter(String stringFilter);
    Optional<BigInteger> countContractKindByFilter(String stringFilter);
    Optional<Boolean> UpdateContractKind(Long id, String name, Long updateUserId,String updateUserName,String contract_kind_code);
    Optional<Boolean> deleteContractKind(Long id);
    Optional<ContractKindBO> getContractKindById(String id);


}
