package com.xqx.xflow.core.impl.persistence.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.xqx.xflow.core.impl.persistence.entity.XflTaskInst;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QXflTaskInst is a Querydsl query type for XflTaskInst
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QXflTaskInst extends com.querydsl.sql.RelationalPathBase<XflTaskInst> {

    private static final long serialVersionUID = 1639905680;

    public static final QXflTaskInst xflTaskInst = new QXflTaskInst("xfl_task_inst");

    public final BooleanPath active = createBoolean("active");

    public final DateTimePath<org.joda.time.DateTime> claimTime = createDateTime("claimTime", org.joda.time.DateTime.class);

    public final DateTimePath<org.joda.time.DateTime> dueDate = createDateTime("dueDate", org.joda.time.DateTime.class);

    public final NumberPath<Long> duration = createNumber("duration", Long.class);

    public final DateTimePath<org.joda.time.DateTime> endTime = createDateTime("endTime", org.joda.time.DateTime.class);

    public final StringPath id = createString("id");

    public final StringPath procInstId = createString("procInstId");

    public final DateTimePath<org.joda.time.DateTime> startTime = createDateTime("startTime", org.joda.time.DateTime.class);

    public final StringPath taskAssignee = createString("taskAssignee");

    public final StringPath taskAssigneeName = createString("taskAssigneeName");

    public final StringPath taskDefId = createString("taskDefId");

    public final StringPath taskOwner = createString("taskOwner");

    public final StringPath taskOwnerName = createString("taskOwnerName");

    public final com.querydsl.sql.PrimaryKey<XflTaskInst> primary = createPrimaryKey(id);

    public QXflTaskInst(String variable) {
        super(XflTaskInst.class, forVariable(variable), "null", "xfl_task_inst");
        addMetadata();
    }

    public QXflTaskInst(String variable, String schema, String table) {
        super(XflTaskInst.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QXflTaskInst(String variable, String schema) {
        super(XflTaskInst.class, forVariable(variable), schema, "xfl_task_inst");
        addMetadata();
    }

    public QXflTaskInst(Path<? extends XflTaskInst> path) {
        super(path.getType(), path.getMetadata(), "null", "xfl_task_inst");
        addMetadata();
    }

    public QXflTaskInst(PathMetadata metadata) {
        super(XflTaskInst.class, metadata, "null", "xfl_task_inst");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(active, ColumnMetadata.named("active").withIndex(13).ofType(Types.BIT).notNull());
        addMetadata(claimTime, ColumnMetadata.named("claim_time").withIndex(9).ofType(Types.TIMESTAMP).withSize(19));
        addMetadata(dueDate, ColumnMetadata.named("due_date").withIndex(11).ofType(Types.TIMESTAMP).withSize(19));
        addMetadata(duration, ColumnMetadata.named("duration").withIndex(12).ofType(Types.BIGINT).withSize(19));
        addMetadata(endTime, ColumnMetadata.named("end_time").withIndex(10).ofType(Types.TIMESTAMP).withSize(19));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(procInstId, ColumnMetadata.named("proc_inst_id").withIndex(2).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(startTime, ColumnMetadata.named("start_time").withIndex(8).ofType(Types.TIMESTAMP).withSize(19).notNull());
        addMetadata(taskAssignee, ColumnMetadata.named("task_assignee").withIndex(6).ofType(Types.VARCHAR).withSize(50));
        addMetadata(taskAssigneeName, ColumnMetadata.named("task_assignee_name").withIndex(7).ofType(Types.VARCHAR).withSize(50));
        addMetadata(taskDefId, ColumnMetadata.named("task_def_id").withIndex(3).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(taskOwner, ColumnMetadata.named("task_owner").withIndex(4).ofType(Types.VARCHAR).withSize(50));
        addMetadata(taskOwnerName, ColumnMetadata.named("task_owner_name").withIndex(5).ofType(Types.VARCHAR).withSize(50));
    }

}

