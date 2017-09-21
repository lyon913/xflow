package com.xqx.xflow.core.impl.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "XFL_NODE_DEF",
        indexes = {
                @Index(name = "IDX_ND_PROC_ID",columnList = "PROCESS_DEF_ID_")
        })
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "NODE_TYPE_")
public abstract class NodeDef extends BaseIdEntity{

    @ManyToOne(optional = false)
    @JoinColumn(name = "PROCESS_DEF_ID_")
    private ProcessDef processDef;

    @Column(name = "NAME_" , length = 255, nullable = false)
    private String name;

    @OneToMany(mappedBy="sourceNode")
    private List<Transition> transitions;

    public ProcessDef getProcessDef() {
        return processDef;
    }

    public void setProcessDef(ProcessDef processDef) {
        this.processDef = processDef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

    abstract public void execute();

    public void enter(){

    }

    private Activity createActivity(){
        return null;
    }

    public void leave(Transition transition){
        transition.take();
    }

}
