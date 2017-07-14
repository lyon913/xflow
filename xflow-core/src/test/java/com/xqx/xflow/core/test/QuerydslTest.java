package com.xqx.xflow.core.test;

import com.querydsl.core.QueryFactory;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.xqx.xflow.core.impl.persistence.entity.XflProcessDef;
import com.xqx.xflow.core.impl.persistence.querydsl.QXflProcessDef;
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
    public void testBasic(){
        DataSource ds = new DriverManagerDataSource("jdbc:mysql://127.0.0.1/xflow","xflow","xqx1234");

        SQLTemplates templates = MySQLTemplates.builder().build();
        Configuration conf = new Configuration(templates);
        SQLQueryFactory factory = new SQLQueryFactory(conf,ds);

        QXflProcessDef processDef = QXflProcessDef.xflProcessDef;
        List<XflProcessDef> list  = factory.selectFrom(processDef)
                .where(processDef.name.like("test1"))
                .fetch();
        Assert.assertEquals(1,list.size());
    }
}
