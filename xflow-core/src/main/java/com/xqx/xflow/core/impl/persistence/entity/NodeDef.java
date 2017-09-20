package com.xqx.xflow.core.impl.persistence.entity;


import javax.persistence.*;

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
