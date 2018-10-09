package com.vn.osp.notarialservices.contract.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by TienManh on 5/12/2017.
 */
@XStreamAlias("Property")
public class Property extends BaseEntityBeans {
    private int id;
    private String type;
    private String property_info;
    private String owner_info;
    private String other_info;
    private String land_certificate;
    private String land_issue_place;
    private String land_issue_date;
    private String land_map_number;
    private String land_number;
    private String land_address;
    private String land_area;
    private String land_public_area;
    private String land_private_area;
    private String land_use_purpose;
    private String land_use_period;
    private String land_use_origin;
    private String land_associate_property;
    private String land_street;
    private String land_district;
    private String land_province;
    private String land_full_of_area;
    private String car_license_number;
    private String car_regist_number;
    private String car_issue_place;
    private String car_issue_date;
    private String car_frame_number;
    private String car_machine_number;

    public Property(){}

    @JsonCreator
    public Property(
            @JsonProperty(value="id",required= true) final int id,
            @JsonProperty(value="type", required = true) final String type,
            @JsonProperty(value="property_info", required= true) final String property_info,
            @JsonProperty(value="owner_info", required= true) final String owner_info,
            @JsonProperty(value="other_info", required= true) final String other_info,
            @JsonProperty(value="land_certificate", required= true) final String land_certificate,
            @JsonProperty(value="land_issue_place", required= true) final String land_issue_place,
            @JsonProperty(value="land_issue_date", required= true) final String land_issue_date,
            @JsonProperty(value="land_map_number", required= true) final String land_map_number,
            @JsonProperty(value="land_number", required= true) final String land_number,
            @JsonProperty(value="land_address", required= true) final String land_address,
            @JsonProperty(value="land_area", required= true) final String land_area,
            @JsonProperty(value="land_public_area", required= true) final String land_public_area,
            @JsonProperty(value="land_private_area", required= true) final String land_private_area,
            @JsonProperty(value="land_use_purpose", required= true) final String land_use_purpose,
            @JsonProperty(value="land_use_period", required= true) final String land_use_period,
            @JsonProperty(value="land_use_origin", required= true) final String land_use_origin,
            @JsonProperty(value="land_associate_property", required= true) final String land_associate_property,
            @JsonProperty(value="land_street", required= true) final String land_street,
            @JsonProperty(value="land_district", required= true) final String land_district,
            @JsonProperty(value="land_province", required= true) final String land_province,
            @JsonProperty(value="land_full_of_area", required= true) final String land_full_of_area,
            @JsonProperty(value="car_license_number", required= true) final String car_license_number,
            @JsonProperty(value="car_regist_number", required= true) final String car_regist_number,
            @JsonProperty(value="car_issue_place", required= true) final String car_issue_place,
            @JsonProperty(value="car_issue_date", required= true) final String car_issue_date,
            @JsonProperty(value="car_frame_number", required= true) final String car_frame_number,
            @JsonProperty(value="car_machine_number", required= true) final String car_machine_number
    ){

        this.id=id;
        this.type=type;
        this.property_info=property_info;
        this.owner_info=owner_info;
        this.other_info=other_info;
        this.land_certificate=land_certificate;
        this.land_issue_place=land_issue_place;
        this.land_issue_date=land_issue_date;
        this.land_map_number=land_map_number;
        this.land_number=land_number;
        this.land_address=land_address;
        this.land_area=land_area;
        this.land_public_area=land_public_area;
        this.land_private_area=land_private_area;
        this.land_use_purpose=land_use_purpose;
        this.land_use_period=land_use_period;
        this.land_use_origin=land_use_origin;
        this.land_associate_property=land_associate_property;
        this.land_street=land_street;
        this.land_district=land_district;
        this.land_province=land_province;
        this.land_full_of_area=land_full_of_area;
        this.car_license_number=car_license_number;
        this.car_regist_number=car_regist_number;
        this.car_issue_place=car_issue_place;
        this.car_issue_date=car_issue_date;
        this.car_frame_number=car_frame_number;
        this.car_machine_number=car_machine_number;
    }

    public int getPid() {
        return id;
    }

