package com.xqx.xflow.core.impl.persistence.repository;

import com.xqx.xflow.core.impl.persistence.entity.XflFlowDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflFlowDef;

import java.util.List;

/**
 * Created by Lyon on 2017/2/14.
 */
public class FlowDefRepository extends AbstractRepository<QXflFlowDef, XflFlowDef, String> {
    public List<XflFlowDef> findBySourceId(String sourceId){
        return getQueryFactory().selectFrom(qType).where(qType.sourceTdefId.eq(sourceId)).fetch();
    }
}
