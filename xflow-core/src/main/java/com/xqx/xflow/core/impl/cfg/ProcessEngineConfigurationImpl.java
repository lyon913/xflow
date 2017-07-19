package com.xqx.xflow.core.impl.cfg;

import com.querydsl.sql.SQLQueryFactory;
import com.xqx.xflow.core.ProcessEngine;
import com.xqx.xflow.core.ProcessEngineConfiguration;
import com.xqx.xflow.core.XflowException;
import com.xqx.xflow.core.impl.ProcessEngineImpl;
import com.xqx.xflow.core.impl.db.DbSqlSessionFactory;
import com.xqx.xflow.core.impl.db.UuidGenerator;
import com.xqx.xflow.core.impl.util.IoUtil;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;
import java.util.UUID;

/**
 * 独立流程引擎配置实现类
 * 目前未实现独立事务管理，需依赖spring的事务管理。
 * 因此该类被标记为abstract，应使用其子类SpringProcessEngineConfigurationImpl
 * Created by Lyon on 2017/2/12.
 */
public class ProcessEngineConfigurationImpl extends ProcessEngineConfiguration {
    /**
     * mybatis配置文件路径
     */
    public static final String DEFAULT_MYBATIS_MAPPING_FILE = "com/xqx/xflow/db/mapping/mappings.xml";

    protected TransactionFactory transactionFactory;
    protected SqlSessionFactory sqlSessionFactory;
    protected DbSqlSessionFactory dbSqlSessionFactory;
    protected IdGenerator idGenerator;

    protected SQLQueryFactory sqlQueryFactory;


    public ProcessEngine buildProcessEngine() {
        init();
        return new ProcessEngineImpl(this);
    }

    protected void init() {
        initDataSource();
        initIdGenerator();
        initTransactionFactory();
        initSqlSessionFactory();
        initDbSqlSessionFactory();
    }

    protected void initDataSource() {
        if (dataSource == null) {
            //配置文件未直接提供datasource，从 jdbcUrl 或 jndi 配置数据源
            //暂未实现
            throw new XflowException("数据源未指定。");
        }
    }

    protected void initIdGenerator(){
        if(idGenerator == null){
            idGenerator = new UuidGenerator();
        }
    }


    protected void initTransactionFactory() {
        if (transactionFactory == null) {
            if (isTransactionExternalManaged) {
                //容器托管的事务管理器
                transactionFactory = new ManagedTransactionFactory();
            } else {
                //尚未实现
                //throw new RuntimeException("独立事务管理功能尚未实现。");
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
                Environment environment = new Environment("default", transactionFactory, dataSource);
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
    protected void initDbSqlSessionFactory(){
        if(dbSqlSessionFactory == null){
            dbSqlSessionFactory = new DbSqlSessionFactory();
            dbSqlSessionFactory.setSqlSessionFactory(sqlSessionFactory);
            dbSqlSessionFactory.setIdGenerator(idGenerator);
        }
    }

    protected Configuration initMybatisConfiguration(Environment environment, Reader reader, Properties properties) {
        XMLConfigBuilder parser = new XMLConfigBuilder(reader,"", properties);
        Configuration configuration = parser.getConfiguration();
        configuration.setEnvironment(environment);
        return parser.parse();
    }

    protected InputStream getResourceAsStream(String resource) {
        return IoUtil.getResourceAsStream(resource);
    }
    protected InputStream getMyBatisXmlConfigurationSteam() {
        return getResourceAsStream(DEFAULT_MYBATIS_MAPPING_FILE);
    }


    //--      getter and setter     -//

    public TransactionFactory getTransactionFactory() {
        return transactionFactory;
    }

    public void setTransactionFactory(TransactionFactory transactionFactory) {
        this.transactionFactory = transactionFactory;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public DbSqlSessionFactory getDbSqlSessionFactory() {
        return dbSqlSessionFactory;
    }

    public void setDbSqlSessionFactory(DbSqlSessionFactory dbSqlSessionFactory) {
        this.dbSqlSessionFactory = dbSqlSessionFactory;
    }

    //--      getter and setter     -//
}
