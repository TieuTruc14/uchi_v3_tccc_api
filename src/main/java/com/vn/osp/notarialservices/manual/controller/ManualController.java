package com.vn.osp.notarialservices.manual.controller;

import com.vn.osp.notarialservices.manual.dto.AddManual;
import com.vn.osp.notarialservices.manual.dto.Manual;
import com.vn.osp.notarialservices.manual.dto.UpdateManual;
import com.vn.osp.notarialservices.manual.service.ManualService;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by minh on 11/19/2016.
 */
@Controller
@RequestMapping(value="/manual")
public class ManualController {
    private static final Logger LOGGER = Logger.getLogger(ManualController.class);

    private final ManualService manualService;
    private final ManualControllerHateoasBuilder manualControllerHateoasBuilder;

    @Autowired
    public ManualController(final ManualService manualService, final ManualControllerHateoasBuilder manualControllerHateoasBuilder){
        this.manualService = manualService;
        this.manualControllerHateoasBuilder = manualControllerHateoasBuilder;
    }
    @RequestMapping(value="/findbyId", method = RequestMethod.POST)
    public ResponseEntity<Manual> findManualByID(@RequestParam final Long id)  {

        Manual manualOptional = manualService.findManualById(id).orElse(new Manual());

        return new ResponseEntity<Manual>(manualOptional, HttpStatus.OK);
    }
    @RequestMapping(value="/deleteById", method = RequestMethod.POST)
    public ResponseEntity<Boolean> deleteManualById(@RequestBody final Long id) {

            Boolean manualOptional = manualService.deleteManualById(id).orElse(Boolean.valueOf(false));
            return new ResponseEntity<Boolean>(manualOptional, HttpStatus.OK);
    }
    @RequestMapping(value="/findManualByFilter", method = RequestMethod.POST)
    public ResponseEntity<List<Manual>> findManualByFilter(@RequestBody final String stringFilter)  {
        List<Manual> manualByFilter = manualService.findManualByFilter(stringFilter).orElse(new ArrayList<Manual>());

        return new ResponseEntity<List<Manual>>(manualByFilter, HttpStatus.OK);
    }

    @RequestMapping(value = "/countTotalManual", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countTotalManual()  {

        BigInteger result = manualService.countTotalManual().orElse(BigInteger.valueOf(0));
        return new ResponseEntity<BigInteger>(result, HttpStatus.OK);

    }
    @RequestMapping(value = "/AddManual", method = RequestMethod.POST)
    public ResponseEntity<Boolean> AddManual(@RequestBody @Valid final AddManual addManual)  {
        return new ResponseEntity<Boolean>((Boolean) manualService.AddManual(addManual.getTitle(),addManual.getContent(),addManual.getFile_name(),addManual.getFile_path(),addManual.getEntry_user_id(),addManual.getEntry_user_name(),addManual.getUpdate_user_id(),addManual.getUpdate_user_name()).orElse(Boolean.valueOf(false)), HttpStatus.OK);
    }
    @RequestMapping(value = "/countTotalByFilter", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countTotalByFilter(@RequestBody final String stringFilter)  {

        BigInteger result = manualService.countTotalByFilter(stringFilter).orElse(BigInteger.valueOf(0));
        return new ResponseEntity<BigInteger>(result, HttpStatus.OK);
    }
    @RequestMapping(value="/updateManual", method = RequestMethod.POST)
    public ResponseEntity<Boolean> updateManual(@RequestBody UpdateManual updateManual){
        return new ResponseEntity<Boolean>((Boolean) manualService.updateManual(updateManual.getId(),updateManual.getTitle(),updateManual.getContent(),updateManual.getFile_name(),updateManual.getFile_path(),updateManual.getUpdate_user_id(),updateManual.getUpdate_user_name()).orElse(Boolean.valueOf(false)), HttpStatus.OK);

    }
    @RequestMapping(value = "/removeFile", method = RequestMethod.POST)
    public ResponseEntity<Boolean> removeFile(@RequestBody @Valid final String input)  {

        return new ResponseEntity<Boolean>((Boolean) manualService.removeFile(input).orElse(false), HttpStatus.OK);
    }

}
