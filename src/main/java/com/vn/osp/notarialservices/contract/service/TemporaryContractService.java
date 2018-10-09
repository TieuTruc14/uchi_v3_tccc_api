package com.vn.osp.notarialservices.contract.service;

import com.vn.osp.notarialservices.contract.dto.*;
import com.vn.osp.notarialservices.transaction.dto.TransactionProperty;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by TienManh on 5/13/2017.
 */
public interface TemporaryContractService {
    Optional<List<TemporaryContract>> getAllTemporaryContract();
    Optional<List<TemporaryContract>> getTemporaryByType(String type);
    Optional<List<TemporaryContract>> getTemporaryByFilter(String filter);
    Optional<BigInteger> countTemporaryByFilter(String filter);
    Optional<BigInteger> countTemporaryByType(String type);
    Optional<Integer> addTemporary(TemporaryContract item);
    Optional<Integer> editTemporary(TemporaryContract item);
    Optional<TemporaryContract> getTemporaryById(String id);
    Contract genContractFromTemporary(TemporaryContract tem);
    Optional<Long> addTemporaryMark(Long tcid, Contract contract, TransactionProperty tran, ContractHistoryInfor his);
    Boolean deleteTemporary(Long id);
    Boolean updateContractNumberValue();
    Optional<Integer> getContractNumberValue();
    Optional<Integer> getContractNumber(String year);
    String getStringFilterFromSearch(String search,String type);
}
