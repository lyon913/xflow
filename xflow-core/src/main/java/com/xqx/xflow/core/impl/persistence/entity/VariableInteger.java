package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.consts.VariableType;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(VariableType.INTEGER)
public class VariableInteger extends Variable{
    @Column(name = "INT_VALUE_")
    private Integer intValue;

    @Override
    public Object getValue() {
        return this.getIntValue();
    }

    @Override
    public void setValue(Object value) {
        this.setIntValue((Integer) value);
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }
}
