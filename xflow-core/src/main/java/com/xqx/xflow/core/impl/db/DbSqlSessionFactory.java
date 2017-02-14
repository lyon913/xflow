package com.xqx.xflow.core.impl.db;

import com.xqx.xflow.core.impl.cfg.IdGenerator;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by Lyon on 2017/2/13.
 */
public class DbSqlSessionFactory {
    protected SqlSessionFactory sqlSessionFactory;
    protected IdGenerator idGenerator;

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
        return new DbSqlSession(this);
    }

    public String getInsertStatement(PersistentObject object){
        String prefix = "insert";
        String className = object.getClass().getSimpleName();
        return prefix + className;
    }
}
