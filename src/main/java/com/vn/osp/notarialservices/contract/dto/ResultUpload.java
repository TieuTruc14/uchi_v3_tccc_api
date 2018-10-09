package com.vn.osp.notarialservices.contract.dto;

/**
 * Created by TienManh on 7/26/2017.
 */
public class ResultUpload {
    private String name;
    private String path;

    public ResultUpload(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public ResultUpload() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
