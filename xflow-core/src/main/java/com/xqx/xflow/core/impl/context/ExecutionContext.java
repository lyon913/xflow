package com.xqx.xflow.core.impl.context;

import com.xqx.xflow.core.impl.persistence.entity.NodeDef;
import com.xqx.xflow.core.impl.persistence.entity.Token;
import com.xqx.xflow.core.impl.persistence.entity.Transition;

public class ExecutionContext {
    private Token token;
    private Transition transition;
    private NodeDef sourceNode;

    public ExecutionContext(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Transition getTransition() {
        return transition;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    public NodeDef getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(NodeDef sourceNode) {
        this.sourceNode = sourceNode;
    }
}
