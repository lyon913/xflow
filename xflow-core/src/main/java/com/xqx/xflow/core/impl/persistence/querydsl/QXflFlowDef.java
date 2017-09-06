package com.xqx.xflow.core.impl.persistence.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.xqx.xflow.core.impl.persistence.entity.XflFlowDef;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QXflFlowDef is a Querydsl query type for XflFlowDef
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QXflFlowDef extends com.querydsl.sql.RelationalPathBase<XflFlowDef> {

    private static final long serialVersionUID = 1378518834;

    public static final QXflFlowDef xflFlowDef = new QXflFlowDef("xfl_flow_def");

    public final StringPath conditionExp = createString("conditionExp");

    public final StringPath flowDesc = createString("flowDesc");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath sourceTdefId = createString("sourceTdefId");

    public final StringPath targetTdefId = createString("targetTdefId");

    public final com.querydsl.sql.PrimaryKey<XflFlowDef> primary = createPrimaryKey(id);

    public QXflFlowDef(String variable) {
        super(XflFlowDef.class, forVariable(variable), "null", "xfl_flow_def");
        addMetadata();
    }

    public QXflFlowDef(String variable, String schema, String table) {
        super(XflFlowDef.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QXflFlowDef(String variable, String schema) {
        super(XflFlowDef.class, forVariable(variable), schema, "xfl_flow_def");
        addMetadata();
    }

    public QXflFlowDef(Path<? extends XflFlowDef> path) {
        super(path.getType(), path.getMetadata(), "null", "xfl_flow_def");
        addMetadata();
    }

    public QXflFlowDef(PathMetadata metadata) {
        super(XflFlowDef.class, metadata, "null", "xfl_flow_def");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(conditionExp, ColumnMetadata.named("condition_exp").withIndex(6).ofType(Types.VARCHAR).withSize(4000));
        addMetadata(flowDesc, ColumnMetadata.named("flow_desc").withIndex(3).ofType(Types.VARCHAR).withSize(500));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(100).notNull());
        addMetadata(sourceTdefId, ColumnMetadata.named("source_tdef_id").withIndex(4).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(targetTdefId, ColumnMetadata.named("target_tdef_id").withIndex(5).ofType(Types.VARCHAR).withSize(50).notNull());
    }

}

