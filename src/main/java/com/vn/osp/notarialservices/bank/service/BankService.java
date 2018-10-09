package com.vn.osp.notarialservices.bank.service;

import com.vn.osp.notarialservices.bank.dto.Bank;
import com.vn.osp.notarialservices.bank.dto.CreateBankForm;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 2/24/2017.
 */
public interface BankService {
    Optional<List<Bank>> selectBank(String stringFilter) ;
    Optional<List<Bank>> getAllBank();
    Optional<BigInteger> countBank(String stringFiltler) ;
    Optional<Boolean> addBank(String name, Long entryUserId, String entryUserName, String code, Long active);
    Optional<Boolean> updateBank(CreateBankForm createBankForm);
    Optional<Bank> getById(String id);
    Optional<Bank> getByCode(String code);
}
