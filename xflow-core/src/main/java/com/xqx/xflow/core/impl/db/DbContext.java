package com.xqx.xflow.core.impl.db;

import com.querydsl.sql.SQLQueryFactory;
import com.xqx.xflow.core.impl.cfg.IdGenerator;
import com.xqx.xflow.core.impl.persistence.repository.AbstractRepoistory;

public class DbContext {
    private IdGenerator idGenerator;

    private SQLQueryFactory queryFactory;

    public <T extends AbstractRepoistory> T getDao(Class<T> cls){
        try {
            T dao = cls.newInstance();
            initDao(dao);
            return dao;
        } catch (Exception e) {
            throw new RuntimeException("无法实例化对象", e);
        }

    }

    private <T extends AbstractRepoistory> void initDao(T dao){
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
