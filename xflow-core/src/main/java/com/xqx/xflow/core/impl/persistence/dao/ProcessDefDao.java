package com.xqx.xflow.core.impl.persistence.dao;

import com.google.common.base.Strings;
import com.querydsl.sql.SQLQueryFactory;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcDef;

/**
 * Created by Lyon on 2017/2/14.
 */
public class ProcessDefDao extends AbstractDao {
    public ProcessDefDao(SQLQueryFactory sqlQueryFactory){
        this.setQueryFactory(sqlQueryFactory);
    }

    public void insert(XflProcDef procDef){
        if(Strings.isNullOrEmpty(procDef.getId())){
            procDef.setId();
        }
        QXflProcDef qXflProcDef = QXflProcDef.xflProcDef;

        getQueryFactory().insert(qXflProcDef).populate(procDef).execute();
    }

    public void update(XflProcDef procDef){
        QXflProcDef qXflProcDef = QXflProcDef.xflProcDef;
        getQueryFactory().update(qXflProcDef).populate(procDef).execute();
    }
}
