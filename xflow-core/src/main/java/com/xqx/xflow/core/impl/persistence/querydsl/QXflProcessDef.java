package com.xqx.xflow.core.impl.persistence.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.xqx.xflow.core.impl.persistence.entity.XflProcessDef;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QXflProcessDef is a Querydsl query type for XflProcessDef
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QXflProcessDef extends com.querydsl.sql.RelationalPathBase<XflProcessDef> {

    private static final long serialVersionUID = -559717893;

    public static final QXflProcessDef xflProcessDef = new QXflProcessDef("xfl_process_def");

    public final StringPath candidateGroup = createString("candidateGroup");

    public final StringPath creator = createString("creator");

    public final DateTimePath<java.sql.Timestamp> gtmCreate = createDateTime("gtmCreate", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> gtmModify = createDateTime("gtmModify", java.sql.Timestamp.class);

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath processDesc = createString("processDesc");

    public final StringPath processType = createString("processType");

    public final com.querydsl.sql.PrimaryKey<XflProcessDef> primary = createPrimaryKey(id);

    public QXflProcessDef(String variable) {
        super(XflProcessDef.class, forVariable(variable), "null", "xfl_process_def");
        addMetadata();
    }

    public QXflProcessDef(String variable, String schema, String table) {
        super(XflProcessDef.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QXflProcessDef(String variable, String schema) {
        super(XflProcessDef.class, forVariable(variable), schema, "xfl_process_def");
        addMetadata();
    }

    public QXflProcessDef(Path<? extends XflProcessDef> path) {
        super(path.getType(), path.getMetadata(), "null", "xfl_process_def");
        addMetadata();
    }

    public QXflProcessDef(PathMetadata metadata) {
        super(XflProcessDef.class, metadata, "null", "xfl_process_def");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(candidateGroup, ColumnMetadata.named("candidate_group").withIndex(4).ofType(Types.VARCHAR).withSize(255));
        addMetadata(creator, ColumnMetadata.named("creator").withIndex(6).ofType(Types.VARCHAR).withSize(255));
        addMetadata(gtmCreate, ColumnMetadata.named("gtm_create").withIndex(7).ofType(Types.TIMESTAMP).withSize(19));
        addMetadata(gtmModify, ColumnMetadata.named("gtm_modify").withIndex(8).ofType(Types.TIMESTAMP).withSize(19));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.VARCHAR).withSize(64).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(processDesc, ColumnMetadata.named("process_desc").withIndex(3).ofType(Types.VARCHAR).withSize(4000));
        addMetadata(processType, ColumnMetadata.named("process_type").withIndex(5).ofType(Types.VARCHAR).withSize(255));
    }

}

