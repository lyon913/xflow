package com.xqx.xflow.core.impl.persistence.dao;

import com.querydsl.sql.SQLQueryFactory;
import com.xqx.xflow.core.impl.cfg.IdGenerator;
import com.xqx.xflow.core.impl.persistence.entity.XflTaskInst;
import com.xqx.xflow.core.impl.persistence.entity.XflVariable;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflTaskInst;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflVariable;

/**
 * Created by Lyon on 2017/2/14.
 */
public class VariableDao extends AbstractDao<QXflVariable, XflVariable, String> {

    public VariableDao(SQLQueryFactory queryFactory, IdGenerator idGenerator) {
        super(queryFactory, idGenerator);
    }

}
