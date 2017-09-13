package com.xqx.xflow.core.impl;

import com.querydsl.sql.SQLQuery;
import com.xqx.xflow.core.RuntimeService;
import com.xqx.xflow.core.XflowException;
import com.xqx.xflow.core.impl.persistence.repository.ProcDefRepository;
import com.xqx.xflow.core.impl.persistence.repository.ProcInstRepository;
import com.xqx.xflow.core.impl.persistence.repository.TaskDefRepository;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.entity.XflProcInst;
import com.xqx.xflow.core.impl.persistence.entity.XflTaskDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcInst;

/**
 * Created by Lyon on 2017/2/15.
 */
public class RuntimeServiceImpl extends ServiceImpl implements RuntimeService {

    private ProcDefRepository procDefRepository;
    private TaskDefRepository taskDefRepository;
    private ProcInstRepository procInstRepository;

    public RuntimeServiceImpl(){
        this.procDefRepository = getDbContext().getProcDefRepository();
        this.procInstRepository = getDbContext().getProcInstRepository();
        this.taskDefRepository = getDbContext().getTaskDefRepository();
    }

    @Override
    public XflProcInst startProcessInstanceByKey(String procDefKey, String businessKey) {
        XflProcDef procDef = procDefRepository.selectByProcKey(procDefKey);
        if(procDef == null){
            throw new XflowException("procDefKey not found:"+procDefKey);
        }
        XflProcInst inst = procDef.createProcInst(businessKey);
        XflTaskDef startNodeDef = procDef.findStartNode();
        if(startNodeDef == null){
            throw new XflowException("Start node not found:procDefKey:"+procDefKey);
        }

        startNodeDef.findOutFlows();
        return inst;
    }



    @Override
    public XflProcInst findProcessInstanceByBusinessKey(String businessKey) {
        QXflProcInst qXflProcInst = QXflProcInst.xflProcInst;
        return createProcessInstanceQuery().where(qXflProcInst.businessKey.eq(businessKey)).fetchOne();
    }

    @Override
    public SQLQuery<XflProcInst> createProcessInstanceQuery() {
        QXflProcInst qXflProcInst = QXflProcInst.xflProcInst;
        return getDbContext().getQueryFactory().selectFrom(qXflProcInst);
    }
}
