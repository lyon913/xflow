package com.xqx.xflow.core.impl.persistence.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.xqx.xflow.core.impl.persistence.entity.XflVariable;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QXflVariable is a Querydsl query type for XflVariable
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QXflVariable extends com.querydsl.sql.RelationalPathBase<XflVariable> {

    private static final long serialVersionUID = 800786081;

    public static final QXflVariable xflVariable = new QXflVariable("xfl_variable");

    public final StringPath category = createString("category");

    public final NumberPath<Double> doubleValue = createNumber("doubleValue", Double.class);

    public final StringPath id = createString("id");

    public final NumberPath<Integer> intValue = createNumber("intValue", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath procInstId = createString("procInstId");

    public final StringPath taskInstId = createString("taskInstId");

    public final StringPath textValue = createString("textValue");

    public final com.querydsl.sql.PrimaryKey<XflVariable> primary = createPrimaryKey(id);

    public QXflVariable(String variable) {
        super(XflVariable.class, forVariable(variable), "null", "xfl_variable");
        addMetadata();
    }

    public QXflVariable(String variable, String schema, String table) {
        super(XflVariable.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QXflVariable(String variable, String schema) {
        super(XflVariable.class, forVariable(variable), schema, "xfl_variable");
        addMetadata();
    }

    public QXflVariable(Path<? extends XflVariable> path) {
        super(path.getType(), path.getMetadata(), "null", "xfl_variable");
        addMetadata();
    }

    public QXflVariable(PathMetadata metadata) {
        super(XflVariable.class, metadata, "null", "xfl_variable");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(category, ColumnMetadata.named("category").withIndex(5).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(doubleValue, ColumnMetadata.named("double_value").withIndex(7).ofType(Types.DOUBLE).withSize(22));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(intValue, ColumnMetadata.named("int_value").withIndex(6).ofType(Types.INTEGER).withSize(10));
        addMetadata(name, ColumnMetadata.named("name").withIndex(4).ofType(Types.VARCHAR).withSize(100).notNull());
        addMetadata(procInstId, ColumnMetadata.named("proc_inst_id").withIndex(2).ofType(Types.VARCHAR).withSize(50));
        addMetadata(taskInstId, ColumnMetadata.named("task_inst_id").withIndex(3).ofType(Types.VARCHAR).withSize(50));
        addMetadata(textValue, ColumnMetadata.named("text_value").withIndex(8).ofType(Types.VARCHAR).withSize(4000));
    }

}

