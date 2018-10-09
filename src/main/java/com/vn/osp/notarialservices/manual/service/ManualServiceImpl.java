package com.vn.osp.notarialservices.manual.service;

import com.vn.osp.notarialservices.manual.domain.ManualBo;
import com.vn.osp.notarialservices.manual.dto.Manual;
import com.vn.osp.notarialservices.manual.repository.ManualRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 11/18/2016.
 */
@Component
public class ManualServiceImpl implements ManualService {
    private static final Logger LOGGER = Logger.getLogger(ManualServiceImpl.class);
    private final ManualRepository manualRepository;
    private final ManualConverter manualConverter;

    @Autowired
    public ManualServiceImpl(final ManualRepository manualRepository, final ManualConverter manualConverter) {
        this.manualRepository = manualRepository;
        this.manualConverter = manualConverter;
    }

    @Override
    public Optional<Manual> findManualById(Long id) {

        return manualRepository.findManualByID(id).map(manualConverter::convert);
    }

    @Override
    public Optional<Boolean> deleteManualById(Long id) {
        return manualRepository.deleteManualById(id);
    }

    @Override
    public Optional<List<Manual>> findManualByFilter(String stringFilter) {
        List<ManualBo> listBO = manualRepository.findManualByFilter(stringFilter).orElse(new ArrayList<ManualBo>());
        ArrayList<Manual> list = new ArrayList<Manual>();
        if (listBO != null && listBO.size() > 0) {
            for (int i = 0; i < listBO.size(); i++) {
                list.add(Optional.ofNullable(listBO.get(i)).map(manualConverter::convert).orElse(new Manual()));
            }
        }
        return Optional.of(list);
    }

    @Override
    public Optional<BigInteger> countTotalManual() {
        return manualRepository.countTotalManual();

    }

    @Override
    public Optional<Boolean> AddManual( String title, String content,String file_name ,String file_path , Long entryUserId, String entryUserName, Long updateUserId, String updateUserName)
    {
        return manualRepository.AddManual(title,content,file_name,file_path,entryUserId,entryUserName,updateUserId,updateUserName);

    }
    @Override
    public Optional<BigInteger> countTotalByFilter(String stringFilter) {
        return manualRepository.countTotalByFilter(stringFilter);

    }

    @Override
    public Optional<Boolean> updateManual(Long id, String title, String content, String file_name, String file_path, Long updateUserId, String updateUserName) {
        return manualRepository.updateManual(id, title, content, file_name, file_path, updateUserId, updateUserName);
    }
    public Optional<Boolean> removeFile(String input) {
        long id = Long.valueOf(input.split(";")[0]);
        String file_name = input.split(";")[1];
        String file_path = input.split(";")[2];
        return manualRepository.removeFile(id,file_name,file_path);
    }


}

