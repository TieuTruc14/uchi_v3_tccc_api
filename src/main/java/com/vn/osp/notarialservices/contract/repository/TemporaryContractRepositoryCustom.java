package com.vn.osp.notarialservices.contract.repository;

import com.vn.osp.notarialservices.contract.domain.ContractBO;
import com.vn.osp.notarialservices.contract.domain.ContractHistoryInfoBO;
import com.vn.osp.notarialservices.contract.domain.TemporaryContractBO;
import com.vn.osp.notarialservices.transaction.domain.TransactionPropertyBo;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by TienManh on 5/13/2017.
 */
@Transactional
public interface TemporaryContractRepositoryCustom {
    Optional<List<TemporaryContractBO>> getAllTemporaryContract();
    Optional<List<TemporaryContractBO>> getTemporaryByType(String type);
    Optional<List<TemporaryContractBO>> getTemporaryByFilter(String filter);
    Optional<BigInteger> countTemporaryByFilter(String filter);
    Optional<BigInteger> countTemporaryByType(String type);

    Optional<Integer> addTemporary(TemporaryContractBO item);
//    Optional<Integer> addTemporary(String xml_temporary);
    Optional<Integer> editTemporary(TemporaryContractBO item);
    Optional<TemporaryContractBO> getTemporaryById(String id);
//    Optional<Integer> addTemporaryMark(String tcid, String xml_contract,String xml_transaction_property,String xml_contract_history);
    Optional<Long> addTemporaryMark(Long tcid, ContractBO contract, TransactionPropertyBo tran, ContractHistoryInfoBO his);
    Boolean deleteTemporary(Long id);
    Boolean updateContractNumberValue();
    Optional<Integer> getContractNumberValue();
    Optional<Integer> getContractNumber(String key);

}
