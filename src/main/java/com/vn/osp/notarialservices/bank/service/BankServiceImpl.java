package com.vn.osp.notarialservices.bank.service;

import com.vn.osp.notarialservices.bank.domain.BankBo;
import com.vn.osp.notarialservices.bank.dto.Bank;
import com.vn.osp.notarialservices.bank.dto.CreateBankForm;
import com.vn.osp.notarialservices.bank.repository.BankRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 2/22/2017.
 */
@Component
public class BankServiceImpl implements BankService {
    private static final Logger LOGGER = Logger.getLogger(BankServiceImpl.class);
    private final BankRepository bankRepository;
    private final BankConverter bankConverter;

    @Autowired
    public BankServiceImpl(final BankRepository bankRepository, final BankConverter bankConverter) {
        this.bankRepository = bankRepository;
        this.bankConverter = bankConverter;
    }

    @Override
    public Optional<List<Bank>> selectBank(String stringFilter) {
        List<BankBo> listBO = bankRepository.selectBank(stringFilter).orElse(new ArrayList<BankBo>());
        ArrayList<Bank> list = new ArrayList<Bank>();
        if(listBO != null && listBO.size() >0) {
            for(int i=0; i<listBO.size(); i++){
                list.add(Optional.ofNullable(listBO.get(i)).map(bankConverter::convert).orElse(new Bank()));

            }
        }
        return Optional.of(list);
    }

    @Override
    public Optional<List<Bank>> getAllBank() {
        List<BankBo> listBO = bankRepository.getAllBank().orElse(new ArrayList<BankBo>());
        ArrayList<Bank> list = new ArrayList<Bank>();
        if(listBO != null && listBO.size() >0) {
            for(int i=0; i<listBO.size(); i++){
                list.add(Optional.ofNullable(listBO.get(i)).map(bankConverter::convert).orElse(new Bank()));
            }
        }
        return Optional.of(list);
    }

    @Override
    public Optional<BigInteger> countBank(String stringFiltler) {

        return Optional.of(bankRepository.countBank(stringFiltler).orElse(BigInteger.valueOf(0)));
    }

    @Override
    public Optional<Boolean> addBank(String name, Long entryUserId, String entryUserName, String code, Long active)
    {
        return bankRepository.addBank(name, entryUserId,entryUserName,code, active);

    }

    @Override
    public Optional<Boolean> updateBank(CreateBankForm createBankForm) {
        try {

            //insert du lieu vao bang npo_groprole
            Bank bank = new Bank();
            bank.setSid(createBankForm.getId());
            bank.setName(createBankForm.getName());
            bank.setOrder_number(createBankForm.getOrder_number());
            bank.setCode(createBankForm.getCode());
            bank.setActive(createBankForm.getActive());
            bank.setEntry_user_id(createBankForm.getEntry_user_id());
            bank.setEntry_user_name(createBankForm.getEntry_user_name());
            bank.setEntry_date_time(new Timestamp(System.currentTimeMillis()));
            bank.setUpdate_user_id(createBankForm.getUpdate_user_id());
            bank.setUpdate_user_name(createBankForm.getUpdate_user_name());
            bank.setUpdate_date_time(new Timestamp(System.currentTimeMillis()));
            bankRepository.updateBank(bank);
            return Optional.of(true);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.of(false);
        }
    }

    @Override
    public Optional<Bank> getById(String id){
        Bank bank=bankRepository.getById(id).map(bankConverter::convert).orElse(null);
        return Optional.of(bank);
    }

    @Override
    public Optional<Bank> getByCode(String code){
        Bank bank=bankRepository.getByCode(code).map(bankConverter::convert).orElse(null);
        return Optional.of(bank);
    }

}

