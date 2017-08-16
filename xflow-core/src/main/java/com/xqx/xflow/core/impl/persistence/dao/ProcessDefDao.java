package com.xqx.xflow.core.impl.persistence.dao;

import com.google.common.base.Strings;
import com.querydsl.sql.SQLQueryFactory;
import com.xqx.xflow.core.impl.cfg.IdGenerator;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcDef;

/**
 * Created by Lyon on 2017/2/14.
 */
public class ProcessDefDao extends AbstractDao<QXflProcDef, XflProcDef, String> {


    public ProcessDefDao(SQLQueryFactory queryFactory, IdGenerator idGenerator) {
        super(queryFactory, idGenerator);
    }
}
