package com.vn.osp.notarialservices.contract.service;

import com.vn.osp.notarialservices.contract.dto.Synchronize;

import java.util.List;
import java.util.Optional;

/**
 * Created by TienManh on 5/12/2017.
 */
public interface SynchronizeService {
    Optional<List<Synchronize>> getAllSynchronize();
}
