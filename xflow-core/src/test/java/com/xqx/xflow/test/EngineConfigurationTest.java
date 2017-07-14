package com.xqx.xflow.test;


import com.querydsl.sql.SQLQueryFactory;
import org.junit.Test;
import org.springframework.jdbc.datasource.ConnectionProxy;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Lyon on 2017/2/13.
 */
public class EngineConfigurationTest {
    @Test
    public void configTest() throws SQLException {
        DataSource ds = new DriverManagerDataSource("jdbc:mysql://127.0.0.1:3306/xflow","xflow","xqx123456@");
        DataSourceUtils.getConnection(ds);
//        ProcessEngineConfigurationImpl configuration = new ProcessEngineConfigurationImpl();
//        configuration.setDataSource(ds);
//        configuration.setTransactionExternalManaged(true);
//        ProcessEngine processEngine = configuration.buildProcessEngine();
//        ProcessDef pd = new ProcessDef();
//        pd.setName("test1");
//        pd.setCreateTime(new Date());
//        DbSqlSession dbSqlSession = configuration.getDbSqlSessionFactory().openSession();
//        dbSqlSession.insert(pd);

    }

}
