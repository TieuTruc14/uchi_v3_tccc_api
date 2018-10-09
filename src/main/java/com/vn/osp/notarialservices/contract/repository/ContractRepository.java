package com.vn.osp.notarialservices.contract.repository;

import com.vn.osp.notarialservices.common.repository.BaseRepository;
import com.vn.osp.notarialservices.contract.domain.ContractBO;

/**
 * Created by TienManh on 5/11/2017.
 */
public interface ContractRepository extends BaseRepository<ContractBO, Long>, ContractRepositoryCustom {

}
