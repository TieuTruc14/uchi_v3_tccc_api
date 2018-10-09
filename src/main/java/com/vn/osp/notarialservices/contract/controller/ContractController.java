package com.vn.osp.notarialservices.contract.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.vn.osp.notarialservices.bank.controller.BankController;
import com.vn.osp.notarialservices.contract.dto.*;
import com.vn.osp.notarialservices.contract.dto.NotaryDateFilter;
import com.vn.osp.notarialservices.contract.service.*;
import com.vn.osp.notarialservices.systemmanager.service.AccessHistoryService;
import com.vn.osp.notarialservices.transaction.dto.*;
import com.vn.osp.notarialservices.transaction.dto.TransactionProperty;
import com.vn.osp.notarialservices.transaction.service.TransactionPropertyService;
import com.vn.osp.notarialservices.utils.*;
import com.vn.osp.notarialservices.utils.StringUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.*;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.math.BigInteger;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 5/8/2017.
 */
@Controller
@RequestMapping(value = "/contract")
public class ContractController {
    private static final Logger LOGGER = Logger.getLogger(ContractController.class);

    private ContractService contractService;
    private SynchronizeService synchronizeService;
    private PropertyService propertyService;
    private TemporaryContractService temporaryContractService;
    private TransactionPropertyService transactionPropertyService;
    private final AccessHistoryService accessHistoryService;
    private final ContractKindService contractKindService;

    @Autowired
    public ContractController(ContractService contractService, SynchronizeService synchronizeService,
                              PropertyService propertyService, TemporaryContractService temporaryContractService,
                              TransactionPropertyService transactionPropertyService,
                              AccessHistoryService accessHistoryService,
                              ContractKindService contractKindService) {
        this.contractService = contractService;
        this.synchronizeService = synchronizeService;
        this.propertyService = propertyService;
        this.temporaryContractService = temporaryContractService;
        this.transactionPropertyService = transactionPropertyService;
        this.accessHistoryService = accessHistoryService;
        this.contractKindService = contractKindService;
    }

