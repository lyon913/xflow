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
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class SpelEvaluator {

    private static final Pattern expPattern = Pattern.compile("\\$\\{(.*)\\}");

    @Autowired
    private ApplicationContext applicationContext;

    public boolean isExpressionString(String input) {
        input = trim(input);
        Matcher matcher = expPattern.matcher(input);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    private String getExpressionFromPattern(String expStr) {
        expStr = trim(expStr);
        Matcher matcher = expPattern.matcher(expStr);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new XflowException("Not a valid Expression pattern.Use ${...} for expresions pattern.");
    }

    private Expression parseExpression(String expPattern) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(getExpressionFromPattern(expPattern));
        return exp;
    }

    public boolean getBooleanValue(@Nonnull String expStr, @Nonnull Map<String, Object> variables) {
        Expression exp = parseExpression(expStr);
        EvaluationContext ctx = getEvaluateContext(variables);
        return exp.getValue(ctx, Boolean.class);
    }

    public String getStringValue(@Nonnull String expStr, @Nonnull Map<String, Object> variables) {
        Expression exp = parseExpression(expStr);
        EvaluationContext ctx = getEvaluateContext(variables);
        return exp.getValue(ctx, String.class);
    }

    private EvaluationContext getEvaluateContext(Map<String, Object> variables) {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.addPropertyAccessor(new BeanExpressionContextAccessor());
        context.addPropertyAccessor(new BeanFactoryAccessor());
        context.addPropertyAccessor(new MapAccessor());
        context.setBeanResolver(new BeanFactoryResolver(applicationContext));
        context.setVariables(variables);
        return context;
    }

    private String trim(String input) {
        if (StringUtils.isEmpty(input)) {
            return "";
        }

        return input.trim();
    }

}
