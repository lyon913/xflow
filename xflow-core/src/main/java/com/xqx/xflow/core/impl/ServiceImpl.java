package com.xqx.xflow.core.impl;

import com.xqx.xflow.core.impl.context.Context;
import com.xqx.xflow.core.impl.db.DbContext;
import com.xqx.xflow.core.impl.persistence.repository.*;

public class ServiceImpl {

    public DbContext getDbContext() {
        return Context.getDbContext();
    }
}
