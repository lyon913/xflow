package com.xqx.xflow.core.impl;

import com.xqx.xflow.core.TaskService;
import com.xqx.xflow.core.impl.persistence.repository.ProcDefRepository;
import com.xqx.xflow.core.impl.persistence.entity.XflTaskInst;
import com.xqx.xflow.core.impl.persistence.repository.ProcInstRepository;
import com.xqx.xflow.core.impl.persistence.repository.TaskDefRepository;

/**
 * Created by Lyon on 2017/2/15.
 */
public class TaskServiceImpl extends ServiceImpl implements TaskService {

    private ProcDefRepository procDefRepository;
    private TaskDefRepository taskDefRepository;
    private ProcInstRepository procInstRepository;

    public TaskServiceImpl(){
        this.procDefRepository = getDbContext().getProcDefRepository();
        this.procInstRepository = getDbContext().getProcInstRepository();
        this.taskDefRepository = getDbContext().getTaskDefRepository();
    }


    @Override
    public XflTaskInst findById(String taskId) {
        return null;
    }

    @Override
    public void complete(String taskId) {

    }

    @Override
    public void complete(String taskId, String targetNodeDefId) {

    }

    @Override
    public void complete(String taskId, String assignee, String assigneeName, String targetNodeDefId) {

    }

    @Override
    public void delegate(String taskId, String assignee, String assigneeName) {

    }

    @Override
    public void resolve(String taskId) {

    }

    @Override
    public void claim(String taskId) {

    }

    @Override
    public void unclaim(String taskId) {

    }
}
