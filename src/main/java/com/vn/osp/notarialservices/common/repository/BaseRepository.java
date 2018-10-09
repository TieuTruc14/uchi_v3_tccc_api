package com.vn.osp.notarialservices.common.repository;

/**
 * Created by longtran on 19/10/2016.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    Optional<T> findById(ID id);
}
