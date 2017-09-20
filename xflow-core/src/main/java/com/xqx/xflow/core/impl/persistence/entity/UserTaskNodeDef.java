package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.consts.NodeType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(NodeType.USER_TASK)
public class UserTaskNodeDef extends NodeDef{
    @Override
    public void execute() {

    }

}
