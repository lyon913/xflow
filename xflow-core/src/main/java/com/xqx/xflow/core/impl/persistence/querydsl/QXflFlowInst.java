package com.xqx.xflow.core.impl.persistence.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.xqx.xflow.core.impl.persistence.entity.XflFlowInst;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QXflFlowInst is a Querydsl query type for XflFlowInst
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QXflFlowInst extends com.querydsl.sql.RelationalPathBase<XflFlowInst> {

    private static final long serialVersionUID = -215430983;

    public static final QXflFlowInst xflFlowInst = new QXflFlowInst("xfl_flow_inst");

    public final StringPath id = createString("id");

    public final StringPath procInstId = createString("procInstId");

    public final StringPath sourceId = createString("sourceId");

    public final StringPath targetId = createString("targetId");

    public final com.querydsl.sql.PrimaryKey<XflFlowInst> primary = createPrimaryKey(id);

    public QXflFlowInst(String variable) {
        super(XflFlowInst.class, forVariable(variable), "null", "xfl_flow_inst");
        addMetadata();
    }

    public QXflFlowInst(String variable, String schema, String table) {
        super(XflFlowInst.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QXflFlowInst(String variable, String schema) {
        super(XflFlowInst.class, forVariable(variable), schema, "xfl_flow_inst");
        addMetadata();
    }

    public QXflFlowInst(Path<? extends XflFlowInst> path) {
        super(path.getType(), path.getMetadata(), "null", "xfl_flow_inst");
        addMetadata();
    }

    public QXflFlowInst(PathMetadata metadata) {
        super(XflFlowInst.class, metadata, "null", "xfl_flow_inst");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(procInstId, ColumnMetadata.named("proc_inst_id").withIndex(2).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(sourceId, ColumnMetadata.named("source_id").withIndex(3).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(targetId, ColumnMetadata.named("target_id").withIndex(4).ofType(Types.VARCHAR).withSize(50).notNull());
    }

}

