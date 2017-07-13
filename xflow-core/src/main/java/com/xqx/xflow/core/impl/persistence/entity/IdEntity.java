package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.db.PersistentObject;

import java.io.Serializable;

/**
 * Created by Lyon on 2017/1/23.
 */
public abstract class IdEntity implements PersistentObject, Serializable {

    protected String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}