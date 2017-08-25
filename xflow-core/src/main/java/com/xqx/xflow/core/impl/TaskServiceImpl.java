package com.xqx.xflow.core.impl;

import com.xqx.xflow.core.RepositoryService;
import com.xqx.xflow.core.TaskService;
import com.xqx.xflow.core.impl.db.DaoFactory;
import com.xqx.xflow.core.impl.persistence.dao.ProcDefDao;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.entity.XflTaskInst;

/**
 * Created by Lyon on 2017/2/15.
 */
public class TaskServiceImpl extends ServiceImpl implements TaskService {

    private ProcDefDao procDefDao;

    public TaskServiceImpl(DaoFactory daoFactory){
        this.procDefDao = daoFactory.getDao(ProcDefDao.class);
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
