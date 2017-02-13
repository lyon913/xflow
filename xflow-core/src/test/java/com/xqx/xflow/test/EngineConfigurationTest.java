package com.xqx.xflow.test;

import com.xqx.xflow.core.ProcessEngine;
import com.xqx.xflow.core.ProcessEngineConfiguration;
import com.xqx.xflow.core.impl.ProcessEngineConfigurationImpl;
import com.xqx.xflow.core.impl.entity.ProcessDef;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Lyon on 2017/2/13.
 */
public class EngineConfigurationTest {
    @Test
    public void configTest() throws SQLException {
        DataSource ds = new DriverManagerDataSource("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=xflow","sa","xqx123456@");
        ProcessEngineConfiguration configuration = new ProcessEngineConfigurationImpl();
        configuration.setDataSource(ds);
        ProcessEngine processEngine = configuration.buildProcessEngine();
        ProcessDef pd = new ProcessDef();
        pd.setId("test1");
        pd.setName("test1");
        pd.setCreateTime(new Date());
        SqlSessionFactory sessionFactory = ((ProcessEngineConfigurationImpl)processEngine.getProcessEngineConfiguration()).getSqlSessionFactory();
        SqlSession session =  sessionFactory.openSession(Transactioniso);
        session.insert("insertProcessDef",pd);
        session.commit();
    }

}
