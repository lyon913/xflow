package com.xqx.xflow.core;

import com.xqx.xflow.core.impl.persistence.entity.XflTaskInst;

/**
 * Created by Lyon on 2017/1/22.
 */
public interface TaskService {

    /**
     * 通过taskid查找task
     * @param taskId
     * @return
     */
    XflTaskInst findById(String taskId);


    /**
     * 提交
     * @param taskId
     */
    void complete(String taskId);

    /**
     * 提交至指定节点
     * @param taskId
     * @param targetNodeDefId
     */
    void complete(String taskId, String targetNodeDefId);


    /**
     * 提交到指定节点，并指定办理者
     * @param taskId
     * @param assignee
     * @param assigneeName
     * @param targetNodeDefId
     */
    void complete(String taskId, String assignee, String assigneeName, String targetNodeDefId);

    /**
     * 委托
     * @param taskId
     * @param assignee
     * @param assigneeName
     */
    void delegate(String taskId, String assignee, String assigneeName);

    /**
     * 完成委托，并归还任务给所有者
     * @param taskId
     */
    void resolve(String taskId);

    /**
     * 申领任务
     * @param taskId
     */
    void claim(String taskId);

    /**
     * 取消申领的任务
     * @param taskId
     */
    void unclaim(String taskId);

}
