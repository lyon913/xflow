package com.xqx.xflow.core.impl.cfg;

import com.querydsl.sql.SQLQueryFactory;
import com.xqx.xflow.core.impl.persistence.dao.AbstractDao;

public class DaoFactory {
    private IdGenerator idGenerator;

    private SQLQueryFactory queryFactory;

    public <T extends AbstractDao> T getDao(Class<T> cls){
        try {
            T dao = cls.newInstance();
            initDao(dao);
            return dao;
        } catch (Exception e) {
            throw new RuntimeException("无法实例化对象", e);
        }

    }

    private <T extends AbstractDao> void initDao(T dao){
        dao.setIdGenerator(idGenerator);
        dao.setQueryFactory(queryFactory);
    }

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public SQLQueryFactory getQueryFactory() {
        return queryFactory;
    }

    public void setQueryFactory(SQLQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


}
