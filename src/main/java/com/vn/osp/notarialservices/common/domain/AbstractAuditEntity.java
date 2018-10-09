package com.vn.osp.notarialservices.common.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by longtran on 19/10/2016.
 */
@EqualsAndHashCode(of = {"createdTs", "updatedBy", "updatedTs"})
@ToString(of = {"createdTs", "updatedBy", "updatedTs"})
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class AbstractAuditEntity implements Serializable {

    private static final long serialVersionUID = 6384069660089559035L;

    @Transient
    private SecurityContext securityContext = SecurityContextHolder.getContext();
}
