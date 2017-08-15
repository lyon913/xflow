package com.xqx.xflow.core.impl;

import com.xqx.xflow.core.RepositoryService;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.dao.AbstractDao;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcDef;

/**
 * Created by Lyon on 2017/2/15.
 */
public class RepositoryServiceImpl extends AbstractDao implements RepositoryService {

    public void createProcessDef(XflProcDef processDef) {
        QXflProcDef qXflProcDef = QXflProcDef.xflProcDef;
        getQueryFactory().insert(qXflProcDef).populate(processDef).execute();
    }
}
