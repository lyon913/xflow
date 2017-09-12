package com.xqx.xflow.core.test;

import com.querydsl.sql.Configuration;
import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.xqx.xflow.core.impl.db.DbContext;
import com.xqx.xflow.core.impl.db.UuidGenerator;
import com.xqx.xflow.core.impl.persistence.repository.ProcDefRepoistory;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import org.joda.time.DateTime;
import org.junit.Assert;
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

        DbContext daoFactory = new DbContext();
        daoFactory.setIdGenerator(new UuidGenerator());
        daoFactory.setQueryFactory(factory);
        ProcDefRepoistory dao =daoFactory.getDao(ProcDefRepoistory.class);
        dao.insert(procDef);


        XflProcDef selectedData = dao.selectById(procDef.getId());
        Assert.assertNotNull(selectedData);

        selectedData.setName("test:" + new DateTime());
        dao.update(selectedData);

        dao.delete(selectedData);
        //提交
        tm.commit(status);


    }
}
