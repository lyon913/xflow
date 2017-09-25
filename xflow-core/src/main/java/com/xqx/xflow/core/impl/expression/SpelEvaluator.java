package com.xqx.xflow.core.impl.expression;

import com.xqx.xflow.core.XflowException;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class SpelEvaluator {

    private static final Pattern expPattern =  Pattern.compile("^\\$\\{(.*)\\}$");

    @Autowired
    private ApplicationContext applicationContext;

    public String checkExpStr(String str){
        Matcher matcher = expPattern.matcher(str);
        if(matcher.find()){
            return matcher.group(1);
        }
        throw new XflowException("Not a valid Expression pattern.User ${...} for expresions.");
    }

    public boolean getBooleanValue(String expStr, Map<String, Object> variables){
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
