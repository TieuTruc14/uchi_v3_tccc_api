package com.vn.osp.notarialservices.announcement.dto;

/**
 * Created by minh on 4/10/2017.
 */
public class NotaryOfficeByAnnouncement {
    private String name;
    private Integer aid;
    private Byte office_type;
    private String authentication_id;

    public NotaryOfficeByAnnouncement() {
    }

    public NotaryOfficeByAnnouncement(String name,Integer aid, Byte office_type, String authentication_id)
    {
        this.name = name;
        this.aid = aid;
        this.office_type = office_type;
        this.authentication_id = authentication_id;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAid(){return aid;}

    public void setAid(Integer aid){this.aid = aid;}

    public Byte getOffice_type(){return office_type;}

    public void setOffice_type(Byte office_type){this.office_type = office_type;}

    public String getAuthentication_id() {
        return authentication_id;
    }

    public void setAuthentication_id(String authentication_id) {
        this.authentication_id = authentication_id;
    }


}
