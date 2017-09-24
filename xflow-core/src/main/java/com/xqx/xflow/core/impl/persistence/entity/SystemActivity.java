package com.xqx.xflow.core.impl.persistence.entity;

import com.xqx.xflow.core.impl.consts.ActivityType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(ActivityType.SYSTEM_ACTIVITY)
public class SystemActivity extends Activity{
}
