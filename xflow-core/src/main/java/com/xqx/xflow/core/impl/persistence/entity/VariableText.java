package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.consts.VariableType;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(VariableType.TEXT)
public class VariableText extends Variable {

    @Column(name = "STRING_VALUE_", length = 4000)
    private String textValue;

    @Override
    public Object getValue() {
        return textValue;
    }

    @Override
    public void setValue(Object value) {
        this.setTextValue((String) value);
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }
}
