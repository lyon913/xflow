package com.xqx.xflow.core.impl;

import com.google.common.base.Strings;
import com.xqx.xflow.core.XflowException;
import com.xqx.xflow.core.impl.persistence.dao.ProcDefDao;
import com.xqx.xflow.core.impl.persistence.dao.ProcInstDao;
import com.xqx.xflow.core.impl.persistence.dao.TaskDefDao;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.entity.XflProcInst;
import com.xqx.xflow.core.impl.persistence.entity.XflTaskDef;
import org.joda.time.DateTime;
import org.joda.time.Period;

public class FlowProcessor {

    public String userId;
    public String userName;

    private ProcDefDao procDefDao;
    private TaskDefDao taskDefDao;
    private ProcInstDao procInstDao;




    public void setUserInfo(String userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }

    public XflProcInst createProcInst(XflProcDef procDef, String businessKey){
        DateTime now = new DateTime();
        XflProcInst instance = new XflProcInst();
        instance.setBusinessKey(businessKey);
        instance.setActive(true);
        instance.setProcDefId(procDef.getId());
        instance.setProcDefId(procDef.getId());
        instance.setStartTime(now);
        instance.setStartUserId(userId);
        instance.setStartUserName(userName);
        if(!Strings.isNullOrEmpty(procDef.getDueDate())){
            String dueDateStr = procDef.getDueDate();
            if(dueDateStr.startsWith("P")){
                Period period = Period.parse(dueDateStr);
                DateTime dueDate = now.plus(period);
                instance.setDueDate(dueDate);
            }else {
                throw new XflowException("Unknown Due Date format");
            }
        }

        return instance;
    }


}
