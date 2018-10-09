package com.vn.osp.notarialservices.bank.repository;

import com.vn.osp.notarialservices.bank.domain.BankBo;
import com.vn.osp.notarialservices.bank.dto.Bank;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 2/24/2017.
 */
public interface BankRepositoryCustom {
    /**
     * Method actually triggering a finder but being overridden.
     */
    void findByOverridingMethod();

    /***
     *
     * @param id
     */
    void delete(Integer id);

    Optional<List<BankBo>> selectBank(String stringFilter);

    Optional<List<BankBo>> getAllBank();

    Optional<BigInteger> countBank(String stringFiltler);

    Optional<Boolean> addBank(String name , Long entryUserId, String entryUserName, String code, Long active);

    Optional<Boolean> updateBank(Bank bank);

    Optional<BankBo> getById(String id);
    Optional<BankBo> getByCode(String code);
}
