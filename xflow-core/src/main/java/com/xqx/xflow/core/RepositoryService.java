package com.xqx.xflow.core;


import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;

/**
 * Created by Lyon on 2017/1/22.
 */
public interface RepositoryService {
   void createProcDef(XflProcDef processDef);

    public XflProcDef findProcDefById(String id);

    public XflProcDef findProcDefByKey(String key);

    public void deleteProcDef(XflProcDef procDef);
}
