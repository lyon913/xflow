package com.xqx.xflow.core.impl;

import com.querydsl.sql.SQLQuery;
import com.xqx.xflow.core.RuntimeService;
import com.xqx.xflow.core.XflowException;
import com.xqx.xflow.core.impl.persistence.entity.*;
import com.xqx.xflow.core.impl.persistence.repository.ProcDefRepository;
import com.xqx.xflow.core.impl.persistence.repository.ProcInstRepository;
import com.xqx.xflow.core.impl.persistence.repository.TaskDefRepository;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcInst;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Map;

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
        XflProcInst procInst = procDef.createProcInst(businessKey);
        XflTaskDef startNodeDef = procDef.findStartNode();
        if(startNodeDef == null){
            throw new XflowException("Start node not found:procDefKey:"+procDefKey);
        }
        XflTaskInst startNodeInst =  startNodeDef.createTaskInstance(procInst);
        List<XflFlowDef> outflows = startNodeDef.findOutFlows();
        if(outflows == null || outflows.size() ==0){
            throw new XflowException("No outgoing found:procKey:"+procDefKey);
        }
        if(outflows.size() > 1){
            throw new XflowException("Multiple flow found on start node:procKey:"+procDefKey);
        }
        XflFlowDef flow = outflows.get(0);
        transition(procInst,startNodeInst,flow);
        return procInst;
    }

    private void transition(XflProcInst procInst, XflTaskInst source, XflFlowDef flow){
        XflTaskDef targetDef = flow.getTargetTaskDef();
        XflTaskInst target = targetDef.createTaskInstance(procInst);

        source.setActive(false);
        target.setActive(true);
        target.setStartTime(new DateTime());
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

    @Override
    public Map<String, Object> getVariables(String processInstId) {
        return null;
    }
}
