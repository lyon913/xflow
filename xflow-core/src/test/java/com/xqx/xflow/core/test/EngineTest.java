package com.xqx.xflow.core.test;

import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLTemplates;
import com.xqx.xflow.core.ProcessEngine;
import com.xqx.xflow.core.ProcessEngineConfiguration;
import com.xqx.xflow.core.RepositoryService;
import com.xqx.xflow.core.RuntimeService;
import com.xqx.xflow.core.impl.Authentication;
import com.xqx.xflow.core.impl.cfg.ProcessEngineConfigurationImpl;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import org.junit.Test;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.UUID;

/**
 * Created by Lyon on 2017/7/14.
 */
public class EngineTest {


    @Test
    public void dataAccessTest() {
        DataSource ds = new DriverManagerDataSource("jdbc:mysql://127.0.0.1/xflow", "xflow", "xqx1234");

        SQLTemplates templates = MySQLTemplates.builder().build();
        DataSourceTransactionManager tm = new DataSourceTransactionManager(ds);

        //初始化事务
        TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
        Authentication.setAuthenticatedUserInfo("test1","测试用户1");

        ProcessEngineConfiguration config = new ProcessEngineConfigurationImpl();
        config.setDatabaseId("MySQL");
        config.setDataSource(ds);
        ProcessEngine engine = config.buildProcessEngine();

        RepositoryService rs = engine.getRepositoryService();

        XflProcDef procDef = new XflProcDef();
        String name = UUID.randomUUID().toString();
        procDef.setName(name);
        procDef.setProcKey(name);
        procDef.setValid(true);

        rs.createProcDef(procDef);

        RuntimeService runtimeService = engine.getRuntimeService();
        runtimeService.startProcessInstanceByKey(name,"test-1");

        //提交
        tm.commit(status);


    }
}
