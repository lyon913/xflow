package com.xqx.xflow.core.impl.persistence.entity;

import javax.annotation.Generated;
import com.xqx.xflow.core.impl.db.PersistentObject;

/**
 * XflProcDef is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class XflProcDef implements PersistentObject {

    private String candidateGroup;

    private String category;

    private String dueDate;

    private String id;

    private String name;

    private String procDesc;

    private String procKey;

    private Boolean valid;

    public String getCandidateGroup() {
        return candidateGroup;
    }

    public void setCandidateGroup(String candidateGroup) {
        this.candidateGroup = candidateGroup;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
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

    public String getProcDesc() {
        return procDesc;
    }

    public void setProcDesc(String procDesc) {
        this.procDesc = procDesc;
    }

    public String getProcKey() {
        return procKey;
    }

    public void setProcKey(String procKey) {
        this.procKey = procKey;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

}

