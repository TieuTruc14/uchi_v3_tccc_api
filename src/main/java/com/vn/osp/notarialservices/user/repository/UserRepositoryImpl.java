/*
 * Copyright 2008-2015 the original author or authors.
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

//import com.vn.osp.notarialservices.user.domain.UserBO;

import com.vn.osp.notarialservices.user.domain.*;
import com.vn.osp.notarialservices.user.dto.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Dummy implementation to allow check for invoking a custom implementation.
 *
 * @author longtran on 27/10/2016
 */
public class UserRepositoryImpl implements UserRepositoryCustom {

    private static final Logger LOG = Logger.getLogger(UserRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserRepositoryImpl(JpaContext context) {
        Assert.notNull(context, "JpaContext must not be null!");
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.jpa.repository.sample.AccessHistoryRepositoryCustom#findByOverrridingMethod()
     */
    public void findByOverridingMethod() {
        LOG.info("A method overriding a finder was invoked!");
    }

    @Override
    public void delete(Integer id) {
        LOG.info("A method overriding a finder was invoked!");
    }

    @Override
    public Optional<List<UserBO>> getUserByFilter(String stringFiller) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_user_select_by_filter");
            storedProcedureQuery.setParameter("stringFilter", stringFiller);
            // execute StoredProcedureQuery
            storedProcedureQuery.execute();
            List<UserBO> list = storedProcedureQuery.getResultList();
            return Optional.of(list);
        } catch (Exception e) {
            LOG.error("Have an error in method  getUserByFilter::"+e.getMessage());
            //e.printStackTrace();
            return Optional.of(new ArrayList<UserBO>());
        }
    }

