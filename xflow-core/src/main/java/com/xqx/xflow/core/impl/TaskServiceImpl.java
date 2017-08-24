package com.xqx.xflow.core.impl;

import com.xqx.xflow.core.RepositoryService;
import com.xqx.xflow.core.TaskService;
import com.xqx.xflow.core.impl.db.DaoFactory;
import com.xqx.xflow.core.impl.persistence.dao.ProcDefDao;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;

/**
 * Created by Lyon on 2017/2/15.
 */
public class TaskServiceImpl extends ServiceImpl implements TaskService {

    private ProcDefDao procDefDao;

    public TaskServiceImpl(DaoFactory daoFactory){
        this.procDefDao = daoFactory.getDao(ProcDefDao.class);
    }

}
