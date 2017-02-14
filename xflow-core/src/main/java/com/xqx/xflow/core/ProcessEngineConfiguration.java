package com.xqx.xflow.core;

import javax.sql.DataSource;

/**
 * Created by Lyon on 2017/2/9.
 */
public abstract class ProcessEngineConfiguration {

    //数据源
    protected DataSource dataSource;

    //数据库厂商id
    protected String databaseId;

    //是否为托管的事务
    protected boolean isTransactionExternalManaged;

    //流程仓库管理服务
    protected RepositoryService repositoryService;

    //运行时服务
    protected RuntimeService runtimeService;

    //任务服务
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

    public boolean isTransactionExternalManaged() {
        return isTransactionExternalManaged;
    }

    public void setTransactionExternalManaged(boolean transactionExternalManaged) {
        isTransactionExternalManaged = transactionExternalManaged;
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

    /**
     * 从流程配置构建流程引擎
     * 由配置子类实现
     * @return
     */
    public abstract ProcessEngine buildProcessEngine();

}
