package com.xqx.xflow.core.test;

import com.xqx.xflow.core.impl.persistence.entity.NodeDef;
import com.xqx.xflow.core.impl.persistence.entity.ProcessDef;
import com.xqx.xflow.core.impl.persistence.entity.StartNodeDef;
import com.xqx.xflow.core.impl.persistence.entity.UserTaskNodeDef;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanExpressionContext;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.expression.BeanExpressionContextAccessor;
import org.springframework.context.expression.BeanFactoryAccessor;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersistenceTest extends BaseTest {
    private final Logger log = LoggerFactory.getLogger(PersistenceTest.class);

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ApplicationContext applicationContext;

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

        List<NodeDef> nodeDefList = em.createQuery("from NodeDef n where n.processDef.id = :pid").setParameter("pid", processDef.getId()).getResultList();
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


    @Test
    public void booleanExpressionTest() {
        ConfigurableBeanFactory beanFactory = null;
        if(applicationContext instanceof ConfigurableBeanFactory){
            beanFactory = (ConfigurableBeanFactory)applicationContext;
        }

        if(applicationContext.getAutowireCapableBeanFactory() instanceof ConfigurableBeanFactory){
            beanFactory = (ConfigurableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        }
        BeanExpressionContext beanEvaluationContext = new BeanExpressionContext(beanFactory, null);

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.addPropertyAccessor(new BeanExpressionContextAccessor());
        context.addPropertyAccessor(new BeanFactoryAccessor());
        context.addPropertyAccessor(new MapAccessor());
        context.setBeanResolver(new BeanFactoryResolver(beanEvaluationContext.getBeanFactory()));

        Map<String,Object> rootObject = new HashMap<>();
        rootObject.put("test1","Test1");
        rootObject.put("test2","Test2");
        context.setVariables(rootObject);

        ExpressionParser parser = new SpelExpressionParser();

        String expStr = "@booleanExpressionExample.trueValue()";
        Expression exp = parser.parseExpression(expStr);
        Boolean value = exp.getValue(context, Boolean.class);
        Assert.assertEquals(value, true);


        String expStr2 = "@booleanExpressionExample.stringValue().concat(#test1)";
        Expression exp2 = parser.parseExpression(expStr2);
        String value2 = exp2.getValue(context, String.class);
        Assert.assertEquals(value2, BooleanExpressionExample.str + rootObject.get("test1"));

        String expStr3 = "#test2";
        Expression exp3 = parser.parseExpression(expStr3);
        String value3 = exp3.getValue(context, String.class);
        Assert.assertEquals(value3, rootObject.get("test2"));
    }
}