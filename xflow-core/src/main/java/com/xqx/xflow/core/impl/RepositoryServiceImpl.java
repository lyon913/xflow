package com.xqx.xflow.core.impl;

import com.xqx.xflow.core.RepositoryService;
import com.xqx.xflow.core.impl.db.DaoFactory;
import com.xqx.xflow.core.impl.persistence.dao.ProcDefDao;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;

/**
 * Created by Lyon on 2017/2/15.
 */
public class RepositoryServiceImpl extends ServiceImpl implements RepositoryService {

    private ProcDefDao procDefDao;

    public RepositoryServiceImpl(DaoFactory daoFactory){
        this.procDefDao = daoFactory.getDao(ProcDefDao.class);
    }

    public void createProcDef(XflProcDef processDef) {
        procDefDao.insert(processDef);
    }

    public XflProcDef findProcDefById(String id) {
        return procDefDao.selectById(id);
    }

    public XflProcDef findProcDefByKey(String key){
        return procDefDao.selectByProcKey(key);
    }

    public void deleteProcDef(XflProcDef procDef){
        procDef.setIsDeleted(true);
    }
}
