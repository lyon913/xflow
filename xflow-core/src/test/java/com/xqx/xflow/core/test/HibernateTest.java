package com.xqx.xflow.core.test;

import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.persistence.metamodel.EntityType;
import javax.sql.DataSource;

import java.util.Map;

public class HibernateTest {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            System.setProperty("hibernate.dialect.storage_engine", "innodb");
            //DataSource ds = new DriverManagerDataSource("jdbc:mysql://127.0.0.1/xflow", "xflow", "xqx1234");
            DataSource ds = new DriverManagerDataSource("jdbc:sqlserver://127.0.0.1:1433;databaseName=xflow;", "sa", "xqx123456@");
            Configuration configuration = new Configuration();
            configuration.configure("xflow-hibernate.cfg.xml");
            configuration.getStandardServiceRegistryBuilder().applySetting(Environment.DATASOURCE, ds);
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    @Test
    public void test() throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}