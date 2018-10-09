package com.vn.osp.notarialservices.contract.service;

import com.vn.osp.notarialservices.bank.dto.Bank;
import com.vn.osp.notarialservices.bank.service.BankService;
import com.vn.osp.notarialservices.contract.domain.TemporaryContractBO;
import com.vn.osp.notarialservices.contract.dto.*;
import com.vn.osp.notarialservices.contract.repository.TemporaryContractRepository;
import com.vn.osp.notarialservices.transaction.dto.TransactionProperty;
import com.vn.osp.notarialservices.transaction.service.TransactionPropertyConverter;
import com.vn.osp.notarialservices.utils.EditString;
import com.vn.osp.notarialservices.utils.TimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by TienManh on 5/13/2017.
 */
@Component
public class TemporaryContractServiceImpl implements TemporaryContractService {
    private static final Logger LOGGER = Logger.getLogger(SynchronizeServiceImpl.class);
    private TemporaryContractConverter temporaryContractConverter;
    private TemporaryContractRepository temporaryContractRepository;
    private BankService bankService;
    private TransactionPropertyConverter transactionPropertyConverter;
    private ContractHistoryConverter contractHistoryConverter;
    private ContractConverter contractConverter;

    @Autowired
    public TemporaryContractServiceImpl(TemporaryContractConverter temporaryContractConverter, TemporaryContractRepository temporaryContractRepository,BankService bankService,
                                        TransactionPropertyConverter transactionPropertyConverter,ContractHistoryConverter contractHistoryConverter,ContractConverter contractConverter){
        this.temporaryContractConverter = temporaryContractConverter;
        this.temporaryContractRepository = temporaryContractRepository;
        this.bankService=bankService;
        this.transactionPropertyConverter=transactionPropertyConverter;
        this.contractHistoryConverter=contractHistoryConverter;
        this.contractConverter=contractConverter;
    }

    @Override
    public Optional<List<TemporaryContract>> getAllTemporaryContract(){
        List<TemporaryContractBO> listBO= temporaryContractRepository.getAllTemporaryContract().orElse(new ArrayList<>());
        ArrayList<TemporaryContract> lst=new ArrayList<>();
        if(listBO!=null && listBO.size()>0){
            for(int i=0;i<listBO.size();i++)
                lst.add(Optional.ofNullable(listBO.get(i)).map(temporaryContractConverter::convert).orElse(new TemporaryContract()));
        }

        return Optional.of(lst);
    }


    @Override
    public Optional<List<TemporaryContract>> getTemporaryByType(String type){
        List<TemporaryContractBO> listBO= temporaryContractRepository.getTemporaryByType(type).orElse(new ArrayList<>());
        ArrayList<TemporaryContract> lst=new ArrayList<>();
        if(listBO!=null && listBO.size()>0){
            for(int i=0;i<listBO.size();i++)
                lst.add(Optional.ofNullable(listBO.get(i)).map(temporaryContractConverter::convert).orElse(new TemporaryContract()));
        }
        return Optional.of(lst);
    }

    @Override
    public Optional<List<TemporaryContract>> getTemporaryByFilter(String filter){
        List<TemporaryContractBO> listBO= temporaryContractRepository.getTemporaryByFilter(filter).orElse(new ArrayList<>());
        ArrayList<TemporaryContract> lst=new ArrayList<>();
        if(listBO!=null && listBO.size()>0){
            for(int i=0;i<listBO.size();i++)
                lst.add(Optional.ofNullable(listBO.get(i)).map(temporaryContractConverter::convert).orElse(new TemporaryContract()));
        }
        return Optional.of(lst);
    }

    @Override
    public Optional<BigInteger> countTemporaryByType(String type){
        return temporaryContractRepository.countTemporaryByType(type);
    }

    @Override
    public Optional<Integer> addTemporary(TemporaryContract item){
        return temporaryContractRepository.addTemporary(temporaryContractConverter.convert(item));
    }
//    @Override
//    public Optional<Integer> addTemporary(String xml_temporary){
//        return temporaryContractRepository.addTemporary(xml_temporary);
//    }

    @Override
    public Optional<Integer> editTemporary(TemporaryContract item){
        return temporaryContractRepository.editTemporary(temporaryContractConverter.convert(item));
    }

    @Override
    public Optional<TemporaryContract> getTemporaryById(String id){
        return Optional.ofNullable(temporaryContractRepository.getTemporaryById(id).map(temporaryContractConverter::convert).orElse(new TemporaryContract())) ;
    }

//    @Override
//    public Optional<Integer> addTemporaryMark(String tcid, String xml_contract,String xml_transaction_property,String xml_contract_history){
//        return temporaryContractRepository.addTemporaryMark(tcid,xml_contract,xml_transaction_property,xml_contract_history);
//    }

