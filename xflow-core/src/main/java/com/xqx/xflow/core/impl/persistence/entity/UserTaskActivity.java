package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.consts.ActivityType;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(ActivityType.USER_TASK_ACTIVITY)
public class UserTaskActivity extends Activity {
    @Column(name = "ASSIGNEE_ID_", length = 64)
    private String assigneeId;

    @Column(name = "ASSIGNEE_NAME_",length = 255)
    private String assigneeName;

    @Column(name = "OWNER_ID_", length = 64)
    private String ownerId;

    @Column(name = "OWNER_NAME_",length = 255)
    private String ownerName;

    @Column(name = "CLAIM_TIME_")
    private DateTime claimTime;

    @Column(name = "DUE_DATE_")
    private DateTime dueDate;

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public DateTime getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(DateTime claimTime) {
        this.claimTime = claimTime;
    }

    public DateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(DateTime dueDate) {
        this.dueDate = dueDate;
    }
}
