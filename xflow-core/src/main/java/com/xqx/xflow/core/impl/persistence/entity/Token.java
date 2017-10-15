package com.xqx.xflow.core.impl.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "XFL_EXECUTION")
public class Token extends BaseIdEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "PROCESS_INST_ID_")
    private ProcessInst processInst;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ACTIVITY_ID_")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID_")
    private Token parent;

    @OneToMany(mappedBy = "parent")
    private List<Token> children;

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

    public Token getParent() {
        return parent;
    }

    public void setParent(Token parent) {
        this.parent = parent;
    }

    public List<Token> getChildren() {
        return children;
    }

    public void setChildren(List<Token> children) {
        this.children = children;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
