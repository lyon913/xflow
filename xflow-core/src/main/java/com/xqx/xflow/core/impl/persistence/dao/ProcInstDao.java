package com.xqx.xflow.core.impl.persistence.dao;

import com.querydsl.sql.SQLQueryFactory;
import com.xqx.xflow.core.impl.cfg.IdGenerator;
import com.xqx.xflow.core.impl.persistence.entity.XflProcInst;
import com.xqx.xflow.core.impl.persistence.entity.XflTaskDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcInst;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflTaskDef;

/**
 * Created by Lyon on 2017/2/14.
 */
public class ProcInstDao extends AbstractDao<QXflProcInst, XflProcInst, String> {

    public ProcInstDao(SQLQueryFactory queryFactory, IdGenerator idGenerator) {
        super(queryFactory, idGenerator);
    }

}
