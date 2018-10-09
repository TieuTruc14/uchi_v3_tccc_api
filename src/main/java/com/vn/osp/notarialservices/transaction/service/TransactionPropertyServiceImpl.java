package com.vn.osp.notarialservices.transaction.service;

import com.vn.osp.notarialservices.transaction.domain.TransactionPropertyBo;
import com.vn.osp.notarialservices.transaction.dto.*;
import com.vn.osp.notarialservices.transaction.repository.TransactionPropertyRepository;
import com.vn.osp.notarialservices.utils.EditString;
import com.vn.osp.notarialservices.utils.TimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 11/23/2016.
 */
@Service
public class TransactionPropertyServiceImpl implements TransactionPropertyService {
    private static final Logger LOGGER = Logger.getLogger(TransactionPropertyServiceImpl.class);
    private final TransactionPropertyRepository transactionRepository;
    private final TransactionPropertyConverter transactionConverter;

    @Autowired
    public TransactionPropertyServiceImpl(final TransactionPropertyRepository transactionRepository, final TransactionPropertyConverter transactionConverter) {
        this.transactionRepository = transactionRepository;
        this.transactionConverter = transactionConverter;
    }

    @Override
    public Optional<Boolean> addTransactionProperty(String data) {
        Boolean result = transactionRepository.addTransactionProperty(data).orElse(false);
        return Optional.of(result);
    }

    @Override
    public Optional<Boolean> synchronizeOk(String notaryOfficeCode, Integer contract_kind, String contractNumber) {
        Boolean result = transactionRepository.synchronizeOk(notaryOfficeCode, contract_kind, contractNumber).orElse(false);
        return Optional.of(result);
    }

    @Override
    public Optional<List<TransactionProperty>> findTransactionByFilter(String stringFilter) {
        List<TransactionPropertyBo> listBO = transactionRepository.findTransactionByFilter(stringFilter).orElse(new ArrayList<TransactionPropertyBo>());
        ArrayList<TransactionProperty> list = new ArrayList<TransactionProperty>();
        if (listBO != null && listBO.size() > 0) {
            for (int i = 0; i < listBO.size(); i++) {
                list.add(Optional.ofNullable(listBO.get(i)).map(transactionConverter::convert).orElse(new TransactionProperty()));
            }
        }
        return Optional.of(list);
    }

    @Override
    public Optional<BigInteger> countTotalByFilter(String stringFilter) {
        return transactionRepository.countTotalByFilter(stringFilter);
    }

    @Override
    public Optional<List<TransactionProperty>> findTransactionByBank(String bankname, String notaryDateFromFilter, String notaryDateToFilter, Integer numOffset, Integer numLimit) {
        List<TransactionPropertyBo> listBO = transactionRepository.findTransactionByBank(bankname, notaryDateFromFilter, notaryDateToFilter, numOffset, numLimit).orElse(new ArrayList<TransactionPropertyBo>());
        ArrayList<TransactionProperty> list = new ArrayList<TransactionProperty>();
        if (listBO != null && listBO.size() > 0) {
            for (int i = 0; i < listBO.size(); i++) {
                list.add(Optional.ofNullable(listBO.get(i)).map(transactionConverter::convert).orElse(new TransactionProperty()));
            }
        }
        return Optional.of(list);
    }

    @Override
    public Optional<BigInteger> countTotalContractByBank(String bankName, String notaryDateFromFilter, String notaryDateToFilter) {
        return transactionRepository.countTotalContractByBank(bankName, notaryDateFromFilter, notaryDateToFilter);

    }

    @Override
    public List<NotaryName> selectNotary(String notaryOffice) {
        List<NotaryName> listBO = transactionRepository.selectNotary(notaryOffice);
        ArrayList<NotaryName> list = new ArrayList<NotaryName>();
        if (listBO != null && listBO.size() > 0) {
            for (int i = 0; i < listBO.size(); i++) {
                list.add(Optional.ofNullable(listBO.get(i)).orElse(new NotaryName()));
            }
        }
        return list;
    }

