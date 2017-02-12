package com.xqx.xflow.core.impl;

import com.xqx.xflow.core.*;

/**
 * Created by Lyon on 2017/2/11.
 */
public class ProcessEngineImpl implements ProcessEngine {

    protected ProcessEngineConfiguration configuration;

    protected RepositoryService repositoryService;
    protected RuntimeService runtimeService;
    protected TaskService taskService;

    public ProcessEngineImpl(ProcessEngineConfiguration configuration) {
        this.configuration = configuration;
    }

    public RepositoryService getRepositoryService() {
        return repositoryService;
    }

    public RuntimeService getRuntimeService() {
        return runtimeService;
    }

    public TaskService getTaskService() {
        return taskService;
    }
}
