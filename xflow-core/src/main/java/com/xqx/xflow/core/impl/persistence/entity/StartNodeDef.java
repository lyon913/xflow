package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.consts.NodeType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(NodeType.START)
public class StartNodeDef extends NodeDef{
    @Override
    public void execute() {

    }

}
