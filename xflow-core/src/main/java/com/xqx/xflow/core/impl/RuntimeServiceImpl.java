package com.xqx.xflow.core.impl;

import com.querydsl.sql.SQLQuery;
import com.xqx.xflow.core.RuntimeService;
import com.xqx.xflow.core.impl.db.DaoFactory;
import com.xqx.xflow.core.impl.persistence.dao.ProcDefDao;
import com.xqx.xflow.core.impl.persistence.dao.ProcInstDao;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.entity.XflProcInst;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcInst;
import org.joda.time.DateTime;

/**
 * Created by Lyon on 2017/2/15.
 */
public class RuntimeServiceImpl extends ServiceImpl implements RuntimeService {

    private ProcDefDao procDefDao;
    private ProcInstDao procInstDao;

    public RuntimeServiceImpl(DaoFactory daoFactory){
        this.procDefDao = daoFactory.getDao(ProcDefDao.class);
        this.procInstDao = daoFactory.getDao(ProcInstDao.class);
    }

    @Override
    public XflProcInst startProcessInstanceByKey(String procKey, String businessKey, String userId, String userName) {
        XflProcDef procDef =  procDefDao.selectByProcKey(procKey);

        XflProcInst instance = newProcInst(procDef);
        instance.setBusinessKey(businessKey);
        instance.setStartUserId(userId);
        instance.setStartUserName(userName);
        procInstDao.insert(instance);
        return instance;
    }

    private XflProcInst newProcInst(XflProcDef procDef){

        DateTime now = new DateTime();
        XflProcInst instance = new XflProcInst();
        instance.setProcDefId(procDef.getId());
        instance.setStartTime(now);
        instance.setIsActive(true);

        return instance;
    }

    @Override
    public XflProcInst startProcessInstanceById(String procDefId, String businessKey) {
        return null;
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
