DROP TABLE IF EXISTS `amendworkorderstatedecider`;
DROP TABLE IF EXISTS `updateworkorderstatedecider`;

CREATE TABLE `updateworkorderstatedecider` (
 `dbid` bigint NOT NULL AUTO_INCREMENT,
 `accepted` varchar(3) NOT NULL,
 `active` varchar(3) NOT NULL,
 `amend_by_o` varchar(3) NOT NULL,
 `amend_by_r` varchar(3) NOT NULL,
 `assigned` varchar(3) NOT NULL,
 `cancelled` varchar(3) NOT NULL,
 `completed` varchar(3) NOT NULL,
 `createdby` varchar(255) DEFAULT NULL,
 `creationtime` datetime(6) DEFAULT NULL,
 `element_name` varchar(255) NOT NULL,
 `orgcode` varchar(255) DEFAULT NULL,
 `rejected` varchar(3) NOT NULL,
 `source_type` varchar(255) DEFAULT NULL,
 `unassigned` varchar(3) NOT NULL,
 `lastmodifiedby` varchar(255) DEFAULT NULL,
 `lastmodified` datetime(6) DEFAULT NULL,
 PRIMARY KEY (`dbid`)
);

CREATE TABLE `amendworkorderstatedecider` (
  `dbid` bigint NOT NULL AUTO_INCREMENT,
  `accepted` varchar(3) NOT NULL,
  `active` varchar(3) NOT NULL,
  `amend_by_o` varchar(3) NOT NULL,
  `amend_by_r` varchar(3) NOT NULL,
  `assigned` varchar(3) NOT NULL,
  `cancelled` varchar(3) NOT NULL,
  `completed` varchar(3) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `creationtime` datetime(6) DEFAULT NULL,
  `element_name` varchar(255) NOT NULL,
  `orgcode` varchar(255) DEFAULT NULL,
  `rejected` varchar(3) NOT NULL,
  `source_type` varchar(255) DEFAULT NULL,
  `unassigned` varchar(3) NOT NULL,
  `lastmodifiedby` varchar(255) DEFAULT NULL,
  `lastmodified` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`dbid`)
);



