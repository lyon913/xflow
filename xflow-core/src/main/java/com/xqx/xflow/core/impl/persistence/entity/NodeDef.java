package com.xqx.xflow.core.impl.persistence.entity;


import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "XFL_NODE_DEF",
        indexes = {
                @Index(name = "IDX_ND_PROC_ID",columnList = "PROCESS_DEF_ID_")
        })
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "NODE_TYPE_",length = 64,discriminatorType = DiscriminatorType.STRING)
public abstract class NodeDef extends BaseIdEntity{

    @PersistenceContext
    @Transient
    protected EntityManager em;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PROCESS_DEF_ID_")
    private ProcessDef processDef;

    @Column(name = "NAME_" , length = 255, nullable = false)
    private String name;

    @OneToMany(mappedBy="sourceNode")
    private List<Transition> transitions;

    public ProcessDef getProcessDef() {
        return processDef;
    }

    public void setProcessDef(ProcessDef processDef) {
        this.processDef = processDef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

    public void enter(Execution execution){
        Activity act = createActivity(execution.getProcessInst());
        execution.setActivity(act);
        em.merge(execution);

        execute(execution);
    }
    public void leave(Execution execution, Transition transition){
        execution.getActivity().end();
        transition.take(execution);
    }

    public List<Transition> getAvailableTransitions(){
        List<Transition> all = getTransitions();

        List<Transition> results = new ArrayList<>();
        for(Transition t : all){
            String expStr = t.getConditionExpression();
            ExpressionParser parser = new SpelExpressionParser();
            Expression exp = parser.parseExpression(expStr);
            EvaluationContext ctx = new StandardEvaluationContext();
            //exp.getValue()
        }

        return results;

    }

    protected abstract void execute(Execution execution);

    protected abstract Activity createActivity(ProcessInst processInst);

}
