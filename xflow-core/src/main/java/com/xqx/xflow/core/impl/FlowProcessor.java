package com.xqx.xflow.core.impl;

import com.google.common.base.Strings;
import com.xqx.xflow.core.XflowException;
import com.xqx.xflow.core.impl.persistence.repository.ProcDefRepository;
import com.xqx.xflow.core.impl.persistence.repository.ProcInstRepository;
import com.xqx.xflow.core.impl.persistence.repository.TaskDefRepository;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.entity.XflProcInst;
import org.joda.time.DateTime;
import org.joda.time.Period;

public class FlowProcessor {

    public String userId;
    public String userName;

    private ProcDefRepository procDefRepository;
    private TaskDefRepository taskDefRepository;
    private ProcInstRepository procInstRepository;




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
