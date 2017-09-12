package com.xqx.xflow.core.impl;

import com.xqx.xflow.core.impl.db.DbContext;
import com.xqx.xflow.core.impl.persistence.repository.*;

public class ServiceImpl {

    private DbContext daoFactory;

    public DbContext getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DbContext daoFactory) {
        this.daoFactory = daoFactory;
    }

    public ProcDefRepoistory getProcDefDao(){
        return getDaoFactory().getDao(ProcDefRepoistory.class);
    }
    public TaskDefRepoistory getTaskDefDao(){
        return getDaoFactory().getDao(TaskDefRepoistory.class);
    }

    public FlowDefRepoistory getFlowDefDao(){
        return getDaoFactory().getDao(FlowDefRepoistory.class);
    }

    public ProcInstRepoistory getProcInstDao(){
        return getDaoFactory().getDao(ProcInstRepoistory.class);
    }

    public TaskInstRepoistory getTaskInstDao(){
        return getDaoFactory().getDao(TaskInstRepoistory.class);
    }

}
