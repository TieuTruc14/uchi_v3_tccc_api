package com.vn.osp.notarialservices.transaction.repository;

import com.vn.osp.notarialservices.transaction.domain.TransactionPropertyBo;
import com.vn.osp.notarialservices.transaction.dto.EntryUserName;
import com.vn.osp.notarialservices.transaction.dto.NotaryName;
import com.vn.osp.notarialservices.transaction.dto.ReportByBank;
import com.vn.osp.notarialservices.transaction.dto.TransactionNotaryOfficeName;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 11/24/2016.
 */
public interface TransactionPropertyRepositoryCustom {
    /**
     * Method actually triggering a finder but being overridden.
     */
    void findByOverridingMethod();

    /***
     *
     * @param id
     */
    void delete(Integer id);

    Optional<Boolean> addTransactionProperty(String data);
    Optional<Boolean> synchronizeOk(String notaryOfficeCode, Integer contract_kind, String contractNumber);
    Optional<List<TransactionPropertyBo>> findTransactionByFilter(String stringFilter);
    public Optional<BigInteger> countTotalByFilter(String stringFilter);
    Optional<List<TransactionPropertyBo>> findTransactionByBank(String bankname, String notaryDateFromFilter , String notaryDateToFilter, Integer numOffset, Integer numLimit );
    Optional<BigInteger> countTotalContractByBank(String bankName, String notaryDateFromFilter, String notaryDateToFilter) ;
    List<NotaryName> selectNotary(String notaryOffice) ;
    List<TransactionNotaryOfficeName> selectVPCC() ;
    Optional<List<TransactionPropertyBo>> selectReportByNotary(String notaryOfficeName,String notaryName, String notaryDateFromFilter , String notaryDateToFilter, Integer numOffset, Integer numLimit );
    Optional<BigInteger> countTotalReportByNotary(String notaryOfficeName,String notaryName, String notaryDateFromFilter, String notaryDateToFilter) ;
    List<EntryUserName> selectEntryUserName(String notaryOffice) ;
    Optional<List<TransactionPropertyBo>> selectReportByUser(String notaryOfficeName,String entryUserName, String notaryDateFromFilter , String notaryDateToFilter, Integer numOffset, Integer numLimit );
    Optional<BigInteger> countTotalReportByUser(String notaryOfficeName,String entryUserName, String notaryDateFromFilter, String notaryDateToFilter) ;
    Optional<List<TransactionPropertyBo>> selectContractCertify(String contractKind, String notaryDateFromFilter, String notaryDateToFilter);

    Optional<List<TransactionPropertyBo>> getByContractId(String id) ;
    Optional<Boolean> updateSynchStatus(Long tpid,Long syn_status);

    public TransactionPropertyBo genInfo(TransactionPropertyBo item,TransactionPropertyBo itemResult);
    List<ReportByBank> reportByBank(String stringFilter) ;
    Optional<BigInteger> countTotalReportBank(String bankName) ;

}
