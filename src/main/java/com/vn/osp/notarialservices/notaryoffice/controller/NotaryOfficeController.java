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
package com.vn.osp.notarialservices.notaryoffice.controller;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.vn.osp.notarialservices.notaryoffice.dto.NotaryOffice;
import com.vn.osp.notarialservices.notaryoffice.service.NotaryOfficeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manhtran on 20/10/2016.
 */
@Controller
@RequestMapping(value = "/notaryoffice")
public class NotaryOfficeController {

    private static final Logger LOGGER = Logger.getLogger(NotaryOfficeController.class);

    private final NotaryOfficeService notaryOfficeService;

    @Autowired
    public NotaryOfficeController(final NotaryOfficeService notaryOfficeService) {
        this.notaryOfficeService = notaryOfficeService;
    }
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(
            value = "Thêm mới tổ chức công chứng",
            notes = "Chỉ có thể được gọi bởi người dùng tại văn phòng công chứng."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Thêm mới tổ chức công chứng thành công!"),
            @ApiResponse(code = 400, message = "Có lỗi xảy ra.")
    })
    public ResponseEntity<Boolean> insert(@RequestBody final NotaryOffice notaryOffice){
        XmlFriendlyReplacer replacer = new XmlFriendlyReplacer("ddd", "_");
        XStream xXStream = new XStream(new DomDriver("UTF-8", replacer));
        xXStream.autodetectAnnotations(true);
        String xml_content  = xXStream.toXML(notaryOffice);
        Boolean result = notaryOfficeService.insert(xml_content).orElse(false);

        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(
            value = "Chỉnh sửa tổ chức công chứng",
            notes = "Chỉ có thể được gọi bởi người dùng tại văn phòng công chứng."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Chỉnh sửa tổ chức công chứng thành công!"),
            @ApiResponse(code = 400, message = "Có lỗi xảy ra.")
    })
    public ResponseEntity<Boolean> update(@RequestBody final NotaryOffice notaryOffice){
        XmlFriendlyReplacer replacer = new XmlFriendlyReplacer("ddd", "_");
        XStream xXStream = new XStream(new DomDriver("UTF-8", replacer));
        xXStream.autodetectAnnotations(true);
        String xml_content  = xXStream.toXML(notaryOffice);
        Boolean result = notaryOfficeService.update(xml_content).orElse(false);

        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    @ApiOperation(
            value = "Xóa tổ chức công chứng bằng id",
            notes = "Chỉ có thể được gọi bởi người dùng tại văn phòng công chứng."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Xóa tổ chức công chứng thành công!"),
            @ApiResponse(code = 400, message = "Có lỗi xảy ra.")
    })
    public ResponseEntity<Boolean> deleteById(@RequestBody final Long noid){
        Boolean result = notaryOfficeService.deleteById(noid).orElse(false);

        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/selectByFilter", method = RequestMethod.POST)
    @ApiOperation(
            value = "Lấy danh sách tổ chức công chứng bằng",
            notes = "Chỉ có thể được gọi bởi người dùng tại văn phòng công chứng."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lấy danh sách chức công chứng thành công!"),
            @ApiResponse(code = 400, message = "Có lỗi xảy ra.")
    })
    public ResponseEntity<List<NotaryOffice>> selectByFilter(@RequestBody final String stringFilter){
        List<NotaryOffice> result = notaryOfficeService.selectByFilter(stringFilter).orElse(new ArrayList<NotaryOffice>() );
        return new ResponseEntity<List<NotaryOffice>>(result, HttpStatus.OK);
    }
    @RequestMapping(value = "/countTotalNotaryOffice", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countTotalNotaryOffice(@RequestBody final String stringFilter){
        BigInteger respone = notaryOfficeService.countTotalNotaryOffice(stringFilter).orElse(null);
        return new ResponseEntity<BigInteger>(respone, HttpStatus.OK);
    }


}
