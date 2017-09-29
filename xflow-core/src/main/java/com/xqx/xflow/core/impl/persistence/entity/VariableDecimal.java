package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.consts.VariableType;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(VariableType.DECIMAL)
public class VariableDecimal extends Variable{
    @Column(name = "DECIMAL_VALUE_")
    private BigDecimal decimalValue;

    @Override
    public Object getValue() {
        return this.getDecimalValue();
    }

    @Override
    public void setValue(Object value) {
        this.setDecimalValue((BigDecimal)value);
    }

    public BigDecimal getDecimalValue() {
        return decimalValue;
    }

    public void setDecimalValue(BigDecimal decimalValue) {
        this.decimalValue = decimalValue;
    }
}
