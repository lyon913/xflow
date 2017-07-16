package com.xqx.xflow.core.test;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lyon on 2017/7/16.
 */
public class PeriodTest {

    @Test
    public void test(){
        DateTime t1 = DateTime.parse("2017-1-1T00:00:00");
        DateTime t2 = t1.plus(Period.parse("P1DT1H1M1S"));

        DateTime expected = DateTime.parse("2017-1-2T01:01:01");
        Assert.assertEquals(expected,t2);
    }
}
