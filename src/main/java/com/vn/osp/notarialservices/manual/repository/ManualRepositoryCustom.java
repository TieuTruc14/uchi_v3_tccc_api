package com.vn.osp.notarialservices.manual.repository;

import com.vn.osp.notarialservices.manual.domain.ManualBo;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 11/19/2016.
 */
public interface ManualRepositoryCustom {
    /**
 * Method actually triggering a finder but being overridden.
 */
void findByOverridingMethod();

    /***
     *
     * @param id
     */
    void delete(Integer id);

    Optional<ManualBo> findManualByID(Long id);

    Optional<Boolean> deleteManualById(Long id);

    Optional<List<ManualBo>> findManualByFilter(String stringFilter);

    Optional<BigInteger> countTotalManual() ;

    Optional<Boolean> AddManual(String title, String content, String file_name, String file_path, Long entryUserId, String entryUserName, Long updateUserId, String updateUserName);

    Optional<BigInteger> countTotalByFilter(String stringFilter) ;

    Optional<Boolean> updateManual(Long id, String title, String content, String file_name, String file_path, Long updateUserId, String updateUserName);

    Optional<Boolean> removeFile(Long id,String file_name,String file_path);


}
