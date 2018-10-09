package com.vn.osp.notarialservices.notaryoffice.domain;

import com.vn.osp.notarialservices.common.domain.AbstractAuditEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by manhtran on 20/10/2016.
 */
@Data
@Entity
@Table(name = "npo_notary_office")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "stp_npo_notary_office_insert",
                procedureName = "stp_npo_notary_office_insert",
                parameters = {
                        @StoredProcedureParameter(name = "xml_content", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_notary_office_update",
                procedureName = "stp_npo_notary_office_update",
                resultClasses = { NotaryOfficeBO.class },
                parameters = {
                        @StoredProcedureParameter(name = "xml_content", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_notary_office_delete_by_id",
                procedureName = "stp_npo_notary_office_delete_by_id",
                parameters = {
                        @StoredProcedureParameter(name = "noid", type = Long.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_notary_office_count_total",
                procedureName = "stp_npo_notary_office_count_total",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_notary_office_select_by_filter",
                procedureName = "stp_npo_notary_office_select_by_filter",
                resultClasses = { NotaryOfficeBO.class },
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_notary_office_select_by_account",
                procedureName = "stp_npo_notary_office_select_by_account",
                resultClasses = { NotaryOfficeBO.class },
                parameters = {
                        @StoredProcedureParameter(name = "account", type = String.class, mode = ParameterMode.IN),
                }
        ),
})
public class NotaryOfficeBO extends AbstractAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="noid", nullable = false)
    private Long id;

    @Column(name="active_flg")
    private Long activeFlg;

    private String address;

    @Column(name="authentication_code")
    private String authenticationCode;

    @Column(name="authentication_id")
    private String authenticationId;

    private String email;

    @Column(name="entry_date_time")
    private Timestamp entryDateTime;

    @Column(name="entry_user_id")
    private Long entryUserId;

    @Column(name="entry_user_name")
    private String entryUserName;

    private String fax;

    @Column(name="hidden_flg")
    private Long hiddenFlg;

    @Column(name="last_connection_time")
    private Timestamp lastConnectionTime;

    @Column(name="mac_address")
    private String macAddress;

    private String name;

    @Column(name="office_type")
    private Long officeType;

    @Lob
    @Column(name="other_info")
    private String otherInfo;

    private String phone;

    @Column(name="synchronize_type")
    private Long synchronizeType;

    @Column(name="update_date_time")
    private Timestamp updateDateTime;

    @Column(name="update_user_id")
    private Long updateUserId;

    @Column(name="update_user_name")
    private String updateUserName;

    private String website;

    @Column(name ="province_id")
    private Long province_id;

    public NotaryOfficeBO() {
    }



    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAuthenticationCode() {
        return this.authenticationCode;
    }

    public void setAuthenticationCode(String authenticationCode) {
        this.authenticationCode = authenticationCode;
    }

    public String getAuthenticationId() {
        return this.authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getEntryDateTime() {
        return this.entryDateTime;
    }

    public void setEntryDateTime(Timestamp entryDateTime) {
        this.entryDateTime = entryDateTime;
    }



    public String getEntryUserName() {
        return this.entryUserName;
    }

    public void setEntryUserName(String entryUserName) {
        this.entryUserName = entryUserName;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }



    public Timestamp getLastConnectionTime() {
        return this.lastConnectionTime;
    }

    public void setLastConnectionTime(Timestamp lastConnectionTime) {
        this.lastConnectionTime = lastConnectionTime;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getOtherInfo() {
        return this.otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public Timestamp getUpdateDateTime() {
        return this.updateDateTime;
    }

    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }



    public String getUpdateUserName() {
        return this.updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActiveFlg() {
        return activeFlg;
    }

    public void setActiveFlg(Long activeFlg) {
        this.activeFlg = activeFlg;
    }

    public Long getEntryUserId() {
        return entryUserId;
    }

    public void setEntryUserId(Long entryUserId) {
        this.entryUserId = entryUserId;
    }

    public Long getHiddenFlg() {
        return hiddenFlg;
    }

    public void setHiddenFlg(Long hiddenFlg) {
        this.hiddenFlg = hiddenFlg;
    }

    public Long getOfficeType() {
        return officeType;
    }

    public void setOfficeType(Long officeType) {
        this.officeType = officeType;
    }

    public Long getSynchronizeType() {
        return synchronizeType;
    }

    public void setSynchronizeType(Long synchronizeType) {
        this.synchronizeType = synchronizeType;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Long getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Long province_id) {
        this.province_id = province_id;
    }

}