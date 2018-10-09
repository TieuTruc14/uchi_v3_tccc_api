package com.vn.osp.notarialservices.transaction.dto;

/**
 * Created by minh on 2/27/2017.
 */
public class NotaryDateFilter {
    private String notaryDateFromFilter;
    private String notaryDateToFilter;

    public NotaryDateFilter() {
    }

    public NotaryDateFilter(String notaryDateFromFilter, String notaryDateToFilter) {
        this.notaryDateFromFilter = notaryDateFromFilter;
        this.notaryDateToFilter = notaryDateToFilter;
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