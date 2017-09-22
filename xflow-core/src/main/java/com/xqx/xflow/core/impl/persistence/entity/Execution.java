package com.xqx.xflow.core.impl.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "XFL_EXECUTION")
public class Execution extends BaseIdEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "PROCESS_INST_ID_")
    private ProcessInst processInst;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ACTIVITY_ID_")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID_")
    private Execution parent;

    @OneToMany(mappedBy = "parent")
    private List<Execution> children;

    @Column(name = "IS_ACTIVE_",length = 1,nullable = false)
    private Boolean isActive;

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

    public Execution getParent() {
        return parent;
    }

    public void setParent(Execution parent) {
        this.parent = parent;
    }

    public List<Execution> getChildren() {
        return children;
    }

    public void setChildren(List<Execution> children) {
        this.children = children;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
