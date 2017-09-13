package com.xqx.xflow.core.impl.db;

import com.querydsl.sql.SQLQueryFactory;
import com.xqx.xflow.core.impl.cfg.IdGenerator;
import com.xqx.xflow.core.impl.persistence.repository.*;

public class DbContext {
    private IdGenerator idGenerator;
    private SQLQueryFactory queryFactory;

    private ProcDefRepository procDefRepository;
    private TaskDefRepository taskDefRepository;
    private FlowDefRepository flowDefRepository;
    private ProcInstRepository procInstRepository;
    private TaskInstRepository taskInstRepository;
    private VariableRepository variableRepository;
    private CommentRepository commentRepository;

    public DbContext(IdGenerator idGenerator, SQLQueryFactory queryFactory) {
        this.idGenerator = idGenerator;
        this.queryFactory = queryFactory;
        initManagers();
    }

    private void initManagers(){
        procDefRepository = getRepo(ProcDefRepository.class);
        taskDefRepository = getRepo(TaskDefRepository.class);
        flowDefRepository = getRepo(FlowDefRepository.class);
        procInstRepository = getRepo(ProcInstRepository.class);
        taskInstRepository = getRepo(TaskInstRepository.class);
        variableRepository = getRepo(VariableRepository.class);
        commentRepository = getRepo(CommentRepository.class);
    }

    private <T extends AbstractRepository> T getRepo(Class<T> cls){
        try {
            T repo = cls.newInstance();
            initRepo(repo);
            return repo;
        } catch (Exception e) {
            throw new RuntimeException("无法实例化对象", e);
        }

    }

    private <T extends AbstractRepository> void initRepo(T repo){
        repo.setIdGenerator(idGenerator);
        repo.setQueryFactory(queryFactory);
    }

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public SQLQueryFactory getQueryFactory() {
        return queryFactory;
    }

    public void setQueryFactory(SQLQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public ProcDefRepository getProcDefRepository() {
        return procDefRepository;
    }

    public void setProcDefRepository(ProcDefRepository procDefRepository) {
        this.procDefRepository = procDefRepository;
    }

    public TaskDefRepository getTaskDefRepository() {
        return taskDefRepository;
    }

    public void setTaskDefRepository(TaskDefRepository taskDefRepository) {
        this.taskDefRepository = taskDefRepository;
    }

    public FlowDefRepository getFlowDefRepository() {
        return flowDefRepository;
    }

    public void setFlowDefRepository(FlowDefRepository flowDefRepository) {
        this.flowDefRepository = flowDefRepository;
    }

    public ProcInstRepository getProcInstRepository() {
        return procInstRepository;
    }

    public void setProcInstRepository(ProcInstRepository procInstRepository) {
        this.procInstRepository = procInstRepository;
    }

    public TaskInstRepository getTaskInstRepository() {
        return taskInstRepository;
    }

    public void setTaskInstRepository(TaskInstRepository taskInstRepository) {
        this.taskInstRepository = taskInstRepository;
    }

    public VariableRepository getVariableRepository() {
        return variableRepository;
    }

    public void setVariableRepository(VariableRepository variableRepository) {
        this.variableRepository = variableRepository;
    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }

    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
