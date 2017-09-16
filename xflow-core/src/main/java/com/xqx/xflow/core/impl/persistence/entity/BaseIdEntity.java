package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.db.PersistentObject;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Lyon on 2017/9/16.
 */
@MappedSuperclass
public class BaseIdEntity implements PersistentObject{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid" , strategy = "uuid2")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(Hibernate.getClass(this) != Hibernate.getClass(obj)){
            return false;
        }
        if(!(obj instanceof BaseIdEntity)){
            return false;
        }
        if(this.id == null || ((BaseIdEntity) obj).id == null){
            return super.equals(obj);
        }else{
            return this.getId().equals(((BaseIdEntity) obj).getId());
        }
    }

    @Override
    public String toString() {
        return Hibernate.getClass(this).getName()+";id:"+getId();
    }
}
