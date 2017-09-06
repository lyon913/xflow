package com.xqx.xflow.core.impl.enums;

public enum TaskType implements EnumClass<String> {
    START("START"),
    END("END"),
    USER_TASK("USER_TASK");

    private String id;

    TaskType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static TaskType fromId(String id) {
        for (TaskType at : TaskType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.id;
    }
}
