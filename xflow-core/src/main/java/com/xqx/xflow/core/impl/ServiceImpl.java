package com.xqx.xflow.core.impl;

import com.xqx.xflow.core.impl.db.DaoFactory;
import com.xqx.xflow.core.impl.persistence.dao.*;

public class ServiceImpl {

    private DaoFactory daoFactory;

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public ProcDefDao getProcDefDao(){
        return getDaoFactory().getDao(ProcDefDao.class);
    }
    public TaskDefDao getTaskDefDao(){
        return getDaoFactory().getDao(TaskDefDao.class);
    }

    public FlowDefDao getFlowDefDao(){
        return getDaoFactory().getDao(FlowDefDao.class);
    }

    public ProcInstDao getProcInstDao(){
        return getDaoFactory().getDao(ProcInstDao.class);
    }

    public TaskInstDao getTaskInstDao(){
        return getDaoFactory().getDao(TaskInstDao.class);
    }

}
