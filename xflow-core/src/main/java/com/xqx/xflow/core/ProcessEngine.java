package com.xqx.xflow.core;

/**
 * Created by Lyon on 2017/1/20.
 */
public interface ProcessEngine {

    RepositoryService getRepositoryService();

    RuntimeService getRuntimeService();

    TaskService getTaskService();

}
