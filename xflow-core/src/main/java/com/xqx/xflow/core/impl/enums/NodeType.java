package com.xqx.xflow.core.impl.enums;

public enum NodeType {
    START("开始"),
    END("结束"),
    USER_TASK("任务"),
    JAVA_TASK("任务"),
    FORK("分支"),
    JOIN("汇聚");

    String displayName;
    NodeType(String displayName){
        this.displayName = displayName;
    }


}
