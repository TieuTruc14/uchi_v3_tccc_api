package com.vn.osp.notarialservices.contract.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by tranv on 12/28/2016.
 */

public class ReportByGroupTotalList {
    @JsonIgnore
    public static final String SESSION_KEY = "ReportByGroupTotalList";
    @JsonIgnore
    private List<ReportByGroupTotal> reportByGroupTotals;
    @JsonProperty
    private long total;
    @JsonProperty
    private String notaryDateFromFilter;
    @JsonProperty
    private String notaryDateToFilter;
    @JsonProperty
    private String timeType;
    @JsonProperty
    private int page;
    @JsonProperty
    private String fromDate;
    @JsonProperty
    private String toDate;
    @JsonProperty
    private int kindId;

    @JsonProperty
    private int contractListNumber;
    @JsonProperty
    private int totalPage;

    @JsonIgnore
    private List<ContractKind> contractKinds;
    @JsonIgnore
    private List<ContractTemplate> contractTemplates;

    @JsonProperty
    private String codeTemplate;
    @JsonProperty
    private String nhomHD;
    @JsonProperty
    private String tenHD;
    @JsonProperty
    private String source;
    @JsonProperty
    private String donVi;

    public ReportByGroupTotalList() {
    }

    public ReportByGroupTotalList(long total, String notaryDateFromFilter, String notaryDateToFilter, int page, String fromDate, String toDate, int kindId, int totalPage, String nhomHD, String tenHD, String source, String donVi) {
        this.total = total;
        this.notaryDateFromFilter = notaryDateFromFilter;
        this.notaryDateToFilter = notaryDateToFilter;
        this.page = page;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.kindId = kindId;
        this.totalPage = totalPage;
        this.nhomHD = nhomHD;
        this.tenHD = tenHD;
        this.source = source;
        this.donVi = donVi;
    }

    public String getCodeTemplate() {
        return codeTemplate;
    }

    public void setCodeTemplate(String codeTemplate) {
        this.codeTemplate = codeTemplate;
    }

    public List<ReportByGroupTotal> getReportByGroupTotals() {
        return reportByGroupTotals;
    }

    public void setReportByGroupTotals(List<ReportByGroupTotal> reportByGroupTotals) {
        this.reportByGroupTotals = reportByGroupTotals;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getNotaryDateFromFilter() {
        return notaryDateFromFilter;
    }

    public void setNotaryDateFromFilter(String notaryDateFromFilter) {
        this.notaryDateFromFilter = notaryDateFromFilter;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getNotaryDateToFilter() {
        return notaryDateToFilter;
    }

    public void setNotaryDateToFilter(String notaryDateToFilter) {
        this.notaryDateToFilter = notaryDateToFilter;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getKindId() {
        return kindId;
    }

    public void setKindId(int kindId) {
        this.kindId = kindId;
    }


    public int getContractListNumber() {
        return contractListNumber;
    }

    public void setContractListNumber(int contractListNumber) {
        this.contractListNumber = contractListNumber;
    }

    public List<ContractKind> getContractKinds() {
        return contractKinds;
    }

    public void setContractKinds(List<ContractKind> contractKinds) {
        this.contractKinds = contractKinds;
    }

    public List<ContractTemplate> getContractTemplates() {
        return contractTemplates;
    }

    public void setContractTemplates(List<ContractTemplate> contractTemplates) {
        this.contractTemplates = contractTemplates;
    }

    public String getNhomHD() {
        return nhomHD;
    }

    public void setNhomHD(String nhomHD) {
        this.nhomHD = nhomHD;
    }

    public String getTenHD() {
        return tenHD;
    }

    public void setTenHD(String tenHD) {
        this.tenHD = tenHD;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

}
