package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.consts.NodeType;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(NodeType.USER_TASK)
public class UserTaskNodeDef extends NodeDef{

    @Column(name = "ASSIGNEE_ID_", length = 64)
    private String assigneeId;

    @Column(name = "ASSIGNEE_NAME_", length = 255)
    private String assigneeName;

    @Column(name = "CANDIDATE_GROUPS_", length = 500)
    private String candidateGroups;

    @Column(name = "CANDIDATE_USERS_", length = 500)
    private String candidateUsers;

    @Column(name = "FORM_KEY_", length = 1000)
    private String formKey;

    @Column(name = "DUE_DATE_")
    private String dueDate;

    @Column(name = "IS_ACTIVE_", length = 1)
    private Boolean isActive;

    @Override
    public void execute() {

    }

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
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

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
