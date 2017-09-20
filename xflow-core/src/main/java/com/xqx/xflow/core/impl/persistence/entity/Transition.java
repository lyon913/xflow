package com.xqx.xflow.core.impl.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "XFL_TRANSITION")
public class Transition extends BaseIdEntity {

    @Column(name = "NAME_", length = 255)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "SOURCE_NODE_ID_")
    private NodeDef sourceNode;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TARGET_NODE_ID_")
    private NodeDef targetNode;

    @Column(name = "CONDITION_EXPRESSION_", length = 500)
    private String conditionExpression;

    public void take(){
        targetNode.enter();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeDef getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(NodeDef sourceNode) {
        this.sourceNode = sourceNode;
    }

    public NodeDef getTargetNode() {
        return targetNode;
    }

    public void setTargetNode(NodeDef targetNode) {
        this.targetNode = targetNode;
    }

    public String getConditionExpression() {
        return conditionExpression;
    }

    public void setConditionExpression(String conditionExpression) {
        this.conditionExpression = conditionExpression;
    }
}
