package com.xqx.xflow.core.impl.db;

import com.xqx.xflow.core.impl.cfg.IdGenerator;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;

/**
 * Created by Lyon on 2017/2/13.
 */
public class DbSqlSessionFactory {
    protected SqlSessionFactory sqlSessionFactory;
    protected IdGenerator idGenerator;
    protected ThreadLocal<DbSqlSession> dbSqlSessionThreadLocal = new ThreadLocal<DbSqlSession>();


    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public DbSqlSession openSession(){
        DbSqlSession dbSqlSession = dbSqlSessionThreadLocal.get();
        if(dbSqlSession == null){
            dbSqlSession = new DbSqlSession(this);
        }
        return dbSqlSession;
    }

    public String getInsertStatement(Class<?> persistentObjectClass){
        String prefix = "insert";
        String className = persistentObjectClass.getSimpleName();
        return prefix + className;
    }

    public String getDeleteStatement(Class<?> persistentObjectClass){
        String prefix = "delete";
        String className = persistentObjectClass.getSimpleName();
        return prefix + className;
    }

    public String getUpdateStatement(Class<?> persistentObjectClass){
        String prefix = "delete";
        String className = persistentObjectClass.getSimpleName();
        return prefix + className;
    }

    public String getSeleteStatement(Class<?> persistentObjectClass){
        String prefix = "select";
        String className = persistentObjectClass.getSimpleName();
        return prefix + className;
    }
}
