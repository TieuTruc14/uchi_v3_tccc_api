package com.vn.osp.notarialservices.transaction.controller;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.vn.osp.notarialservices.systemmanager.service.AccessHistoryService;
import com.vn.osp.notarialservices.transaction.dto.*;
import com.vn.osp.notarialservices.transaction.service.TransactionPropertyService;
import net.sf.jett.transform.ExcelTransformer;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by minh on 11/24/2016.
 */
@Controller
@RequestMapping(value = "/transaction")
public class TransactionPropertyController {
    private static final Logger LOGGER = Logger.getLogger(TransactionPropertyController.class);

    private final TransactionPropertyService transactionPropertyService;
    private final TransactionPropertyControllerHateoasBuilder transactionControllerHateoasBuilder;
    private final AccessHistoryService accessHistoryService;

    @Autowired
    public TransactionPropertyController(final TransactionPropertyService transactionPropertyService, final TransactionPropertyControllerHateoasBuilder transactionControllerHateoasBuilder,
                                         final AccessHistoryService accessHistoryService) {
        this.transactionPropertyService = transactionPropertyService;
        this.transactionControllerHateoasBuilder = transactionControllerHateoasBuilder;
        this.accessHistoryService=accessHistoryService;
    }

    @RequestMapping(value = "/addTransactionProperty", method = RequestMethod.POST)
    public ResponseEntity<Boolean> addTransaction(@RequestBody final TransactionProperty transactionProperty) {
        if(transactionProperty.getContract_id() == null ) transactionProperty.setContract_id(Long.valueOf(0));
        //check exits
        String filter = " where contract_number like '"+transactionProperty.getContract_number()+"' and contract_kind ="+transactionProperty.getContract_kind() +" and synchronize_id like '"+transactionProperty.getSynchronize_id()+"'";
        List<TransactionProperty> transactionProperties = transactionPropertyService.findTransactionByFilter(filter).orElse(null);
        if(transactionProperties.size() > 0) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }

