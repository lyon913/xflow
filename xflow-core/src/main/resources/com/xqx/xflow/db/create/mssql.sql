
--流程定义表
CREATE TABLE XFL_ProcessDef(
  id VARCHAR (64) NOT  NULL ,
  name VARCHAR (255) NOT NULL ,
  description VARCHAR (4000),
  candidateGroup VARCHAR (255),
  processType VARCHAR (255),
  creator VARCHAR (255),
  createTime DATETIME ,
  PRIMARY KEY (id)
);