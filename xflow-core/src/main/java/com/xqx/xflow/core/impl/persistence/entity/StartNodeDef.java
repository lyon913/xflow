package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.XflowException;
import com.xqx.xflow.core.impl.consts.NodeType;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(NodeType.START)
public class StartNodeDef extends NodeDef{

    @PersistenceContext
    @Transient
    private EntityManager em;

    @Override
    public void execute(Execution execution) {
        List<Transition> transitions = getTransitions();
        if(transitions.size() != 1){
            throw new XflowException("Start node must have only one transition.");
        }
        Transition transition = transitions.get(0);
        this.leave(execution,transition);
    }

    protected Activity createActivity(ProcessInst processInst){
        SystemActivity act = new SystemActivity();
        act.setActive(true);
        act.setProcessInst(processInst);
        act.setNodeDef(this);
        act.setNodeName(this.getName());
        act.setStartTime(new DateTime());
        em.persist(act);

        return act;
    }

}
