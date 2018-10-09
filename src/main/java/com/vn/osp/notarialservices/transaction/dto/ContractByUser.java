package com.vn.osp.notarialservices.transaction.dto;

/**
 * Created by minh on 3/3/2017.
 */
public class ContractByUser {
    private String notaryOfficeName;
    private String entry_user_name;
    private String notaryDateFromFilter;
    private String notaryDateToFilter;

    public ContractByUser() {
    }

    public ContractByUser(String notaryOfficeName,String entry_user_name, String notaryDateFromFilter, String notaryDateToFilter)
    {
        this.notaryOfficeName = notaryOfficeName;
        this.entry_user_name = entry_user_name;
        this.notaryDateFromFilter = notaryDateFromFilter;
        this.notaryDateToFilter = notaryDateToFilter;

    }
    public String getNotary_office_name() {
        return notaryOfficeName;
    }

    public void setNotary_office_name(String notaryOfficeName) {
        this.notaryOfficeName = notaryOfficeName;
    }

    public String getEntry_user_name() {
        return entry_user_name;
    }

    public void setEntry_user_name(String entry_user_name) {
        this.entry_user_name = entry_user_name;
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
