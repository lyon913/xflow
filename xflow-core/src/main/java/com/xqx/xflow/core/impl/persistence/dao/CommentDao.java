package com.xqx.xflow.core.impl.persistence.dao;

import com.querydsl.sql.SQLQueryFactory;
import com.xqx.xflow.core.impl.cfg.IdGenerator;
import com.xqx.xflow.core.impl.persistence.entity.XflComment;
import com.xqx.xflow.core.impl.persistence.entity.XflVariable;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflComment;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflVariable;

/**
 * Created by Lyon on 2017/2/14.
 */
public class CommentDao extends AbstractDao<QXflComment, XflComment, String> {

    public CommentDao(SQLQueryFactory queryFactory, IdGenerator idGenerator) {
        super(queryFactory, idGenerator);
    }

}
