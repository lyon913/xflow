package com.xqx.xflow.core.impl.persistence.entity;

import javax.annotation.Generated;
import com.xqx.xflow.core.impl.db.PersistentObject;

/**
 * XflTaskInst is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class XflTaskInst implements PersistentObject {

    private Boolean active;

    private org.joda.time.DateTime claimTime;

    private org.joda.time.DateTime dueDate;

    private Long duration;

    private org.joda.time.DateTime endTime;

    private String id;

    private String procInstId;

    private org.joda.time.DateTime startTime;

    private String taskAssignee;

    private String taskAssigneeName;

    private String taskDefId;

    private String taskOwner;

    private String taskOwnerName;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public org.joda.time.DateTime getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(org.joda.time.DateTime claimTime) {
        this.claimTime = claimTime;
    }

    public org.joda.time.DateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(org.joda.time.DateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public org.joda.time.DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(org.joda.time.DateTime endTime) {
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public org.joda.time.DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(org.joda.time.DateTime startTime) {
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

