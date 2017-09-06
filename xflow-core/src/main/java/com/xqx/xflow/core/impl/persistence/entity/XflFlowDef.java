package com.xqx.xflow.core.impl.persistence.entity;

import javax.annotation.Generated;
import com.xqx.xflow.core.impl.db.PersistentObject;

/**
 * XflFlowDef is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class XflFlowDef implements PersistentObject {

    private String conditionExp;

    private String flowDesc;

    private String id;

    private String name;

    private String sourceTdefId;

    private String targetTdefId;

    public String getConditionExp() {
        return conditionExp;
    }

    public void setConditionExp(String conditionExp) {
        this.conditionExp = conditionExp;
    }

    public String getFlowDesc() {
        return flowDesc;
    }

    public void setFlowDesc(String flowDesc) {
        this.flowDesc = flowDesc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceTdefId() {
        return sourceTdefId;
    }

    public void setSourceTdefId(String sourceTdefId) {
        this.sourceTdefId = sourceTdefId;
    }

    public String getTargetTdefId() {
        return targetTdefId;
    }

    public void setTargetTdefId(String targetTdefId) {
        this.targetTdefId = targetTdefId;
    }

}

