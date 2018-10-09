package com.vn.osp.notarialservices.user.service;

import com.vn.osp.notarialservices.user.dto.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by longtran on 20/10/2016.
 */
public interface UserService {

    /*
        Optional<User> findByUserNameAndPassword(String username, String password) throws NoSuchUserException;


        Optional<List<User>> updateUpdateManyUsers(String xml_content) throws NoSuchUserException;*/
    Optional<List<User>> getUserByFilter(String stringFiltler);

    Optional<BigInteger> countTotal(String stringFiltler);

    Optional<Integer> addUser(String xml_content);

    Optional<Boolean> updateUser(String xml_content);

    Optional<Boolean> removeUserById(Long id);

    Optional<List<GroupRole>> getGroupRoleByFilter(String stringFiltler);

    Optional<BigInteger> groupRoleCountTotalByFilter(String stringFiltler);

    List<UserGroupRole> getUserGroupRoleByFilter(String stringFiltler);

    Optional<Boolean> permissionUser(UserPermisson userPermisson);

    Optional<Boolean> addGroupRoleAuthority(long grouprole_id, String authority_code, int value);

    Optional<Boolean> addGroupRole(CreateGroupRoleForm createGroupRoleForm);

    Optional<Boolean> updateGroupRole(CreateGroupRoleForm createGroupRoleForm);

    Optional<Boolean> deleteGroupRoleAuthority(Long id);
    Optional<Boolean> deleteGroupRole(Long id);

    Optional<List<Authority>> getAuthorityByFilter(String stringFilter);

    List<GrouproleAuthority> getGroupRoleAuthority(String stringFitler);
    Optional<BigInteger> countUserAuthorityByFilter(String stringFitler);
    List<UserAuthority> getUserAuthorityByFilter(String stringFitler);

    List<UserByRoleList> getUserByRoleList(String stringFilter);
    Optional<List<User>> getByGroupRoleId(String id);
    Optional<User> getUserById(String id);
    Optional<List<User>> getUsersByAuthorityCode(String authority_code);
    Optional<List<GrouproleAuthority>> getGroupRoleAuthorityByUserAndAuthorityCode(String userId, String authority_code);
    Optional<List<User>> selectUsersByAuthorityCodeAndValue(String authority_code,int value);
    Optional<List<Role>> listRole();
    Optional<Role> roleByCode(String code);
    Optional<Boolean> checkExitsGroupRole(CreateGroupRoleForm createGroupRoleForm);
    Optional<Boolean> removeFile(Long id);
}
