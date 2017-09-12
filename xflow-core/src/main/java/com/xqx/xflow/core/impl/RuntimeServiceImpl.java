package com.xqx.xflow.core.impl;

import com.querydsl.sql.SQLQuery;
import com.xqx.xflow.core.RuntimeService;
import com.xqx.xflow.core.XflowException;
import com.xqx.xflow.core.impl.db.DbContext;
import com.xqx.xflow.core.impl.persistence.repository.ProcDefRepoistory;
import com.xqx.xflow.core.impl.persistence.repository.ProcInstRepoistory;
import com.xqx.xflow.core.impl.persistence.repository.TaskDefRepoistory;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.entity.XflProcInst;
import com.xqx.xflow.core.impl.persistence.entity.XflTaskDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcInst;

/**
 * Created by Lyon on 2017/2/15.
 */
public class RuntimeServiceImpl extends ServiceImpl implements RuntimeService {

    private ProcDefRepoistory procDefDao;
    private TaskDefRepoistory taskDefDao;
    private ProcInstRepoistory procInstDao;

    public RuntimeServiceImpl(DbContext daoFactory){
        this.procDefDao = daoFactory.getDao(ProcDefRepoistory.class);
        this.procInstDao = daoFactory.getDao(ProcInstRepoistory.class);
    }

    @Override
    public XflProcInst startProcessInstanceByKey(String procDefKey, String businessKey, String userId, String userName) {

        FlowProcessor processor = new FlowProcessor();
        processor.setUserInfo(userId,userName);

        XflProcDef procDef = procDefDao.selectByProcKey(procDefKey);
        if(procDef == null) {
            throw new XflowException("XflProcDef not found:procKey=" + procDefKey);
        }
        XflProcInst inst = processor.createProcInst(procDef,businessKey);
        procInstDao.insert(inst);

        XflTaskDef start = taskDefDao.findStartTask(inst.getProcDefId());
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
        return getDaoFactory().getQueryFactory().selectFrom(qXflProcInst);
    }
}
