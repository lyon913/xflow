package com.xqx.xflow.core.impl;

import com.xqx.xflow.core.*;
import com.xqx.xflow.core.impl.cfg.ProcessEngineConfigurationImpl;

/**
 * Created by Lyon on 2017/2/11.
 */
public class ProcessEngineImpl implements ProcessEngine {

    protected ProcessEngineConfigurationImpl processEngineConfiguration;

    protected RepositoryService repositoryService;
    protected RuntimeService runtimeService;
    protected TaskService taskService;

    public ProcessEngineImpl(ProcessEngineConfigurationImpl configuration) {
        this.processEngineConfiguration = configuration;
        this.repositoryService = configuration.getRepositoryService();
        this.runtimeService = configuration.getRuntimeService();
        this.taskService = configuration.getTaskService();
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

    public ProcessEngineConfigurationImpl getProcessEngineConfiguration() {
        return processEngineConfiguration;
    }
}
