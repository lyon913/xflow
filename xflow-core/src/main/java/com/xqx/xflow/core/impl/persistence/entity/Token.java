package com.xqx.xflow.core.impl.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Token extends BaseIdEntity{

    @ManyToOne
    private Token parent;
}
