package com.xqx.xflow.core.impl.db;

import org.apache.ibatis.session.SqlSession;

/**
 * Created by Lyon on 2017/2/10.
 */
public class DbSqlSession {
    protected IdGenerator idGenerator;
    protected SqlSession sqlSession;

    public void insert(PersistentObject entity) {
        if(entity.getId() == null){
            entity.setId(idGenerator.getNextId());
        }
        sqlSession.insert("",entity);
    }
}
