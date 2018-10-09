package com.vn.osp.notarialservices.transaction.dto;

/**
 * Created by minh on 3/3/2017.
 */
public class ContractByNotary {
    private String notaryOfficeName;
    private String notaryName;
    private String notaryDateFromFilter;
    private String notaryDateToFilter;

    public ContractByNotary() {
    }

    public ContractByNotary(String notaryOfficeName,String notaryName, String notaryDateFromFilter, String notaryDateToFilter)
    {
        this.notaryOfficeName = notaryOfficeName;
        this.notaryName = notaryName;
        this.notaryDateFromFilter = notaryDateFromFilter;
        this.notaryDateToFilter = notaryDateToFilter;

    }
    public String getNotary_office_name() {
        return notaryOfficeName;
    }

    public void setNotary_office_name(String notaryOfficeName) {
        this.notaryOfficeName = notaryOfficeName;
    }

    public String getNotary_person() {
        return notaryName;
    }

    public void setNotary_person(String notaryName) {
        this.notaryName = notaryName;
    }
    public String getNotaryDateFromFilter() {
        return notaryDateFromFilter;
    }

    public void setNotaryDateFromFilter(String notaryDateFromFilter) {
        this.notaryDateFromFilter = notaryDateFromFilter;
    }

    public String getNotaryDateToFilter() {
        return notaryDateToFilter;
    }

    public void setNotaryDateToFilter(String notaryDateToFilter) {
        this.notaryDateToFilter = notaryDateToFilter;
    }
}
