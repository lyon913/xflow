package com.xqx.xflow.core.test;

import com.xqx.xflow.core.impl.expression.SpelEvaluator;
import org.junit.Assert;
import org.junit.Test;
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

import java.util.HashMap;
import java.util.Map;

public class SpELTest extends BaseTest{

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SpelEvaluator spelEvaluator;

    @Test
    public void booleanExpressionTest() {
        ConfigurableBeanFactory beanFactory = null;
        if(applicationContext instanceof ConfigurableBeanFactory){
            beanFactory = (ConfigurableBeanFactory)applicationContext;
        }

        if(applicationContext.getAutowireCapableBeanFactory() instanceof ConfigurableBeanFactory){
            beanFactory = (ConfigurableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        }


        StandardEvaluationContext context = new StandardEvaluationContext();
        context.addPropertyAccessor(new BeanExpressionContextAccessor());
        context.addPropertyAccessor(new BeanFactoryAccessor());
        context.addPropertyAccessor(new MapAccessor());

        BeanExpressionContext beanEvaluationContext = new BeanExpressionContext(beanFactory, null);
        context.setBeanResolver(new BeanFactoryResolver(beanEvaluationContext.getBeanFactory()));

        Map<String,Object> variables = new HashMap<>();
        variables.put("test1","Test1");
        variables.put("test2","Test2");
        context.setVariables(variables);

        ExpressionParser parser = new SpelExpressionParser();

        String expStr = "@booleanExpressionExample.trueValue()";
        Expression exp = parser.parseExpression(expStr);
        Boolean value = exp.getValue(context, Boolean.class);
        Assert.assertEquals(value, true);


        String expStr2 = "@booleanExpressionExample.stringValue().concat(#test1)";
        Expression exp2 = parser.parseExpression(expStr2);
        String value2 = exp2.getValue(context, String.class);
        Assert.assertEquals(value2, BooleanExpressionExample.str + variables.get("test1"));

        String expStr3 = "#test2";
        Expression exp3 = parser.parseExpression(expStr3);
        String value3 = exp3.getValue(context, String.class);
        Assert.assertEquals(value3, variables.get("test2"));
    }

    @Test
    public void test2(){
        Map<String,Object> variables = new HashMap<>();
        variables.put("trueValue",true);
        variables.put("falseValue",false);

        String expStr = "@booleanExpressionExample.trueValue() == #trueValue";
        boolean result = spelEvaluator.getBooleanValue(expStr, variables);
        Assert.assertEquals(true,result);

        String expStr2 = "@booleanExpressionExample.falseValue() == #trueValue";
        boolean result2 = spelEvaluator.getBooleanValue(expStr2, variables);
        Assert.assertEquals(false,result2);

        String expStr3 = "#falseValue";
        boolean result3= spelEvaluator.getBooleanValue(expStr3, variables);
        Assert.assertEquals(false,result3);

    }

    @Test
    public void regexTest(){
        String result = spelEvaluator.checkExpStr("${123aaa}");
        Assert.assertEquals("123aaa",result);
    }
}
