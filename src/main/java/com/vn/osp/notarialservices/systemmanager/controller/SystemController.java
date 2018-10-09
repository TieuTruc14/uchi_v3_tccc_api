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
package com.vn.osp.notarialservices.systemmanager.controller;

import com.vn.osp.notarialservices.systemmanager.dto.AccessHistory;
import com.vn.osp.notarialservices.systemmanager.service.AccessHistoryService;
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
@RequestMapping(value = "/systemmanager")
public class SystemController {

    private static final Logger LOGGER = Logger.getLogger(SystemController.class);

    private final AccessHistoryService accessHistoryService;
    private final SystemControllerHateoasBuilder systemControllerHateoasBuilder;

    @Autowired
    public SystemController(final AccessHistoryService accessHistoryService, final SystemControllerHateoasBuilder systemControllerHateoasBuilder) {
        this.accessHistoryService = accessHistoryService;
        this.systemControllerHateoasBuilder = systemControllerHateoasBuilder;
    }

    @RequestMapping(value = "/selectAccessHistoryByFilter", method = RequestMethod.POST)
    @ApiOperation(
            value = "Lấy lịch sử truy cập hệ thống",
            notes = "Chỉ có thể được gọi bởi người dùng trên Sở tư pháp."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lấy lịch sử thành công!"),
            @ApiResponse(code = 400, message = "Có lỗi xảy ra.")
    })
    public ResponseEntity<List<AccessHistory>> selectAccessHistoryByFilter(@RequestBody final String stringFilter){
        List<AccessHistory> accessHistories = accessHistoryService.selectByFilter(stringFilter).orElse(new ArrayList<AccessHistory>());

        return new ResponseEntity<List<AccessHistory>>(accessHistories, HttpStatus.OK);
    }

    @RequestMapping(value = "/getConfigValue", method = RequestMethod.POST)
    @ApiOperation(
            value = "Lấy giá trị config",
            notes = "Chỉ có thể được gọi bởi người dùng trên Sở tư pháp."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lấy giá trị thành công!"),
            @ApiResponse(code = 400, message = "Có lỗi xảy ra.")
    })
    public ResponseEntity<String> getConfigValue(@RequestBody final String key){
        String value = accessHistoryService.getConfigValue(key).orElse("error");

        return new ResponseEntity<String>(value, HttpStatus.OK);
    }
    @RequestMapping(value = "/countTotal", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countTotalAccess(@RequestBody final String stringFilter)  {
        BigInteger result = accessHistoryService.countTotalAccess(stringFilter).orElse(BigInteger.valueOf(0));

        return new ResponseEntity<BigInteger>(result, HttpStatus.OK);

    }
    @RequestMapping(value = "/setAccessHistory", method = RequestMethod.POST)
    @ApiOperation(
            value = "Set lịch sử truy cập hệ thống",
            notes = "Chỉ có thể được gọi bởi người dùng trên Sở tư pháp."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "set lịch sử thành công!"),
            @ApiResponse(code = 400, message = "Có lỗi xảy ra.")
    })
    public ResponseEntity<Boolean> setAccessHistoryByFilter(@RequestBody final AccessHistory accessHistory){
        Boolean result = accessHistoryService.setAccessHistory(accessHistory);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }
}
