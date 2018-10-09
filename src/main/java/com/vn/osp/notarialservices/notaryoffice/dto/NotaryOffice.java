package com.vn.osp.notarialservices.notaryoffice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.springframework.hateoas.ResourceSupport;


@XStreamAlias("NotaryOffice")
public class NotaryOffice extends ResourceSupport {
    private Long noid;
    private Long office_type;
    private String name;
    private String address;
    private String phone;
    private String fax;
    private String email;
    private String website;
    private String other_info;
    private String mac_address;
    private String authentication_id;
    private String authentication_code;
    private Long active_flg;
    private Long hidden_flg;
    private String last_connection_time;
    private Long synchronize_type;
    private Long entry_user_id;
    private String entry_user_name;
    private String entry_date_time;
    private Long update_user_id;
    private String update_user_name;
    private String update_date_time;
    private Long province_id;

    @JsonCreator
    public NotaryOffice(@JsonProperty(value = "noid", required = false) Long noid,
                        @JsonProperty(value = "office_type", required = false) Long office_type,
                        @JsonProperty(value = "name", required = false) String name,
                        @JsonProperty(value = "address", required = false) String address,
                        @JsonProperty(value = "phone", required = false) String phone,
                        @JsonProperty(value = "fax", required = false) String fax,
                        @JsonProperty(value = "email", required = false) String email,
                        @JsonProperty(value = "website", required = false) String website,
                        @JsonProperty(value = "other_info", required = false) String other_info,
                        @JsonProperty(value = "mac_address", required = false) String mac_address,
                        @JsonProperty(value = "authentication_id", required = false) String authentication_id,
                        @JsonProperty(value = "authentication_code", required = false) String authentication_code,
                        @JsonProperty(value = "active_flg", required = false) Long active_flg,
                        @JsonProperty(value = "hidden_flg", required = false) Long hidden_flg,
                        @JsonProperty(value = "last_connection_time", required = false) String last_connection_time,
                        @JsonProperty(value = "synchronize_type", required = false) Long synchronize_type,
                        @JsonProperty(value = "entry_user_id", required = false) Long entry_user_id,
                        @JsonProperty(value = "entry_user_name", required = false) String entry_user_name,
                        @JsonProperty(value = "entry_date_time", required = false) String entry_date_time,
                        @JsonProperty(value = "update_user_id", required = false) Long update_user_id,
                        @JsonProperty(value = "update_user_name", required = false) String update_user_name,
                        @JsonProperty(value = "update_date_time", required = false) String update_date_time,
                        @JsonProperty(value = "province_id",required = false) Long province_id) {
        this.noid = noid;
        this.office_type = office_type;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.website = website;
        this.other_info = other_info;
        this.mac_address = mac_address;
        this.authentication_id = authentication_id;
        this.authentication_code = authentication_code;
        this.active_flg = active_flg;
        this.hidden_flg = hidden_flg;
        this.last_connection_time = last_connection_time;
        this.synchronize_type = synchronize_type;
        this.entry_user_id = entry_user_id;
        this.entry_user_name = entry_user_name;
        this.entry_date_time = entry_date_time;
        this.update_user_id = update_user_id;
        this.update_user_name = update_user_name;
        this.update_date_time = update_date_time;
        this.province_id = province_id;
    }

    public Long getNoid() {
        return noid;
    }

    public void setNoid(Long noid) {
        this.noid = noid;
    }

    public Long getOffice_type() {
        return office_type;
    }

    public void setOffice_type(Long office_type) {
        this.office_type = office_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOther_info() {
        return other_info;
    }

    public void setOther_info(String other_info) {
        this.other_info = other_info;
    }

    public String getMac_address() {
        return mac_address;
    }

    public void setMac_address(String mac_address) {
        this.mac_address = mac_address;
    }

    public String getAuthentication_id() {
        return authentication_id;
    }

    public void setAuthentication_id(String authentication_id) {
        this.authentication_id = authentication_id;
    }

    public String getAuthentication_code() {
        return authentication_code;
    }

    public void setAuthentication_code(String authentication_code) {
        this.authentication_code = authentication_code;
    }

    public Long getActive_flg() {
        return active_flg;
    }

    public void setActive_flg(Long active_flg) {
        this.active_flg = active_flg;
    }

    public Long getHidden_flg() {
        return hidden_flg;
    }

    public void setHidden_flg(Long hidden_flg) {
        this.hidden_flg = hidden_flg;
    }


    public Long getSynchronize_type() {
        return synchronize_type;
    }

    public void setSynchronize_type(Long synchronize_type) {
        this.synchronize_type = synchronize_type;
    }

    public Long getEntry_user_id() {
        return entry_user_id;
    }

    public void setEntry_user_id(Long entry_user_id) {
        this.entry_user_id = entry_user_id;
    }

    public String getEntry_user_name() {
        return entry_user_name;
    }

    public void setEntry_user_name(String entry_user_name) {
        this.entry_user_name = entry_user_name;
    }


    public Long getUpdate_user_id() {
        return update_user_id;
    }

    public void setUpdate_user_id(Long update_user_id) {
        this.update_user_id = update_user_id;
    }

    public String getUpdate_user_name() {
        return update_user_name;
    }

    public void setUpdate_user_name(String update_user_name) {
        this.update_user_name = update_user_name;
    }

    public String getLast_connection_time() {
        return last_connection_time;
    }

    public void setLast_connection_time(String last_connection_time) {
        this.last_connection_time = last_connection_time;
    }

    public String getEntry_date_time() {
        return entry_date_time;
    }

    public void setEntry_date_time(String entry_date_time) {
        this.entry_date_time = entry_date_time;
    }

    public String getUpdate_date_time() {
        return update_date_time;
    }

    public void setUpdate_date_time(String update_date_time) {
        this.update_date_time = update_date_time;
    }

    public Long getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Long province_id) {
        this.province_id = province_id;
    }

}
