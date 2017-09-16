package com.xqx.xflow.core.impl.persistence.repo;

import java.io.Serializable;

public interface GenericDao <T,ID extends Serializable>{
    T save(T entity);
    T saveOrUpdate(T entity);
    T
}
