package com.xqx.xflow.core;

import com.xqx.xflow.core.impl.persistence.entity.XflProcInst;

/**
 * Created by Lyon on 2017/1/22.
 */
public interface RuntimeService {
    XflProcInst startProcessInstanceByKey(String procKey, String businessKey);

    XflProcInst startProcessInstanceById(String procDefId, String businessKey);


}
