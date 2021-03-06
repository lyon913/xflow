package com.xqx.xflow.core.impl.persistence.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.xqx.xflow.core.impl.persistence.entity.XflProcInst;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QXflProcInst is a Querydsl query type for XflProcInst
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QXflProcInst extends com.querydsl.sql.RelationalPathBase<XflProcInst> {

    private static final long serialVersionUID = 1044387553;

    public static final QXflProcInst xflProcInst = new QXflProcInst("xfl_proc_inst");

    public final BooleanPath active = createBoolean("active");

    public final StringPath businessKey = createString("businessKey");

    public final DateTimePath<org.joda.time.DateTime> dueDate = createDateTime("dueDate", org.joda.time.DateTime.class);

    public final NumberPath<Long> duration = createNumber("duration", Long.class);

    public final DateTimePath<org.joda.time.DateTime> endTime = createDateTime("endTime", org.joda.time.DateTime.class);

    public final StringPath id = createString("id");

    public final StringPath procDefId = createString("procDefId");

    public final DateTimePath<org.joda.time.DateTime> startTime = createDateTime("startTime", org.joda.time.DateTime.class);

    public final StringPath startUserId = createString("startUserId");

    public final StringPath startUserName = createString("startUserName");

    public final com.querydsl.sql.PrimaryKey<XflProcInst> primary = createPrimaryKey(id);

    public QXflProcInst(String variable) {
        super(XflProcInst.class, forVariable(variable), "null", "xfl_proc_inst");
        addMetadata();
    }

    public QXflProcInst(String variable, String schema, String table) {
        super(XflProcInst.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QXflProcInst(String variable, String schema) {
        super(XflProcInst.class, forVariable(variable), schema, "xfl_proc_inst");
        addMetadata();
    }

    public QXflProcInst(Path<? extends XflProcInst> path) {
        super(path.getType(), path.getMetadata(), "null", "xfl_proc_inst");
        addMetadata();
    }

    public QXflProcInst(PathMetadata metadata) {
        super(XflProcInst.class, metadata, "null", "xfl_proc_inst");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(active, ColumnMetadata.named("active").withIndex(10).ofType(Types.BIT).notNull());
        addMetadata(businessKey, ColumnMetadata.named("business_key").withIndex(3).ofType(Types.VARCHAR).withSize(100).notNull());
        addMetadata(dueDate, ColumnMetadata.named("due_date").withIndex(8).ofType(Types.TIMESTAMP).withSize(19));
        addMetadata(duration, ColumnMetadata.named("duration").withIndex(9).ofType(Types.BIGINT).withSize(19));
        addMetadata(endTime, ColumnMetadata.named("end_time").withIndex(7).ofType(Types.TIMESTAMP).withSize(19));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(procDefId, ColumnMetadata.named("proc_def_id").withIndex(2).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(startTime, ColumnMetadata.named("start_time").withIndex(4).ofType(Types.TIMESTAMP).withSize(19).notNull());
        addMetadata(startUserId, ColumnMetadata.named("start_user_id").withIndex(5).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(startUserName, ColumnMetadata.named("start_user_name").withIndex(6).ofType(Types.VARCHAR).withSize(50).notNull());
    }

}

