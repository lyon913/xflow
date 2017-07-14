package com.xqx.xflow.core.impl.persistence.entity;

import javax.annotation.Generated;

/**
 * XflProcessDef is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class XflProcessDef {

    private String candidateGroup;

    private String creator;

    private java.sql.Timestamp gtmCreate;

    private java.sql.Timestamp gtmModify;

    private String id;

    private String name;

    private String processDesc;

    private String processType;

    public String getCandidateGroup() {
        return candidateGroup;
    }

    public void setCandidateGroup(String candidateGroup) {
        this.candidateGroup = candidateGroup;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public java.sql.Timestamp getGtmCreate() {
        return gtmCreate;
    }

    public void setGtmCreate(java.sql.Timestamp gtmCreate) {
        this.gtmCreate = gtmCreate;
    }

    public java.sql.Timestamp getGtmModify() {
        return gtmModify;
    }

    public void setGtmModify(java.sql.Timestamp gtmModify) {
        this.gtmModify = gtmModify;
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

    public String getProcessDesc() {
        return processDesc;
    }

    public void setProcessDesc(String processDesc) {
        this.processDesc = processDesc;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

}

