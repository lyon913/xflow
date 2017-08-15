package com.xqx.xflow.core.impl.persistence.dao;

import com.querydsl.core.types.Constant;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.sql.RelationalPath;
import com.querydsl.sql.SQLQueryFactory;
import com.xqx.xflow.core.XflowException;
import com.xqx.xflow.core.impl.cfg.IdGenerator;
import com.xqx.xflow.core.impl.db.PersistentObject;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Lyon on 2017/2/14.
 */
public class AbstractDao<Q extends RelationalPath<E>, E extends PersistentObject> {
    protected SQLQueryFactory queryFactory;

    protected IdGenerator idGenerator;


    protected Class<Q> getQClass(){
        return (Class<Q>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Class<E> getEClass(){
        return (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected Q getQType(){
        try {
            Class<Q> qClass = getQClass();
            return qClass.newInstance();
        } catch (Exception e) {
            throw new XflowException(e.getMessage(), e);
        }
    }

    public SQLQueryFactory getQueryFactory() {
        return queryFactory;
    }

    public void setQueryFactory(SQLQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public void insert(E object){
        if(object.getId() == null){
            object.setId(idGenerator.getNextId());
        }
        queryFactory.insert(getQType()).populate(object).execute();
    }

    public void delete(E entity){
        PathBuilder<E> builder = new PathBuilder<E>(getEClass(),"entity");
        Path<E> entityClass = Expressions.path(getEClass(), "entity");
        Path<String> idFiled = Expressions.path(String.class, entityClass, "id");
        String id = entity.getId();
       Constant<String> constant = Expressions.constant(id);

        Expressions.predicate(Ops.equalsOps,idFiled,entity.getId());
        queryFactory.delete(getQType()).where();
    }

}
