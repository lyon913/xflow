package com.xqx.xflow.core.impl;

import com.xqx.xflow.core.impl.db.DaoFactory;

public class ServiceImpl {
    private DaoFactory daoFactory;

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