        XmlFriendlyReplacer replacer = new XmlFriendlyReplacer("ddd", "_");
        XStream xXStream = new XStream(new DomDriver("UTF-8", replacer));
        xXStream.autodetectAnnotations(true);
        // OBJECT --> XML
        String transactionProperty_content = xXStream.toXML(transactionProperty);
        Boolean result = transactionPropertyService.addTransactionProperty(transactionProperty_content).orElse(false);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }
    @RequestMapping(value = "/synchronize-ok", method = RequestMethod.POST)
    public ResponseEntity<Boolean> synchronizeOK(@RequestBody final SynchonizeContractKey synchonizeContractKey) {
        Boolean result = transactionPropertyService.synchronizeOk(synchonizeContractKey.getNotaryOfficeCode(), Integer.parseInt(synchonizeContractKey.getContractKindCode()), synchonizeContractKey.getContractNumber()).orElse(false);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/findTransactionByFilter", method = RequestMethod.POST)
    public ResponseEntity<List<TransactionProperty>> findTransactionByFilter(@RequestBody final String stringFilter) {
        List<TransactionProperty> transactionByFilter = transactionPropertyService.findTransactionByFilter(stringFilter).orElse(new ArrayList<TransactionProperty>());
        return new ResponseEntity<List<TransactionProperty>>(transactionByFilter, HttpStatus.OK);
    }

    @RequestMapping(value = "/countTotalByFilter", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countTotalByFilter(@RequestBody final String stringFilter) {
        BigInteger transactionByFilter = transactionPropertyService.countTotalByFilter(stringFilter).orElse(BigInteger.valueOf(0));
        return new ResponseEntity<BigInteger>(transactionByFilter, HttpStatus.OK);
    }

    //minhbq
    @RequestMapping(value="/findTransactionByBank", method = RequestMethod.POST)
    public ResponseEntity<List<TransactionProperty>> findTransactionByBank(@RequestBody final ContractByBank contractByBank, @RequestParam(name="numOffset") Integer numOffset, @RequestParam(name="numLimit") Integer numLimit) {

        List<TransactionProperty> findTransactionByBank = transactionPropertyService.findTransactionByBank(contractByBank.getBankname(),contractByBank.getNotaryDateFromFilter(), contractByBank.getNotaryDateToFilter(),numOffset,numLimit).orElse(new ArrayList<TransactionProperty>());
        return new ResponseEntity<List<TransactionProperty>>(findTransactionByBank, HttpStatus.OK);
    }
    @RequestMapping(value = "/countTotalContractByBank", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countTotalContractByBank( @RequestBody final ContractByBank contractByBank)  {
        BigInteger result = transactionPropertyService.countTotalContractByBank(contractByBank.getBankname(),contractByBank.getNotaryDateFromFilter(), contractByBank.getNotaryDateToFilter()).orElse(BigInteger.valueOf(0));
        return new ResponseEntity<BigInteger>(result, HttpStatus.OK);

    }
    @RequestMapping(value="/findNotary", method = RequestMethod.POST)
    public ResponseEntity<List<NotaryName>> selectNotary(@RequestBody String notaryOffice) {
        List<NotaryName> selectNotary = transactionPropertyService.selectNotary(notaryOffice);
        return new ResponseEntity<List<NotaryName>>(selectNotary, HttpStatus.OK);
    }
    @RequestMapping(value="/selectVPCC", method = RequestMethod.POST)
    public ResponseEntity<List<TransactionNotaryOfficeName>> selectVPCC() {

        List<TransactionNotaryOfficeName> selectVPCC = transactionPropertyService.selectVPCC();
        return new ResponseEntity<List<TransactionNotaryOfficeName>>(selectVPCC, HttpStatus.OK);
    }
    @RequestMapping(value="/selectReportByNotary", method = RequestMethod.POST)
    public ResponseEntity<List<TransactionProperty>> selectReportByNotary(@RequestBody final ContractByNotary contractByNotary, @RequestParam(name="numOffset") Integer numOffset, @RequestParam(name="numLimit") Integer numLimit) {
        List<TransactionProperty> selectReportByNotary = transactionPropertyService.selectReportByNotary(contractByNotary.getNotary_office_name(),contractByNotary.getNotary_person(),contractByNotary.getNotaryDateFromFilter(), contractByNotary.getNotaryDateToFilter(),numOffset,numLimit).orElse(new ArrayList<TransactionProperty>());
        return new ResponseEntity<List<TransactionProperty>>(selectReportByNotary, HttpStatus.OK);
    }
    @RequestMapping(value = "/countTotalReportByNotary", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countTotalReportByNotary( @RequestBody final ContractByNotary contractByNotary)  {
        BigInteger result = transactionPropertyService.countTotalReportByNotary( contractByNotary.getNotary_office_name(),contractByNotary.getNotary_person(),contractByNotary.getNotaryDateFromFilter(), contractByNotary.getNotaryDateToFilter()).orElse(BigInteger.valueOf(0));
        return new ResponseEntity<BigInteger>(result, HttpStatus.OK);

    }
    @RequestMapping(value="/selectEntryUserName", method = RequestMethod.POST)
    public ResponseEntity<List<EntryUserName>> selectEntryUserName(@RequestBody String notaryOffice) {

        List<EntryUserName> entryUserNames = transactionPropertyService.selectEntryUserName(notaryOffice);
        return new ResponseEntity<List<EntryUserName>>(entryUserNames, HttpStatus.OK);
    }
    @RequestMapping(value="/selectReportByUser", method = RequestMethod.POST)
    public ResponseEntity<List<TransactionProperty>> selectReportByUser(  @RequestBody final ContractByUser contractByUser,@RequestParam(name="numOffset") Integer numOffset, @RequestParam(name="numLimit") Integer numLimit) {
        List<TransactionProperty> selectReportByUser = transactionPropertyService.selectReportByUser(contractByUser.getNotary_office_name(),contractByUser.getEntry_user_name(),contractByUser.getNotaryDateFromFilter(), contractByUser.getNotaryDateToFilter(),numOffset,numLimit).orElse(new ArrayList<TransactionProperty>());
        return new ResponseEntity<List<TransactionProperty>>(selectReportByUser, HttpStatus.OK);
    }
    @RequestMapping(value = "/countTotalReportByUser", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countTotalReportByUser( @RequestBody final ContractByUser contractByUser)  {
        BigInteger result = transactionPropertyService.countTotalReportByUser( contractByUser.getNotary_office_name(),contractByUser.getEntry_user_name(),contractByUser.getNotaryDateFromFilter(), contractByUser.getNotaryDateToFilter()).orElse(BigInteger.valueOf(0));
        return new ResponseEntity<BigInteger>(result, HttpStatus.OK);
    }
    @RequestMapping(value="/selectContractCertify", method = RequestMethod.POST)
    public ResponseEntity<List<TransactionProperty>> selectContractCertify(@RequestParam(name="contractKind") String contractKind, @RequestBody NotaryDateFilter notaryDateFilter) {
        List<TransactionProperty> selectReportByUser = transactionPropertyService.selectContractCertify(contractKind ,notaryDateFilter.getNotaryDateFromFilter(),notaryDateFilter.getNotaryDateToFilter()).orElse(new ArrayList<TransactionProperty>());
        return new ResponseEntity<List<TransactionProperty>>(selectReportByUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-by-contract-id", method = RequestMethod.GET)
    public ResponseEntity<TransactionProperty> getByContractId(@RequestParam final String id) {
        TransactionProperty trans = transactionPropertyService.getByContractId(id).orElse(null);
        return new ResponseEntity<TransactionProperty>(trans, HttpStatus.OK);
    }

    @RequestMapping(value = "/countTrans", method = RequestMethod.GET)
    public ResponseEntity<BigInteger> countTransByFilter(@RequestParam final String stringFilter) {
        BigInteger transactionByFilter = transactionPropertyService.countTotalByFilter(stringFilter).orElse(BigInteger.valueOf(0));
        return new ResponseEntity<BigInteger>(transactionByFilter, HttpStatus.OK);
    }

    @RequestMapping(value = "/countTransBySearch", method = RequestMethod.GET)
    public ResponseEntity<BigInteger> countTransBySearch(@RequestParam final String search,@RequestParam final String syn_status) {

        String stringFilter="";
        /*for search*/
        String result=transactionPropertyService.getStringFilterFromSearch(search,syn_status);
        if(!StringUtils.isBlank(result)){
            stringFilter=result;
        }

        BigInteger transactionByFilter = transactionPropertyService.countTotalByFilter(stringFilter).orElse(BigInteger.valueOf(0));
        return new ResponseEntity<BigInteger>(transactionByFilter, HttpStatus.OK);
    }

    @RequestMapping(value = "/transactionsByFilter", method = RequestMethod.GET)
    public ResponseEntity<List<TransactionProperty>> transactionsByFilter(@RequestParam final String stringFilter) {
        List<TransactionProperty> transactionByFilter = transactionPropertyService.findTransactionByFilter(stringFilter).orElse(new ArrayList<TransactionProperty>());
        return new ResponseEntity<List<TransactionProperty>>(transactionByFilter, HttpStatus.OK);
    }

    @RequestMapping(value = "/transactionsBySearch", method = RequestMethod.GET)
    public ResponseEntity<List<TransactionProperty>> transactionsBySearch(@RequestParam final String search,@RequestParam final String syn_status,@RequestParam final int offset,@RequestParam final int number) {

        String stringFilter=transactionPropertyService.getStringFilterFromSearch(search,syn_status);

        if(number>0){
                stringFilter+="limit "+offset+","+number +" ";
        }else{
            stringFilter+="limit 0,25 ";
        }

        List<TransactionProperty> transactionByFilter = transactionPropertyService.findTransactionByFilter(stringFilter).orElse(new ArrayList<TransactionProperty>());
        return new ResponseEntity<List<TransactionProperty>>(transactionByFilter, HttpStatus.OK);
    }


    @RequestMapping(value = "/download/contract-by-search", method = RequestMethod.GET)
    public void downloadContractBySearch(@RequestParam final String search, HttpServletResponse response, HttpServletRequest request) {
        try {
            String stringFilter=transactionPropertyService.getStringFilterFromSearch(search,"2");
            List<TransactionProperty> items = transactionPropertyService.findTransactionByFilter(stringFilter).orElse(new ArrayList<TransactionProperty>());

            Map<String, Object> beans = new HashMap<String, Object>();
           for(int i=0;i<items.size();i++){
               if(!StringUtils.isBlank(items.get(i).getRelation_object())){
                   items.get(i).setRelation_object(items.get(i).getRelation_object().replaceAll("(\\\\r\\\\n|\\\\n)","\n"));
               }
               if(!StringUtils.isBlank(items.get(i).getTransaction_content())){
                   items.get(i).setTransaction_content("Nội dung hợp đồng: "+items.get(i).getTransaction_content().replaceAll("(\\\\r\\\\n|\\\\n)","\n"));
               }
               if(!StringUtils.isBlank(items.get(i).getProperty_info())){
                   items.get(i).setProperty_info("\nThông tin tài sản: "+items.get(i).getProperty_info().replaceAll("(\\\\r\\\\n|\\\\n)","\n"));
               }
               items.get(i).setTransaction_content(items.get(i).getTransaction_content()+" "+items.get(i).getProperty_info());
           }
            beans.put("report", items);
            beans.put("total",items.size());
            Date date = new Date(); // your date
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH)+1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            beans.put("year", year);
            beans.put("month", month);
            beans.put("day", day);

            String office_name=accessHistoryService.getConfigValue("notary_office_name").orElse(null);
            beans.put("agency",office_name);
            /*Resource ClassPathResource se lay dc thu muc resource trong project, ngay ca khi chay app*/
            Resource resource = new ClassPathResource("file/report/BaocaoHDCC.xls");
//            File file = resource.getFile();
//            File directory = new File("src/main/resources/file/report/BaocaoHDCC.xls");
//            InputStream fileIn = new BufferedInputStream(new FileInputStream( file.getAbsolutePath()));
//            InputStream fileIn = new BufferedInputStream(new FileInputStream( resource.getInputStream()));

            InputStream fileIn = resource.getInputStream();

            ExcelTransformer transformer = new ExcelTransformer();
            Workbook workbook = transformer.transform(fileIn, beans);

            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=" + "BaoCaoHDCC.xls");
            ServletOutputStream out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();

        } catch(Exception e){
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/reportByBank", method = RequestMethod.POST)

    public ResponseEntity<List<ReportByBank>> reportBank(@RequestBody final String stringFilter) {
        List<ReportByBank> reportByBanks = transactionPropertyService.reportByBank(stringFilter);
        return new ResponseEntity<List<ReportByBank>>(reportByBanks, HttpStatus.OK);
    }
    @RequestMapping(value = "/countTotalReportBank", method = RequestMethod.POST)
    public ResponseEntity<BigInteger> countTotalReportBank(@RequestBody final String stringFilter) {
        BigInteger transactionByFilter = transactionPropertyService.countTotalReportBank(stringFilter).orElse(BigInteger.valueOf(0));
        return new ResponseEntity<BigInteger>(transactionByFilter, HttpStatus.OK);
    }
}
