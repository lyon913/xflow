
--流程定义表
CREATE TABLE XFL_PROCESS_DEF(
  id VARCHAR (64) NOT  NULL ,
  name VARCHAR (255) NOT NULL ,
  process_desc VARCHAR (4000),
  candidate_group VARCHAR (255),
  process_type VARCHAR (255),
  creator VARCHAR (255),
  gtm_create DATETIME ,
  gtm_modify DATETIME ,
  PRIMARY KEY (id)
);