package com.vn.osp.notarialservices.contract.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vn.osp.notarialservices.utils.TimeUtil;


import java.util.Date;

/**
 * Created by tranv on 12/28/2016.
 */

public class ReportByTT20List {
    @JsonIgnore
    public static final String SESSION_KEY = "ReportByTT20List";
    @JsonProperty
    private String notaryDateFromFilter;
    @JsonProperty
    private String notaryDateToFilter;
    @JsonProperty
    private String timeType;
    @JsonProperty
    private String fromDate;
    @JsonProperty
    private String toDate;
    @JsonProperty
    private int numberOfNotaryPerson;
    @JsonProperty
    private int numberOfTotalContract;
    @JsonProperty
    private int numberOfContractLand;
    @JsonProperty
    private int numberOfContractOther;
    @JsonProperty
    private int numberOfContractDanSu;
    @JsonProperty
    private int numberOfThuaKe;
    @JsonProperty
    private int numberOfOther;
    @JsonProperty
    private long tongPhiCongChung;
    @JsonProperty
    private int tongNopNganSach;

    public ReportByTT20List() {
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

    public int getNumberOfNotaryPerson() {
        return numberOfNotaryPerson;
    }

    public void setNumberOfNotaryPerson(int numberOfNotaryPerson) {
        this.numberOfNotaryPerson = numberOfNotaryPerson;
    }

    public int getNumberOfTotalContract() {
        return numberOfTotalContract;
    }

    public void setNumberOfTotalContract(int numberOfTotalContract) {
        this.numberOfTotalContract = numberOfTotalContract;
    }

    public int getNumberOfContractLand() {
        return numberOfContractLand;
    }

    public void setNumberOfContractLand(int numberOfContractLand) {
        this.numberOfContractLand = numberOfContractLand;
    }

    public int getNumberOfContractOther() {
        return numberOfContractOther;
    }

    public void setNumberOfContractOther(int numberOfContractOther) {
        this.numberOfContractOther = numberOfContractOther;
    }

    public int getNumberOfContractDanSu() {
        return numberOfContractDanSu;
    }

    public void setNumberOfContractDanSu(int numberOfContractDanSu) {
        this.numberOfContractDanSu = numberOfContractDanSu;
    }

    public int getNumberOfThuaKe() {
        return numberOfThuaKe;
    }

    public void setNumberOfThuaKe(int numberOfThuaKe) {
        this.numberOfThuaKe = numberOfThuaKe;
    }

    public int getNumberOfOther() {
        return numberOfOther;
    }

    public void setNumberOfOther(int numberOfOther) {
        this.numberOfOther = numberOfOther;
    }

    public long getTongPhiCongChung() {
        return tongPhiCongChung;
    }

    public void setTongPhiCongChung(long tongPhiCongChung) {
        this.tongPhiCongChung = tongPhiCongChung;
    }

    public int getTongNopNganSach() {
        return tongNopNganSach;
    }

    public void setTongNopNganSach(int tongNopNganSach) {
        this.tongNopNganSach = tongNopNganSach;
    }

    public void createFromToDate(){
        if(this.timeType == null || this.timeType.equals("")){
            this.timeType = "03";
        }
        if(timeType.equals("01")){
            this.notaryDateFromFilter = TimeUtil.toTimestamp(true, TimeUtil.getDay(new Date())).toString();
            this.notaryDateToFilter = TimeUtil.toTimestamp(false,TimeUtil.getDay(new Date())).toString();

            fromDate = TimeUtil.convertTimeStampToString(TimeUtil.toTimestamp(true,TimeUtil.getDay(new Date())));
            toDate = TimeUtil.convertTimeStampToString(TimeUtil.toTimestamp(false,TimeUtil.getDay(new Date())));
        } else if(timeType.equals("02")){
            this.notaryDateFromFilter = TimeUtil.toTimestamp(true,TimeUtil.getDateByFirstDayOfWeek(new Date())).toString();
            this.notaryDateToFilter = TimeUtil.toTimestamp(false,TimeUtil.getDateByLastDayOfWeek(new Date())).toString();

            fromDate = TimeUtil.convertTimeStampToString(TimeUtil.toTimestamp(true,TimeUtil.getDateByFirstDayOfWeek(new Date())));
            toDate =  TimeUtil.convertTimeStampToString(TimeUtil.toTimestamp(false,TimeUtil.getDateByLastDayOfWeek(new Date())));
        } else if(timeType.equals("03")){
            this.notaryDateFromFilter = TimeUtil.toTimestamp(true,TimeUtil.getDateByFirstDayOfMonth(new Date())).toString();
            this.notaryDateToFilter = TimeUtil.toTimestamp(false,TimeUtil.getDateByLastDayOfMonth(new Date())).toString();

            fromDate = TimeUtil.convertTimeStampToString(TimeUtil.toTimestamp(true,TimeUtil.getDateByFirstDayOfMonth(new Date())));
            toDate =  TimeUtil.convertTimeStampToString(TimeUtil.toTimestamp(false,TimeUtil.getDateByLastDayOfMonth(new Date())));
        } else if(timeType.equals("04")){
            this.notaryDateFromFilter = TimeUtil.toTimestamp(true,TimeUtil.getDateByFirstDayOfYear(new Date())).toString();
            this.notaryDateToFilter = TimeUtil.toTimestamp(false,TimeUtil.getDateByLastDayOfYear(new Date())).toString();

            fromDate = TimeUtil.convertTimeStampToString(TimeUtil.toTimestamp(true,TimeUtil.getDateByFirstDayOfYear(new Date())));
            toDate =  TimeUtil.convertTimeStampToString(TimeUtil.toTimestamp(false,TimeUtil.getDateByLastDayOfYear(new Date())));
        } else if(timeType.equals("05")){
            this.notaryDateFromFilter = TimeUtil.toTimestamp(true,fromDate).toString();
            this.notaryDateToFilter = TimeUtil.toTimestamp(false,toDate).toString();;
        }
    }

}
