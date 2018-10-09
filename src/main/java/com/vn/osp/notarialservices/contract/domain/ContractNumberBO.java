package com.vn.osp.notarialservices.contract.domain;

import com.vn.osp.notarialservices.common.domain.AbstractAuditEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by TienManh on 6/15/2017.
 */
@Data
@Entity
@Table(name = "npo_contract_number")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_contract_number_update",
                procedureName = "vpcc_npo_contract_number_update"
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_contract_number_get_number",
                procedureName = "vpcc_npo_contract_number_get_number"
        ),

})
public class ContractNumberBO  extends AbstractAuditEntity implements Serializable {
    @Id
    @Column(name = "kind_id", nullable = false)
    private String kind_id;
    @Column(name = "contract_number")
    private long contract_number;

    public String getKind_id() {
        return kind_id;
    }

    public void setKind_id(String kind_id) {
        this.kind_id = kind_id;
    }

    public long getContract_number() {
        return contract_number;
    }

    public void setContract_number(long contract_number) {
        this.contract_number = contract_number;
    }
}
