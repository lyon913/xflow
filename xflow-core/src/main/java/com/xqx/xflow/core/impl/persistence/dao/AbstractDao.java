package com.xqx.xflow.core.impl.persistence.dao;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.sql.RelationalPath;
import com.querydsl.sql.RelationalPathBase;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.dml.DefaultMapper;
import com.xqx.xflow.core.XflowException;
import com.xqx.xflow.core.impl.cfg.IdGenerator;
import com.xqx.xflow.core.impl.db.PersistentObject;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Lyon on 2017/2/14.
 */
public class AbstractDao<E extends PersistentObject> {
    protected SQLQueryFactory queryFactory;

    protected IdGenerator idGenerator;

    public AbstractDao(SQLQueryFactory queryFactory, IdGenerator idGenerator){
        this.queryFactory = queryFactory;
        this.idGenerator = idGenerator;
    }


//    protected Class<Q> getQClass() {
//        return (Class<Q>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//    }

    protected Class<E> getEClass() {
        return (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
//
//    protected Q getQType() {
//        try {
//            Class<Q> qClass = getQClass();
//            Field instanceFiled = qClass.getField("instance");
//            return (Q)instanceFiled.get(qClass);
//        } catch (Exception e) {
//            throw new XflowException(e.getMessage(), e);
//        }
//    }

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
        queryFactory.insert(getQType()).populate(object).execute();
    }

    /**
     * 删除记录
     * @param entity
     */
    public void delete(E entity) {
        Predicate p = findByIdPredicate(entity.getId());
        queryFactory.delete(getQType()).where(p).execute();
    }

    /**
     * 更新记录
     * @param entity
     */
    public void update(E entity) {
        queryFactory.update(getPathBuilder(entity)).populate(entity, DefaultMapper.WITH_NULL_BINDINGS).execute();
    }

    protected PathBuilder<E> getPathBuilder(E entity){
        return new PathBuilder<E>(getEClass(),"entity");
    }

    protected Predicate findByIdPredicate(String id){
        Path<E> entityPath = Expressions.path(getEClass(), "entity");
        Path<String> idPath = Expressions.path(String.class, entityPath, "id");
        Expression<String> constant = Expressions.constant(id);
        Predicate p = Expressions.predicate(Ops.EQ, idPath, constant);
        return p;
    }

    public E selectById(String id){
        Predicate p = findByIdPredicate(id);
        return queryFactory.selectFrom(getQType()).where(p).fetchOne();
    }

}
