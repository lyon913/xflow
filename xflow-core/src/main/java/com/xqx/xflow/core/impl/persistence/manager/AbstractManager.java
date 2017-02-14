package com.xqx.xflow.core.impl.persistence.manager;

import com.xqx.xflow.core.impl.db.DbSqlSession;
import com.xqx.xflow.core.impl.db.DbSqlSessionFactory;
import com.xqx.xflow.core.impl.db.PersistentObject;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by Lyon on 2017/2/14.
 */
public class AbstractManager {
    protected DbSqlSessionFactory dbSqlSessionFactory;

    protected DbSqlSession getDbSqlSession(){
        return dbSqlSessionFactory.openSession();
    }

    public void insert(PersistentObject object){
        getDbSqlSession().insert(object);
    }
}
