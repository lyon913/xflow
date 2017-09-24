package com.xqx.xflow.core.impl.expression;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.expression.BeanExpressionContextAccessor;
import org.springframework.context.expression.BeanFactoryAccessor;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpelEvaluator {

    private static final String expPattern = "^\\$\\{*\\}$";

    @Autowired
    private ApplicationContext applicationContext;

    public boolean evaluateBooleanExpression(String expStr, Map<String, Object> variables){
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(expStr);
        EvaluationContext ctx = getEvaluateContext(variables);
        return exp.getValue(ctx,Boolean.class);
    }

    private EvaluationContext getEvaluateContext(Map<String, Object> variables){
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.addPropertyAccessor(new BeanExpressionContextAccessor());
        context.addPropertyAccessor(new BeanFactoryAccessor());
        context.addPropertyAccessor(new MapAccessor());
        context.setBeanResolver(new BeanFactoryResolver(applicationContext));
        context.setVariables(variables);
        return context;
    }

}
