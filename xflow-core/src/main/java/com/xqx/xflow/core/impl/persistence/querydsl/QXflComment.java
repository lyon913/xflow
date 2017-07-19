package com.xqx.xflow.core.impl.persistence.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.xqx.xflow.core.impl.persistence.entity.XflComment;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QXflComment is a Querydsl query type for XflComment
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QXflComment extends com.querydsl.sql.RelationalPathBase<XflComment> {

    private static final long serialVersionUID = -1200217702;

    public static final QXflComment xflComment = new QXflComment("xfl_comment");

    public final StringPath category = createString("category");

    public final DateTimePath<java.sql.Timestamp> createTime = createDateTime("createTime", java.sql.Timestamp.class);

    public final StringPath id = createString("id");

    public final StringPath msg = createString("msg");

    public final StringPath procInstId = createString("procInstId");

    public final StringPath taskInstId = createString("taskInstId");

    public final StringPath userId = createString("userId");

    public final StringPath userName = createString("userName");

    public final com.querydsl.sql.PrimaryKey<XflComment> primary = createPrimaryKey(id);

    public QXflComment(String variable) {
        super(XflComment.class, forVariable(variable), "null", "xfl_comment");
        addMetadata();
    }

    public QXflComment(String variable, String schema, String table) {
        super(XflComment.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QXflComment(String variable, String schema) {
        super(XflComment.class, forVariable(variable), schema, "xfl_comment");
        addMetadata();
    }

    public QXflComment(Path<? extends XflComment> path) {
        super(path.getType(), path.getMetadata(), "null", "xfl_comment");
        addMetadata();
    }

    public QXflComment(PathMetadata metadata) {
        super(XflComment.class, metadata, "null", "xfl_comment");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(category, ColumnMetadata.named("category").withIndex(4).ofType(Types.VARCHAR).withSize(50));
        addMetadata(createTime, ColumnMetadata.named("create_time").withIndex(8).ofType(Types.TIMESTAMP).withSize(19));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.VARCHAR).withSize(36).notNull());
        addMetadata(msg, ColumnMetadata.named("msg").withIndex(5).ofType(Types.VARCHAR).withSize(4000));
        addMetadata(procInstId, ColumnMetadata.named("proc_inst_id").withIndex(2).ofType(Types.VARCHAR).withSize(36));
        addMetadata(taskInstId, ColumnMetadata.named("task_inst_id").withIndex(3).ofType(Types.VARCHAR).withSize(36));
        addMetadata(userId, ColumnMetadata.named("user_id").withIndex(6).ofType(Types.VARCHAR).withSize(36));
        addMetadata(userName, ColumnMetadata.named("user_name").withIndex(7).ofType(Types.VARCHAR).withSize(50));
    }

}

