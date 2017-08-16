package com.xqx.xflow.core.impl.persistence.dao;

import com.querydsl.sql.SQLQueryFactory;
import com.xqx.xflow.core.impl.cfg.IdGenerator;
import com.xqx.xflow.core.impl.persistence.entity.XflFlowDef;
import com.xqx.xflow.core.impl.persistence.entity.XflTaskDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflFlowDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflTaskDef;

/**
 * Created by Lyon on 2017/2/14.
 */
public class FlowDefDao extends AbstractDao<QXflFlowDef, XflFlowDef, String> {

    public FlowDefDao(SQLQueryFactory queryFactory, IdGenerator idGenerator) {
        super(queryFactory, idGenerator);
    }

}
