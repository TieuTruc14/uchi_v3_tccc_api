package com.vn.osp.notarialservices.contract.repository;

import com.vn.osp.notarialservices.contract.domain.SynchronizeBO;

import java.util.List;
import java.util.Optional;

/**
 * Created by TienManh on 5/12/2017.
 */
public interface SynchronizeRepositoryCustom {
    Optional<List<SynchronizeBO>> getAllSynchronize();
}
