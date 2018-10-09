package com.vn.osp.notarialservices.notaryoffice.service;

import com.vn.osp.notarialservices.notaryoffice.dto.NotaryOffice;
import com.vn.osp.notarialservices.notaryoffice.repository.NotaryOfficeRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by manhtran on 20/10/2016.
 */
@Component
public class NotaryOfficeServiceImpl implements NotaryOfficeService {

    private static final Logger LOGGER = Logger.getLogger(NotaryOfficeServiceImpl.class);

    private final NotaryOfficeRepository notaryOfficeRepository;
    private final NotaryOfficeConverter notaryOfficeConverter;

    @Autowired
    public NotaryOfficeServiceImpl(final NotaryOfficeRepository notaryOfficeRepository, final NotaryOfficeConverter notaryOfficeConverter) {
        this.notaryOfficeRepository = notaryOfficeRepository;
        this.notaryOfficeConverter = notaryOfficeConverter;
    }

    @Override
    public Optional<Boolean> insert(String xml_content) {
        return notaryOfficeRepository.insert(xml_content);
    }

    @Override
    public Optional<Boolean> update(String xml_content) {
        return notaryOfficeRepository.update(xml_content);
    }

    @Override
    public Optional<Boolean> deleteById(Long id) {
        return notaryOfficeRepository.deleteById(id);
    }

    @Override
    public Optional<List<NotaryOffice>> selectByFilter(String stringFilter) {
        List<NotaryOffice> listUser = notaryOfficeRepository.selectByFilter(stringFilter)
                .map(notaryOfficeConverter::converts).orElse(null);
        return Optional.of(listUser);
    }
    @Override
    public Optional<BigInteger> countTotalNotaryOffice(String stringFilter) {
        return notaryOfficeRepository.countTotalNotaryOffice(stringFilter);
    }

}
