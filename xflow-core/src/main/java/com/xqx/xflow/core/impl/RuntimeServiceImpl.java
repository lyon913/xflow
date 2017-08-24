package com.xqx.xflow.core.impl;

import com.xqx.xflow.core.RuntimeService;
import com.xqx.xflow.core.impl.db.DaoFactory;
import com.xqx.xflow.core.impl.persistence.dao.ProcDefDao;

/**
 * Created by Lyon on 2017/2/15.
 */
public class RuntimeServiceImpl extends ServiceImpl implements RuntimeService {

    private ProcDefDao procDefDao;

    public RuntimeServiceImpl(DaoFactory daoFactory){
        this.procDefDao = daoFactory.getDao(ProcDefDao.class);
    }
    
}
