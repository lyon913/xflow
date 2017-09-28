package com.xqx.xflow.core.impl.expression;

import org.springframework.expression.BeanResolver;

import java.util.Map;

public class SpelConditionChecker implements ConditionChecker {
    private BeanResolver beanResolver;

    private Map<String,Object> variables;

    public SpelConditionChecker(BeanResolver beanResolver, Map<String, Object> variables) {
        this.beanResolver = beanResolver;
        this.variables = variables;
    }

    @Override
    public boolean check(String condition) {
        return SpelEvaluator.getBooleanValue(condition,beanResolver,variables);
    }
}
