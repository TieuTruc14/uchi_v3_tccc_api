package com.vn.osp.notarialservices.contract.service;

import com.vn.osp.notarialservices.contract.dto.*;
import com.vn.osp.notarialservices.transaction.dto.*;
import com.vn.osp.notarialservices.transaction.dto.TransactionProperty;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by TienManh on 5/11/2017.
 */
public interface ContractService {
    Optional<List<Contract>> findLatestContract(Long countNumber) ;
    Optional<List<Contract>> getAllContract();
    Optional<Integer> addContractWrapper(String xml_contract, String xml_property);

    Optional<List<ContractKind>> selectContractKindByFilter(String stringFilter);
    Optional<BigInteger> countByContractNumber(String contract_number);
    Optional<Long> countContractNumber(String contractNumber);

    Optional<List<ContractTemplate>> selectContractTeamplateByFilter(String stringFilter);
    Optional<BigInteger> countHistoryContract(String stringFilter) ;
    List<ContractHistory> selectByFilter(String stringFilter);
    List<ReportByNotaryPerson> getReportByNotary(String stringFilter);

    Optional<BigInteger> countTotalReportByNotary(String stringFilter);

    List<ReportByUser> getReportByUser(String stringFilter);

    Optional<BigInteger> countTotalReportByUser(String stringFilter);

    List<ReportByGroupTotal> selectReportByGroupTotal(ReportByGroupTotalList reportByGroupTotalList);
    List<TransactionProperty> selectDetailReportByGroup(ReportByGroupTotalList reportByGroupTotalList);
    List<TransactionProperty> selectAllDetailReportByGroup(ReportByGroupTotalList reportByGroupTotalList);
    BigInteger countDetailReportByGroup(ReportByGroupTotalList reportByGroupTotalList);

    com.vn.osp.notarialservices.transaction.dto.TransactionProperty genaralInfoToTransactionProperty(Contract contract, com.vn.osp.notarialservices.transaction.dto.TransactionProperty trans);
    ContractHistoryInfor genaralHistoryInfo(Contract contract,ContractHistoryInfor his, String action);
    Optional<Integer> addContract(Contract contract, TransactionProperty trans, ContractHistoryInfor his);
    Optional<Integer> editContract(Contract contract, TransactionProperty trans, ContractHistoryInfor his);
    Optional<Integer> cancelContract(long contract_cancel_id ,Contract contract, TransactionProperty trans, ContractHistoryInfor his);
    //    Optional<Integer> addContract(String xml_contract,String xml_transaction_property,String xml_contract_history);
//    Optional<Integer> editContract(String xml_contract,String xml_transaction_property,String xml_contract_history);
//    Optional<Integer> cancelContract(String contract_cancel_id ,String xml_contract,String xml_transaction_property,String xml_contract_history);

    Boolean deleteContract(String id, String xml_contract_history);

    ReportByTT20List reportByTT20(ReportByTT20List reportByTT20List);

    ReportByTT04List reportByTT04(ReportByTT04List reportByTT04List);


    List<ContractError> getReportContractError(String stringFilter);
    Optional<Contract> getContractById(String id);
    Optional<Contract> genContractForEdit(Contract contractDb,Contract contractEdit);
    Optional<ContractTemplate> getContractTemplateById(String id);
    Optional<ContractTemplate> getContractTemplateByCodeTemp(String code_temp);
    Optional<ContractKind> getContractKindByContractTempId(String id);
    Optional<ContractKind> getContractKindByContractTempCode(int code);
    Optional<List<ContractKind>> listContractKind();

    Optional<List<ContractTemplate>> listContractTemplateByContractKindId(String id);
    Optional<List<ContractTemplate>> listContractTemplateByContractKindCode(String code);
    Optional<List<ContractTemplate>> listContractTemplateSameKind(int id);
    Optional<List<ContractTemplate>> listContractTemplate();
    SynchronizeContractTag genSynchronizeContractTagByTrans(com.vn.osp.notarialservices.transaction.dto.TransactionProperty trans,int action);
    Boolean synchronizeContractTags(List<SynchronizeContractTag> contractTags);




    List<ContractAdditional> getReportContractAdditional(String stringFilter);

    List<ContractCertify> getReportContractCertify(String stringFilter);

    List<ContractStastics> getContractStasticsDrafter(String notaryDateFromFilter, String notaryDateToFilter);

    List<ContractStastics> getContractStasticsNotary(String notaryDateFromFilter, String notaryDateToFilter);
    List<ContractStasticsBank> getContractStasticsBank(String notaryDateFromFilter, String notaryDateToFilter);






}
