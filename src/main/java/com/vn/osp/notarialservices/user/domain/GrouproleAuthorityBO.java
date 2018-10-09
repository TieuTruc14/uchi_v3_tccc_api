package com.vn.osp.notarialservices.user.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by TienManh on 7/10/2017.
 */

@Data
@Entity
@Table(name = "npo_grouprole_authority")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "stp_npo_group_role_authority_get_by_userId_and_authority_code",
                procedureName = "stp_npo_group_role_authority_get_by_userId_and_authority_code",
                resultClasses = {GrouproleAuthorityBO.class},
                parameters = {
                        @StoredProcedureParameter(name = "userId", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "authority_code", type = String.class, mode = ParameterMode.IN)
                }
        ),

})
public class GrouproleAuthorityBO {
    @Id
    @Column(name = "grouprole_id", nullable = false)
    private Long grouprole_id;

    @Column(name = "authority_code",nullable = false)
    private String authority_code;

    @Column(name = "value")
    private int value;


    public Long getGrouprole_id() {
        return grouprole_id;
    }

    public void setGrouprole_id(Long grouprole_id) {
        this.grouprole_id = grouprole_id;
    }

    public String getAuthority_code() {
        return authority_code;
    }

    public void setAuthority_code(String authority_code) {
        this.authority_code = authority_code;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
