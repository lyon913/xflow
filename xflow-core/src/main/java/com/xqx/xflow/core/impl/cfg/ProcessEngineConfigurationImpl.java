package com.xqx.xflow.core.impl.cfg;

import com.google.common.base.Strings;
import com.querydsl.sql.*;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.xqx.xflow.core.ProcessEngine;
import com.xqx.xflow.core.ProcessEngineConfiguration;
import com.xqx.xflow.core.XflowException;
import com.xqx.xflow.core.impl.ProcessEngineImpl;
import com.xqx.xflow.core.impl.RepositoryServiceImpl;
import com.xqx.xflow.core.impl.RuntimeServiceImpl;
import com.xqx.xflow.core.impl.TaskServiceImpl;
import com.xqx.xflow.core.impl.context.Context;
import com.xqx.xflow.core.impl.db.DbContext;
import com.xqx.xflow.core.impl.db.UuidGenerator;

/**
 * 独立流程引擎配置实现类
 * 目前未实现独立事务管理，需依赖spring的事务管理。
 * Created by Lyon on 2017/8/12.
 */
public class ProcessEngineConfigurationImpl extends ProcessEngineConfiguration {


    protected IdGenerator idGenerator;
    protected SQLQueryFactory sqlQueryFactory;
    protected DbContext dbContext;




    public ProcessEngine buildProcessEngine() {
        init();
        return new ProcessEngineImpl(this);
    }

    protected void init() {
        initDataSource();
        initIdGenerator();
        initSqlQueryFactory();
        initDbContext();
        initServices();
    }

    protected void initDataSource() {
        if (dataSource == null) {
            throw new XflowException("数据源未指定。");
        }
    }

    protected void initIdGenerator() {
        if (idGenerator == null) {
            idGenerator = new UuidGenerator();
        }
    }

    protected void initSqlQueryFactory() {
        if (sqlQueryFactory == null) {

            if (Strings.isNullOrEmpty(databaseId)) {
                throw new XflowException("未指定数据库id");
            }
            SQLTemplates templates = null;
            switch (databaseId) {
                case "MySQL":
                    templates = new MySQLTemplates();
                    break;
                case "SQLServer2005":
                    templates = new SQLServer2005Templates();
                    break;
                case "SQLServer2008":
                    templates = new SQLServer2008Templates();
                    break;
                case "SQLServer2012":
                    templates = new SQLServer2012Templates();
                    break;
                case "Oracle":
                    templates = new OracleTemplates();
                    break;
                default:
                    break;
            }
            if (templates == null) {
                throw new XflowException("不支持的数据库版本:" + databaseId);
            }

            Configuration configuration = new Configuration(templates);
            sqlQueryFactory = new SQLQueryFactory(configuration ,new SpringConnectionProvider(dataSource));

        }
    }

    protected void initDbContext(){
        if(dbContext == null){
            dbContext = new DbContext();
            dbContext.setIdGenerator(idGenerator);
            dbContext.setQueryFactory(sqlQueryFactory);
            Context.setDbContext(dbContext);
        }
    }

    protected void initServices(){
        if(repositoryService == null){
            repositoryService = new RepositoryServiceImpl(dbContext);
        }

        if(taskService == null){
            taskService = new TaskServiceImpl(dbContext);
        }

        if(runtimeService == null){
            runtimeService = new RuntimeServiceImpl(dbContext);
        }
    }


    //--      getter and setter     -//

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public SQLQueryFactory getSqlQueryFactory() {
        return sqlQueryFactory;
    }

    public void setSqlQueryFactory(SQLQueryFactory sqlQueryFactory) {
        this.sqlQueryFactory = sqlQueryFactory;
    }
}