    @Override
    public List<TransactionNotaryOfficeName> selectVPCC() {
        List<TransactionNotaryOfficeName> listBO = transactionRepository.selectVPCC();
        ArrayList<TransactionNotaryOfficeName> list = new ArrayList<TransactionNotaryOfficeName>();
        if (listBO != null && listBO.size() > 0) {
            for (int i = 0; i < listBO.size(); i++) {
                list.add(Optional.ofNullable(listBO.get(i)).orElse(new TransactionNotaryOfficeName()));
            }
        }
        return list;
    }

    @Override
    public Optional<List<TransactionProperty>> selectReportByNotary(String notaryOfficeName, String notaryName, String notaryDateFromFilter, String notaryDateToFilter, Integer numOffset, Integer numLimit) {
        List<TransactionPropertyBo> listBO = transactionRepository.selectReportByNotary(notaryOfficeName, notaryName, notaryDateFromFilter, notaryDateToFilter, numOffset, numLimit).orElse(new ArrayList<TransactionPropertyBo>());
        ArrayList<TransactionProperty> list = new ArrayList<TransactionProperty>();
        if (listBO != null && listBO.size() > 0) {
            for (int i = 0; i < listBO.size(); i++) {
                list.add(Optional.ofNullable(listBO.get(i)).map(transactionConverter::convert).orElse(new TransactionProperty()));
            }
        }
        return Optional.of(list);
    }

    @Override
    public Optional<BigInteger> countTotalReportByNotary(String notaryOfficeName, String notaryName, String notaryDateFromFilter, String notaryDateToFilter) {
        return transactionRepository.countTotalReportByNotary(notaryOfficeName, notaryName, notaryDateFromFilter, notaryDateToFilter);

    }

    @Override
    public List<EntryUserName> selectEntryUserName(String notaryOffice) {
        List<EntryUserName> listBO = transactionRepository.selectEntryUserName(notaryOffice);
        ArrayList<EntryUserName> list = new ArrayList<EntryUserName>();
        if (listBO != null && listBO.size() > 0) {
            for (int i = 0; i < listBO.size(); i++) {
                list.add(Optional.ofNullable(listBO.get(i)).orElse(new EntryUserName()));
            }
        }
        return list;
    }

    @Override
    public Optional<List<TransactionProperty>> selectReportByUser(String notaryOfficeName, String entryUserName, String notaryDateFromFilter, String notaryDateToFilter, Integer numOffset, Integer numLimit) {
        List<TransactionPropertyBo> listBO = transactionRepository.selectReportByUser(notaryOfficeName, entryUserName, notaryDateFromFilter, notaryDateToFilter, numOffset, numLimit).orElse(new ArrayList<TransactionPropertyBo>());
        ArrayList<TransactionProperty> list = new ArrayList<TransactionProperty>();
        if (listBO != null && listBO.size() > 0) {
            for (int i = 0; i < listBO.size(); i++) {
                list.add(Optional.ofNullable(listBO.get(i)).map(transactionConverter::convert).orElse(new TransactionProperty()));
            }
        }
        return Optional.of(list);
    }

    @Override
    public Optional<BigInteger> countTotalReportByUser(String notaryOfficeName, String entryUserName, String notaryDateFromFilter, String notaryDateToFilter) {
        return transactionRepository.countTotalReportByUser(notaryOfficeName, entryUserName, notaryDateFromFilter, notaryDateToFilter);

    }

    @Override
    public Optional<List<TransactionProperty>> selectContractCertify(String contractKind, String notaryDateFromFilter, String notaryDateToFilter) {
        List<TransactionPropertyBo> listBO = transactionRepository.selectContractCertify(contractKind, notaryDateFromFilter, notaryDateToFilter).orElse(new ArrayList<TransactionPropertyBo>());
        ArrayList<TransactionProperty> list = new ArrayList<TransactionProperty>();
        if (listBO != null && listBO.size() > 0) {
            for (int i = 0; i < listBO.size(); i++) {
                list.add(Optional.ofNullable(listBO.get(i)).map(transactionConverter::convert).orElse(new TransactionProperty()));
            }
        }
        return Optional.of(list);
    }

