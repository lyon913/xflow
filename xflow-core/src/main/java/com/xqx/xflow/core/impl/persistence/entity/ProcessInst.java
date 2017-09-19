package com.xqx.xflow.core.impl.persistence.entity;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "XFL_PROCESS_INST")
public class ProcessInst extends BaseIdEntity {
    /**
     * 流程定义
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "PROCESS_DEF_ID_")
    private ProcessDef processDef;

    /**
     * 业务号
     */
    @Column(name = "BUSINESS_KEY_", length = 255, unique = true, nullable = false)
    private String businessKey;

    /**
     * 流程启动时间
     */
    @Column(name = "START_TIME_", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private DateTime startTime;

    /**
     * 流程结束时间
     */
    @Column(name = "END_TIME_")
    @Temporal(TemporalType.TIMESTAMP)
    private DateTime endTime;

    /**
     * 流程耗时
     */
    @Column(name = "DURATION_")
    private Long duration;

    /**
     * 启动用户的id
     */
    @Column(name = "START_USER_ID_",length = 64)
    private String startUserId;

    /**
     * 启动用户的姓名
     */
    @Column(name = "START_USER_NAME_",length = 255)
    private String startUserName;

    /**
     * 结束用户的id
     */
    @Column(name = "END_USER_ID_",length = 64)
    private String endUserId;

    /**
     * 结束用户的姓名
     */
    @Column(name = "END_USER_NAME_",length = 255)
    private String endUserName;

    /**
     * 流程预定办结期限（判断是否超期）
     */
    @Column(name = "DUE_DATE_")
    @Temporal(TemporalType.TIMESTAMP)
    private DateTime dueDate;

    /**
     * 流程是否处于活动状态
     */
    @Column(name = "IS_ACTIVE_", length = 1, nullable = false)
    private Boolean isActive;

    @Column(name = "DELETE_REASON_", length = 500)
    private String deleteReason;

    public ProcessDef getProcessDef() {
        return processDef;
    }

    public void setProcessDef(ProcessDef processDef) {
        this.processDef = processDef;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
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

    public String getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(String endUserId) {
        this.endUserId = endUserId;
    }

    public String getEndUserName() {
        return endUserName;
    }

    public void setEndUserName(String endUserName) {
        this.endUserName = endUserName;
    }

    public DateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(DateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getDeleteReason() {
        return deleteReason;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
    }
}
