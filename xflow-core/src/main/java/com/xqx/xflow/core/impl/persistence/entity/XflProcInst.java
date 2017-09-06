package com.xqx.xflow.core.impl.persistence.entity;

import javax.annotation.Generated;
import com.xqx.xflow.core.impl.db.PersistentObject;

/**
 * XflProcInst is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class XflProcInst implements PersistentObject {

    private Boolean active;

    private String businessKey;

    private org.joda.time.DateTime dueDate;

    private Long duration;

    private org.joda.time.DateTime endTime;

    private String id;

    private String procDefId;

    private org.joda.time.DateTime startTime;

    private String startUserId;

    private String startUserName;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
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

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public org.joda.time.DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(org.joda.time.DateTime startTime) {
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

