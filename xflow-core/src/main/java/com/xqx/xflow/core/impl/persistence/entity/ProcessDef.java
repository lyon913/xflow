package com.xqx.xflow.core.impl.persistence.entity;

import java.util.Date;

/**
 * 流程定义实体
 * Created by Lyon on 2017/1/23.
 */
public class ProcessDef extends IdEntity {
    /**
     * 流程名称
     */
    private String name;

    /**
     * 流程描述
     */
    private String description;

    /**
     * 候选用户组
     */
    private String candidateGroup;

    /**
     * 流程分类
     */
    private String processType;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCandidateGroup() {
        return candidateGroup;
    }

    public void setCandidateGroup(String candidateGroup) {
        this.candidateGroup = candidateGroup;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