    @Override
    public Optional<Long> addTemporaryMark(Long tcid, Contract contract, TransactionProperty tran, ContractHistoryInfor his) {
        return temporaryContractRepository.addTemporaryMark(tcid, contractConverter.convert(contract), transactionPropertyConverter.convert(tran), contractHistoryConverter.convert(his));
    }


    @Override
    public Contract genContractFromTemporary(TemporaryContract tem){
        Contract con=new Contract();
        con.setContract_template_id(tem.getContract_template_id());
        con.setContract_number(tem.getContract_number());
        con.setContract_value(tem.getContract_value());
        con.setRelation_object_a(tem.getRelation_object_a());
        con.setRelation_object_b(tem.getRelation_object_b());
        if(tem.getNotary_id()!=null && tem.getNotary_id()!=0){
            con.setNotary_id(tem.getNotary_id());
        }
        if(tem.getDrafter_id()!=null && tem.getDrafter_id()!=0){
            con.setDrafter_id(tem.getDrafter_id());
        }
        con.setReceived_date(tem.getReceived_date());
        con.setNotary_date(tem.getNotary_date());
        con.setNumber_copy_of_contract(tem.getNumber_copy_of_contract());
        con.setNumber_of_page(tem.getNumber_of_page());
        con.setCost_tt91(tem.getCost_tt91());
        con.setCost_draft(tem.getCost_draft());
        con.setCost_notary_outsite(tem.getCost_notary_outsite());
        con.setCost_other_determine(tem.getCost_other_determine());
        con.setCost_total(tem.getCost_total());
        con.setNotary_place_flag(tem.getNotary_place_flag());
        con.setNotary_place(tem.getNotary_place());
        con.setBank_service_fee(tem.getBank_service_fee());
        con.setCrediter_name(tem.getCrediter_name());
        con.setFile_name(tem.getFile_name());
        con.setFile_path(tem.getFile_path());
        con.setOriginal_store_place(tem.getOriginal_store_place());
        con.setNote(tem.getNote());
        con.setSummary(tem.getSummary());
        if(tem.getEntry_user_id()!=null && tem.getEntry_user_id()!=0){
            con.setEntry_user_id(tem.getEntry_user_id());
        }
        con.setEntry_user_name(tem.getEntry_user_name());
        if(tem.getEntry_date_time()!=null ){
            con.setEntry_date_time(tem.getEntry_date_time());
        }
        if(tem.getUpdate_user_id()!=null && tem.getUpdate_user_id()!=0){
            con.setUpdate_user_id(tem.getUpdate_user_id());
        }
        con.setUpdate_user_name(tem.getUpdate_user_name());
        if(tem.getUpdate_date_time()!=null){
            con.setUpdate_date_time(tem.getUpdate_date_time());
        }
        if(tem.getBank_code()!=null && !tem.equals("")){
            Bank bank=bankService.getByCode(tem.getBank_code()).orElse(null);
            if(bank!=null) con.setBank_name(bank.getName());
        }
        con.setJsonstring(tem.getJsonstring());
        con.setKindhtml(tem.getKindhtml());
        con.setBank_code(tem.getBank_code());
        con.setJson_person(tem.getJson_person());
        con.setJson_property(tem.getJson_property());

        //set default
        con.setError_status(Long.valueOf(0));
        con.setAddition_status(Long.valueOf(0));
        con.setCancel_status(Long.valueOf(0));
        con.setMortage_cancel_flag(Long.valueOf(0));


        return con;
    }
    @Override
    public Boolean deleteTemporary(Long id){
        return temporaryContractRepository.deleteTemporary(id);
    }

    @Override
    public Boolean updateContractNumberValue() {
        return temporaryContractRepository.updateContractNumberValue();
    }

    @Override
    public Optional<Integer> getContractNumberValue() {
        return temporaryContractRepository.getContractNumberValue();
    }

    @Override
    public Optional<Integer> getContractNumber(String key) {
        return  temporaryContractRepository.getContractNumber(key);
    }

