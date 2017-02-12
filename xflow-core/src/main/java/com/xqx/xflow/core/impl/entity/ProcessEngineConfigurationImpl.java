package com.xqx.xflow.core.impl.entity;

import com.xqx.xflow.core.ProcessEngine;
import com.xqx.xflow.core.ProcessEngineConfiguration;
import com.xqx.xflow.core.XflowException;
import com.xqx.xflow.core.util.IoUtil;
import com.xqx.xflow.core.util.ReflectUtil;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

/**
 * Created by Lyon on 2017/2/12.
 */
public class ProcessEngineConfigurationImpl extends ProcessEngineConfiguration {
    public static final String DEFAULT_MYBATIS_MAPPING_FILE = "org/activiti/db/mapping/mappings.xml";

    protected SqlSessionFactory sqlSessionFactory;
    protected TransactionFactory transactionFactory;

    public ProcessEngine buildProcessEngine() {
        return null;
    }

    protected void init() {
        initDataSource();
        initTransactionFactory();
    }

    protected void initDataSource() {
        if (dataSource == null) {
            //配置文件未直接提供datasource，从 jdbcUrl 或 jndi 配置数据源
            //暂未实现
            throw new XflowException("数据源未指定。");
        }
    }

    protected void initTransactionFactory() {
        if (transactionFactory == null) {
            if (isTransactionManaged) {
                transactionFactory = new ManagedTransactionFactory();
            } else {
                transactionFactory = new JdbcTransactionFactory();
            }
        }
    }

    protected void initSqlSessionFactory(){
        if(sqlSessionFactory == null){
            InputStream inputStream = null;
            try {
                inputStream = getMyBatisXmlConfigurationSteam();

                // update the jdbc parameters to the configured ones...
                Environment environment = new Environment("xflow-default", transactionFactory, dataSource);
                Reader reader = new InputStreamReader(inputStream);
                Properties properties = new Properties();


                Configuration configuration = initMybatisConfiguration(environment, reader, properties);
                sqlSessionFactory = new DefaultSqlSessionFactory(configuration);

            } catch (Exception e) {
                throw new XflowException("SqlSessionFactory 创建异常: " + e.getMessage(), e);
            } finally {
                IoUtil.closeSilently(inputStream);
            }
        }
    }

    protected Configuration initMybatisConfiguration(Environment environment, Reader reader, Properties properties) {
        XMLConfigBuilder parser = new XMLConfigBuilder(reader,"", properties);
        Configuration configuration = parser.getConfiguration();
        configuration.setEnvironment(environment);
        return configuration;
    }

    protected InputStream getResourceAsStream(String resource) {
        return ReflectUtil.getResourceAsStream(resource);
    }
    protected InputStream getMyBatisXmlConfigurationSteam() {
        return getResourceAsStream(DEFAULT_MYBATIS_MAPPING_FILE);
    }
}
