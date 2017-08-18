package com.xqx.xflow.core.impl.persistence.dao;

import com.querydsl.sql.SQLQueryFactory;
import com.xqx.xflow.core.impl.cfg.IdGenerator;
import com.xqx.xflow.core.impl.persistence.entity.XflProcInst;
import com.xqx.xflow.core.impl.persistence.entity.XflTaskInst;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcInst;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflTaskDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflTaskInst;

/**
 * Created by Lyon on 2017/2/14.
 */
public class TaskInstDao extends AbstractDao<QXflTaskInst, XflTaskInst, String> {

    public TaskInstDao(SQLQueryFactory queryFactory, IdGenerator idGenerator) {
        super(queryFactory, idGenerator);
    }

}
