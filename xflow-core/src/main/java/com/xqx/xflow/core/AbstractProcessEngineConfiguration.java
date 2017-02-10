package com.xqx.xflow.core;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Lyon on 2017/2/9.
 */
public class AbstractProcessEngineConfiguration {


    protected DataSource dataSource;

    protected PlatformTransactionManager transactionManager;

    protected boolean isTransactionManaged;



    protected SqlSessionFactory sqlSessionFactory;

    public AbstractProcessEngineConfiguration() {

    }


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public boolean isTransactionManaged() {
        return isTransactionManaged;
    }

    public void setTransactionManaged(boolean transactionManaged) {
        isTransactionManaged = transactionManaged;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
