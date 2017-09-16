package com.xqx.xflow.core.impl;

import com.xqx.xflow.core.RepositoryService;
import com.xqx.xflow.core.impl.persistence.repository.ProcDefRepository;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.repository.ProcInstRepository;
import com.xqx.xflow.core.impl.persistence.repository.TaskDefRepository;

/**
 * Created by Lyon on 2017/2/15.
 */
public class RepositoryServiceImpl extends ServiceImpl implements RepositoryService {

    private ProcDefRepository procDefRepository;
    private TaskDefRepository taskDefRepository;
    private ProcInstRepository procInstRepository;

    public RepositoryServiceImpl(){
        this.procDefRepository = getDbContext().getProcDefRepository();
        this.procInstRepository = getDbContext().getProcInstRepository();
        this.taskDefRepository = getDbContext().getTaskDefRepository();
    }

    public void createProcDef(XflProcDef processDef) {
        procDefRepository.insert(processDef);
    }

    public XflProcDef findProcDefById(String id) {
        return procDefRepository.selectById(id);
    }

    public XflProcDef findProcDefByKey(String key){
        return procDefRepository.selectByProcKey(key);
    }

    public void deleteProcDef(XflProcDef procDef){
        procDef.setValid(true);
    }
}
