package com.xqx.xflow.core.impl.db;

import com.xqx.xflow.core.impl.cfg.IdGenerator;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by Lyon on 2017/2/10.
 */
public class DbSqlSession {
    protected IdGenerator idGenerator;
    protected DbSqlSessionFactory dbSqlSessionFacotory;
    protected SqlSession sqlSession;

    public DbSqlSession(DbSqlSessionFactory dbSqlSessionFacotory){
        this.dbSqlSessionFacotory = dbSqlSessionFacotory;
        this.sqlSession = dbSqlSessionFacotory.getSqlSessionFactory().openSession();
    }

    public void insert(PersistentObject object) {
        if(object.getId() == null){
            String id = dbSqlSessionFacotory.getIdGenerator().getNextId();
            object.setId(id);
        }

        String insertStatement = dbSqlSessionFacotory.getInsertStatement(object);
        sqlSession.insert(insertStatement,object);
    }
}
