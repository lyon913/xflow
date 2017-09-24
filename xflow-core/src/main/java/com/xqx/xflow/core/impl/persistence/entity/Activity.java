package com.xqx.xflow.core.impl.persistence.entity;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "XFL_ACTIVITY", indexes = {})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ACTIVITY_TYPE_", length = 64)
public abstract class Activity extends BaseIdEntity{
    @PersistenceContext
    @Transient
    protected EntityManager em;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PROCESS_INST_ID_")
    private ProcessInst processInst;

    @ManyToOne(optional = false)
    @JoinColumn(name = "NODE_DEF_ID_")
    private NodeDef nodeDef;

    @Column(name = "NODE_NAME_",length = 255)
    private String nodeName;


    @Column(name = "START_TIME_",nullable = false)
    private DateTime startTime;

    @Column(name = "END_TIME_")
    private DateTime endTime;

    @Column(name = "DURATION_")
    private Long duration;

    @Column(name = "IS_ACTIVE_", length = 1, nullable = false)
    private Boolean isActive;

    public void end(){
        this.setEndTime(new DateTime());
        this.setDuration(this.getEndTime().getMillis() - this.getStartTime().getMillis());
        this.setActive(false);
        em.merge(this);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public ProcessInst getProcessInst() {
        return processInst;
    }

    public void setProcessInst(ProcessInst processInst) {
        this.processInst = processInst;
    }

    public NodeDef getNodeDef() {
        return nodeDef;
    }

    public void setNodeDef(NodeDef nodeDef) {
        this.nodeDef = nodeDef;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
