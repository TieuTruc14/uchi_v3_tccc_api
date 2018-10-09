package com.vn.osp.notarialservices.manual.service;

import com.vn.osp.notarialservices.manual.dto.Manual;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 11/18/2016.
 */
public interface ManualService {
    Optional<Manual> findManualById(Long id) ;

    Optional<Boolean> deleteManualById(Long id);

    Optional<List<Manual>> findManualByFilter(String stringFilter) ;

    Optional<BigInteger> countTotalManual() ;

    Optional<Boolean> AddManual(String title, String content, String file_name, String file_path, Long entryUserId, String entryUserName, Long updateUserId, String updateUserName);

    Optional<BigInteger> countTotalByFilter(String stringFilter) ;

    Optional<Boolean> updateManual(Long id, String title, String content, String file_name, String file_path, Long updateUserId, String updateUserName);

    Optional<Boolean> removeFile(String input);



}