    public void setPid(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProperty_info() {
        return property_info;
    }

    public void setProperty_info(String property_info) {
        this.property_info = property_info;
    }

    public String getOwner_info() {
        return owner_info;
    }

    public void setOwner_info(String owner_info) {
        this.owner_info = owner_info;
    }

    public String getOther_info() {
        return other_info;
    }

    public void setOther_info(String other_info) {
        this.other_info = other_info;
    }

    public String getLand_certificate() {
        return land_certificate;
    }

    public void setLand_certificate(String land_certificate) {
        this.land_certificate = land_certificate;
    }

    public String getLand_issue_place() {
        return land_issue_place;
    }

    public void setLand_issue_place(String land_issue_place) {
        this.land_issue_place = land_issue_place;
    }

    public String getLand_map_number() {
        return land_map_number;
    }

    public void setLand_map_number(String land_map_number) {
        this.land_map_number = land_map_number;
    }

    public String getLand_number() {
        return land_number;
    }

    public void setLand_number(String land_number) {
        this.land_number = land_number;
    }

    public String getLand_address() {
        return land_address;
    }

    public void setLand_address(String land_address) {
        this.land_address = land_address;
    }

    public String getLand_area() {
        return land_area;
    }

    public void setLand_area(String land_area) {
        this.land_area = land_area;
    }

    public String getLand_public_area() {
        return land_public_area;
    }

    public void setLand_public_area(String land_public_area) {
        this.land_public_area = land_public_area;
    }

    public String getLand_private_area() {
        return land_private_area;
    }

    public void setLand_private_area(String land_private_area) {
        this.land_private_area = land_private_area;
    }

    public String getLand_use_purpose() {
        return land_use_purpose;
    }

    public void setLand_use_purpose(String land_use_purpose) {
        this.land_use_purpose = land_use_purpose;
    }

    public String getLand_use_period() {
        return land_use_period;
    }

    public void setLand_use_period(String land_use_period) {
        this.land_use_period = land_use_period;
    }

    public String getLand_use_origin() {
        return land_use_origin;
    }

    public void setLand_use_origin(String land_use_origin) {
        this.land_use_origin = land_use_origin;
    }

    public String getLand_associate_property() {
        return land_associate_property;
    }

    public void setLand_associate_property(String land_associate_property) {
        this.land_associate_property = land_associate_property;
    }

    public String getLand_street() {
        return land_street;
    }

    public void setLand_street(String land_street) {
        this.land_street = land_street;
    }

    public String getLand_district() {
        return land_district;
    }

    public void setLand_district(String land_district) {
        this.land_district = land_district;
    }

    public String getLand_province() {
        return land_province;
    }

    public void setLand_province(String land_province) {
        this.land_province = land_province;
    }

    public String getLand_full_of_area() {
        return land_full_of_area;
    }

    public void setLand_full_of_area(String land_full_of_area) {
        this.land_full_of_area = land_full_of_area;
    }

    public String getCar_license_number() {
        return car_license_number;
    }

    public void setCar_license_number(String car_license_number) {
        this.car_license_number = car_license_number;
    }

    public String getCar_regist_number() {
        return car_regist_number;
    }

    public void setCar_regist_number(String car_regist_number) {
        this.car_regist_number = car_regist_number;
    }

    public String getCar_issue_place() {
        return car_issue_place;
    }

    public void setCar_issue_place(String car_issue_place) {
        this.car_issue_place = car_issue_place;
    }

    public String getCar_frame_number() {
        return car_frame_number;
    }

    public void setCar_frame_number(String car_frame_number) {
        this.car_frame_number = car_frame_number;
    }

    public String getCar_machine_number() {
        return car_machine_number;
    }

    public void setCar_machine_number(String car_machine_number) {
        this.car_machine_number = car_machine_number;
    }

    public String getLand_issue_date() {
        return land_issue_date;
    }

    public void setLand_issue_date(String land_issue_date) {
        this.land_issue_date = land_issue_date;
    }

    public String getCar_issue_date() {
        return car_issue_date;
    }

    public void setCar_issue_date(String car_issue_date) {
        this.car_issue_date = car_issue_date;
    }
}
