package com.xqx.xflow.core.impl.util;

import com.google.common.base.Strings;
import com.xqx.xflow.core.XflowException;
import org.joda.time.DateTime;
import org.joda.time.Period;

public class DateUtil {
    public static DateTime parsePeriod(String periodString){
        if(Strings.isNullOrEmpty(periodString)){
            return null;
        }
        if(periodString.startsWith("P")){
            Period period = Period.parse(periodString);
            DateTime now = new DateTime();
            DateTime dueDate = now.plus(period);
            return dueDate;
        }else {
            throw new XflowException("Unknown Due Date format");
        }
    }
}
