package com.xqx.xflow.core.impl;

public abstract class Authentication {

    static ThreadLocal<String> userIdThreadLocal = new ThreadLocal<String>();
    static ThreadLocal<String> userNameThreadLocal = new ThreadLocal<String>();

    public static void setAuthenticatedUserInfo(String userId, String userName) {
        userIdThreadLocal.set(userId);
        userNameThreadLocal.set(userName);
    }

    public static String getUserId() {
        return userIdThreadLocal.get();
    }

    public static String getUserName() {
        return userNameThreadLocal.get();
    }
}
