package com.vn.osp.notarialservices.transaction.dto;

/**
 * Created by minh on 3/7/2017.
 */
public class ContractByBank {
    private String bankname;
    private String notaryDateFromFilter;
    private String notaryDateToFilter;

    public ContractByBank() {
    }

    public ContractByBank(String notaryDateFromFilter, String notaryDateToFilter) {
        this.bankname = bankname;
        this.notaryDateFromFilter = notaryDateFromFilter;
        this.notaryDateToFilter = notaryDateToFilter;
    }
    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
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
