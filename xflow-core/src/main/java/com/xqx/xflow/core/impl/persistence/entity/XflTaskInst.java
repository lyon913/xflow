package com.xqx.xflow.core.impl.persistence.entity;

import javax.annotation.Generated;

/**
 * XflTaskInst is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class XflTaskInst {

    private java.sql.Timestamp claimTime;

    private java.sql.Timestamp dueTime;

    private Long duration;

    private java.sql.Timestamp endTime;

    private String id;

    private Byte isActive;

    private Byte isDeleted;

    private String procInstId;

    private java.sql.Timestamp startTime;

    private String taskAssignee;

    private String taskAssigneeName;

    private String taskDefId;

    private String taskOwner;

    private String taskOwnerName;

    public java.sql.Timestamp getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(java.sql.Timestamp claimTime) {
        this.claimTime = claimTime;
    }

    public java.sql.Timestamp getDueTime() {
        return dueTime;
    }

    public void setDueTime(java.sql.Timestamp dueTime) {
        this.dueTime = dueTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public java.sql.Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(java.sql.Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public java.sql.Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(java.sql.Timestamp startTime) {
        this.startTime = startTime;
    }

    public String getTaskAssignee() {
        return taskAssignee;
    }

    public void setTaskAssignee(String taskAssignee) {
        this.taskAssignee = taskAssignee;
    }

    public String getTaskAssigneeName() {
        return taskAssigneeName;
    }

    public void setTaskAssigneeName(String taskAssigneeName) {
        this.taskAssigneeName = taskAssigneeName;
    }

    public String getTaskDefId() {
        return taskDefId;
    }

    public void setTaskDefId(String taskDefId) {
        this.taskDefId = taskDefId;
    }

    public String getTaskOwner() {
        return taskOwner;
    }

    public void setTaskOwner(String taskOwner) {
        this.taskOwner = taskOwner;
    }

    public String getTaskOwnerName() {
        return taskOwnerName;
    }

    public void setTaskOwnerName(String taskOwnerName) {
        this.taskOwnerName = taskOwnerName;
    }

}

