package com.vn.osp.notarialservices.bank.repository;

import com.vn.osp.notarialservices.bank.domain.BankBo;
import com.vn.osp.notarialservices.common.repository.BaseRepository;

/**
 * Created by minh on 2/24/2017.
 */
public interface BankRepository extends BaseRepository<BankBo, Long>, BankRepositoryCustom {
}
