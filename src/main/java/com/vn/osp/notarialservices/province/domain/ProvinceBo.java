package com.vn.osp.notarialservices.province.domain;

import com.vn.osp.notarialservices.common.domain.AbstractAuditEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by ProBook on 5/25/2017.
 */
@Data
@Entity
@Table(name = "npo_province")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name ="addProvince",
                procedureName = "osp_npo_province_add",
                parameters = {
                        @StoredProcedureParameter(name = "name", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "entry_user_id", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "entry_user_name", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "code", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name="findProvinceByFilter",
                procedureName = "osp_npo_province_select_filter",
                resultClasses = {ProvinceBo.class},
                parameters = {
                        @StoredProcedureParameter(name="stringFilter",type = String.class,mode=ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name="countProvinceByFilter",
                procedureName = "osp_npo_province_count_filter",
                parameters = {
                        @StoredProcedureParameter(name="stringFilter",type = String.class,mode=ParameterMode.IN)
                }
        )
})
public class ProvinceBo extends AbstractAuditEntity implements Serializable{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "order_number")
    private Long order_number;
    @Column(name = "entry_user_id")
    private Long entry_user_id;
    @Column(name = "entry_user_name")
    private String entry_user_name;
    @Column(name = "entry_date_time")
    private java.sql.Timestamp entry_date_time;
    @Column(name = "update_user_id")
    private Long update_user_id;
    @Column(name = "update_user_name")
    private String update_user_name;
    @Column(name = "update_date_time")
    private java.sql.Timestamp update_date_time;
    @Column(name = "code")
    private String code;
    @Column(name = "notary_index")
    private Long notary_index;

    public Long getSid() {
        return id;
    }

    public void setSid(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Long order_number) {
        this.order_number = order_number;
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

    public Timestamp getEntry_date_time() {
        return entry_date_time;
    }

    public void setEntry_date_time(Timestamp entry_date_time) {
        this.entry_date_time = entry_date_time;
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

    public Timestamp getUpdate_date_time() {
        return update_date_time;
    }

    public void setUpdate_date_time(Timestamp update_date_time) {
        this.update_date_time = update_date_time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getNotary_index() {
        return notary_index;
    }

    public void setNotary_index(Long notary_index) {
        this.notary_index = notary_index;
    }

}
