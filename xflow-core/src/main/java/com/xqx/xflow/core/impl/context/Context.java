package com.xqx.xflow.core.impl.context;

import com.xqx.xflow.core.impl.db.DbContext;

public class Context {
    private static DbContext dbContext;

    public static DbContext getDbContext() {
        return dbContext;
    }

    public static void setDbContext(DbContext dbContext) {
        Context.dbContext = dbContext;
    }
}