    @Override
    public String getStringFilterFromSearch(String search, String type) {
        StringBuilder stringFilter=new StringBuilder("");

        try{

            JSONObject searchObject=new JSONObject(search);


            if(searchObject.has("basic") && !StringUtils.isBlank(searchObject.get("basic").toString())){
                String basic=searchObject.get("basic").toString();
                if(EditString.isNumber(basic)){
                    if(Integer.parseInt(basic)==0){//tim kiem co ban
                        if(searchObject.has("search_basic") && !StringUtils.isBlank(searchObject.get("search_basic").toString())){
                            String search_basic=searchObject.get("search_basic").toString();
                            stringFilter.append("or contract_number like '%"+search_basic+"%' ");
                            stringFilter.append("or relation_object_A like '%"+search_basic+"%' ");
                            stringFilter.append("or summary like '%"+search_basic+"%' ");
                            stringFilter.append("or relation_object_B like '%"+search_basic+"%' ");
                            //cat bo or o dau` chuoi neu length>0
                            if(stringFilter.length()>3){
                                stringFilter=new StringBuilder(stringFilter.substring(2));
                            }
                        }
                    }else if(Integer.parseInt(basic)==1){ //tim kiem nang cao


                        if(searchObject.has("contract_number") && !StringUtils.isBlank(searchObject.get("contract_number").toString())){
                            stringFilter.append("and contract_number like '%"+searchObject.get("contract_number")+"%' ");
                        }
                        if(searchObject.has("relation_object") && !StringUtils.isBlank(searchObject.get("relation_object").toString())){
                            stringFilter.append("and relation_object_A like '%"+searchObject.get("relation_object")+"%' ");
                        }
                        if(searchObject.has("property_info") && !StringUtils.isBlank(searchObject.get("property_info").toString())){
                            stringFilter.append("and relation_object_B like '%"+searchObject.get("property_info")+"%' ");
                        }
                        if(searchObject.has("time") && !StringUtils.isBlank(searchObject.get("time").toString())){
                            Date now=new Date();
                            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String result=df.format(now);
                            Date dateStart;
                            Date dateEnd;
                            switch (searchObject.get("time").toString()){
                                case "1":
                                    dateStart= TimeUtil.convertStringToDateWithPlusSecond(result,0);
                                    dateEnd=TimeUtil.convertStringToDateWithPlusSecond(result,86399);
                                    stringFilter.append("and notary_date between '"+dateFormat.format(dateStart)+"' and '"+dateFormat.format(dateEnd)+"' ");
                                    break;
                                case "2":
                                    dateStart=TimeUtil.convertStringToDateWithPlusSecond(TimeUtil.getDateByFirstDayOfWeek(now),0);
                                    dateEnd=TimeUtil.convertStringToDateWithPlusSecond(TimeUtil.getDateByLastDayOfWeek(now),86399);
                                    stringFilter.append("and notary_date between '"+dateFormat.format(dateStart)+"' and '"+dateFormat.format(dateEnd)+"' ");
                                    break;
                                case "3":
                                    dateStart=TimeUtil.convertStringToDateWithPlusSecond(TimeUtil.getDateByFirstDayOfMonth(now),0);
                                    dateEnd=TimeUtil.convertStringToDateWithPlusSecond(TimeUtil.getDateByLastDayOfMonth(now),86399);
                                    stringFilter.append("and notary_date between '"+dateFormat.format(dateStart)+"' and '"+dateFormat.format(dateEnd)+"' ");
                                    break;
                                case "4":
                                    dateStart=TimeUtil.convertStringToDateWithPlusSecond(TimeUtil.getDateByFirstDayOfYear(now),0);
                                    dateEnd=TimeUtil.convertStringToDateWithPlusSecond(TimeUtil.getDateByLastDayOfYear(now),86399);
                                    stringFilter.append("and notary_date between '"+dateFormat.format(dateStart)+"' and '"+dateFormat.format(dateEnd)+"' ");
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

                        if(stringFilter.length()>3){
                            stringFilter=new StringBuilder(stringFilter.substring(3));
                        }
                    }
                }

            }


            if(!StringUtils.isBlank(type)){
                if(EditString.isNumber(type)){
                    switch (Integer.parseInt(type)){
                        case 0:
                            if(stringFilter.length()>0){
                                stringFilter=new StringBuilder("("+stringFilter+") and type=0 ");

                            }else stringFilter.append("type=0 ");
                            break;
                        case 1:
                            if(stringFilter.length()>0){
                                stringFilter=new StringBuilder("("+stringFilter+") and type=1 ");

                            }else stringFilter.append("type=1 ");
                            break;
                        case 2:
                            if(stringFilter.length()>0){
                                stringFilter=new StringBuilder("("+stringFilter+") and type=2 ");

                            }else stringFilter.append("type=2 ");
                            break;
                        case 3:
                            if(stringFilter.length()>0){
                                stringFilter=new StringBuilder("("+stringFilter+") and type=3 ");

                            }else stringFilter.append("type=3 ");
                            break;
                        default: break;

                    }

                }
            }




        }catch (Exception e){
            stringFilter=new StringBuilder("");
           LOGGER.error("Loi xay ra tai method: TransactionPropertyController.countTransBySearch(): "+e.getMessage());
        }

        if(stringFilter.length()>0){
            stringFilter=new StringBuilder("where "+stringFilter);
        }

        stringFilter.append("ORDER BY notary_date desc ");

        return stringFilter.toString();
    }

    @Override
    public Optional<BigInteger> countTemporaryByFilter(String filter) {
        return temporaryContractRepository.countTemporaryByFilter(filter);
    }
}