    @Override
    public Optional<BigInteger> countTotal(String stringFiltler) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_user_count_total_by_filter");
            storedProcedureQuery.setParameter("stringFilter", stringFiltler);
            // execute StoredProcedureQuery
            storedProcedureQuery.execute();
            BigInteger result = (BigInteger) storedProcedureQuery.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            LOG.error("Have an error in method  countTotal::"+e.getMessage());
            //e.printStackTrace();
            return Optional.of(BigInteger.valueOf(0));
        }
    }

    @Override
    public Optional<Integer> addUser(String xml_content) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_user_add");
            storedProcedureQuery.setParameter("xml_content", xml_content);
            storedProcedureQuery.execute();
            Integer id = (Integer) storedProcedureQuery.getSingleResult();
            return Optional.of(id);
        } catch (Exception e) {
            LOG.error("Have an error in method  addUser:"+e.getMessage());
            return Optional.of(-1);

        }
    }

    @Override
    public Optional<Boolean> updateUser(String xml_content) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_user_update");
            storedProcedureQuery.setParameter("xml_content", xml_content);
            storedProcedureQuery.execute();
            return Optional.of(true);
        } catch (Exception e) {
            LOG.error("Have an error in method updateUser:"+e.getMessage());
        }
        return Optional.of(false);
    }

    @Override
    public Optional<Boolean> removeUserById(Long id) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_user_delete_by_id");
            storedProcedureQuery.setParameter("id", id);
            storedProcedureQuery.execute();
            return Optional.of(true);
        } catch (Exception e) {
            LOG.error("Have an error in method removeUserById:"+e.getMessage());
        }
        return Optional.of(false);
    }

    @Override
    public Optional<List<GroupRoleBO>> getGroupRoleByFilter(String stringFiltler) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_grouprole_select_by_filter");
            storedProcedureQuery.setParameter("stringFilter", stringFiltler);
            // execute StoredProcedureQuery
            storedProcedureQuery.execute();
            List<GroupRoleBO> list = storedProcedureQuery.getResultList();
            return Optional.of(list);
        } catch (Exception e) {
            LOG.error("Have an error in method  getGroupRoleByFilter:"+e.getMessage());
            return Optional.of(new ArrayList<GroupRoleBO>());
        }
    }

    @Override
    public Optional<BigInteger> groupRoleCountTotalByFilter(String stringFiltler) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_grouprole_count_total");
            storedProcedureQuery.setParameter("stringFilter", stringFiltler);
            // execute StoredProcedureQuery
            storedProcedureQuery.execute();
            BigInteger result = (BigInteger) storedProcedureQuery.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            LOG.error("Have an error in method  groupRoleCountTotalByFilter:"+e.getMessage());
            return Optional.of(BigInteger.valueOf(0));
        }
    }

    @Override
    public List<UserGroupRole> getUserGroupRoleByFilter(String stringFiltler) {
        try {
            ArrayList<UserGroupRole> userGroupRoles = new ArrayList<UserGroupRole>();
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("stp_npo_user_get_grouprole_by_user");

            storedProcedure.setParameter("stringFilter", stringFiltler);
            storedProcedure.execute();

            List<Object[]> results = storedProcedure.getResultList();

            results.stream().forEach((record) -> {
                UserGroupRole userGroupRole = new UserGroupRole();

                userGroupRole.setUserId(record[0] == null ? null : ((Integer) record[0]).longValue());
                userGroupRole.setGroupid(record[1] == null ? null : ((Integer) record[1]).longValue());
                userGroupRole.setGrouprolename(record[2] == null ? null : ((String) record[2]));

                userGroupRoles.add(userGroupRole);
            });
            return userGroupRoles;
        } catch (Exception e) {
            LOG.error("Have an error in method getUserGroupRoleByFilter:"+e.getMessage());
            return new ArrayList<UserGroupRole>();
        }
    }

    @Override
    public Optional<Boolean> removeUserGroupRole(long userId) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_user_authority_delete");
            storedProcedureQuery.setParameter("userId", userId);
            storedProcedureQuery.execute();
            return Optional.of(true);
        } catch (Exception e) {
            LOG.error("Have an error in method removeUserGroupRole:"+e.getMessage());
        }
        return Optional.of(false);
    }

    @Override
    public Optional<Boolean> addUserGroupRole(long userId, long groupId) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_user_authority_add");
            storedProcedureQuery.setParameter("userId", userId);
            storedProcedureQuery.setParameter("groupId", groupId);
            storedProcedureQuery.execute();
            return Optional.of(true);
        } catch (Exception e) {
            LOG.error("Have an error in method addUserGroupRole:"+e.getMessage());
        }
        return Optional.of(false);
    }

    @Override
    public Optional<Boolean> addGroupRoleAuthority(long grouprole_id, String authority_code, int value) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_grouprole_authority_add");
            storedProcedureQuery.setParameter("grouprole_id", grouprole_id);
            storedProcedureQuery.setParameter("authority_code", authority_code);
            storedProcedureQuery.setParameter("value", value);
            storedProcedureQuery.execute();
            return Optional.of(true);
        } catch (Exception e) {
            LOG.error("Have an error in method addGroupRoleAuthority:"+e.getMessage());
        }
        return Optional.of(false);
    }

    @Override
    public Optional<BigInteger> addGroupRole(GroupRole groupRole) {
        try {
            if(groupRole.getDescription()==null){
                groupRole.setDescription("");
            }
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_grouprole_add");
            storedProcedureQuery.setParameter("grouprolename", groupRole.getGrouprolename());
            storedProcedureQuery.setParameter("description", groupRole.getDescription());
            storedProcedureQuery.setParameter("active_flg", groupRole.getActive_flg());
            storedProcedureQuery.setParameter("entry_user_id", groupRole.getActive_flg());
            storedProcedureQuery.setParameter("entry_user_name", groupRole.getEntry_user_name());

            // execute StoredProcedureQuery
            storedProcedureQuery.execute();
            BigInteger result = (BigInteger) storedProcedureQuery.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            //LOG.error("Có lỗi xảy ra khi thao tác csdl tại hàm countTotal");
           LOG.error("Have an error in method addGroupRole:"+e.getMessage());
            return Optional.of(BigInteger.valueOf(0));
        }
    }

    @Override
    public Optional<Boolean> updateGroupRole(GroupRole groupRole) {
        try {
            if(groupRole.getDescription()==null){
                groupRole.setDescription("");
            }
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_grouprole_update");
            storedProcedureQuery.setParameter("id", groupRole.getGroupRoleId());
            storedProcedureQuery.setParameter("grouprolename", groupRole.getGrouprolename());
            storedProcedureQuery.setParameter("description", groupRole.getDescription());
            storedProcedureQuery.setParameter("active_flg", groupRole.getActive_flg());
            storedProcedureQuery.setParameter("update_user_id", groupRole.getUpdate_user_id());
            storedProcedureQuery.setParameter("update_user_name", groupRole.getUpdate_user_name());
            storedProcedureQuery.execute();
            return Optional.of(true);
        } catch (Exception e) {
            LOG.error("Have an error in method  updateGroupRole:"+e.getMessage());
        }
        return Optional.of(false);
    }

    @Override
    public Optional<List<AuthorityBO>> getAuthorityByFilter(String stringFilter) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_authority_select_by_filter");
            storedProcedureQuery.setParameter("stringFilter", stringFilter);
            storedProcedureQuery.execute();
            List<AuthorityBO> list = storedProcedureQuery.getResultList();
            return Optional.of((List<AuthorityBO>) list);
        } catch (Exception e) {
            LOG.error("Have an error in method  getAuthorityByFilter:"+e.getMessage());
            return Optional.of(new ArrayList<AuthorityBO>());
        }
    }

    @Override
    public List<GrouproleAuthority> getGroupRoleAuthority(String stringFitler) {
        try {
            ArrayList<GrouproleAuthority> grouproleAuthorities = new ArrayList<GrouproleAuthority>();
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("stp_npo_grouprole_authority_select_by_filter");

            storedProcedure.setParameter("stringFilter", stringFitler);
            storedProcedure.execute();

            List<Object[]> results = storedProcedure.getResultList();
            results.stream().forEach((record) -> {
                GrouproleAuthority grouproleAuthority = new GrouproleAuthority();
                grouproleAuthority.setGrouprole_id(record[0] == null ? 0 : ((Integer) record[0]).longValue());
                grouproleAuthority.setAuthority_code(record[1] == null ? null : ((String) record[1]));
                grouproleAuthority.setValue(record[2] == null ? 0 : ((Integer) record[2]).intValue());

                grouproleAuthorities.add(grouproleAuthority);
            });
            return grouproleAuthorities;
        } catch (Exception e) {
            LOG.error("Have an error in method getGroupRoleAuthority:"+e.getMessage());
            return new ArrayList<GrouproleAuthority>();
        }
    }

    @Override
    public Optional<Boolean> updateGroupRoleAuthorityValue(long grouprole_id, String authority_code, int value) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_grouprole_authority_update_value");
            storedProcedureQuery.setParameter("grouprole_id", grouprole_id);
            storedProcedureQuery.setParameter("authority_code", authority_code);
            storedProcedureQuery.setParameter("value", value);
            storedProcedureQuery.execute();
            return Optional.of(true);
        } catch (Exception e) {
            LOG.error("Have an error in method updateGroupROleAuthorityValue:"+e.getMessage());
        }
        return Optional.of(false);
    }

    @Override
    public Optional<Boolean> deleteGroupRoleAuthority(Long id) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_grouprole_authority_delete");
            storedProcedureQuery.setParameter("grouprole_id", id);
            storedProcedureQuery.execute();
            return Optional.of(true);
        } catch (Exception e) {
            LOG.error("Have an error in method deleteGroupRoleAuthority:"+e.getMessage());
        }
        return Optional.of(false);
    }

    @Override
    public Optional<Boolean> deleteGroupRole(Long id) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_grouprole_delete");
            storedProcedureQuery.setParameter("id", id);
            storedProcedureQuery.execute();
            return Optional.of(true);
        } catch (Exception e) {
            LOG.error("Have an error in method deleteGroupRole:"+e.getMessage());
        }
        return Optional.of(false);
    }

    @Override
    public Optional<BigInteger> countUserAuthorityByFilter(String stringFitler) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_user_authority_count_by_filter");
            storedProcedureQuery.setParameter("stringFilter", stringFitler);
            // execute StoredProcedureQuery
            storedProcedureQuery.execute();
            BigInteger result = (BigInteger) storedProcedureQuery.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            LOG.error("Have an error in method  countUserAuthorityByFilter:"+e.getMessage());
            return Optional.of(BigInteger.valueOf(0));
        }
    }

    @Override
    public List<UserAuthority> getUserAuthorityByFilter(String stringFitler) {
        try {
            ArrayList<UserAuthority> userAuthorities = new ArrayList<UserAuthority>();
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("stp_npo_user_get_grouprole_by_user");

            storedProcedure.setParameter("stringFilter", stringFitler);
            storedProcedure.execute();

            List<Object[]> results = storedProcedure.getResultList();

            results.stream().forEach((record) -> {
                UserAuthority userAuthority = new UserAuthority();

                userAuthority.setUser_id(record[0] == null ? null : ((Integer) record[0]).longValue());
                userAuthority.setGroupid(record[1] == null ? null : ((Integer) record[1]).longValue());

                userAuthorities.add(userAuthority);
            });
            return userAuthorities;
        } catch (Exception e) {
            LOG.error("Have an error in method getUserAuthorityByFilter:"+e.getMessage());
            return new ArrayList<UserAuthority>();
        }
    }

    /*@Override
    public Optional<UserBO> findByUserNameAndPassword(String usename, String password) {
        LOG.info("Retrieves users by useName and password. Acts as a dummy method declaration to test finder query creation.");
        StoredProcedureQuery findByUserNameAndPassword = entityManager.createNamedStoredProcedureQuery("findByUserNameAndPassWord");
        StoredProcedureQuery storedProcedure = findByUserNameAndPassword
                                                                    .setParameter("user_name", usename)
                                                                    .setParameter("pass_word", password);
        // execute StoredProcedureQuery
        storedProcedure.execute();
        return Optional.ofNullable((UserBO)storedProcedure.getSingleResult());
    }

    @Override
    public Optional<List<UserBO>> updateUpdateManyUsers(String xml_content) throws NoSuchUserException {
        LOG.info("Update Many Users");
        StoredProcedureQuery storedProcedureQueryUpdateUserAccount = entityManager.createNamedStoredProcedureQuery("updateUserAccount");
        StoredProcedureQuery storedProcedureQuery = storedProcedureQueryUpdateUserAccount.setParameter("xml_content", xml_content);
        // execute StoredProcedureQuery
        storedProcedureQuery.execute();
        List<UserBO> list = new ArrayList<UserBO>();
        return Optional.ofNullable(list);
    }*/
    @Override
    public List<UserByRoleList> getUserByRoleList(String stringFitler) {
        try {
            ArrayList<UserByRoleList> userByRoleLists = new ArrayList<UserByRoleList>();
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_select_user");

            storedProcedure.setParameter("stringFilter", stringFitler);
            storedProcedure.execute();

            List<Object[]> results = storedProcedure.getResultList();

            results.stream().forEach((record) -> {
                UserByRoleList userByRoleList = new UserByRoleList();

                userByRoleList.setId(record[0] == null ? null : ((Integer) record[0]).intValue());
                userByRoleList.setOffice_id(record[1] == null ? null : ((Integer) record[1]).intValue());
                userByRoleList.setFamily_name(record[2] == null ? null : ((String) record[2]));
                userByRoleList.setFirst_name(record[3] == null ? null : ((String) record[3]));
                userByRoleList.setAccount(record[4] == null ? null : ((String) record[4]));
                userByRoleList.setPassword(record[5] == null ? null : ((String) record[5]));
                userByRoleList.setSex(record[6] == null ? null : ((Boolean) record[6]).booleanValue());
                userByRoleList.setActive_flg(record[7] == null ? null : ((Boolean) record[7]).booleanValue());
                userByRoleList.setHidden_flg(record[8] == null ? null : ((Boolean) record[8]).booleanValue());
                userByRoleList.setRole(record[9] == null ? null : ((String) record[9]));
                userByRoleList.setBirthday(record[10] == null ? null : ((String) record[10]));
                userByRoleList.setTelephone(record[11] == null ? null : ((String) record[11]));
                userByRoleList.setMobile(record[12] == null ? null : ((String) record[12]));
                userByRoleList.setEmail(record[13] == null ? null : ((String) record[13]));
                userByRoleList.setAddress(record[14] == null ? null : ((String) record[14]));
                userByRoleList.setLast_login_date(record[15] == null ? null : ((Timestamp) record[15]));
                userByRoleList.setEntry_user_id(record[16] == null ? null : ((Integer) record[16]).intValue());
                userByRoleList.setEntry_user_name(record[17] == null ? null : ((String) record[17]));
                userByRoleList.setEntry_date_time(record[18] == null ? null : ((Timestamp) record[18]));
                userByRoleList.setUpdate_user_id(record[19] == null ? null : ((Integer) record[19]).intValue());
                userByRoleList.setUpdate_user_name(record[20] == null ? null : ((String) record[20]));
                userByRoleList.setUpdate_date_time(record[21] == null ? null : ((Timestamp) record[21]));

                userByRoleLists.add(userByRoleList);
            });
            return userByRoleLists;
        } catch (Exception e) {
           LOG.error("Have an error in method getUserRoleList:"+e.getMessage());
            return new ArrayList<UserByRoleList>();
        }
    }

    @Override
    public Optional<UserBO> getUserById(String id) {
        try{
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_user_select_by_id");
            storedProcedure
                    .setParameter("id",id );
            storedProcedure.execute();
            return Optional.ofNullable((UserBO)storedProcedure.getSingleResult());
        }catch (Exception e){
            LOG.error("Have an error in method  getUserById:"+e.getMessage());
            return Optional.ofNullable(new UserBO());
        }

    }

    @Override
    public Optional<List<UserBO>> getByGroupRoleId(String id) {
        try{
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("vpcc_npo_user_select_by_group_role");
            storedProcedure
                    .setParameter("id",id );
            storedProcedure.execute();
            return Optional.ofNullable((List<UserBO>)storedProcedure.getResultList());
        }catch (Exception e){
            LOG.error("Have an error in method  getByGroupRoleId:"+e.getMessage());
            return  Optional.ofNullable(new ArrayList<>());
        }

    }

    /**
     * author:manhpt
     * get all user has authority code.
     * @param authority_code
     * @return
     */
    @Override
    public Optional<List<UserBO>> getUsersByAuthorityCode(String authority_code) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_user_select_list_by_authority_code");
            storedProcedureQuery.setParameter("authority_code",authority_code );
            // execute StoredProcedureQuery
            storedProcedureQuery.execute();
            return Optional.ofNullable((List<UserBO>)storedProcedureQuery.getResultList());

        } catch (Exception e) {
            LOG.error("Have an error in method   UserRepositoryImpl.getUsersByAuthorityCode: "+e.getMessage());
            return Optional.of(new ArrayList<UserBO>());
        }
    }

    @Override
    public Optional<List<GrouproleAuthorityBO>> getGroupRoleAuthorityByUserAndAuthorityCode(String userId, String authority_code) {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("stp_npo_group_role_authority_get_by_userId_and_authority_code");
            storedProcedureQuery.setParameter("userId",userId);
            storedProcedureQuery.setParameter("authority_code",authority_code );
            // execute StoredProcedureQuery
            storedProcedureQuery.execute();
            return Optional.ofNullable((List<GrouproleAuthorityBO>)storedProcedureQuery.getResultList());

        } catch (Exception e) {
            LOG.error("Have an error in method UserRepositoryImpl.getGroupRoleAuthorityByUserAndAuthorityCode: "+e.getMessage());
            return Optional.of(new ArrayList<GrouproleAuthorityBO>());
        }
    }

    @Override
    public Optional<List<RoleBO>> listRole() {
        try {
            StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("vpcc_npo_role_list");
            storedProcedureQuery.execute();
            return Optional.ofNullable((List<RoleBO>)storedProcedureQuery.getResultList());
        } catch (Exception e) {
            LOG.error("Have an error in method UserRepositoryImpl.listRole: "+e.getMessage());
            return Optional.of(new ArrayList<RoleBO>());
        }
    }

    @Override
    public Optional<RoleBO> roleByCode(String code) {
        try {
        List<RoleBO> adminList = entityManager.createNamedQuery("getRoleByCode", RoleBO.class)
                .setParameter(1, code)
                .getResultList();
            return Optional.of(adminList.get(0));
        } catch (Exception e) {
            LOG.error("Have an error in method UserRepositoryImpl.roleByCode: "+e.getMessage());
            return Optional.of(new RoleBO());
        }
    }

    @Override
    public Optional<Boolean> removeFile(Long id) {
        try {
            StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("removeFileUser");
            storedProcedure
                    .setParameter("id", id);
            storedProcedure.execute();
            return Optional.of(Boolean.valueOf(true));
        } catch (Exception e) {
            LOG.error("Have an error in method  removeFIle:"+e.getMessage());
            return Optional.of(Boolean.valueOf(false));
        }
    }
}
