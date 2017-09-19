package com.xqx.xflow.core.impl.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TOKEN_", indexes = {})
public class Token extends BaseIdEntity{


    @ManyToOne
    @JoinColumn(name = "PARENT_ID_")
    private Token parent;

    @OneToMany(mappedBy = "parent")
    private List<Token> children;

    @ManyToOne
    private NodeDef node;
}
