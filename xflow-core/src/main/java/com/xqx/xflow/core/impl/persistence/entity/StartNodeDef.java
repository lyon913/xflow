package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.context.ExecutionContext;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("START")
public class StartNodeDef extends NodeDef{
    @Override
    public void execute() {

    }

    @Override
    public void enter() {

    }

    @Override
    public void leave() {

    }
}
