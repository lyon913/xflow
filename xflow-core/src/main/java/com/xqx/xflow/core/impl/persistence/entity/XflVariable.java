package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.db.PersistentObject;

import javax.annotation.Generated;

/**
 * XflVariable is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class XflVariable implements PersistentObject {

    private String category;

    private Double doubleValue;

    private String id;

    private Integer intValue;

    private String name;

    private String procInstId;

    private String taskInstId;

    private String textValue;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getTaskInstId() {
        return taskInstId;
    }

    public void setTaskInstId(String taskInstId) {
        this.taskInstId = taskInstId;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

}

