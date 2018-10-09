package com.vn.osp.notarialservices.contract.service;

import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.contract.domain.SynchronizeBO;
import com.vn.osp.notarialservices.contract.dto.Synchronize;
import org.springframework.stereotype.Service;

/**
 * Created by TienManh on 5/12/2017.
 */
@Service
public class SynchronizeConverter implements Converter<SynchronizeBO, Synchronize> {

    @Override
    public Synchronize convert(SynchronizeBO source){
        Synchronize object=new Synchronize();
        object.setType(source.getType());
        object.setData_id(source.getData_id());
        object.setAuthentication_id(source.getAuthentication_id());
        object.setAction(source.getAction());
        object.setStatus(source.getStatus());
        object.setEntry_date_time(source.getEntry_date_time());

        return object;
    }
    @Override
    public SynchronizeBO convert(Synchronize source){return null;}
}
