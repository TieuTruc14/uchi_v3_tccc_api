package com.vn.osp.notarialservices.notaryoffice.service;

import com.vn.osp.notarialservices.notaryoffice.dto.NotaryOffice;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by manhtran on 20/10/2016.
 */
public interface NotaryOfficeService {

    Optional<Boolean> insert(String xml_content);
    Optional<Boolean> update(String xml_content);
    Optional<Boolean> deleteById(Long id);
    Optional<List<NotaryOffice>> selectByFilter(String stringFilter);
    Optional<BigInteger> countTotalNotaryOffice(String stringFilter);
}
