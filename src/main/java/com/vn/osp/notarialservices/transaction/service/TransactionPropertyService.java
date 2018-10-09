package com.vn.osp.notarialservices.transaction.service;

import com.vn.osp.notarialservices.transaction.domain.TransactionPropertyBo;
import com.vn.osp.notarialservices.transaction.dto.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 11/23/2016.
 */
public interface TransactionPropertyService {
    Optional<Boolean> addTransactionProperty(String data);
    Optional<Boolean> synchronizeOk(String notaryOfficeCode, Integer contract_kind, String contractNumber);
    Optional<List<TransactionProperty>> findTransactionByFilter(String stringFilter) ;
    public Optional<BigInteger> countTotalByFilter(String stringFilter);
    Optional<List<TransactionProperty>> findTransactionByBank(String bankname,String notaryDateFromFilter, String notaryDateToFilter, Integer numOffset, Integer numLimit);
    Optional<BigInteger> countTotalContractByBank(String bankName, String notaryDateFromFilter, String notaryDateToFilter) ;
    List<NotaryName> selectNotary(String notaryOffice) ;
    List<TransactionNotaryOfficeName> selectVPCC() ;
    Optional<List<TransactionProperty>> selectReportByNotary(String notaryOfficeName,String notaryName,String notaryDateFromFilter, String notaryDateToFilter, Integer numOffset, Integer numLimit);
    Optional<BigInteger> countTotalReportByNotary(String notaryOfficeName,String notaryName, String notaryDateFromFilter, String notaryDateToFilter) ;

    List<EntryUserName> selectEntryUserName(String notaryOffice) ;
    Optional<List<TransactionProperty>> selectReportByUser(String notaryOfficeName,String entryUserName,String notaryDateFromFilter, String notaryDateToFilter, Integer numOffset, Integer numLimit);
    Optional<BigInteger> countTotalReportByUser(String notaryOfficeName,String entryUserName, String notaryDateFromFilter, String notaryDateToFilter) ;
    Optional<List<TransactionProperty>> selectContractCertify(String contractKind, String notaryDateFromFilter, String notaryDateToFilter);

    Optional<TransactionProperty> getByContractId(String id) ;
    Optional<Boolean> updateSynchStatus(Long tpid,Long syn_status);
    String getStringFilterFromSearch(String search,String syn_status);
    List<ReportByBank> reportByBank(String stringFilter) ;
    Optional<BigInteger> countTotalReportBank(String bankName) ;

}
