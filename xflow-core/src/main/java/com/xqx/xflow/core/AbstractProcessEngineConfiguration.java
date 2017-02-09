package com.xqx.xflow.core;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by Lyon on 2017/2/9.
 */
public class AbstractProcessEngineConfiguration {
    protected SqlSessionFactory sqlSessionFactory;

    protected TransactionAwareDataSourceProxy dataSourceProxy;

    protected PlatformTransactionManager transactionManager;

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public TransactionAwareDataSourceProxy getDataSourceProxy() {
        return dataSourceProxy;
    }

    public void setDataSourceProxy(TransactionAwareDataSourceProxy dataSourceProxy) {
        this.dataSourceProxy = dataSourceProxy;
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
