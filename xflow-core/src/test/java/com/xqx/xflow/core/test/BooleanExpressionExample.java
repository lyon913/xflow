package com.xqx.xflow.core.test;

import org.springframework.stereotype.Component;

@Component("booleanExpressionExample")
public class BooleanExpressionExample {
    public static String str = "This is a String.";

    public boolean trueValue(){
        return true;
    }

    public boolean falseValue(){
        return false;
    }

    public String stringValue(){
        return str;
    }
}
