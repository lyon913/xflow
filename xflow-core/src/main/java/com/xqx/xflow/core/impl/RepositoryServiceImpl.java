package com.xqx.xflow.core.impl;

import com.xqx.xflow.core.RepositoryService;
import com.xqx.xflow.core.impl.db.DbSqlSessionFactory;
import com.xqx.xflow.core.impl.persistence.entity.ProcessDef;
import com.xqx.xflow.core.impl.persistence.manager.AbstractManager;

/**
 * Created by Lyon on 2017/2/15.
 */
public class RepositoryServiceImpl extends AbstractManager implements RepositoryService {

    public void createProcessDef(ProcessDef processDef) {
        getDbSqlSession().insert(processDef);
    }
}
