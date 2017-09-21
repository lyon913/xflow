package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.consts.NodeType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue(NodeType.START)
public class StartNodeDef extends NodeDef{
    @Override
    public void execute() {
        List<Transition> transitions = getTransitions();
    }

}
