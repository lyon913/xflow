package com.xqx.xflow.core.impl.db;

import com.xqx.xflow.core.XflowException;
import com.xqx.xflow.core.impl.Page;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 封装mybatis的SqlSession
 * Created by Lyon on 2017/2/10.
 */
public class DbSqlSession {

    private DbSqlSessionFactory dbSqlSessionFacotory;
    private SqlSession sqlSession;

    public DbSqlSession(DbSqlSessionFactory dbSqlSessionFacotory) {
        this.dbSqlSessionFacotory = dbSqlSessionFacotory;
        this.sqlSession = dbSqlSessionFacotory.getSqlSessionFactory().openSession();
    }

    public void insert(PersistentObject object) {
        if (object.getId() == null) {
            String id = dbSqlSessionFacotory.getIdGenerator().getNextId();
            object.setId(id);
        }
        String statement = dbSqlSessionFacotory.getInsertStatement(object.getClass());
        sqlSession.insert(statement, object);
    }

    public void delete(PersistentObject object) {
        if (object.getId() == null) {
            throw new XflowException("无效的实体ID");
        }
        String statement = dbSqlSessionFacotory.getDeleteStatement(object.getClass());
        sqlSession.delete(statement, object);
    }

    public void update(PersistentObject object) {
        if (object.getId() == null) {
            throw new XflowException("无效的实体ID");
        }
        String statement = dbSqlSessionFacotory.getUpdateStatement(object.getClass());
        sqlSession.update(statement, object);
    }

    public <T extends PersistentObject> T selectById(Class<T> entityClass, String id) {
        if (id == null || id.length() == 0) {
            throw new XflowException("无效的实体ID");
        }
        String statement = dbSqlSessionFacotory.getSeleteStatement(entityClass);
        T persistentObject = (T) sqlSession.selectOne(statement, id);
        if (persistentObject == null) {
            return null;
        }
        return persistentObject;
    }

    public List selectList(String statement) {
        return selectList(statement, null);
    }

    public List selectList(String statement, Object parameter, Page page) {
        return selectList(statement, new ListQueryParameterObject(parameter,page.getFirstResult(),page.getMaxResults()));
    }

    public List selectList(String statement, ListQueryParameterObject parameter) {
        return sqlSession.selectList(statement, parameter);
    }

    public void commit() {
        sqlSession.commit();
    }

    public void rollback() {
        sqlSession.rollback();
    }

    public void close() {
        sqlSession.close();
    }
}
