package com.vn.osp.notarialservices.bank.controller;

import com.vn.osp.notarialservices.bank.dto.AddBank;
import com.vn.osp.notarialservices.bank.dto.Bank;
import com.vn.osp.notarialservices.bank.dto.CreateBankForm;
import com.vn.osp.notarialservices.bank.service.BankService;
import com.vn.osp.notarialservices.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by minh on 2/22/2017.
 */
@Controller
@RequestMapping(value="/bank")
public class BankController {
    private static final Logger LOGGER =  Logger.getLogger(BankController.class);

    private final BankService bankService;

    @Autowired
    public BankController(final BankService bankService) {
        this.bankService= bankService;
    }

    @RequestMapping(value="/selectBank", method = RequestMethod.POST)
    public ResponseEntity<List<Bank>> selectBank(@RequestBody final String stringFilter ){
        List<Bank> bank = bankService.selectBank(stringFilter).orElse(null);
        return new ResponseEntity<List<Bank>>(bank, HttpStatus.OK);
    }

    @RequestMapping(value="/getAllBank", method = RequestMethod.GET)
    public ResponseEntity<String> selectBank(){
        String functionName = "getAllBank()";

        ResponseEntity<String> respone = null;
        try {
            List<Bank> result = bankService.getAllBank().orElse(null);
            if (result != null) {
                String jsonString = StringUtils.getJson(result);
                respone = new ResponseEntity<String>(jsonString, HttpStatus.OK);
            }
        } catch (Exception e) {
            LOGGER.error("Method " + functionName + ": " + e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (respone == null) {
            respone = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }

        return respone;
    }

    @RequestMapping(value="/countBank", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countBank(@RequestBody String stringFiltler){

        BigInteger respone = bankService.countBank(stringFiltler).orElse(null);
        return new ResponseEntity<BigInteger>(respone, HttpStatus.OK);

    }

    @RequestMapping(value = "/AddBank", method = RequestMethod.POST)
    public ResponseEntity<Boolean> addBank(@RequestBody @Valid final AddBank addBank)  {
        return new ResponseEntity<Boolean>((Boolean) bankService.addBank(addBank.getName(),addBank.getEntry_user_id(),addBank.getEntry_user_name(),addBank.getCode(),addBank.getActive()).orElse(Boolean.valueOf(false)), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateBank", method = RequestMethod.POST)
    public ResponseEntity<Boolean> updateGroupRole(@RequestBody @Valid final CreateBankForm createBankForm) {
        Boolean result = bankService.updateBank(createBankForm).orElse(false);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Bank> getBankById(@RequestParam @Valid final String id) {
        Bank result = bankService.getById(id).orElse(null);
        return new ResponseEntity<Bank>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-by-code", method = RequestMethod.GET)
    public ResponseEntity<Bank> getBankByCode(@RequestParam @Valid final String code) {
        Bank result = bankService.getByCode(code).orElse(null);
        return new ResponseEntity<Bank>(result, HttpStatus.OK);
    }


}