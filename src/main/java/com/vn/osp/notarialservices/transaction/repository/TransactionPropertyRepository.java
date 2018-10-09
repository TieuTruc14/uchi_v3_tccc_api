package com.vn.osp.notarialservices.transaction.repository;

import com.vn.osp.notarialservices.common.repository.BaseRepository;
import com.vn.osp.notarialservices.transaction.domain.TransactionPropertyBo;

/**
 * Created by minh on 11/24/2016.
 */
public interface TransactionPropertyRepository extends BaseRepository<TransactionPropertyBo, Long>, TransactionPropertyRepositoryCustom {
}
