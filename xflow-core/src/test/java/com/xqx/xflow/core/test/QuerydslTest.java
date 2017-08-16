package com.xqx.xflow.core.test;

import com.querydsl.sql.*;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.xqx.xflow.core.impl.db.UuidGenerator;
import com.xqx.xflow.core.impl.persistence.dao.ProcessDefDao;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcDef;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

/**
 * Created by Lyon on 2017/7/14.
 */
public class QuerydslTest {


    @Test
    public void dataAccessTest() {
        DataSource ds = new DriverManagerDataSource("jdbc:mysql://127.0.0.1/xflow", "xflow", "xqx1234");

        SQLTemplates templates = MySQLTemplates.builder().build();
        DataSourceTransactionManager tm = new DataSourceTransactionManager(ds);

        //初始化事务
        TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));

        Configuration conf = new Configuration(templates);
        SpringConnectionProvider provider = new SpringConnectionProvider(ds);
        SQLQueryFactory factory = new SQLQueryFactory(conf, provider);

        XflProcDef procDef = new XflProcDef();
        String name = UUID.randomUUID().toString();
        procDef.setName(name);
        procDef.setProcKey(name);

        ProcessDefDao dao = new ProcessDefDao(factory,new UuidGenerator());
        dao.insert(procDef);


        XflProcDef selectedData = dao.selectById(procDef.getId());

        //提交
        tm.commit(status);
        Assert.assertNotNull(selectedData);
    }
}
