package com.xqx.xflow.core.impl;

import com.querydsl.sql.SQLQuery;
import com.xqx.xflow.core.RuntimeService;
import com.xqx.xflow.core.XflowException;
import com.xqx.xflow.core.impl.db.DaoFactory;
import com.xqx.xflow.core.impl.persistence.dao.ProcDefDao;
import com.xqx.xflow.core.impl.persistence.dao.ProcInstDao;
import com.xqx.xflow.core.impl.persistence.dao.TaskDefDao;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.entity.XflProcInst;
import com.xqx.xflow.core.impl.persistence.entity.XflTaskDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcInst;

/**
 * Created by Lyon on 2017/2/15.
 */
public class RuntimeServiceImpl extends ServiceImpl implements RuntimeService {

    private ProcDefDao procDefDao;
    private TaskDefDao taskDefDao;
    private ProcInstDao procInstDao;

    public RuntimeServiceImpl(DaoFactory daoFactory){
        this.procDefDao = daoFactory.getDao(ProcDefDao.class);
        this.procInstDao = daoFactory.getDao(ProcInstDao.class);
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
