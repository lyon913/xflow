package com.xqx.xflow.core.impl.persistence.entity;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "XFL_ACTIVITY", indexes = {})
public class Activity extends BaseIdEntity{
    @PersistenceContext
    @Transient
    private EntityManager em;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PROCESS_INST_ID_")
    private ProcessInst processInst;

    @ManyToOne(optional = false)
    @JoinColumn(name = "NODE_DEF_ID_")
    private NodeDef nodeDef;

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

    @Column(name = "START_TIME_",nullable = false)
    private DateTime startTime;

    @Column(name = "CLAIM_TIME_")
    private DateTime claimTime;

    @Column(name = "END_TIME_")
    private DateTime endTime;

    @Column(name = "DUE_DATE_")
    private DateTime dueDate;

    @Column(name = "DURATION_")
    private Long duration;

    @Column(name = "IS_ACTIVE_", length = 1, nullable = false)
    private Boolean isActive;

    public void end(){
        this.setEndTime(new DateTime());
        this.setDuration(this.getEndTime().getMillis() - this.getStartTime().getMillis());
        this.setActive(false);
        em.merge(this);
    }

    public ProcessInst getProcessInst() {
        return processInst;
    }

    public void setProcessInst(ProcessInst processInst) {
        this.processInst = processInst;
    }

    public NodeDef getNodeDef() {
        return nodeDef;
    }

    public void setNodeDef(NodeDef nodeDef) {
        this.nodeDef = nodeDef;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(DateTime claimTime) {
        this.claimTime = claimTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public DateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(DateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
