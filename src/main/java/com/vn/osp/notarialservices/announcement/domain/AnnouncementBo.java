package com.vn.osp.notarialservices.announcement.domain;

import com.vn.osp.notarialservices.common.domain.AbstractAuditEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by minh on 11/21/2016.
 */
@Data
@Entity
@Table(name = "npo_announcement")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "findAnnouncementByID",
                procedureName = "stp_npo_announcement_select_by_id",
                resultClasses = {AnnouncementBo.class},
                parameters = {
                        @StoredProcedureParameter(name = "aid", type = Long.class, mode = ParameterMode.IN)
                }),
        @NamedStoredProcedureQuery(
                name = "findAnnouncement",
                procedureName = "stp_npo_announcement_select",
                resultClasses = {AnnouncementBo.class},
                parameters = {

                        @StoredProcedureParameter(name = "numOffset", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "numLimit", type = Long.class, mode = ParameterMode.IN)
                }),
        @NamedStoredProcedureQuery(
                name = "findAnnouncementByFilter",
                procedureName = "stp_npo_announcement_select_by_filter",
                resultClasses = {AnnouncementBo.class},
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }),
        @NamedStoredProcedureQuery(
                name = "countTotalAnnouncement",
                procedureName = "stp_npo_announcement_count_total"
        ),
        @NamedStoredProcedureQuery(
                name = "countTotalAnnouncementByFilter",
                procedureName = "stp_npo_announcement_count_total_by_filter",
                parameters = {
                @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
        } ),
        @NamedStoredProcedureQuery(
                name = "AddAnnouncement",
                procedureName = "vpcc_npo_announcement_add",
                parameters = {
                        @StoredProcedureParameter(name = "announcement_content", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "UpdateAnnouncement",
                procedureName = "vpcc_npo_announcement_update",
                parameters = {
                        @StoredProcedureParameter(name = "announcement_content", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "DeleteAnnouncement",
                procedureName = "stp_npo_announcement_delete_by_id",
                parameters = {
                        @StoredProcedureParameter(name = "aid", type = Long.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "FindLatestAnnouncement",
                procedureName = "stp_npo_announcement_select_latest_announcement",
                resultClasses = {AnnouncementBo.class},
                parameters = {
                        @StoredProcedureParameter(name = "countNumber", type = Long.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "PopupAnnouncement",
                procedureName = "stp_npo_announcement_select_popup_announcement",
                resultClasses = {AnnouncementBo.class}
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_select_notary_office_by_announcement",
                procedureName = "stp_npo_select_notary_office_by_announcement",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_authentication_id_announcement",
                procedureName = "stp_npo_authentication_id_announcement",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_announcement_remove_file",
                procedureName = "vpcc_npo_announcement_remove_file",
                parameters = {
                        @StoredProcedureParameter(name = "aid", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "file_name", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "file_path", type = String.class, mode = ParameterMode.IN)
                }
        )


})
public class AnnouncementBo extends AbstractAuditEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "aid", nullable = false)
    private Long id;


    @Column(name = "synchronize_Id")
    private String synchronize_id;


    @Column(name = "kind")
    private Long kind;

    @Column(name = "confirm_request")
    private Long confirm_request;

    @Column(name = "importance_type")
    private Long importance_type;

    @Column(name = "popup_display_flg")
    private Long popup_display_flg;

    @Column(name = "popup_display_day")
    private Long popup_display_day;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "sender_info")
    private String sender_info;

    @Column(name = "send_date_time")
    private java.sql.Timestamp send_date_time;

    @Column(name = "attach_file_name")
    private String attach_file_name;

    @Column(name = "attach_file_path")
    private String attach_file_path;

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

    @Column(name = "announcement_type")
    private Long anouncement_type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSynchronize_id() {
        return synchronize_id;
    }

    public void setSynchronize_id(String synchronize_id) {
        this.synchronize_id = synchronize_id;
    }

    public Long getKind() {
        return kind;
    }

    public void setKind(Long kind) {
        this.kind = kind;
    }

    public Long getConfirm_request() {
        return confirm_request;
    }

    public void setConfirm_request(Long confirm_request) {
        this.confirm_request = confirm_request;
    }

    public Long getImportance_type() {
        return importance_type;
    }

    public void setImportance_type(Long importance_type) {
        this.importance_type = importance_type;
    }

    public Long getPopup_display_flg() {
        return popup_display_flg;
    }

    public void setPopup_display_flg(Long popup_display_flg) {
        this.popup_display_flg = popup_display_flg;
    }

    public Long getPopup_display_day() {
        return popup_display_day;
    }

    public void setPopup_display_day(Long popup_display_day) {
        this.popup_display_day = popup_display_day;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender_info() {
        return sender_info;
    }

    public void setSender_info(String sender_info) {
        this.sender_info = sender_info;
    }

    public java.sql.Timestamp getSend_date_time() {
        return send_date_time;
    }

    public void setSend_date_time(java.sql.Timestamp send_date_time) {
        this.send_date_time = send_date_time;
    }

    public String getAttach_file_name() {
        return attach_file_name;
    }

    public void setAttach_file_name(String attach_file_name) {
        this.attach_file_name = attach_file_name;
    }

    public String getAttach_file_path() {
        return attach_file_path;
    }

    public void setAttach_file_path(String attach_file_path) {
        this.attach_file_path = attach_file_path;
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

    public java.sql.Timestamp getEntry_date_time() {
        return entry_date_time;
    }

    public void setEntry_date_time(java.sql.Timestamp entry_date_time) {
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

    public java.sql.Timestamp getUpdate_date_time() {
        return update_date_time;
    }

    public void setUpdate_date_time(java.sql.Timestamp update_date_time) {
        this.update_date_time = update_date_time;
    }

    public Long getAnouncement_type() {
        return anouncement_type;
    }

    public void setAnouncement_type(Long anouncement_type) {
        this.anouncement_type = anouncement_type;
    }

}
