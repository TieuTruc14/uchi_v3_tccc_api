package com.vn.osp.notarialservices.user.service;

import com.vn.osp.notarialservices.common.converter.Converter;
import com.vn.osp.notarialservices.user.domain.GrouproleAuthorityBO;
import com.vn.osp.notarialservices.user.dto.GrouproleAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by TienManh on 7/6/2017.
 */
@Service
public class GroupRoleAuthorityConvert implements Converter<GrouproleAuthorityBO, GrouproleAuthority> {
    @Override
    public GrouproleAuthority convert(final GrouproleAuthorityBO source) {
        return new GrouproleAuthority(
                source.getGrouprole_id(),
                source.getAuthority_code(),
                source.getValue()
        );
    }

    @Override
    public GrouproleAuthorityBO convert(GrouproleAuthority source) {
        GrouproleAuthorityBO item=new GrouproleAuthorityBO();
        item.setGrouprole_id(source.getGrouprole_id());
        item.setAuthority_code(source.getAuthority_code());
        item.setValue(source.getValue());
        return item;
    }

    public List<GrouproleAuthority> converts(final List<GrouproleAuthorityBO> source) {
        return source.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
