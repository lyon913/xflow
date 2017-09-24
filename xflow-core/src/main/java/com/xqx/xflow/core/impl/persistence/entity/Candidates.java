package com.xqx.xflow.core.impl.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "XFL_CANDIATES")
public class Candidates extends BaseIdEntity{

    @ManyToOne
    @JoinColumn(name = "PROCESS_DEF_ID_")
    private ProcessDef processDef;

    @ManyToOne
    @JoinColumn(name = "PROCESS_INST_ID_")
    private ProcessInst processInst;

    @ManyToOne
    @JoinColumn(name = "ACTIVITY_ID_")
    private Activity activity;

    @Column(name = "CANDIDATE_USER_ID_", length = 255)
    private String candidateUser;

    @Column(name = "CANDIDATE_GROUP_ID_", length = 255)
    private String candidateGroup;

    public ProcessDef getProcessDef() {
        return processDef;
    }

    public void setProcessDef(ProcessDef processDef) {
        this.processDef = processDef;
    }

    public ProcessInst getProcessInst() {
        return processInst;
    }

    public void setProcessInst(ProcessInst processInst) {
        this.processInst = processInst;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getCandidateUser() {
        return candidateUser;
    }

    public void setCandidateUser(String candidateUser) {
        this.candidateUser = candidateUser;
    }

    public String getCandidateGroup() {
        return candidateGroup;
    }

    public void setCandidateGroup(String candidateGroup) {
        this.candidateGroup = candidateGroup;
    }
}
