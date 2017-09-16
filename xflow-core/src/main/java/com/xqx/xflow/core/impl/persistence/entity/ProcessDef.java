package com.xqx.xflow.core.impl.persistence.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * Created by Lyon on 2017/9/16.
 */
@Entity
@Table(name = "XFL_PROCESS_DEF", indexes = {@Index(name="IDX_PROC_DEF_KEY", columnList = "KEY_"),@Index(name="IDX_PROC_DEF_NAME", columnList = "NAME_")})
public class ProcessDef extends BaseIdEntity{
    @Column(name = "KEY_", length = 50, nullable = false,unique = true)
    private String key;

    @Column(name = "NAME_", length = 200, nullable = false)
    private String name;

    @Column(name = "CATEGORY_", length = 50)
    private String category;

    @Column(name = "CANDIDATE_GROUP_", length = 50)
    private String candidateGroup;

    @Column(name = "CANDIDATE_USER_", length = 50)
    private String candidateUser;

    @Column(name = "DUE_DATE_", length = 50)
    private String dueDate;

    @Column(name = "DESC_", length = 500)
    private String desc;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
