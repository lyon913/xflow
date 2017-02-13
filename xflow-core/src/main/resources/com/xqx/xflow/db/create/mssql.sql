CREATE TABLE XFL_ProcessDef(
  id VARCHAR (10) NOT  NULL ,
  name VARCHAR (100) NOT NULL ,
  description VARCHAR (500),
  candidateGroup VARCHAR (50),
  processType VARCHAR (50),
  creator VARCHAR (50),
  createTime DATETIME ,
  PRIMARY KEY (id)
);