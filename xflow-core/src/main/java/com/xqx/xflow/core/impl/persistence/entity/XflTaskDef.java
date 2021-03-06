package com.xqx.xflow.core.impl.persistence.entity;

import javax.annotation.Generated;

import com.xqx.xflow.core.impl.context.Context;
import com.xqx.xflow.core.impl.db.PersistentObject;
import com.xqx.xflow.core.impl.util.DateUtil;
import org.joda.time.DateTime;

import java.util.List;

/**
 * XflTaskDef is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class XflTaskDef implements PersistentObject {

    private String candidateGroup;

    private String candidateUser;

    private String dueDate;

    private String id;

    private String name;

    private String procDefId;

    private String taskDesc;

    private String taskType;

    public List<XflFlowDef> findOutFlows(){
        return Context.getDbContext().getFlowDefRepository().selectBySourceId(this.getId());
    }

    public XflTaskInst createTaskInstance(XflProcInst procInst){
        XflTaskInst inst = new XflTaskInst();
        inst.setProcInstId(procInst.getId());
        inst.setTaskDefId(this.getId());
        inst.setStartTime(new DateTime());
        inst.setDueDate(DateUtil.parsePeriod(this.getDueDate()));
        inst.setActive(true);
        Context.getDbContext().getTaskInstRepository().insert(inst);
        return inst;
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

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

}

