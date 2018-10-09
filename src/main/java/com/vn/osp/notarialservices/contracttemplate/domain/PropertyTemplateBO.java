package com.vn.osp.notarialservices.contracttemplate.domain;

import com.vn.osp.notarialservices.common.domain.AbstractAuditEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by TienManh on 8/5/2017.
 */
@Data
@Entity
@Table(name = "npo_property_template")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_privy_property_getAll",
                procedureName = "vpcc_npo_privy_property_getAll",
                resultClasses = {PropertyTemplateBO.class}
        )

})
public class PropertyTemplateBO extends AbstractAuditEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "html")
    private String html;

    @Column(name = "entry_user")
    private int entry_user;

    @Column(name = "entry_time")
    private Date entry_time;

    @Column(name = "update_user")
    private int update_user;

    @Column(name = "update_time")
    private Date update_time;

    @Column(name = "disable")
    private boolean disable;

    public PropertyTemplateBO(String type,String code, String name, String description, String html, int entry_user, Date entry_time, int update_user, Date update_time,boolean disable) {
        this.type = type;
        this.code=code;
        this.name = name;
        this.description = description;
        this.html = html;
        this.entry_user = entry_user;
        this.entry_time = entry_time;
        this.update_user = update_user;
        this.update_time = update_time;
        this.disable=disable;
    }

    public PropertyTemplateBO() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public int getEntry_user() {
        return entry_user;
    }

    public void setEntry_user(int entry_user) {
        this.entry_user = entry_user;
    }

    public Date getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(Date entry_time) {
        this.entry_time = entry_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public int getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(int update_user) {
        this.update_user = update_user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
}
