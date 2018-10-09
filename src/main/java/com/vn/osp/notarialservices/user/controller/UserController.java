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
package com.vn.osp.notarialservices.user.controller;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.vn.osp.notarialservices.user.domain.UserBO;
import com.vn.osp.notarialservices.user.dto.*;
import com.vn.osp.notarialservices.user.service.UserService;
import com.vn.osp.notarialservices.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by longtran on 20/10/2016.
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    private final UserService userService;
    private final UserControllerHateoasBuilder userControllerHateoasBuilder;


    @Autowired
    public UserController(final UserService userService, final UserControllerHateoasBuilder userControllerHateoasBuilder) {
        this.userService = userService;
        this.userControllerHateoasBuilder = userControllerHateoasBuilder;
    }

    @RequestMapping(value = "/countTotal", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> counTotal(@RequestBody final String stringFilter) {
        BigInteger result = userService.countTotal(stringFilter).orElse(BigInteger.valueOf(0));
        return new ResponseEntity<BigInteger>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/selectByFilter", method = RequestMethod.POST)
    public ResponseEntity<List<User>> logout(@RequestBody final String stringFilter) {
        List<User> users = userService.getUserByFilter(stringFilter).orElse(new ArrayList<User>());
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public ResponseEntity<Integer> addUser(@RequestBody @Valid final User user) {
        XmlFriendlyReplacer replacer = new XmlFriendlyReplacer("ddd", "_");
        XStream xXStream = new XStream(new DomDriver("UTF-8", replacer));
//        XmlFriendlyNameCoder nameCoder = new XmlFriendlyNameCoder("ddd", "_");
//        XStream xmlStream = new XStream(new Dom4JDriver(nameCoder));
//        XStream xXStream = new XStream(new DomDriver("UTF_8", new NoNameCoder()));
        xXStream.autodetectAnnotations(true);
        // OBJECT --> XML
        String xml_content = xXStream.toXML(user);
        Integer id = userService.addUser(xml_content).orElse(null);
        return new ResponseEntity<Integer>(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/update-user", method = RequestMethod.POST)
    public ResponseEntity<Boolean> updateUser(@RequestBody @Valid final User user) {
        XmlFriendlyReplacer replacer = new XmlFriendlyReplacer("ddd", "_");
        XStream xXStream = new XStream(new DomDriver("UTF-8", replacer));
        xXStream.autodetectAnnotations(true);
        String xml_content = xXStream.toXML(user);
        Boolean result = userService.updateUser(xml_content).orElse(false);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove-user", method = RequestMethod.POST)
    public ResponseEntity<Boolean> updateUser(@RequestBody @Valid final Long id) {
        Boolean result = userService.removeUserById(id).orElse(false);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/select-group-role", method = RequestMethod.POST)
    public ResponseEntity<List<GroupRole>> selectGroupRoleByFilter(@RequestBody @Valid final String stringFilter) {
        List<GroupRole> groupRoles = userService.getGroupRoleByFilter(stringFilter).orElse(null);
        return new ResponseEntity<List<GroupRole>>(groupRoles, HttpStatus.OK);
    }

    @RequestMapping(value = "/count-total-group-role", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> groupRoleCountTotalByFilter(@RequestBody @Valid final String stringFilter) {
        BigInteger result = userService.groupRoleCountTotalByFilter(stringFilter).orElse(BigInteger.valueOf(0));
        return new ResponseEntity<BigInteger>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/count-user-authority", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countUserAuthorityByFilter(@RequestBody @Valid final String stringFilter) {
        BigInteger result = userService.countUserAuthorityByFilter(stringFilter).orElse(BigInteger.valueOf(0));
        return new ResponseEntity<BigInteger>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/select-user-group-role", method = RequestMethod.POST)
    public ResponseEntity<List<UserGroupRole>> selectUserGroupRoleByFilter(@RequestBody @Valid final String stringFilter) {
        List<UserGroupRole> groupRoles = userService.getUserGroupRoleByFilter(stringFilter);
        return new ResponseEntity<List<UserGroupRole>>(groupRoles, HttpStatus.OK);
    }

    @RequestMapping(value = "/permission-user", method = RequestMethod.POST)
    public ResponseEntity<Boolean> permissionUser(@RequestBody @Valid final UserPermisson userPermisson) {
        Boolean result = userService.permissionUser(userPermisson).orElse(false);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-authority-by-filter", method = RequestMethod.POST)
    public ResponseEntity<List<Authority>> getAuthorityByFilter(@RequestBody @Valid final String stringFilter) {
        List<Authority> result = userService.getAuthorityByFilter(stringFilter).orElse(new ArrayList<Authority>());
        return new ResponseEntity<List<Authority>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/add-grouprole-authority", method = RequestMethod.POST)
    public ResponseEntity<Boolean> addGroupRoleAuthority(@RequestBody @Valid final GrouproleAuthority grouproleAuthority) {
        Boolean result = userService.addGroupRoleAuthority(grouproleAuthority.getGrouprole_id(), grouproleAuthority.getAuthority_code(), grouproleAuthority.getValue()).orElse(false);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/add-grouprole", method = RequestMethod.POST)
    public ResponseEntity<Boolean> addGroupRole(@RequestBody @Valid final CreateGroupRoleForm createGroupRoleForm) {
        StringUtils.trimAllFieldOfObject(createGroupRoleForm);
        Boolean result = userService.addGroupRole(createGroupRoleForm).orElse(false);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/update-grouprole", method = RequestMethod.POST)
    public ResponseEntity<Boolean> updateGroupRole(@RequestBody @Valid final CreateGroupRoleForm createGroupRoleForm) {
        StringUtils.trimAllFieldOfObject(createGroupRoleForm);
        Boolean result = userService.updateGroupRole(createGroupRoleForm).orElse(false);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/check-exits-grouprole", method = RequestMethod.POST)
    public ResponseEntity<Boolean> checkExitsGroupRole(@RequestBody @Valid final CreateGroupRoleForm createGroupRoleForm) {
        StringUtils.trimAllFieldOfObject(createGroupRoleForm);
        Boolean result = userService.checkExitsGroupRole(createGroupRoleForm).orElse(false);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/select-group-role-authority", method = RequestMethod.POST)
    public ResponseEntity<List<GrouproleAuthority>> selectGroupRoleAuthorityByFilter(@RequestBody @Valid final String stringFilter) {
        List<GrouproleAuthority> grouproleAuthorities = userService.getGroupRoleAuthority(stringFilter);
        return new ResponseEntity<List<GrouproleAuthority>>(grouproleAuthorities, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete-group-role-authority-by-groupid", method = RequestMethod.POST)
    public ResponseEntity<Boolean> deleteGroupRoleAuthority(@RequestBody @Valid final Long id) {
        Boolean result = userService.deleteGroupRoleAuthority(id).orElse(false);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete-group-role-by-groupid", method = RequestMethod.POST)
    public ResponseEntity<Boolean> deleteGroupRole(@RequestBody @Valid final Long id) {
        Boolean result = userService.deleteGroupRole(id).orElse(false);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/select-user-authority-by-filter", method = RequestMethod.POST)
    public ResponseEntity<List<UserAuthority>> selectUserAuthorityByFilter(@RequestBody @Valid final String stringFilter) {
        List<UserAuthority> result = userService.getUserAuthorityByFilter(stringFilter);
        return new ResponseEntity<List<UserAuthority>>(result, HttpStatus.OK);
    }
    @RequestMapping(value = "/select-user-by-group-role", method = RequestMethod.POST)
    public ResponseEntity<List<UserByRoleList>> selectUserByGrouprole(@RequestBody @Valid final String stringFilter) {
        List<UserByRoleList> result = userService.getUserByRoleList(stringFilter);
        return new ResponseEntity<List<UserByRoleList>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-by-group-role", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getByGrouproleId(@RequestParam final String id) {
        List<User> result = userService.getByGroupRoleId(id).orElse(null);
        return new ResponseEntity<List<User>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> listRole() {
        List<Role> result = userService.listRole().orElse(null);
        return new ResponseEntity<List<Role>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/roleByCode", method = RequestMethod.GET)
    public ResponseEntity<Role> roleByCode(@RequestParam final String code) {
        Role result = userService.roleByCode(code).orElse(null);
        return new ResponseEntity<Role>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/list-role", method = RequestMethod.POST)
    public ResponseEntity<List<Role>> listRole1() {
        List<Role> result = userService.listRole().orElse(null);
        return new ResponseEntity<List<Role>>(result, HttpStatus.OK);
    }
    @RequestMapping(value = "/get-user",method=RequestMethod.GET)
    public ResponseEntity<User> getUserById(@RequestParam final String id){
        String functionName="UserController.getUserById()";
        ResponseEntity<User> respone=new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        try{
            User result= userService.getUserById(id).orElse(null);
            respone=new ResponseEntity<User>(result,HttpStatus.OK);
        }catch (Exception e){
            LOGGER.error("Method error "+functionName+ ": "+e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/users-by-authority-code", method = RequestMethod.GET)
    public ResponseEntity<List<User>> selectUsersByAuthorityCode(@RequestParam @Valid final String authority_code) {
        if(org.apache.commons.lang3.StringUtils.isBlank(authority_code)){
            return  new ResponseEntity<List<User>>(new ArrayList<User>(),HttpStatus.NO_CONTENT);
        }
        List<User> users = userService.getUsersByAuthorityCode(authority_code).orElse(new ArrayList<>());
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/select-grouprole-authority-by-user-and-authority-code", method = RequestMethod.GET)
    public ResponseEntity<List<GrouproleAuthority>> selectGroupAuthorityByUseridAndAuthorityCode(@RequestParam @Valid final String userId,@RequestParam @Valid final String authority_code) {
        if(org.apache.commons.lang3.StringUtils.isBlank(authority_code) || org.apache.commons.lang3.StringUtils.isBlank(userId)){
            return  new ResponseEntity<List<GrouproleAuthority>>(new ArrayList<GrouproleAuthority>(),HttpStatus.NO_CONTENT);
        }
        List<GrouproleAuthority> items = userService.getGroupRoleAuthorityByUserAndAuthorityCode(userId,authority_code).orElse(new ArrayList<>());
        return new ResponseEntity<List<GrouproleAuthority>>(items, HttpStatus.OK);
    }

    @RequestMapping(value = "/users-by-authority-code-and-value", method = RequestMethod.GET)
    public ResponseEntity<List<User>> selectUsersByAuthorityCodeAndValue(@RequestParam @Valid final String authority_code,@RequestParam @Valid final int value) {
        if(org.apache.commons.lang3.StringUtils.isBlank(authority_code)){
            return  new ResponseEntity<List<User>>(new ArrayList<User>(),HttpStatus.NO_CONTENT);
        }
        List<User> users = userService.selectUsersByAuthorityCodeAndValue(authority_code,value).orElse(new ArrayList<>());
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/removeFile", method = RequestMethod.POST)
    public ResponseEntity<Boolean> removeFile(@RequestBody @Valid final Long id)  {

        return new ResponseEntity<Boolean>((Boolean) userService.removeFile(id).orElse(false), HttpStatus.OK);
    }
}
