package com.xqx.xflow.core.impl.persistence.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.xqx.xflow.core.impl.persistence.entity.XflTaskDef;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QXflTaskDef is a Querydsl query type for XflTaskDef
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QXflTaskDef extends com.querydsl.sql.RelationalPathBase<XflTaskDef> {

    private static final long serialVersionUID = 607084411;

    public static final QXflTaskDef xflTaskDef = new QXflTaskDef("xfl_task_def");

    public final StringPath candidateGroup = createString("candidateGroup");

    public final StringPath candidateUser = createString("candidateUser");

    public final StringPath dueDate = createString("dueDate");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath procDefId = createString("procDefId");

    public final StringPath taskDesc = createString("taskDesc");

    public final StringPath taskType = createString("taskType");

    public final com.querydsl.sql.PrimaryKey<XflTaskDef> primary = createPrimaryKey(id);

    public QXflTaskDef(String variable) {
        super(XflTaskDef.class, forVariable(variable), "null", "xfl_task_def");
        addMetadata();
    }

    public QXflTaskDef(String variable, String schema, String table) {
        super(XflTaskDef.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QXflTaskDef(String variable, String schema) {
        super(XflTaskDef.class, forVariable(variable), schema, "xfl_task_def");
        addMetadata();
    }

    public QXflTaskDef(Path<? extends XflTaskDef> path) {
        super(path.getType(), path.getMetadata(), "null", "xfl_task_def");
        addMetadata();
    }

    public QXflTaskDef(PathMetadata metadata) {
        super(XflTaskDef.class, metadata, "null", "xfl_task_def");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(candidateGroup, ColumnMetadata.named("candidate_group").withIndex(6).ofType(Types.VARCHAR).withSize(255));
        addMetadata(candidateUser, ColumnMetadata.named("candidate_user").withIndex(7).ofType(Types.VARCHAR).withSize(255));
        addMetadata(dueDate, ColumnMetadata.named("due_date").withIndex(8).ofType(Types.VARCHAR).withSize(50));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(3).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(procDefId, ColumnMetadata.named("proc_def_id").withIndex(2).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(taskDesc, ColumnMetadata.named("task_desc").withIndex(4).ofType(Types.VARCHAR).withSize(1000));
        addMetadata(taskType, ColumnMetadata.named("task_type").withIndex(5).ofType(Types.VARCHAR).withSize(255));
    }

}

