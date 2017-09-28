package com.xqx.xflow.core.impl.expression;

import com.xqx.xflow.core.XflowException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.BeanResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import java.util.Map;

@Component
public class ConditionHelper {
    public static final String SPEL_PREFIX = "#{";
    public static final String SPEL_SUBFIX = "}";

    public static final String SQL_PREFIX = "SQL{";
    public static final String SQL_SUBFIX = "}";

    @Autowired
    private ApplicationContext applicationContext;

    public static boolean isSpelCondition(@Nonnull String condition){
        condition = condition.trim();
        if(condition.startsWith(SPEL_PREFIX) && condition.endsWith(SPEL_SUBFIX)){
            return true;
        }
        return false;
    }

    public static boolean isSqlCondition(@Nonnull String condition){
        condition = condition.trim();
        if(condition.startsWith(SQL_PREFIX) && condition.endsWith(SQL_SUBFIX)){
            return true;
        }
        return false;
    }

    public boolean checkCondition(String condition){
        if(StringUtils.isEmpty(condition)){
            return true;
        }
        ConditionChecker checker = null;
        BeanResolver beanResolver = new BeanFactoryResolver(applicationContext);
        Map<String, Object> variables = null;
        if(isSpelCondition(condition)){
            checker = new SpelConditionChecker(beanResolver,variables);
        }else if(isSqlCondition(condition)){
            throw new XflowException("Sql condition not support yet.");
        }

        if(checker == null){
            throw new XflowException("Unrecgnized condition:" + condition);
        }
        return checker.check(condition);

    }
}
