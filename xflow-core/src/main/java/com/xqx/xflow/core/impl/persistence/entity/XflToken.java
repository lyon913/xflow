package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.db.PersistentObject;

public class XflToken implements PersistentObject {
    private String id;
    private String procInstId;
    private String taskInstId;
    private String parentId;
    private Integer status;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
