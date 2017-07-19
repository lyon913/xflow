package com.xqx.xflow.core.test;

import com.querydsl.sql.Configuration;
import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcDef;
import org.junit.Assert;

import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Lyon on 2017/7/14.
 */
public class QuerydslTest {


    @Test
    public void dataAccessTest(){
        DataSource ds = new DriverManagerDataSource("jdbc:mysql://127.0.0.1/xflow","xflow","xqx1234");

        SQLTemplates templates = MySQLTemplates.builder().build();
        Configuration conf = new Configuration(templates);
        SpringConnectionProvider provider = new SpringConnectionProvider(ds);
        SQLQueryFactory factory = new SQLQueryFactory(conf,provider);

        QXflProcDef procDef = QXflProcDef.xflProcDef;
        List<XflProcDef> list  = factory.selectFrom(procDef)
                .where(procDef.name.like("test1"))
                .fetch();
        Assert.assertEquals(1,list.size());
    }
}
