package com.vn.osp.notarialservices.user.service;

import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.user.domain.RoleBO;
import com.vn.osp.notarialservices.user.dto.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by TienManh on 7/17/2017.
 */
@Service
public class RoleConverter implements Converter<RoleBO, Role> {
    @Override
    public Role convert(final RoleBO source) {
        return new Role(
                source.getCode(),
                source.getName()
        );
    }

    @Override
    public RoleBO convert(final Role source) {
        RoleBO roleBO = new RoleBO();
        roleBO.setCode(source.getCode());
        roleBO.setName(source.getName());
        return roleBO;
    }

    public List<Role> converts(final List<RoleBO> source) {
        return source.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
