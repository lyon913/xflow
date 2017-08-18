package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.db.PersistentObject;

import javax.annotation.Generated;

/**
 * XflProcInst is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class XflProcInst implements PersistentObject {

    private String businessKey;

    private Long duration;

    private java.sql.Timestamp endTime;

    private String id;

    private Byte isActive;

    private Byte isDeleted;

    private String procDefId;

    private java.sql.Timestamp startTime;

    private String startUserId;

    private String startUserName;

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
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

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public java.sql.Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(java.sql.Timestamp startTime) {
        this.startTime = startTime;
    }

    public String getStartUserId() {
        return startUserId;
    }

    public void setStartUserId(String startUserId) {
        this.startUserId = startUserId;
    }

    public String getStartUserName() {
        return startUserName;
    }

    public void setStartUserName(String startUserName) {
        this.startUserName = startUserName;
    }

}

