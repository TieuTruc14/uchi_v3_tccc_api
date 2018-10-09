/*
 * Copyright 2008-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vn.osp.notarialservices.user.repository;

import com.vn.osp.notarialservices.user.domain.*;
import com.vn.osp.notarialservices.user.dto.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Simple interface for custom methods on the repository for {@code ContractHistoryInfor}s.
 *
 * @author longtran on 27/10/2016.
 */
public interface UserRepositoryCustom {

    /**
     * Method actually triggering a finder but being overridden.
     */
    void findByOverridingMethod();

    /***
     *
     * @param id
     */
    void delete(Integer id);

    Optional<List<UserBO>> getUserByFilter(String stringFiltler);

    Optional<BigInteger> countTotal(String stringFiltler);

    Optional<Integer> addUser(String xml_content);

    Optional<Boolean> updateUser(String xml_content);

    Optional<Boolean> removeUserById(Long id);

    Optional<List<GroupRoleBO>> getGroupRoleByFilter(String stringFiltler);
    Optional<BigInteger> groupRoleCountTotalByFilter(String stringFiltler);

    List<UserGroupRole> getUserGroupRoleByFilter(String stringFiltler);

    Optional<Boolean> removeUserGroupRole(long userId);

    Optional<Boolean> addUserGroupRole(long userId, long groupId);

    Optional<Boolean> addGroupRoleAuthority(long grouprole_id, String authority_code, int value);

    Optional<BigInteger> addGroupRole(GroupRole GroupRole);

    Optional<Boolean> updateGroupRole(GroupRole GroupRole);

    Optional<List<AuthorityBO>> getAuthorityByFilter(String stringFilter);

    List<GrouproleAuthority> getGroupRoleAuthority(String stringFitler);

    Optional<Boolean> updateGroupRoleAuthorityValue(long grouprole_id, String authority_code, int value);

    Optional<Boolean> deleteGroupRoleAuthority(Long id);
    Optional<Boolean> deleteGroupRole(Long id);

    Optional<BigInteger> countUserAuthorityByFilter(String stringFitler);
    List<UserAuthority> getUserAuthorityByFilter(String stringFitler);

    List<UserByRoleList> getUserByRoleList(String stringFilter);
    Optional<List<UserBO>> getByGroupRoleId(String id);

    Optional<UserBO> getUserById(String id);
    Optional<List<UserBO>> getUsersByAuthorityCode(String authority_code);
    Optional<List<GrouproleAuthorityBO>> getGroupRoleAuthorityByUserAndAuthorityCode(String userId, String authority_code);
    Optional<List<RoleBO>> listRole();
    Optional<RoleBO> roleByCode(String code);
    Optional<Boolean> removeFile(Long id);

}