    @RequestMapping(value = "/all-contract", method = RequestMethod.GET)
    public ResponseEntity<String> getAllContract() {
        String functionName = "ContractController.getAllContract()";
        ResponseEntity<String> respone = null;
        try {
            List<Contract> result = contractService.getAllContract().orElse(null);
            if (result != null) {
                String jsonString = StringUtils.getJson(result);
                respone = new ResponseEntity<String>(jsonString, HttpStatus.OK);
            } else {
                respone = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/findLatestContract", method = RequestMethod.POST)
    public ResponseEntity<List<Contract>> findLatestContract(@RequestBody final Long countNumber)  {
        List<Contract> contracts1 = contractService.findLatestContract(countNumber).orElse(new ArrayList<Contract>());

        return new ResponseEntity<List<Contract>>(contracts1, HttpStatus.OK);
    }
    @RequestMapping(value = "/all-synchronize", method = RequestMethod.GET)
    public ResponseEntity<String> getAllSynchronize() {
        String functionName = "ContractController.getAllSynchronize()";
        ResponseEntity<String> respone = null;
        try {
            List<Synchronize> result = synchronizeService.getAllSynchronize().orElse(null);
            if (result != null) {
                String jsonString = StringUtils.getJson(result);
                respone = new ResponseEntity<String>(jsonString, HttpStatus.OK);
            } else {
                respone = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/all-property", method = RequestMethod.GET)
    public ResponseEntity<String> getAllProperty() {
        String functionName = "ContractController.getAllProperty()";
        ResponseEntity<String> respone = null;
        try {
            List<Property> result = propertyService.getAllProperty().orElse(null);
            if (result != null) {
                String jsonString = StringUtils.getJson(result);
                respone = new ResponseEntity<String>(jsonString, HttpStatus.OK);
            } else {
                respone = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/all-temporary-contract", method = RequestMethod.GET)
    public ResponseEntity<String> getAllTemporaryContract() {
        String functionName = "ContractController.getAllTemporaryContract()";
        ResponseEntity<String> respone = null;
        try {
            List<TemporaryContract> result = temporaryContractService.getAllTemporaryContract().orElse(null);
            if (result != null) {
                String jsonString = StringUtils.getJson(result);
                respone = new ResponseEntity<String>(jsonString, HttpStatus.OK);
            } else {
                respone = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }


    @RequestMapping(value = "/getContractKindByFilter", method = RequestMethod.POST)
    public ResponseEntity<List<ContractKind>> getContractKindByFilter(@RequestBody String stringFilter) {
        List<ContractKind> result = contractService.selectContractKindByFilter(stringFilter).orElse(new ArrayList<ContractKind>());
        return new ResponseEntity<List<ContractKind>>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/getContractTemplateByFilter", method = RequestMethod.POST)
    public ResponseEntity<List<ContractTemplate>> getContractTemplateByFilter(@RequestBody String stringFilter) {
        List<ContractTemplate> result = contractService.selectContractTeamplateByFilter(stringFilter).orElse(new ArrayList<ContractTemplate>());
        return new ResponseEntity<List<ContractTemplate>>(result, HttpStatus.OK);

    }


    @RequestMapping(value = "/selectReportByGroupTotal", method = RequestMethod.POST)
    public ResponseEntity<List<ReportByGroupTotal>> selectReportByGroupTotal(@RequestBody final ReportByGroupTotalList reportByGroupTotalList) {
        List<ReportByGroupTotal> reportByGroupTotals = contractService.selectReportByGroupTotal(reportByGroupTotalList);

        return new ResponseEntity<List<ReportByGroupTotal>>(reportByGroupTotals, HttpStatus.OK);
    }

    @RequestMapping(value = "/selectDetailReportByGroup", method = RequestMethod.POST)
    public ResponseEntity<List<com.vn.osp.notarialservices.transaction.dto.TransactionProperty>> selectDetailReportByGroup(@RequestBody final ReportByGroupTotalList reportByGroupTotalList) {
        List<com.vn.osp.notarialservices.transaction.dto.TransactionProperty> reportByGroupTotals = contractService.selectDetailReportByGroup(reportByGroupTotalList);

        return new ResponseEntity<List<com.vn.osp.notarialservices.transaction.dto.TransactionProperty>>(reportByGroupTotals, HttpStatus.OK);
    }

    @RequestMapping(value = "/selectAllDetailReportByGroup", method = RequestMethod.POST)
    public ResponseEntity<List<com.vn.osp.notarialservices.transaction.dto.TransactionProperty>> selectAllDetailReportByGroup(@RequestBody final ReportByGroupTotalList reportByGroupTotalList) {
        List<com.vn.osp.notarialservices.transaction.dto.TransactionProperty> reportByGroupTotals = contractService.selectAllDetailReportByGroup(reportByGroupTotalList);

        return new ResponseEntity<List<com.vn.osp.notarialservices.transaction.dto.TransactionProperty>>(reportByGroupTotals, HttpStatus.OK);
    }

    @RequestMapping(value = "/countDetailReportByGroup", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countDetailReportByGroup(@RequestBody final ReportByGroupTotalList reportByGroupTotalList) {
        BigInteger result = contractService.countDetailReportByGroup(reportByGroupTotalList);

        return new ResponseEntity<BigInteger>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/countTotalByFilter", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countHistoryContract(@RequestBody String stringFilter) {
        BigInteger result = contractService.countHistoryContract(stringFilter).orElse(BigInteger.valueOf(0));

        return new ResponseEntity<BigInteger>(result, HttpStatus.OK);

    }

    @RequestMapping(value = "/selectContractHistoryByFilter", method = RequestMethod.POST)
    @ApiOperation(
            value = "Lấy lịch sử thay đổi hợp đồng",
            notes = "Chỉ có thể được gọi bởi người dùng trên Sở tư pháp."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lấy lịch sử thành công!"),
            @ApiResponse(code = 400, message = "Có lỗi xảy ra.")
    })
    public ResponseEntity<List<ContractHistory>> selectContractHistoryByFilter(@RequestBody final String stringFilter) {
        List<ContractHistory> contractHistoryInfors = contractService.selectByFilter(stringFilter);
        return new ResponseEntity<List<ContractHistory>>(contractHistoryInfors, HttpStatus.OK);
    }

    @RequestMapping(value = "/selectReportByNotary", method = RequestMethod.POST)
    public ResponseEntity<List<ReportByNotaryPerson>> selectReportByNotary(@RequestBody @Valid final String stringFilter) {
        List<ReportByNotaryPerson> result = contractService.getReportByNotary(stringFilter);
        return new ResponseEntity<List<ReportByNotaryPerson>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/countTotalReportByNotary", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countTotalReportByNotary(@RequestBody final String stringFilter) {

        return new ResponseEntity<BigInteger>((BigInteger) contractService.countTotalReportByNotary(stringFilter).orElse(BigInteger.valueOf(0)), HttpStatus.OK);
    }

    @RequestMapping(value = "/selectReportByUser", method = RequestMethod.POST)
    public ResponseEntity<List<ReportByUser>> getReportByUser(@RequestBody @Valid final String stringFilter) {
        List<ReportByUser> result = contractService.getReportByUser(stringFilter);
        return new ResponseEntity<List<ReportByUser>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/countTotalReportByUser", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countTotalReportByUser(@RequestBody final String stringFilter) {

        return new ResponseEntity<BigInteger>((BigInteger) contractService.countTotalReportByUser(stringFilter).orElse(BigInteger.valueOf(0)), HttpStatus.OK);
    }


    @RequestMapping(value = "/report-tt-20", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<ReportByTT20List>> reportByTT20(@RequestBody final ReportByTT20List reportByTT20List) {
        ReportByTT20List reportByTT20 = contractService.reportByTT20(reportByTT20List);
        ArrayList<ReportByTT20List> reportByTT20Lists = new ArrayList<ReportByTT20List>();
        reportByTT20Lists.add(reportByTT20);
        return new ResponseEntity<ArrayList<ReportByTT20List>>(reportByTT20Lists, HttpStatus.OK);
    }

    @RequestMapping(value = "/report-tt-04", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<ReportByTT04List>> reportByTT04(@RequestBody final ReportByTT04List reportByTT04List) {
        ReportByTT04List reportByTT04 = contractService.reportByTT04(reportByTT04List);
        ArrayList<ReportByTT04List> reportByTT04Lists = new ArrayList<ReportByTT04List>();
        reportByTT04Lists.add(reportByTT04);
        return new ResponseEntity<ArrayList<ReportByTT04List>>(reportByTT04Lists, HttpStatus.OK);
    }

//    @RequestMapping(value = "/contract_number", method = RequestMethod.GET)
//    public ResponseEntity<Integer> countTotalReportByUser() {
//        SimpleDateFormat.getDateInstance();
//        return new ResponseEntity<Integer>((Integer) temporaryContractService.getContractNumberValue().orElse(Integer.valueOf(0)), HttpStatus.OK);
//    }
    @RequestMapping(value = "/contractNumber", method = RequestMethod.GET)
    public ResponseEntity<Integer> getContractNumber(@RequestParam @Valid final long year,@RequestParam @Valid final long userId) {
        int contractNumber=0;
        String key=year+"";
        try{
            if(1900<=year || year<=2100){
                if(userId>0) key=year+"/"+userId;
                contractNumber=temporaryContractService.getContractNumber(key).orElse(Integer.valueOf(0));
            }
        }catch (Exception e){
            return new ResponseEntity<Integer>(0 , HttpStatus.OK);
        }

        return new ResponseEntity<Integer>(Integer.valueOf(contractNumber), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Integer> addContract(@RequestBody @Valid final Contract contract) {
        if (contract == null) return new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT);
        StringUtils.trimAllFieldOfObject(contract);
        boolean checkContractNumber=checkContractNumber(contract.getContract_number());
        if(!checkContractNumber){
            return new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT);
        }
        TransactionProperty trans = new com.vn.osp.notarialservices.transaction.dto.TransactionProperty();
        trans = contractService.genaralInfoToTransactionProperty(contract, trans);
        ContractHistoryInfor history = new ContractHistoryInfor();
        history = contractService.genaralHistoryInfo(contract, history, "Đăng ký");
        /*convert xml*/

        Integer id = contractService.addContract(contract, trans, history).orElse(null);
        if (id > 0) {
            // dong bo du lieu
            SynchronizeContractTag contractTag = contractService.genSynchronizeContractTagByTrans(trans, Constants.CREATE_CONTRACT);
            List<SynchronizeContractTag> contractTags = new ArrayList<>();
            contractTags.add(contractTag);
            boolean checkSynch = contractService.synchronizeContractTags(contractTags);
            if (checkSynch) {
                boolean ch = transactionPropertyService.updateSynchStatus(Long.valueOf(id), Long.valueOf(1)).orElse(false);
            }
        }
        return new ResponseEntity<Integer>(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<ResultUpload> uploadFile(@RequestBody @Valid final MultipartFile file) {
        if (file == null) return new ResponseEntity<ResultUpload>(new ResultUpload(), HttpStatus.NO_CONTENT);
        String folder=SystemProperties.getProperty("system_folder");
        ResultUpload item=new ResultUpload();
        try{

            if (file!= null && !file.isEmpty()) {
                File fileSave = FileUtil.createNewFile(folder, "CTR_");
                String localName = EditString.convertUnicodeToASCII(file.getOriginalFilename());
                String path = "";
                try {
                    FileOutputStream outputStream = null;
                    outputStream = new FileOutputStream(fileSave);
                    outputStream.write(file.getBytes());
                    path = fileSave.getAbsolutePath();
                    item.setName(localName);
                    item.setPath(path);
                    return new ResponseEntity<ResultUpload>(item, HttpStatus.OK);
                } catch (IOException e) {
//                    e.printStackTrace();
                    return new ResponseEntity<ResultUpload>(item, HttpStatus.OK);
                }
            }


        }catch (Exception e){
            return new ResponseEntity<ResultUpload>(item, HttpStatus.OK);
        }
        return new ResponseEntity<ResultUpload>(item, HttpStatus.OK);
    }
    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST )
    public  ResponseEntity<List<ResultUpload>> uploadFiles(@RequestParam("file") MultipartFile[] files) {
        if (files == null) return new ResponseEntity<List<ResultUpload>>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        String folder=SystemProperties.getProperty("system_folder");
        List<ResultUpload> items=new ArrayList<>();
        try{
            for(MultipartFile file:files){
                if (file!= null && !file.isEmpty()) {
                    ResultUpload item=new ResultUpload();
                    File fileSave = FileUtil.createNewFile(folder, "CTR_");
                    String localName = EditString.convertUnicodeToASCII(file.getOriginalFilename());
                    String path = "";
                    try {
                        FileOutputStream outputStream = null;
                        outputStream = new FileOutputStream(fileSave);
                        outputStream.write(file.getBytes());
                        path = fileSave.getAbsolutePath();
                        item.setName(localName);
                        item.setPath(path);
                        items.add(item);
                    } catch (IOException e) {

                    }
                }
            }

        }catch (Exception e){
            return new ResponseEntity<List<ResultUpload>>(items, HttpStatus.OK);
        }
        return new ResponseEntity<List<ResultUpload>>(items, HttpStatus.OK);
    }

    @RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
    public void downloadFile(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        try {
            Contract item=contractService.getContractById(id.toString()).orElse(null);
            if(item==null) return;
            File file = new File(item.getFile_path());
            if (!file.exists()) {
                String errorMessage = "Sorry. The file you are looking for does not exist";
                OutputStream outputStream = response.getOutputStream();
                outputStream.write(errorMessage.getBytes());
                outputStream.close();
                return;
            }
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + item.getFile_name() + "\""));
            response.setContentLength((int) file.length());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
            inputStream.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public ResponseEntity<Boolean> removeFile(@RequestParam @Valid final String id) {
        try {
            Contract item=contractService.getContractById(id.toString()).orElse(null);
            if(item==null) return new ResponseEntity<Boolean>(false, HttpStatus.OK);
            File file = new File(item.getFile_path());
            if (!file.exists()) {
                String errorMessage = "Sorry. The file you are looking for does not exist";
                return new ResponseEntity<Boolean>(false, HttpStatus.OK);
            }else{
                item.setFile_name("");
                item.setFile_path("");
                if(!org.apache.commons.lang3.StringUtils.isBlank(item.getKindhtml())){
                    item.setKindhtml(item.getKindhtml().replaceAll("&lt;", "<"));
                    item.setKindhtml(item.getKindhtml().replaceAll("&gt;", ">"));
                    item.setKindhtml(item.getKindhtml().replaceAll("&amp;nbsp;", " "));
                }
                TransactionProperty trans = transactionPropertyService.getByContractId(item.getid().toString()).orElse(null);
                trans = contractService.genaralInfoToTransactionProperty(item, trans);
                ContractHistoryInfor history = new ContractHistoryInfor();
                history = contractService.genaralHistoryInfo(item, history, "Gỡ file");
                /*convert xml*/

                Integer idTran = contractService.editContract(item,trans, history).orElse(null);

                file.delete();
                return new ResponseEntity<Boolean>(true, HttpStatus.OK);
            }


        } catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<Integer> editContract(@RequestBody @Valid final Contract contract) {
        if (contract == null || contract.getid() == null || contract.getid() == 0)
            return new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT);
        Contract item=contractService.getContractById(contract.getid().toString()).orElse(null);
        if(item==null) return new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT);

        StringUtils.trimAllFieldOfObject(contract);
        item=contractService.genContractForEdit(item,contract).orElse(item);

        TransactionProperty trans = transactionPropertyService.getByContractId(item.getid().toString()).orElse(null);
        trans = contractService.genaralInfoToTransactionProperty(item, trans);
        ContractHistoryInfor history = new ContractHistoryInfor();
        history = contractService.genaralHistoryInfo(item, history, "Chỉnh sửa");

        Integer id = contractService.editContract(item,trans,history).orElse(null);

        if (id > 0) {
            //dong bo du lieu
            //set sys_status=0
            boolean ch = transactionPropertyService.updateSynchStatus(trans.getTpid(), Long.valueOf(0)).orElse(false);
            SynchronizeContractTag contractTag = contractService.genSynchronizeContractTagByTrans(trans, Constants.UPDATE_CONTRACT);
            List<SynchronizeContractTag> contractTags = new ArrayList<>();
            contractTags.add(contractTag);
            boolean checkSynch = contractService.synchronizeContractTags(contractTags);
            if (checkSynch) {
                ch = transactionPropertyService.updateSynchStatus(Long.valueOf(id), Long.valueOf(1)).orElse(false);
            }
        }

        return new ResponseEntity<Integer>(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public ResponseEntity<Integer> cancelContract(@RequestBody @Valid final Contract contract) {
        if (contract == null || contract.getid() == null || contract.getid() == 0)
            return new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT);
        StringUtils.trimAllFieldOfObject(contract);
        boolean checkContractNumber=checkContractNumber(contract.getContract_number());
        if(!checkContractNumber){
            return new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT);
        }
        Contract contractCancel = contractService.getContractById(contract.getid().toString()).orElse(null);

        TransactionProperty transOfContractCancel = transactionPropertyService.getByContractId(contractCancel.getid().toString()).orElse(null);
        if (contractCancel == null || transOfContractCancel == null)
            return new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT);
        contract.setId(null);

        TransactionProperty trans = new TransactionProperty();
        trans = contractService.genaralInfoToTransactionProperty(contract, trans);
        ContractHistoryInfor history = new ContractHistoryInfor();
        history = contractService.genaralHistoryInfo(contract, history, "Huỷ HĐ");
        /*convert xml*/

        Integer id = contractService.cancelContract(contractCancel.getid(), contract,trans,history).orElse(null);

        if (id > 0) {
            //update transactionOfCancel for syn to stp
            transOfContractCancel.setCancel_status(Long.valueOf(1));
            transOfContractCancel.setCancel_description("Đã hủy bởi hợp đồng số " + contract.getContract_number());
            transOfContractCancel.setUpdate_user_id(trans.getUpdate_user_id());
            transOfContractCancel.setUpdate_user_name(trans.getUpdate_user_name());
            transOfContractCancel.setSyn_status(0);
            //update syn_status of contract cancel=0
//            boolean check1=transactionPropertyService.updateSynchStatus(transOfContractCancel.getTpid(),Long.valueOf(0)).orElse(false);
            trans.setTpid(Long.valueOf(0));
            SynchronizeContractTag contractTag = contractService.genSynchronizeContractTagByTrans(trans, Constants.CREATE_CONTRACT);
            SynchronizeContractTag contractCancelSynch = contractService.genSynchronizeContractTagByTrans(transOfContractCancel, Constants.UPDATE_CONTRACT);
            ArrayList<SynchronizeContractTag> contractTags = new ArrayList<>();
            contractTags.add(contractTag);
            contractTags.add(contractCancelSynch);
            boolean check = contractService.synchronizeContractTags(contractTags);
            if (check) {
                boolean ch = transactionPropertyService.updateSynchStatus(Long.valueOf(id), Long.valueOf(1)).orElse(false);
                ch = transactionPropertyService.updateSynchStatus(transOfContractCancel.getTpid(), Long.valueOf(1)).orElse(false);
            }
        }

        return new ResponseEntity<Integer>(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteContract(@RequestParam @Valid final String id, @RequestParam @Valid final String userId) {
        Contract contract = contractService.getContractById(id).orElse(null);
        if (contract == null) {
            return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
        }
        ContractHistoryInfor history = new ContractHistoryInfor();
        history = contractService.genaralHistoryInfo(contract, history, "Xóa HĐ");
        history.setExecute_person(userId);
        /*convert xml*/
        XmlFriendlyNameCoder nameCoder = new XmlFriendlyNameCoder("ddd", "_");
        XStream xXStream = new XStream(new Dom4JDriver(nameCoder));
        xXStream.autodetectAnnotations(true);
        String xml_history = xXStream.toXML(history);
        Boolean status = contractService.deleteContract(contract.getid().toString(), xml_history);

        return new ResponseEntity<Boolean>(status, HttpStatus.OK);
    }


    @RequestMapping(value = "add-property", method = RequestMethod.POST)
    public ResponseEntity<Integer> addProperty() {
        return new ResponseEntity<Integer>(0, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-contract-by-id", method = RequestMethod.GET)
    public ResponseEntity<Contract> getContractById(@RequestParam final String id) {
        String functionName = "ContractController.getContractById()";
        ResponseEntity<Contract> respone = new ResponseEntity<Contract>(HttpStatus.NO_CONTENT);
        try {
            Contract result = contractService.getContractById(id).orElse(null);
//            if(!org.apache.commons.lang3.StringUtils.isBlank(result.getKindhtml())){
//                result.setKindhtml(result.getKindhtml().replaceAll("&lt;", "<"));
//                result.setKindhtml(result.getKindhtml().replaceAll("&gt;", ">"));
//                result.setKindhtml(result.getKindhtml().replaceAll("&amp;nbsp;", " "));
//            }

            respone = new ResponseEntity<Contract>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/get-property-by-contract-id", method = RequestMethod.GET)
    public ResponseEntity<Property> getPropertyByContractId(@RequestParam final String id) {
        String functionName = "ContractController.getPropertyByContractId()";
        ResponseEntity<Property> respone = new ResponseEntity<Property>(HttpStatus.NO_CONTENT);
        try {
            Property result = propertyService.getPropertyByContractId(id).orElse(null);
            respone = new ResponseEntity<Property>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/get-contract-template-by-id", method = RequestMethod.GET)
    public ResponseEntity<ContractTemplate> getContractTemplateByContractId(@RequestParam final String id) {
        String functionName = "ContractController.getContractTemplateById()";
        ResponseEntity<ContractTemplate> respone = new ResponseEntity<ContractTemplate>(HttpStatus.NO_CONTENT);
        try {
            ContractTemplate result = contractService.getContractTemplateById(id).orElse(null);
            respone = new ResponseEntity<ContractTemplate>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }
    @RequestMapping(value = "/get-contract-template-by-code-template", method = RequestMethod.GET)
    public ResponseEntity<ContractTemplate> getContractTemplateByCodeTemplate(@RequestParam final String code_temp) {
        String functionName = "ContractController.getContractTemplateByCodeTemplate()";
        ResponseEntity<ContractTemplate> respone = new ResponseEntity<ContractTemplate>(HttpStatus.NO_CONTENT);
        try {
            ContractTemplate result = contractService.getContractTemplateByCodeTemp(code_temp).orElse(null);
            respone = new ResponseEntity<ContractTemplate>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/get-contract-kind-by-contract-template-id", method = RequestMethod.GET)
    public ResponseEntity<ContractKind> getContractKindByContractTemplateId(@RequestParam final String id) {
        String functionName = "ContractController.getContractKindByContractTemplateId()";
        ResponseEntity<ContractKind> respone = new ResponseEntity<ContractKind>(HttpStatus.NO_CONTENT);
        try {
            ContractKind result = contractService.getContractKindByContractTempId(id).orElse(null);
            respone = new ResponseEntity<ContractKind>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/get-contract-kind-by-contract-template-code", method = RequestMethod.GET)
    public ResponseEntity<ContractKind> getContractKindByCode(@RequestParam final int code) {
        String functionName = "ContractController.getContractKindByCode()";
        ResponseEntity<ContractKind> respone = new ResponseEntity<ContractKind>(HttpStatus.NO_CONTENT);
        try {
            ContractKind result = contractService.getContractKindByContractTempCode(code).orElse(null);
            respone = new ResponseEntity<ContractKind>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }
    @RequestMapping(value = "/list-contract-kind", method = RequestMethod.GET)
    public ResponseEntity<List<ContractKind>> listContractKind() {
        String functionName = "ContractController.listContractKind()";
        ResponseEntity<List<ContractKind>> respone = new ResponseEntity<List<ContractKind>>(HttpStatus.NO_CONTENT);
        try {
            List<ContractKind> result = contractService.listContractKind().orElse(null);
            respone = new ResponseEntity<List<ContractKind>>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/list-contract-template-by-contract-kind", method = RequestMethod.GET)
    public ResponseEntity<List<ContractTemplate>> listContractTemplateByContractKind(@RequestParam final String id) {
        String functionName = "ContractController.listContractTemplateByContractKind()";
        ResponseEntity<List<ContractTemplate>> respone = new ResponseEntity<List<ContractTemplate>>(HttpStatus.NO_CONTENT);
        try {
            List<ContractTemplate> result = contractService.listContractTemplateByContractKindId(id).orElse(null);
            respone = new ResponseEntity<List<ContractTemplate>>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/list-contract-template-by-contract-kind-code",method=RequestMethod.GET)
    public ResponseEntity<List<ContractTemplate>> listContractTemplateByContractKindCode(@RequestParam final String code){
        String functionName="ContractController.listContractTemplateByContractKindCode()";
        ResponseEntity<List<ContractTemplate>> respone=new ResponseEntity<List<ContractTemplate>>(HttpStatus.NO_CONTENT);
        try{
            List<ContractTemplate> result= contractService.listContractTemplateByContractKindCode(code).orElse(null);
            respone=new ResponseEntity<List<ContractTemplate>>(result,HttpStatus.OK);
        }catch (Exception e){
            LOGGER.error("Method error "+functionName+ ": "+e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/list-contract-template-same-kind", method = RequestMethod.GET)
    public ResponseEntity<List<ContractTemplate>> listContractTemplateSameKind(@RequestParam final int code_temp) {
        String functionName = "ContractController.listContractTemplateSameKind()";
        ResponseEntity<List<ContractTemplate>> respone = new ResponseEntity<List<ContractTemplate>>(HttpStatus.NO_CONTENT);
        try {
            List<ContractTemplate> result = contractService.listContractTemplateSameKind(code_temp).orElse(null);
            respone = new ResponseEntity<List<ContractTemplate>>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/list-property-type", method = RequestMethod.GET)
    public ResponseEntity<List<PropertyType>> listPropertyType() {
        String functionName = "ContractController.listPropertyType()";
        ResponseEntity<List<PropertyType>> respone = new ResponseEntity<List<PropertyType>>(HttpStatus.NO_CONTENT);
        try {
            List<PropertyType> result = propertyService.listPropertyType().orElse(null);
            respone = new ResponseEntity<List<PropertyType>>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }

    /**
     * Khu vuc hop dong online
     *
     * @return
     */
    @RequestMapping(value = "/temporary/get-by-type", method = RequestMethod.GET)
    public ResponseEntity<List<TemporaryContract>> getTempoByType(@RequestParam final String type) {
        String functionName = "ContractController.getTempoByType()";
        ResponseEntity<List<TemporaryContract>> respone = new ResponseEntity<List<TemporaryContract>>(HttpStatus.NO_CONTENT);
        try {
            List<TemporaryContract> result = temporaryContractService.getTemporaryByType(type).orElse(null);
            respone = new ResponseEntity<List<TemporaryContract>>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/temporary/count-by-type", method = RequestMethod.GET)
    public ResponseEntity<BigInteger> countTempoByType(@RequestParam final String type) {
        String functionName = "ContractController.getTempoByType()";
        ResponseEntity<BigInteger> respone = new ResponseEntity<BigInteger>(BigInteger.valueOf(0), HttpStatus.NO_CONTENT);
        try {
            BigInteger result = temporaryContractService.countTemporaryByType(type).orElse(BigInteger.valueOf(0));
            respone = new ResponseEntity<BigInteger>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }


    @RequestMapping(value = "/temporary/get-by-filter", method = RequestMethod.GET)
    public ResponseEntity<List<TemporaryContract>> getTempoByFilter(@RequestParam final String filter) {
        String functionName = "ContractController.getTempoByFilter()";
        ResponseEntity<List<TemporaryContract>> respone = new ResponseEntity<List<TemporaryContract>>(HttpStatus.NO_CONTENT);
        try {
            List<TemporaryContract> result = temporaryContractService.getTemporaryByFilter(filter).orElse(null);
            respone = new ResponseEntity<List<TemporaryContract>>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/list-contract-template", method = RequestMethod.GET)
    public ResponseEntity<List<ContractTemplate>> listContractTemplate() {
        String functionName = "ContractController.listContractTemplate()";
        ResponseEntity<List<ContractTemplate>> respone = new ResponseEntity<List<ContractTemplate>>(HttpStatus.NO_CONTENT);
        try {
            List<ContractTemplate> result = contractService.listContractTemplate().orElse(null);
            respone = new ResponseEntity<List<ContractTemplate>>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/temporary", method = RequestMethod.GET)
    public ResponseEntity<TemporaryContract> getTemporaryById(@RequestParam final String id) {
        String functionName = "ContractController.getTemporaryById()";
        ResponseEntity<TemporaryContract> respone = new ResponseEntity<TemporaryContract>(HttpStatus.NO_CONTENT);
        try {
            TemporaryContract result = temporaryContractService.getTemporaryById(id).orElse(null);
            if(result==null || result.getTcid()==null) return new ResponseEntity<TemporaryContract>(HttpStatus.NO_CONTENT);

            respone = new ResponseEntity<TemporaryContract>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Method error " + functionName + ": " + e.getMessage());
        }
        return respone;
    }

    @RequestMapping(value = "/temporary", method = RequestMethod.POST)
    public ResponseEntity<Integer> addTemporary(@RequestBody @Valid final TemporaryContract temporary) {
        if (temporary == null) return new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT);
        StringUtils.trimAllFieldOfObject(temporary);
        boolean checkContractNumber=checkContractNumber(temporary.getContract_number());
        if(!checkContractNumber){
            return new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT);
        }
        Integer id = temporaryContractService.addTemporary(temporary).orElse(null);
        return id == null ? new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT) : new ResponseEntity<Integer>(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/temporary", method = RequestMethod.PUT)
    public ResponseEntity<Integer> editTemporary(@RequestBody @Valid final TemporaryContract temporary) {
        if (temporary == null || temporary.getTcid()==null || temporary.getTcid()==0) return new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT);
        TemporaryContract item=temporaryContractService.getTemporaryById(temporary.getTcid().toString()).orElse(null);
        if(item==null || item.getTcid()==null) return new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT);
        StringUtils.trimAllFieldOfObject(temporary);

        Integer id = temporaryContractService.editTemporary(temporary).orElse(null);
        return new ResponseEntity<Integer>(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/temporary/mark", method = RequestMethod.PUT)
    public ResponseEntity<Integer> markTemporary(@RequestBody @Valid final TemporaryContract temporary) {
        if (temporary == null|| temporary.getTcid()==null || temporary.getTcid()==0) return new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT);
        TemporaryContract item=temporaryContractService.getTemporaryById(temporary.getTcid().toString()).orElse(null);
        if(item==null || item.getTcid()==null) return new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT);
        StringUtils.trimAllFieldOfObject(temporary);
        Contract contract = temporaryContractService.genContractFromTemporary(temporary);
        TransactionProperty trans = new com.vn.osp.notarialservices.transaction.dto.TransactionProperty();
        trans = contractService.genaralInfoToTransactionProperty(contract, trans);
        ContractHistoryInfor history = new ContractHistoryInfor();
        history = contractService.genaralHistoryInfo(contract, history, "Đăng ký");
        Long id = temporaryContractService.addTemporaryMark(temporary.getTcid(), contract, trans, history).orElse(null);
        if (id > 0) {
            //dong bo du lieu
            SynchronizeContractTag contractTag = contractService.genSynchronizeContractTagByTrans(trans, Constants.CREATE_CONTRACT);
            List<SynchronizeContractTag> contractTags = new ArrayList<>();
            contractTags.add(contractTag);
            boolean checkSynch = contractService.synchronizeContractTags(contractTags);
            if (checkSynch) {
                boolean ch = transactionPropertyService.updateSynchStatus(Long.valueOf(id), Long.valueOf(1)).orElse(false);
            }
        }


        return new ResponseEntity<Integer>(Integer.valueOf(id.intValue()), HttpStatus.OK);
    }

    @RequestMapping(value = "/temporary", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteTemporary(@RequestParam @Valid final String id) {
        if (id == null || id.equals("") || !EditString.isNumber(id)) {
            return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
        }
        Boolean status = temporaryContractService.deleteTemporary(Long.valueOf(id));
        return new ResponseEntity<Boolean>(status, HttpStatus.OK);
    }

    @RequestMapping(value = "/temporary/remove", method = RequestMethod.GET)
    public ResponseEntity<Boolean> removeFileonline(@RequestParam @Valid final String id) {
        try {
            TemporaryContract item=temporaryContractService.getTemporaryById(id.toString()).orElse(null);
            if(item==null) return new ResponseEntity<Boolean>(false, HttpStatus.OK);
            File file = new File(item.getFile_path());
            if (!file.exists()) {
                return new ResponseEntity<Boolean>(false, HttpStatus.OK);
            }else{
                item.setFile_name("");
                item.setFile_path("");
                Integer idTem = temporaryContractService.editTemporary(item).orElse(null);
                file.delete();
                return new ResponseEntity<Boolean>(true, HttpStatus.OK);
            }
        } catch(Exception e){
        }
        return new ResponseEntity<Boolean>(false, HttpStatus.OK);
    }

    @RequestMapping(value = "/temporary/download/{id}", method = RequestMethod.GET)
    public void downloadFileOnline(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        try {
            TemporaryContract item=temporaryContractService.getTemporaryById(id.toString()).orElse(null);
            if(item==null) return;
            File file = new File(item.getFile_path());
            if (!file.exists()) {
                String errorMessage = "Sorry. The file you are looking for does not exist";
                OutputStream outputStream = response.getOutputStream();
                outputStream.write(errorMessage.getBytes());
                outputStream.close();
                return;
            }
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + item.getFile_name() + "\""));
            response.setContentLength((int) file.length());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
            inputStream.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    @RequestMapping(value = "/selectReportByContractError", method = RequestMethod.POST)
    public ResponseEntity<List<ContractError>> getReportContractError(@RequestBody @Valid final String stringFilter) {
        List<ContractError> result = contractService.getReportContractError(stringFilter);
        return new ResponseEntity<List<ContractError>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/selectReportByContractAdditional", method = RequestMethod.POST)
    public ResponseEntity<List<ContractAdditional>> getReportContractAdditional(@RequestBody @Valid final String stringFilter) {
        List<ContractAdditional> result = contractService.getReportContractAdditional(stringFilter);
        return new ResponseEntity<List<ContractAdditional>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/selectReportByContractCertify", method = RequestMethod.POST)
    public ResponseEntity<List<ContractCertify>> getReportContractCertify(@RequestBody @Valid final String stringFilter) {
        List<ContractCertify> result = contractService.getReportContractCertify(stringFilter);
        return new ResponseEntity<List<ContractCertify>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/contractStatisticsDrafter", method = RequestMethod.POST)
    public ResponseEntity<List<ContractStastics>> getContractStatisticsDrafter(@RequestBody @Valid final NotaryDateFilter notaryDateFilter) {
        List<ContractStastics> result = contractService.getContractStasticsDrafter(notaryDateFilter.getNotaryDateFromFilter(), notaryDateFilter.getNotaryDateToFilter());
        return new ResponseEntity<List<ContractStastics>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/contractStatisticsNotary", method = RequestMethod.POST)
    public ResponseEntity<List<ContractStastics>> getContractStatisticsNotary(@RequestBody @Valid final NotaryDateFilter notaryDateFilter) {
        List<ContractStastics> result = contractService.getContractStasticsNotary(notaryDateFilter.getNotaryDateFromFilter(), notaryDateFilter.getNotaryDateToFilter());
        return new ResponseEntity<List<ContractStastics>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/contractStatisticsBank", method = RequestMethod.POST)
    public ResponseEntity<List<ContractStasticsBank>> getContractStatisticsBank(@RequestBody @Valid final NotaryDateFilter notaryDateFilter) {
        List<ContractStasticsBank> result = contractService.getContractStasticsBank(notaryDateFilter.getNotaryDateFromFilter(), notaryDateFilter.getNotaryDateToFilter());
        return new ResponseEntity<List<ContractStasticsBank>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/AddContractKind", method = RequestMethod.POST)
    public ResponseEntity<Boolean> ContractKindAdd(@RequestBody @Valid final AddContractKind addContractKind) {


        return new ResponseEntity<Boolean>((Boolean) contractKindService.ContractKindAdd(addContractKind.getId(),addContractKind.getName(), addContractKind.getUpdate_user_id(), addContractKind.getUpdate_user_name(), addContractKind.getCode()).orElse(Boolean.valueOf(false)), HttpStatus.OK);
    }

    @RequestMapping(value = "/UpdateContractKind", method = RequestMethod.POST)
    public ResponseEntity<Boolean> UpdateContractKind(@RequestBody @Valid final UpdateContractKind updateContractKind) {
        return new ResponseEntity<Boolean>((Boolean) contractKindService.UpdateContractKind(updateContractKind.getCkId(), updateContractKind.getName(), updateContractKind.getUpdate_user_id(), updateContractKind.getUpdate_user_name(), updateContractKind.getContract_kind_code()).orElse(Boolean.valueOf(false)), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteContractKind", method = RequestMethod.POST)
    public ResponseEntity<Boolean> deleteProvince(@RequestBody @Valid final Long id) {
        return new ResponseEntity<Boolean>((Boolean) contractKindService.deleteContractKind(id).orElse(Boolean.valueOf(false)), HttpStatus.OK);
    }

    @RequestMapping(value = "/findContractKindByFilter", method = RequestMethod.POST)
    public ResponseEntity<List<ContractKind>> findContractKindByFilter(@RequestBody final String stringFilter) {
        List<ContractKind> contractKinds = contractKindService.findContractKindByFilter(stringFilter).orElse(new ArrayList<ContractKind>());
        return new ResponseEntity<List<ContractKind>>(contractKinds, HttpStatus.OK);
    }

    @RequestMapping(value = "/countContractKindByFilter", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countContractKindByFilter(@RequestBody final String stringFilter) {
        BigInteger result = contractKindService.countContractKindByFilter(stringFilter).orElse(BigInteger.valueOf(0));

        return new ResponseEntity<BigInteger>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/countTemporaryBySearch", method = RequestMethod.GET)
    public ResponseEntity<BigInteger> countTemporaryBySearch(@RequestParam final String search, @RequestParam final String type) {

        /*for search*/
        String stringFilter = temporaryContractService.getStringFilterFromSearch(search, type);

        BigInteger transactionByFilter = temporaryContractService.countTemporaryByFilter(stringFilter).orElse(BigInteger.valueOf(0));
        return new ResponseEntity<BigInteger>(transactionByFilter, HttpStatus.OK);
    }

    @RequestMapping(value = "/temporarysBySearch", method = RequestMethod.GET)
    public ResponseEntity<List<TemporaryContract>> temporarysBySearch(@RequestParam final String search, @RequestParam final String type, @RequestParam final int offset, @RequestParam final int number) {

        String stringFilter = temporaryContractService.getStringFilterFromSearch(search, type);

        if (number > 0) {
            stringFilter += "limit " + offset + "," + number + " ";
        } else {
            stringFilter += "limit 0,25 ";
        }

        List<TemporaryContract> temporaryContracts = temporaryContractService.getTemporaryByFilter(stringFilter).orElse(null);
        return new ResponseEntity<List<TemporaryContract>>(temporaryContracts, HttpStatus.OK);
    }


    @RequestMapping(value = "/checkContractNumber", method = RequestMethod.GET)
    public ResponseEntity<Boolean> checkAddContractNumber(@RequestParam final String contract_number) {
        try{
            BigInteger count = contractService.countByContractNumber(contract_number).orElse(BigInteger.valueOf(0));
            if (count.compareTo(BigInteger.valueOf(0)) > 0) {
                return new ResponseEntity<Boolean>(false, HttpStatus.OK);
            } else {
                BigInteger countOnline = temporaryContractService.countTemporaryByFilter("where contract_number='" + contract_number+"'").orElse(BigInteger.valueOf(0));
                if (countOnline.compareTo(BigInteger.valueOf(0)) > 0) {
                    return new ResponseEntity<Boolean>(false, HttpStatus.OK);
                }else if(countOnline.compareTo(BigInteger.valueOf(0)) == 0){
                    return new ResponseEntity<Boolean>(true, HttpStatus.OK);
                }
            }
        }catch (Exception e){
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);
        }
        return new ResponseEntity<Boolean>(false,HttpStatus.OK);
    }

    private boolean checkContractNumber(String contract_number) {
        try{
            BigInteger count = contractService.countByContractNumber(contract_number).orElse(BigInteger.valueOf(0));
            if (count.compareTo(BigInteger.valueOf(0)) > 0) {
                return false;
            } else {
                BigInteger countOnline = temporaryContractService.countTemporaryByFilter("where contract_number='" + contract_number+"'").orElse(BigInteger.valueOf(0));
                if (countOnline.compareTo(BigInteger.valueOf(0)) > 0) {
                   return false;
                }else if(countOnline.compareTo(BigInteger.valueOf(0)) == 0){
                    return true;
                }
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }



}
