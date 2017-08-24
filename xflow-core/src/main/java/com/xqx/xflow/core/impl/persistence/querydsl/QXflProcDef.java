package com.xqx.xflow.core.impl.persistence.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.xqx.xflow.core.impl.persistence.entity.XflProcDef;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QXflProcDef is a Querydsl query type for XflProcDef
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QXflProcDef extends com.querydsl.sql.RelationalPathBase<XflProcDef> {

    private static final long serialVersionUID = 1834800138;

    public static final QXflProcDef xflProcDef = new QXflProcDef("xfl_proc_def");

    public final StringPath candidateGroup = createString("candidateGroup");

    public final StringPath category = createString("category");

    public final StringPath id = createString("id");

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final StringPath name = createString("name");

    public final StringPath procDesc = createString("procDesc");

    public final StringPath procKey = createString("procKey");

    public final com.querydsl.sql.PrimaryKey<XflProcDef> primary = createPrimaryKey(id);

    public QXflProcDef(String variable) {
        super(XflProcDef.class, forVariable(variable), "null", "xfl_proc_def");
        addMetadata();
    }

    public QXflProcDef(String variable, String schema, String table) {
        super(XflProcDef.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QXflProcDef(String variable, String schema) {
        super(XflProcDef.class, forVariable(variable), schema, "xfl_proc_def");
        addMetadata();
    }

    public QXflProcDef(Path<? extends XflProcDef> path) {
        super(path.getType(), path.getMetadata(), "null", "xfl_proc_def");
        addMetadata();
    }

    public QXflProcDef(PathMetadata metadata) {
        super(XflProcDef.class, metadata, "null", "xfl_proc_def");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(candidateGroup, ColumnMetadata.named("candidate_group").withIndex(5).ofType(Types.VARCHAR).withSize(255));
        addMetadata(category, ColumnMetadata.named("category").withIndex(6).ofType(Types.VARCHAR).withSize(255));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.VARCHAR).withSize(36).notNull());
        addMetadata(isDeleted, ColumnMetadata.named("is_deleted").withIndex(7).ofType(Types.TINYINT).withSize(3).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(255).notNull());
        addMetadata(procDesc, ColumnMetadata.named("proc_desc").withIndex(4).ofType(Types.VARCHAR).withSize(1000));
        addMetadata(procKey, ColumnMetadata.named("proc_key").withIndex(3).ofType(Types.VARCHAR).withSize(255).notNull());
    }

}

