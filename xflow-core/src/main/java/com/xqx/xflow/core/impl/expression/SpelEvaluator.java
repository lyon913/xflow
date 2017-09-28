package com.xqx.xflow.core.impl.expression;

import com.xqx.xflow.core.XflowException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.expression.BeanExpressionContextAccessor;
import org.springframework.context.expression.BeanFactoryAccessor;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.BeanResolver;
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

public class SpelEvaluator {

    private static final Pattern expPattern = Pattern.compile("#\\{(.*)\\}");

    public static boolean getBooleanValue(@Nonnull String expStr, @Nonnull BeanResolver beanResolver, @Nonnull Map<String, Object> variables) {
        Expression exp = parseExpression(expStr);
        EvaluationContext ctx = getEvaluateContext(beanResolver, variables);
        return exp.getValue(ctx, Boolean.class);
    }

    public static String getStringValue(@Nonnull String expStr, @Nonnull BeanResolver beanResolver,@Nonnull Map<String, Object> variables) {
        Expression exp = parseExpression(expStr);
        EvaluationContext ctx = getEvaluateContext(beanResolver, variables);
        return exp.getValue(ctx, String.class);
    }

    private static String getExpressionFromPattern(String expStr) {
        expStr = trim(expStr);
        Matcher matcher = expPattern.matcher(expStr);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new XflowException("Not a valid Expression pattern.Use ${...} for expresions pattern.");
    }

    private static Expression parseExpression(String expPattern) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(getExpressionFromPattern(expPattern));
        return exp;
    }

    private static EvaluationContext getEvaluateContext(BeanResolver beanResolver, Map<String, Object> variables) {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.addPropertyAccessor(new BeanExpressionContextAccessor());
        context.addPropertyAccessor(new BeanFactoryAccessor());
        context.addPropertyAccessor(new MapAccessor());
        context.setBeanResolver(beanResolver);
        context.setVariables(variables);
        return context;
    }

    private static String trim(String input) {
        if (StringUtils.isEmpty(input)) {
            return "";
        }
        return input.trim();
    }

}
