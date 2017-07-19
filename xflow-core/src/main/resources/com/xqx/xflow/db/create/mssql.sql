
-- 流程定义表
CREATE TABLE XFL_PROC_DEF(
  id VARCHAR (36) NOT  NULL ,
  name VARCHAR (255) NOT NULL ,
  proc_key VARCHAR(255) UNIQUE NOT NULL ,
  proc_desc VARCHAR (1000),
  candidate_group VARCHAR (255),
  category VARCHAR (255),
  is_deleted TINYINT NOT NULL DEFAULT FALSE ,
  PRIMARY KEY (id)
);

-- 节点定义
CREATE TABLE XFL_TASK_DEF(
  id VARCHAR(36) NOT NULL ,
  proc_inst_id VARCHAR(36) NOT NULL ,
  name VARCHAR(255) NOT NULL ,
  task_desc VARCHAR(1000),
  category VARCHAR(255),
  candidate_group VARCHAR(255),
  candidate_user VARCHAR(255),
  task_due_time VARCHAR(50),
  PRIMARY KEY (id)
);

-- 流向定义
CREATE TABLE XFL_FLOW_DEF(
  id VARCHAR(36) NOT NULL ,
  name VARCHAR(100) NOT NULL ,
  flow_desc VARCHAR(500),
  source_id VARCHAR(36) NOT NULL ,
  target_id VARCHAR(36) NOT NULL ,
  condition_exp VARCHAR(4000),
  PRIMARY KEY (id)
);

--
CREATE TABLE XFL_PROC_INST(
  id VARCHAR(36) NOT NULL ,
  proc_def_id VARCHAR(36) NOT NULL ,
  business_key VARCHAR(100) NOT NULL ,
  start_time DATETIME NOT NULL ,
  start_user_id VARCHAR(50) NOT NULL ,
  start_user_name VARCHAR(50) NOT NULL ,
  end_time DATETIME ,
  duration BIGINT,
  is_active TINYINT,
  is_deleted TINYINT,
  PRIMARY KEY (id)
);

CREATE TABLE XFL_TASK_INST(
  id VARCHAR(36) NOT NULL ,
  proc_inst_id VARCHAR(36) NOT NULL ,
  task_def_id VARCHAR(36) NOT NULL ,
  task_owner VARCHAR(50),
  task_owner_name VARCHAR(50),
  task_assignee VARCHAR(50),
  task_assignee_name VARCHAR(50),
  start_time DATETIME NOT NULL ,
  claim_time DATETIME ,
  end_time DATETIME,
  due_time DATETIME,
  duration BIGINT,
  is_active TINYINT,
  is_deleted TINYINT,
  PRIMARY KEY (id)
);

CREATE TABLE XFL_FLOW_INST(
  id VARCHAR(36) NOT NULL ,
  proc_inst_id VARCHAR(36) NOT NULL ,
  flow_def_id VARCHAR(36) NOT NULL ,
  source_id VARCHAR(36) NOT NULL ,
  target_id VARCHAR(36) NOT NULL ,
  PRIMARY KEY (id)
);

CREATE TABLE XFL_VARIABLE(
  id VARCHAR(36) NOT NULL ,
  proc_inst_id VARCHAR(36),
  task_inst_id VARCHAR(36),
  name VARCHAR(100) NOT NULL ,
  category VARCHAR(50) NOT NULL ,
  int_value INT,
  double_value DOUBLE,
  text_value VARCHAR(4000),
  PRIMARY KEY (id)
);

CREATE TABLE XFL_COMMENT(
  id VARCHAR(36) NOT NULL ,
  proc_inst_id VARCHAR(36),
  task_inst_id VARCHAR(36),
  category VARCHAR(50),
  msg VARCHAR(4000),
  user_id VARCHAR(36),
  user_name VARCHAR(50),
  create_time DATETIME,
  PRIMARY KEY (id)
);
