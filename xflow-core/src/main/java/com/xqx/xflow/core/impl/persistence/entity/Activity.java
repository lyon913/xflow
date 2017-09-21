package com.xqx.xflow.core.impl.persistence.entity;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "XFL_ACTIVITY", indexes = {})
public class Activity extends BaseIdEntity{

    @ManyToOne(optional = false)
    @JoinColumn(name = "PROCESS_INST_ID_")
    private ProcessInst processInst;

    @ManyToOne(optional = false)
    @JoinColumn(name = "NODE_DEF_ID_")
    private NodeDef nodeDef;

    @Column(name = "NODE_TYPE_",length = 100, nullable = false)
    private String nodeType;

    @Column(name = "NODE_NAME_",length = 255)
    private String nodeName;

    @Column(name = "ASSIGNEE_ID_", length = 64)
    private String assigneeId;

    @Column(name = "ASSIGNEE_NAME_",length = 255)
    private String assigneeName;

    @Column(name = "OWNER_ID_", length = 64)
    private String ownerId;

    @Column(name = "OWNER_NAME_",length = 255)
    private String ownerName;



    @Column(name = "START_TIME_")
    //@Temporal(TemporalType.TIMESTAMP)
    private DateTime startTime;

    @Column(name = "CLAIM_TIME_")
    //@Temporal(TemporalType.TIMESTAMP)
    private DateTime claimTime;

    @Column(name = "END_TIME_")
    //@Temporal(TemporalType.TIMESTAMP)
    private DateTime endTime;

    @Column(name = "DUE_DATE_")
    //@Temporal(TemporalType.TIMESTAMP)
    private DateTime dueDate;

    @Column(name = "DURATION_")
    private Long duration;

    @Column(name = "IS_ACTIVE_", length = 1, nullable = false)
    private Boolean isActive;
}
