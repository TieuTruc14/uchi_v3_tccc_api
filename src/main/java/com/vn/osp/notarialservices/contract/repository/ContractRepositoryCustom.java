package com.vn.osp.notarialservices.contract.repository;

import com.vn.osp.notarialservices.contract.domain.ContractBO;
import com.vn.osp.notarialservices.contract.domain.ContractHistoryInfoBO;
import com.vn.osp.notarialservices.contract.domain.ContractKindBO;
import com.vn.osp.notarialservices.contract.domain.ContractTemplateBO;
import com.vn.osp.notarialservices.contract.dto.ReportByNotaryPerson;
import com.vn.osp.notarialservices.contract.dto.ReportByUser;
import com.vn.osp.notarialservices.contract.dto.*;
import com.vn.osp.notarialservices.transaction.domain.TransactionPropertyBo;
import com.vn.osp.notarialservices.transaction.dto.TransactionProperty;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by TienManh on 5/11/2017.
 */
public interface ContractRepositoryCustom {
    Optional<List<ContractBO>> findLatestContract(Long countNumber);
    Optional<List<ContractBO>> getAllContract();
    Optional<Integer> addContractWrapper(String xml_contract, String xml_property);

    Optional<List<ContractKindBO>> selectContractKindByFilter(String stringFilter);
    Optional<BigInteger> countByContractNumber(String contract_number);
    Optional<Long> countContractNumber(String contractNumber);

    Optional<List<ContractTemplateBO>> selectContractTeamplateByFilter(String stringFilter);
    Optional<BigInteger> countHistoryContract(String stringFilter) ;
    List<ContractHistory> selectByFilter(String stringFilter);

    List<ReportByNotaryPerson> getReportByNotary(String stringFilter);

    Optional<BigInteger> countTotalReportByNotary(String stringFilter);

    List<ReportByUser> getReportByUser(String stringFilter);

    Optional<BigInteger> countTotalReportByUser(String stringFilter);

//    Optional<Integer> addContract(String xml_contract,String xml_transaction_property,String xml_contract_history);
//    Optional<Integer> editContract(String xml_contract,String xml_transaction_property,String xml_contract_history);
//    Optional<Integer> cancelContract(String contract_cancel_id,String xml_contract,String xml_transaction_property,String xml_contract_history);
    Optional<Integer> addContract(ContractBO contract, TransactionPropertyBo trans, ContractHistoryInfoBO his);
    Optional<Integer> editContract(ContractBO contract, TransactionPropertyBo trans, ContractHistoryInfoBO his);
    Optional<Integer> cancelContract(long contract_cancel_id , ContractBO contract, TransactionPropertyBo trans, ContractHistoryInfoBO his);

    Boolean deleteContract(String id, String xml_contract_history);

    List<ReportByGroupTotal> selectReportByGroupTotal(ReportByGroupTotalList reportByGroupTotalList, String filter);

    BigInteger numberOfNotaryPerson(ReportByTT20List reportByTT20List);
    BigInteger numberOfContractLand(ReportByTT20List reportByTT20List);
    BigInteger numberOfContractOther(ReportByTT20List reportByTT20List);
    BigInteger numberOfContractDanSu(ReportByTT20List reportByTT20List);
    BigInteger numberOfThuaKe(ReportByTT20List reportByTT20List);
    BigInteger numberOfOther(ReportByTT20List reportByTT20List);
    BigDecimal tongPhiCongChung(ReportByTT20List reportByTT20List);

    BigInteger numberOfNotaryPerson04(ReportByTT04List reportByTT20List);
    Double numThuLaoCongChung(ReportByTT04List reportByTT20List);
    BigInteger numberOfNotaryPersonHopDanh04(ReportByTT04List reportByTT20List);
    BigInteger numberOfContractLand04(ReportByTT04List reportByTT20List);
    BigInteger numberOfContractOther04(ReportByTT04List reportByTT20List);
    BigInteger numberOfContractDanSu04(ReportByTT04List reportByTT20List);
    BigInteger numberOfThuaKe04(ReportByTT04List reportByTT20List);
    BigInteger numberOfOther04(ReportByTT04List reportByTT20List);
    BigDecimal tongPhiCongChung04(ReportByTT04List reportByTT20List);


    List<ContractError> getReportContractError(String stringFilter);

    Optional<ContractBO> getContractById(String id);
    Optional<ContractTemplateBO> getContractTemplateById(String id);
    Optional<ContractTemplateBO> getContractTemplateByCodeTemp(String code_temp);
    Optional<ContractKindBO> getContractKindByContractTempId(String id);
    Optional<ContractKindBO> getContractKindByContractTempCode(int code);

    List<ContractAdditional> getReportContractAdditional(String stringFilter);

    Optional<List<ContractKindBO>> listContractKind();
    Optional<List<ContractTemplateBO>> listContractTemplateByContractKindId(String id);
    Optional<List<ContractTemplateBO>> listContractTemplateByContractKindCode(String code);
    Optional<List<ContractTemplateBO>> listContractTemplateSameKind(int code);
    Optional<List<ContractTemplateBO>> listContractTemplate();
    List<ContractCertify> getReportContractCertify(String stringFilter);

    List<ContractStastics> getContractStasticsDrafter(String notaryDateFromFilter, String notaryDateToFilter);
    List<ContractStastics> getContractStasticsNotary(String notaryDateFromFilter, String notaryDateToFilter);

    List<ContractStasticsBank> getContractStasticsBank(String notaryDateFromFilter, String notaryDateToFilter);

    ContractBO genInfo(ContractBO item, ContractBO itemResult);

}
