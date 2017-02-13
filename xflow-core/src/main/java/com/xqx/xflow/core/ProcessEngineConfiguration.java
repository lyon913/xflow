package com.xqx.xflow.core;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Lyon on 2017/2/9.
 */
public abstract class ProcessEngineConfiguration {

    protected DataSource dataSource;

    protected String databaseId;

    protected boolean isTransactionManaged;

    protected RepositoryService repositoryService;

    protected RuntimeService runtimeService;

    protected TaskService taskService;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(String databaseId) {
        this.databaseId = databaseId;
    }

    public boolean isTransactionManaged() {
        return isTransactionManaged;
    }

    public void setTransactionManaged(boolean transactionManaged) {
        isTransactionManaged = transactionManaged;
    }

    public RepositoryService getRepositoryService() {
        return repositoryService;
    }

    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public RuntimeService getRuntimeService() {
        return runtimeService;
    }

    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public abstract ProcessEngine buildProcessEngine();

}
