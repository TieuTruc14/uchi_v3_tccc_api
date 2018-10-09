package com.vn.osp.notarialservices.systemmanager.domain;

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
@Table(name = "npo_system_config")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "stp_npo_system_config_get_value",
                procedureName = "stp_npo_system_config_get_value",
                resultClasses = { SystemConfigBO.class },
                parameters = {
                        @StoredProcedureParameter(name = "config_key", type = String.class, mode = ParameterMode.IN),
                }
        ),
})
public class SystemConfigBO extends AbstractAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="config_key")
    private String config_key;

    @Column(name="config_value")
    private String config_value;

    public SystemConfigBO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfig_key() {
        return config_key;
    }

    public void setConfig_key(String config_key) {
        this.config_key = config_key;
    }

    public String getConfig_value() {
        return config_value;
    }

    public void setConfig_value(String config_value) {
        this.config_value = config_value;
    }
}
