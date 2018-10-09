package com.vn.osp.notarialservices.contract.service;

import com.vn.osp.notarialservices.contract.domain.SynchronizeBO;
import com.vn.osp.notarialservices.contract.dto.Synchronize;
import com.vn.osp.notarialservices.contract.repository.SynchronizeRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Created by TienManh on 5/12/2017.
 */
@Component
public class SynchronizeServiceImpl implements SynchronizeService {
    private static final Logger LOGGER = Logger.getLogger(SynchronizeServiceImpl.class);
    private SynchronizeConverter synchronizeConverter;
    private SynchronizeRepository synchronizeRepository;

    @Autowired
    public SynchronizeServiceImpl(SynchronizeConverter synchronizeConverter,SynchronizeRepository synchronizeRepository){
        this.synchronizeConverter=synchronizeConverter;
        this.synchronizeRepository=synchronizeRepository;
    }

    @Override
    public Optional<List<Synchronize>> getAllSynchronize(){
        List<SynchronizeBO> listBO= synchronizeRepository.getAllSynchronize().orElse(new ArrayList<>());
        ArrayList<Synchronize> lst=new ArrayList<>();
        if(listBO!=null && listBO.size()>0){
            for(int i=0;i<listBO.size();i++)
                lst.add(Optional.ofNullable(listBO.get(i)).map(synchronizeConverter::convert).orElse(new Synchronize()));
        }

        return Optional.of(lst);
    }
}
