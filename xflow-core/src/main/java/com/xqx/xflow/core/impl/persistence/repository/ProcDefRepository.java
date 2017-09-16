package com.xqx.xflow.core.impl.persistence.repository;

import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcDef;

/**
 * Created by Lyon on 2017/2/14.
 */
public class ProcDefRepository extends AbstractRepository<QXflProcDef, XflProcDef, String> {
    public XflProcDef selectByProcKey(String key){
        QXflProcDef procDef = QXflProcDef.xflProcDef;
        return queryFactory.selectFrom(procDef).where(procDef.procKey.eq(key).and(procDef.valid.eq(true) )).fetchOne();
    }
}
