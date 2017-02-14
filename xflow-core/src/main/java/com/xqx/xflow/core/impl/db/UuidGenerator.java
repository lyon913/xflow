package com.xqx.xflow.core.impl.db;

import com.xqx.xflow.core.impl.cfg.IdGenerator;

import java.util.UUID;

/**
 * Created by Lyon on 2017/2/14.
 */
public class UuidGenerator implements IdGenerator {
    public String getNextId() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
