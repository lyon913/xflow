package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.db.PersistentObject;

import javax.annotation.Generated;

/**
 * XflTaskDef is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class XflTaskDef implements PersistentObject {

    private String candidateGroup;

    private String candidateUser;

    private String category;

    private String id;

    private String name;

    private String procInstId;

    private String taskDesc;

    private String taskDueTime;

    public String getCandidateGroup() {
        return candidateGroup;
    }

    public void setCandidateGroup(String candidateGroup) {
        this.candidateGroup = candidateGroup;
    }

    public String getCandidateUser() {
        return candidateUser;
    }

    public void setCandidateUser(String candidateUser) {
        this.candidateUser = candidateUser;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getTaskDueTime() {
        return taskDueTime;
    }

    public void setTaskDueTime(String taskDueTime) {
        this.taskDueTime = taskDueTime;
    }

}

