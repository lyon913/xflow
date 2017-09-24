package com.xqx.xflow.core.test;

import com.xqx.xflow.core.impl.persistence.entity.NodeDef;
import com.xqx.xflow.core.impl.persistence.entity.ProcessDef;
import com.xqx.xflow.core.impl.persistence.entity.StartNodeDef;
import com.xqx.xflow.core.impl.persistence.entity.UserTaskNodeDef;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.List;

public class PersistenceTest extends BaseTest {
    private final Logger log = LoggerFactory.getLogger(PersistenceTest.class);

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

    @Test
    @Transactional
    public void inheritanceTest() {
        ProcessDef processDef = new ProcessDef();
        processDef.setKey("Key1");
        processDef.setName("Name1");
        em.persist(processDef);

        StartNodeDef start = new StartNodeDef();
        start.setName("Start");
        start.setProcessDef(processDef);
        em.persist(start);

        UserTaskNodeDef userTask = new UserTaskNodeDef();
        userTask.setName("User Task 1");
        userTask.setProcessDef(processDef);
        em.persist(userTask);

        String ql = "select n from NodeDef n where n.processDef.id = :pid";
        List<NodeDef> nodeDefList = em.createQuery(ql,NodeDef.class).setParameter("pid", processDef.getId()).getResultList();
        Assert.assertEquals(nodeDefList.size(), 2);

        for (NodeDef node : nodeDefList) {
            if (node instanceof StartNodeDef) {
                log.debug("=========  start node found");
            } else if (node instanceof UserTaskNodeDef) {
                log.debug("=========  UserTask node found");
            } else {
                throw new RuntimeException("NODE TYPE ERROR");
            }
        }
    }


}