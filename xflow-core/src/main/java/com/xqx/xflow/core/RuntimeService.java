package com.xqx.xflow.core;

import com.querydsl.sql.SQLQuery;
import com.xqx.xflow.core.impl.persistence.entity.XflProcInst;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lyon on 2017/1/22.
 */
public interface RuntimeService {
    XflProcInst startProcessInstanceByKey(String procDefKey, String businessKey);

    XflProcInst findProcessInstanceByBusinessKey(String businessKey);

    SQLQuery<XflProcInst> createProcessInstanceQuery();

    Map<String, Object> getVariables(String processInstId);
}
