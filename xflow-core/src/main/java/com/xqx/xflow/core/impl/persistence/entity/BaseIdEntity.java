package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.db.PersistentObject;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 有ID的实体基类
 * Created by Lyon on 2017/9/16.
 */
@MappedSuperclass
public class BaseIdEntity implements PersistentObject{
    /**
     * ID主键
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid" , strategy = "uuid2")
    @Column(name = "ID_",length = 64)
    private String id;

    /**
     * 乐观锁（防止多人同时修改同一记录）
     */
    @Version
    @Column(name = "LOCK_VER_")
    private Integer lockVer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLockVer() {
        return lockVer;
    }

    public void setLockVer(Integer lockVer) {
        this.lockVer = lockVer;
    }

    /**
     * 判定实体是否相等
     * @param obj
     * @return
     */
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
