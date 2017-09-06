package com.xqx.xflow.core.impl.persistence.entity;

import javax.annotation.Generated;
import com.xqx.xflow.core.impl.db.PersistentObject;

/**
 * XflComment is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class XflComment implements PersistentObject {

    private String category;

    private org.joda.time.DateTime createTime;

    private String id;

    private String msg;

    private String procInstId;

    private String taskInstId;

    private String userId;

    private String userName;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public org.joda.time.DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(org.joda.time.DateTime createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getTaskInstId() {
        return taskInstId;
    }

    public void setTaskInstId(String taskInstId) {
        this.taskInstId = taskInstId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}

