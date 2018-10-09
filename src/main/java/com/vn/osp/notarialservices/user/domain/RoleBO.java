package com.vn.osp.notarialservices.user.domain;

import com.vn.osp.notarialservices.common.domain.AbstractAuditEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by TienManh on 7/17/2017.
 */
@Data
@Entity
@Table(name = "npo_role")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_role_list",
                procedureName = "vpcc_npo_role_list",
                resultClasses = {RoleBO.class}
        ),
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "getRoleByCode",
                query = "SELECT * " +
                        "FROM npo_role " +
                        "WHERE npo_role.code = ?",
                resultClass = RoleBO.class
        ),
})
public class RoleBO  extends AbstractAuditEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name="name")
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
