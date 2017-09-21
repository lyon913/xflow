package com.xqx.xflow.core.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:xflow-spring-test.xml")
public class HibernateTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void test() throws Exception {
        System.out.println("querying all the managed entities...");
        final Metamodel metamodel = em.getMetamodel();
        for (EntityType<?> entityType : metamodel.getEntities()) {
            final String entityName = entityType.getName();
            final Query query = em.createQuery("from " + entityName);
            System.out.println("executing: " + query.toString());
            for (Object o : query.getResultList()) {
                System.out.println("  " + o);
            }
        }
    }
}