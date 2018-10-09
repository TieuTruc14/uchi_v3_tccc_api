package com.vn.osp.notarialservices.systemmanager.service;


import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.systemmanager.domain.AccessHistoryBO;
import com.vn.osp.notarialservices.systemmanager.domain.SystemConfigBO;
import com.vn.osp.notarialservices.systemmanager.dto.AccessHistory;
import com.vn.osp.notarialservices.systemmanager.dto.SystemConfig;
import org.springframework.stereotype.Service;

/**
 * Created by manhtran on 02/11/2016.
 */

@Service
public class SystemConfigConverter implements Converter<SystemConfigBO, SystemConfig> {

    @Override
    public SystemConfig convert(final SystemConfigBO source) {
        return new SystemConfig(
                source.getId(),
                source.getConfig_key(),
                source.getConfig_value());
    }

    @Override
    public SystemConfigBO convert(final SystemConfig source) {
        SystemConfigBO systemConfigBO= new SystemConfigBO();
        systemConfigBO.setId(source.getSystemConfigId());
        systemConfigBO.setConfig_key(source.getConfig_key());
        systemConfigBO.setConfig_value(source.getConfig_value());
        return systemConfigBO;
    }

}