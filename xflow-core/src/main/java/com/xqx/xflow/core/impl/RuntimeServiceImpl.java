package com.xqx.xflow.core.impl;

import com.google.common.base.Strings;
import com.querydsl.sql.SQLQuery;
import com.xqx.xflow.core.RuntimeService;
import com.xqx.xflow.core.impl.db.DaoFactory;
import com.xqx.xflow.core.impl.persistence.dao.ProcDefDao;
import com.xqx.xflow.core.impl.persistence.dao.ProcInstDao;
import com.xqx.xflow.core.impl.persistence.dao.TaskDefDao;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.entity.XflProcInst;
import com.xqx.xflow.core.impl.persistence.entity.XflTaskDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcInst;
import org.joda.time.DateTime;
import org.joda.time.Period;

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
        XflProcInst inst = newProcInst(procDefKey);
        inst.setStartUserId(userId);
        inst.setStartUserName(userName);
        inst.setBusinessKey(businessKey);
        procInstDao.insert(inst);

        XflTaskDef start = taskDefDao.findStartTask(inst.getProcDefId());
        return inst;
    }


    private XflProcInst newProcInst(String procDefKey){
        DateTime now = new DateTime();
        XflProcDef procDef =  procDefDao.selectByProcKey(procDefKey);

        XflProcInst instance = new XflProcInst();
        instance.setProcDefId(procDef.getId());
        instance.setActive(true);
        instance.setProcDefId(procDef.getId());
        instance.setStartTime(now);
        if(!Strings.isNullOrEmpty(procDef.getDueDate())){
            String dueDateStr = procDef.getDueDate();
            if(dueDateStr.startsWith("P")){
                Period period = Period.parse(dueDateStr);
                DateTime dueDate = now.plus(period);
                instance.setDueDate(dueDate);
            }else {
                throw new RuntimeException("Unknown Due Date format");
            }
        }

        return instance;
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