    @Override
    public Optional<TransactionProperty> getByContractId(String id) {
        List<TransactionPropertyBo> listBO = transactionRepository.getByContractId(id).orElse(new ArrayList<TransactionPropertyBo>());
        TransactionProperty trans = new TransactionProperty();
        if (listBO != null && listBO.size() > 0) {
            trans = Optional.ofNullable(listBO.get(0)).map(transactionConverter::convert).orElse(new TransactionProperty());
        }
        return Optional.of(trans);
    }

    @Override
    public Optional<Boolean> updateSynchStatus(Long tpid, Long syn_status) {
        return transactionRepository.updateSynchStatus(tpid, syn_status);
    }

    @Override
    public String getStringFilterFromSearch(String search, String syn_status) {
        StringBuilder stringFilter = new StringBuilder("");

        try {

            JSONObject searchObject = new JSONObject(search);

            if (searchObject.has("basic") && !StringUtils.isBlank(searchObject.get("basic").toString())) {
                String basic = searchObject.get("basic").toString();
                if (EditString.isNumber(basic)) {
                    if (Integer.parseInt(basic) == 0) {//tim kiem co ban
                        if (searchObject.has("search_basic") && !StringUtils.isBlank(searchObject.get("search_basic").toString())) {
                            String search_basic = searchObject.get("search_basic").toString();
                            stringFilter.append("or contract_number like '%" + search_basic + "%' ");
                            stringFilter.append("or relation_object like '%" + search_basic + "%' ");
                            stringFilter.append("or transaction_content like '%" + search_basic + "%' ");
                            stringFilter.append("or property_info like '%" + search_basic + "%' ");
                            stringFilter.append("or contract_name like '%" + search_basic + "%' ");
                            //cat bo or o dau` chuoi neu length>0
                            if (stringFilter.length() > 3) {
                                stringFilter = new StringBuilder(stringFilter.substring(2));
                            }
                        }
                    } else if (Integer.parseInt(basic) == 1) { //tim kiem nang cao

                        if (searchObject.has("contract_kind") && !StringUtils.isBlank(searchObject.get("contract_kind").toString())) {
                            stringFilter.append("and contract_kind=" + searchObject.get("contract_kind") + " ");
                        }
                        if (searchObject.has("contract_template") && !StringUtils.isBlank(searchObject.get("contract_template").toString())) {
                            stringFilter.append("and code_template=" + searchObject.get("contract_template") + " ");
                        }
                        if (searchObject.has("contract_number") && !StringUtils.isBlank(searchObject.get("contract_number").toString())) {
                            stringFilter.append("and contract_number like '%" + searchObject.get("contract_number") + "%' ");
                        }
                        if (searchObject.has("relation_object") && !StringUtils.isBlank(searchObject.get("relation_object").toString())) {
                            stringFilter.append("and relation_object like '%" + searchObject.get("relation_object") + "%' ");
                        }
                        if (searchObject.has("property_info") && !StringUtils.isBlank(searchObject.get("property_info").toString())) {
                            stringFilter.append("and property_info like '%" + searchObject.get("property_info") + "%' ");
                        }
                        if (searchObject.has("time") && !StringUtils.isBlank(searchObject.get("time").toString())) {
                            Date now = new Date();
                            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String result = df.format(now);
                            Date dateStart;
                            Date dateEnd;
                            switch (searchObject.get("time").toString()) {
                                case "1":
                                    dateStart = TimeUtil.convertStringToDateWithPlusSecond(result, 0);
                                    dateEnd = TimeUtil.convertStringToDateWithPlusSecond(result, 86399);
                                    stringFilter.append("and notary_date between '" + dateFormat.format(dateStart) + "' and '" + dateFormat.format(dateEnd) + "' ");
                                    break;
                                case "2":
                                    dateStart = TimeUtil.convertStringToDateWithPlusSecond(TimeUtil.getDateByFirstDayOfWeek(now), 0);
                                    dateEnd = TimeUtil.convertStringToDateWithPlusSecond(TimeUtil.getDateByLastDayOfWeek(now), 86399);
                                    stringFilter.append("and notary_date between '" + dateFormat.format(dateStart) + "' and '" + dateFormat.format(dateEnd) + "' ");
                                    break;
                                case "3":
                                    dateStart = TimeUtil.convertStringToDateWithPlusSecond(TimeUtil.getDateByFirstDayOfMonth(now), 0);
                                    dateEnd = TimeUtil.convertStringToDateWithPlusSecond(TimeUtil.getDateByLastDayOfMonth(now), 86399);
                                    stringFilter.append("and notary_date between '" + dateFormat.format(dateStart) + "' and '" + dateFormat.format(dateEnd) + "' ");
                                    break;
                                case "4":
                                    dateStart = TimeUtil.convertStringToDateWithPlusSecond(TimeUtil.getDateByFirstDayOfYear(now), 0);
                                    dateEnd = TimeUtil.convertStringToDateWithPlusSecond(TimeUtil.getDateByLastDayOfYear(now), 86399);
                                    stringFilter.append("and notary_date between '" + dateFormat.format(dateStart) + "' and '" + dateFormat.format(dateEnd) + "' ");
                                    break;
                                case "5":
                                    if (searchObject.has("fromTime") && !StringUtils.isBlank(searchObject.get("fromTime").toString())) {
                                        dateStart = TimeUtil.convertStringToDateWithPlusSecond(searchObject.get("fromTime").toString(), 0);
                                        if (dateStart != null) {
                                            if (searchObject.has("toTime") &&!StringUtils.isBlank(searchObject.get("toTime").toString())) {
                                                dateEnd = TimeUtil.convertStringToDateWithPlusSecond(searchObject.get("toTime").toString(), 86399);
                                            } else {
//                                                dateEnd = TimeUtil.convertStringToDateWithPlusSecond(searchObject.get("fromTime").toString(), 86399);
                                                dateEnd = new Date();
                                            }
                                            if (dateEnd != null) {
                                                stringFilter.append("and notary_date between '" + dateFormat.format(dateStart) + "' and '" + dateFormat.format(dateEnd) + "' ");
                                            }
                                        }
                                    }else  if (searchObject.has("toTime") && !StringUtils.isBlank(searchObject.get("toTime").toString())) {
                                        dateEnd = TimeUtil.convertStringToDateWithPlusSecond(searchObject.get("toTime").toString(), 86399);
                                        if(dateEnd!=null){
                                            stringFilter.append("and notary_date < '"  + dateFormat.format(dateEnd) + "' ");
                                        }
                                    }
                                    break;
                                default:
                                    break;
                            }

                        }

                        if (stringFilter.length() > 3) {
                            stringFilter = new StringBuilder(stringFilter.substring(3));
                        }
                    }
                }

            }


            if (!StringUtils.isBlank(syn_status)) {
                if (EditString.isNumber(syn_status)) {
                    if (Integer.parseInt(syn_status) == 0) {
                        if (stringFilter.length() > 0) {
                            stringFilter = new StringBuilder("(" + stringFilter + ") and syn_status=0 ");

                        } else stringFilter.append("syn_status=0 ");
                    } else if (Integer.parseInt(syn_status) == 1) {
                        if (stringFilter.length() > 0) {
                            stringFilter = new StringBuilder("(" + stringFilter + ") and syn_status=1 ");
                        } else stringFilter.append("syn_status=1 ");
                    }
                }
            }
        } catch (Exception e) {
            stringFilter = new StringBuilder("");
            LOGGER.error("Have an error in method TransactionPropertyController.countTransBySearch(): " + e.getMessage());
        }

        if (stringFilter.length() > 0) {
            stringFilter = new StringBuilder("where " + stringFilter);
        }

        stringFilter.append("ORDER BY notary_date desc ");

        return stringFilter.toString();
    }
    @Override
    public List<ReportByBank> reportByBank(String stringFilter) {
        List<ReportByBank> listBO = transactionRepository.reportByBank(stringFilter);
        ArrayList<ReportByBank> list = new ArrayList<ReportByBank>();
        if (listBO != null && listBO.size() > 0) {
            for (int i = 0; i < listBO.size(); i++) {
                list.add(Optional.ofNullable(listBO.get(i)).orElse(new ReportByBank()));
            }
        }
        return list;
    }
    @Override
    public Optional<BigInteger> countTotalReportBank(String stringFilter) {
        return transactionRepository.countTotalReportBank(stringFilter);
    }
}
