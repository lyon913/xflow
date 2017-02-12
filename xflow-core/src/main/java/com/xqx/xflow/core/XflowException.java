package com.xqx.xflow.core;

/**
 * Created by Lyon on 2017/2/12.
 */
public class XflowException extends RuntimeException {
    public XflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public XflowException(String message) {
        super(message);
    }
}
