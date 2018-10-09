package com.vn.osp.notarialservices.contract.repository;

import com.vn.osp.notarialservices.contract.domain.ContractKindBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

/**
 * Created by Admin on 5/4/2018.
 */
public interface KindRepository extends JpaRepository<ContractKindBO,Long> {

}
