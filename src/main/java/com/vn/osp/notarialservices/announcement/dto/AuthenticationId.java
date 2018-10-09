package com.vn.osp.notarialservices.announcement.dto;

/**
 * Created by minh on 4/12/2017.
 */
public class AuthenticationId {
    private String authentication_id;

    public AuthenticationId() {
    }

    public AuthenticationId( String authentication_id)
    {
        this.authentication_id = authentication_id;

    }

    public String getAuthentication_id() {
        return authentication_id;
    }

    public void setAuthentication_id(String authentication_id) {
        this.authentication_id = authentication_id;
    }


}
