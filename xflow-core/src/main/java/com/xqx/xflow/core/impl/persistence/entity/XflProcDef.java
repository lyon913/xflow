package com.xqx.xflow.core.impl.persistence.entity;

import javax.annotation.Generated;

import com.xqx.xflow.core.impl.Authentication;
import com.xqx.xflow.core.impl.context.Context;
import com.xqx.xflow.core.impl.db.PersistentObject;
import com.xqx.xflow.core.impl.persistence.repository.TaskDefRepository;
import com.xqx.xflow.core.impl.util.DateUtil;
import org.joda.time.DateTime;

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



    public XflProcInst createProcInst(String businessKey){
        XflProcInst inst = new XflProcInst();
        inst.setProcDefId(this.getId());
        inst.setBusinessKey(businessKey);
        inst.setStartUserId(Authentication.getUserId());
        inst.setStartUserName(Authentication.getUserName());
        inst.setProcDefId(this.getId());
        inst.setDueDate(DateUtil.parsePeriod(this.getDueDate()));
        inst.setStartTime(new DateTime());
        inst.setActive(true);

        Context.getDbContext().getProcInstRepository().insert(inst);
        return inst;
    }

    public XflTaskDef findStartNode(){
        TaskDefRepository taskDefRepo = Context.getDbContext().getTaskDefRepository();
        return taskDefRepo.findStartTask(this.getId());
    }




    //  getters n setters //

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

