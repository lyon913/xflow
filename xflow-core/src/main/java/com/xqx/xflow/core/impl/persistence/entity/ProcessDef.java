package com.xqx.xflow.core.impl.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * Created by Lyon on 2017/9/16.
 */
@Entity
@Table(
        name = "XFL_PROCESS_DEF",
        indexes = {
                @Index(name = "IDX_PROC_DEF_KEY", columnList = "KEY_"),
                @Index(name = "IDX_PROC_DEF_NAME", columnList = "NAME_")
        })
public class ProcessDef extends BaseIdEntity {
    @Column(name = "KEY_", length = 255, nullable = false, unique = true)
    private String key;

    @Column(name = "NAME_", length = 255, nullable = false)
    private String name;

    @Column(name = "CATEGORY_", length = 255)
    private String category;

    @Column(name = "CANDIDATE_GROUPS_", length = 500)
    private String candidateGroups;

    @Column(name = "CANDIDATE_USERS_", length = 500)
    private String candidateUsers;

    @Column(name = "DUE_DATE_", length = 255)
    private String dueDate;

    @Column(name = "DESC_", length = 2000)
    private String desc;

    @Column(name = "VER_")
    private Long ver;

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

    public String getCandidateGroups() {
        return candidateGroups;
    }

    public void setCandidateGroups(String candidateGroups) {
        this.candidateGroups = candidateGroups;
    }

    public String getCandidateUsers() {
        return candidateUsers;
    }

    public void setCandidateUsers(String candidateUsers) {
        this.candidateUsers = candidateUsers;
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

    public Long getVer() {
        return ver;
    }

    public void setVer(Long ver) {
        this.ver = ver;
    }
}
