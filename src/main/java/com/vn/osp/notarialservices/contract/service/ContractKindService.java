
package com.vn.osp.notarialservices.contract.service;

import com.vn.osp.notarialservices.contract.dto.ContractKind;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 5/30/2017.
 */
public interface ContractKindService  {
    Optional<Boolean> ContractKindAdd(String id, String name, Long updateUserId, String updateUserName, String code);
    Optional<List<ContractKind>> findContractKindByFilter(String stringFilter);
    Optional<BigInteger> countContractKindByFilter(String stringFilter);
    Optional<Boolean> UpdateContractKind(Long id, String name, Long updateUserId, String updateUserName, String contract_kind_code);
    Optional<Boolean> deleteContractKind(Long id);
    Optional<ContractKind> getContractKindById(String id);

}
