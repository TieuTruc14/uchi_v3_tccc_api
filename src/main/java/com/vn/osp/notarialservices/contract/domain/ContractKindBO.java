package com.vn.osp.notarialservices.contract.domain;

import com.vn.osp.notarialservices.common.domain.AbstractAuditEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Admin on 5/8/2017.
 */
@Data
@Entity
@Table(name = "npo_contract_kind")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "stp_npo_contract_kind_getAll",
                procedureName = "stp_npo_contract_kind_getAll",
                resultClasses = {ContractKindBO.class}
        ),

        @NamedStoredProcedureQuery(
                name = "stp_npo_contract_template_by_filter",
                procedureName = "stp_npo_contract_template_by_filter",
                resultClasses = {ContractKindBO.class},
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_contract_kind_select",
                procedureName = "stp_npo_contract_kind_select",
                resultClasses = {ContractKindBO.class},
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name ="osp_contract_kind_add",
                procedureName = "osp_contract_kind_add",
                parameters = {
                        @StoredProcedureParameter(name = "id", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "name", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "update_user_id", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "update_user_name", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "contract_kind_code", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name ="osp_contract_kind_update",
                procedureName = "osp_contract_kind_update",
                parameters = {
                        @StoredProcedureParameter(name = "id", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "name", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "update_user_id", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "update_user_name", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "contract_kind_code", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name="osp_contract_kind_select_filter",
                procedureName = "osp_contract_kind_select_filter",
                resultClasses = {ContractKindBO.class},
                parameters = {
                        @StoredProcedureParameter(name="stringFilter",type = String.class,mode=ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name="vpcc_npo_contract_kind_get_by_id",
                procedureName = "vpcc_npo_contract_kind_get_by_id",
                resultClasses = {ContractKindBO.class},
                parameters = {
                        @StoredProcedureParameter(name="id",type = String.class,mode=ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name="osp_contract_kind_delete",
                procedureName = "osp_contract_kind_delete",

                parameters = {
                        @StoredProcedureParameter(name="id",type = Long.class,mode=ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name="osp_contract_kind_count_filter",
                procedureName = "osp_contract_kind_count_filter",
                parameters = {
                        @StoredProcedureParameter(name="stringFilter",type = String.class,mode=ParameterMode.IN)
                }
        )

})
public class ContractKindBO extends AbstractAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "parent_kind_id")
    private Long parent_kind_id;
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
    @Column(name = "contract_kind_code")
    private String contract_kind_code;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParent_kind_id() {
        return parent_kind_id;
    }

    public void setParent_kind_id(Long parent_kind_id) {
        this.parent_kind_id = parent_kind_id;
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

    public String getContract_kind_code() {
        return contract_kind_code;
    }

    public void setContract_kind_code(String contract_kind_code) {
        this.contract_kind_code = contract_kind_code;
    }
}
