package com.xqx.xflow.core.impl.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "XFL_VARIABLE", indexes = {@Index(
        name = "IDX_VAR_NAME",
        columnList = "NAME_"
)})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_", length = 64)
public abstract class Variable extends BaseIdEntity {

    @ManyToOne()
    @JoinColumn(name = "PROCESS_INST_ID_")
    private ProcessInst processInst;

    @ManyToOne()
    @JoinColumn(name = "ACTIVITY_ID_")
    private Activity activity;

    @Column(name = "NAME_", length = 500, nullable = false)
    private String name;

    @Transient
    public abstract Object getValue();

    @Transient
    public abstract void setValue(Object value);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
