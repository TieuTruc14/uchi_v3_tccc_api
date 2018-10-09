package com.vn.osp.notarialservices.contract.repository;

import com.vn.osp.notarialservices.common.repository.BaseRepository;
import com.vn.osp.notarialservices.contract.domain.PropertyBO;

/**
 * Created by TienManh on 5/12/2017.
 */
public interface PropertyRepository extends BaseRepository<PropertyBO, Long>, PropertyRepositoryCustom {
}
