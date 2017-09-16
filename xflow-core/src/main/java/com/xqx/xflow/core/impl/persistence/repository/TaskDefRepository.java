package com.xqx.xflow.core.impl.persistence.repository;

import com.xqx.xflow.core.impl.enums.TaskType;
import com.xqx.xflow.core.impl.persistence.entity.XflTaskDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflFlowDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflTaskDef;

import java.util.List;

/**
 * Created by Lyon on 2017/2/14.
 */
public class TaskDefRepository extends AbstractRepository<QXflTaskDef, XflTaskDef, String> {
    public XflTaskDef findStartTask(String procDefId) {
        return getQueryFactory().selectFrom(qType).where(qType.procDefId.eq(procDefId).and(qType.taskType.eq(TaskType.START.toString()))).fetchOne();
    }

    public List<XflTaskDef> findOutTasks(String taskDefId) {
        QXflTaskDef t = QXflTaskDef.xflTaskDef;
        QXflFlowDef f = QXflFlowDef.xflFlowDef;

        return getQueryFactory().selectFrom(t).innerJoin(f).on(t.id.eq(f.targetTdefId)).where(f.sourceTdefId.eq(taskDefId)).orderBy().fetch();
    }
}
