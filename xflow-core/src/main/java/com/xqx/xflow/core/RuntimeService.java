package com.xqx.xflow.core;

import com.querydsl.sql.SQLQuery;
import com.xqx.xflow.core.impl.persistence.entity.XflProcInst;

/**
 * Created by Lyon on 2017/1/22.
 */
public interface RuntimeService {
    XflProcInst startProcessInstanceByKey(String procDefKey, String businessKey, String userId, String userName);

    XflProcInst findProcessInstanceByBusinessKey(String businessKey);

    SQLQuery<XflProcInst> createProcessInstanceQuery();

}
