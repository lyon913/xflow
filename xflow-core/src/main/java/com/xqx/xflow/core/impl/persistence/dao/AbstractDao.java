package com.xqx.xflow.core.impl.persistence.dao;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.sql.RelationalPathBase;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.dml.DefaultMapper;
import com.xqx.xflow.core.XflowException;
import com.xqx.xflow.core.impl.cfg.IdGenerator;
import com.xqx.xflow.core.impl.db.PersistentObject;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Lyon on 2017/2/14.
 */
public class AbstractDao<Q extends RelationalPathBase<E>, E extends PersistentObject, T extends Serializable> {
    protected Q qType;
    protected SQLQueryFactory queryFactory;
    protected IdGenerator idGenerator;

    private static final String VARIABLE = "t";
    private static final String ID_FIELD = "id";

    public AbstractDao(){
        this.qType = getQTypeInstance();
    }


    protected Class<Q> getQClass() {
        return (Class<Q>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private Q getQTypeInstance(){
        try {
            Constructor<Q> constructor = getQClass().getDeclaredConstructor(String.class);
            return constructor.newInstance(VARIABLE);
        } catch (Exception e) {
            throw new XflowException(e.getMessage(),e);
        }
    }
    protected Class<E> getEClass() {
        return (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }


    protected Path<T> getIdPath(){
        try {
            Field idField = getQClass().getDeclaredField(ID_FIELD);
            Path<T> path = (Path<T>)idField.get(qType);
            return path;
        } catch (Exception e) {
            throw new XflowException(e.getMessage(),e);
        }
    }

    protected Predicate getIdPredicate(T id){
        Expression<T> constant = Expressions.constant(id);
        Predicate p = Expressions.predicate(Ops.EQ,getIdPath(),constant);
        return p;
    }

    public SQLQueryFactory getQueryFactory() {
        return queryFactory;
    }

    public void setQueryFactory(SQLQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    public IdGenerator getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    /**
     * 插入记录
     * @param object
     */
    public void insert(E object) {
        if (object.getId() == null) {
            object.setId(idGenerator.getNextId());
        }
        queryFactory.insert(qType).populate(object).execute();
    }

    /**
     * 删除记录
     * @param entity
     */
    public void delete(E entity) {
        Predicate p = getIdPredicate((T)entity.getId());
        queryFactory.delete(qType).where(p).execute();
    }


    /**
     * 删除记录
     * @param id
     */
    public void delete(T id) {
        Predicate p = getIdPredicate(id);
        queryFactory.delete(qType).where(p).execute();
    }

    /**
     * 更新记录
     * @param entity
     */
    public void update(E entity) {
        queryFactory.update(qType).populate(entity, DefaultMapper.WITH_NULL_BINDINGS).where(getIdPredicate((T)entity.getId())).execute();
    }

    /**
     * 用id查询
     * @param id
     * @return
     */
    public E selectById(T id){
        Predicate p = getIdPredicate(id);
        return queryFactory.selectFrom(qType).where(p).fetchOne();
    }

}
