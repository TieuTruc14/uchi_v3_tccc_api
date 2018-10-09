package com.vn.osp.notarialservices.manual.domain;

import com.vn.osp.notarialservices.common.domain.AbstractAuditEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by minh on 11/18/2016.
 */
@Data
@Entity
@Table(name = "npo_manual")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "findManualByID",
                procedureName = "stp_npo_manual_select_by_id",
                resultClasses = {ManualBo.class},
                parameters = {
                        @StoredProcedureParameter(name = "id", type = Long.class, mode = ParameterMode.IN)
                }),
        @NamedStoredProcedureQuery(
                name ="deleteManualByID",
                procedureName = "vpcc_npo_manual_delete_by_id",
                parameters = {
                        @StoredProcedureParameter(name = "manual_id", type = Long.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name ="findManualByFilter",
                procedureName = "vpcc_npo_manual_select_by_filter",
                resultClasses = {ManualBo.class},
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name ="countTotalManual",
                procedureName = "vpcc_npo_manual_count_total"
        ),
        @NamedStoredProcedureQuery(
                name ="addManual",
                procedureName = "vpcc_npo_manual_insert",
                parameters = {
                        @StoredProcedureParameter(name = "title", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "content", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "file_name", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "file_path", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "entry_user_id", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "entry_user_name", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "update_user_id", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "update_user_name", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name ="removeFileManual",
                procedureName = "vpcc_npo_manual_delete_file",
                parameters = {
                        @StoredProcedureParameter(name = "id", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "file_name", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "file_path", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name ="updateManual",
                procedureName = "vpcc_npo_manual_update",
                parameters = {
                        @StoredProcedureParameter(name = "id", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "title", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "content", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "file_name", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "file_path", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "update_user_id", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "update_user_name", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name ="countTotalManualByFilter",
                procedureName = "vpcc_npo_manual_count_total_by_filter",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type =String.class, mode = ParameterMode.IN)
                }
        ),
})
public class ManualBo extends AbstractAuditEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "file_name")
    private String file_name;

    @Column(name = "file_path")
    private String file_path;

    @Column(name = "entry_user_id")
    private Long entry_user_id;

    @Column(name = "entry_user_name")
    private String entry_user_name;

    @Column(name = "entry_date_time", nullable = true)
    private java.sql.Timestamp entry_date_time;

    @Column(name = "update_user_id", nullable = true)
    private Long update_user_id;

    @Column(name = "update_user_name", nullable = true)
    private String update_user_name;

    @Column(name = "update_date_time", nullable = true)
    private java.sql.Timestamp update_date_time;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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

        public String getFile_name() {
            return file_name;
        }

        public void setFile_name(String file_name) {
            this.file_name = file_name;
        }

        public String getFile_path() {
            return file_path;
        }

        public void setFile_path(String file_path) {
            this.file_path = file_path;
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

    }