package com.xqx.xflow.core.impl.persistence.dao;

import com.querydsl.sql.SQLQueryFactory;
import com.xqx.xflow.core.impl.cfg.IdGenerator;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcDef;

/**
 * Created by Lyon on 2017/2/14.
 */
public class ProcDefDao extends AbstractDao<QXflProcDef, XflProcDef, String> {

    public ProcDefDao(SQLQueryFactory queryFactory, IdGenerator idGenerator) {
        super(queryFactory, idGenerator);
    }

}