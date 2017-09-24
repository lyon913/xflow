package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.XflowException;
import com.xqx.xflow.core.impl.consts.NodeType;
import com.xqx.xflow.core.impl.util.DateUtil;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

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

    @Override
    public void execute(Execution execution) {
        //waiting for user commit task
    }

    public void commit(Execution execution){
        List<Transition> transitions = getAvailableTransitions();
        if(transitions.size() != 1){
            throw new XflowException("Availible transition number must be 1.");
        }
        leave(execution, transitions.get(0));
    }

    @Override
    protected Activity createActivity(ProcessInst processInst) {
        UserTaskActivity act = new UserTaskActivity();
        act.setActive(true);
        act.setProcessInst(processInst);
        act.setNodeDef(this);
        act.setNodeName(this.getName());
        act.setStartTime(new DateTime());
        act.setDueDate(DateUtil.parsePeriod(this.getDueDate()));
        em.persist(act);
        return act;
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


}
