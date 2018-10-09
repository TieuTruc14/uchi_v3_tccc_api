package com.vn.osp.notarialservices.province.controller;

import com.vn.osp.notarialservices.province.dto.AddProvince;
import com.vn.osp.notarialservices.province.dto.Province;
import com.vn.osp.notarialservices.province.service.ProvinceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TienManh on 5/10/2017.
 */
@Controller
@RequestMapping(value="/province")

public class ProvinceController {
    private static final Logger LOGGER = Logger.getLogger(ProvinceController.class);

    private final ProvinceService provinceService;

    @Autowired
    public ProvinceController(final ProvinceService provinceService ){
        this.provinceService = provinceService;
    }
    @RequestMapping(value = "/AddProvince", method = RequestMethod.POST)
    public ResponseEntity<Boolean> AddProvince(@RequestBody @Valid final AddProvince addProvince)  {


        return new ResponseEntity<Boolean>((Boolean) provinceService.AddProvince(addProvince.getName() ,addProvince.getEntry_user_id(),addProvince.getEntry_user_name() ,addProvince.getCode()).orElse(Boolean.valueOf(false)), HttpStatus.OK);
    }
    @RequestMapping(value="/findProvinceByFilter", method = RequestMethod.POST)
    public ResponseEntity<List<Province>> findProvinceByFilter(@RequestBody final String stringFilter)  {
        List<Province> provinceByFilter = provinceService.findProvinceByFilter(stringFilter).orElse(new ArrayList<Province>());
        return new ResponseEntity<List<Province>>(provinceByFilter, HttpStatus.OK);
    }
    @RequestMapping(value="/countProvinceByFilter", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countProvinceByFilter(@RequestBody final String stringFilter)  {
        BigInteger provinceByFilter = provinceService.countProvinceByFilter(stringFilter).orElse(BigInteger.valueOf(0));

        return new ResponseEntity<BigInteger>(provinceByFilter, HttpStatus.OK);
    }

}
