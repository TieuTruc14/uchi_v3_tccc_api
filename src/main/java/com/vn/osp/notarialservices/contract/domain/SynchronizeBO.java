package com.vn.osp.notarialservices.contract.domain;

import com.vn.osp.notarialservices.common.domain.AbstractAuditEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by TienManh on 5/12/2017.
 */
@Data
@Entity
@Table(name = "npo_synchronize")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_synchronize_getAll",
                procedureName = "vpcc_npo_synchronize_getAll",
                resultClasses = {SynchronizeBO.class}
        ),

        @NamedStoredProcedureQuery(
                name = "vpcc_npo_synchronize_by_filter",
                procedureName = "vpcc_npo_synchronize_by_filter",
                resultClasses = {SynchronizeBO.class},
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
})
public class SynchronizeBO extends AbstractAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "type", nullable = false)
    private int type;

    @Column(name = "data_id", nullable = false)
    private String data_id;

    @Column(name = "authentication_id", nullable = false)
    private String authentication_id;

    @Column(name = "action", nullable = false)
    private int action;

    @Column(name = "history_id")
    private Integer history_id;

    @Column(name = "status")
    private Integer status;

    @Column(name = "entry_date_time", nullable = false)
    private Timestamp entry_date_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getData_id() {
        return data_id;
    }

    public void setData_id(String data_id) {
        this.data_id = data_id;
    }

    public String getAuthentication_id() {
        return authentication_id;
    }

    public void setAuthentication_id(String authentication_id) {
        this.authentication_id = authentication_id;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getEntry_date_time() {
        return entry_date_time;
    }

    public void setEntry_date_time(Timestamp entry_date_time) {
        this.entry_date_time = entry_date_time;
    }

    public Integer getHistory_id() {
        return history_id;
    }

    public void setHistory_id(Integer history_id) {
        this.history_id = history_id;
    }
}
