INSERT INTO `tests`.`amendworkorderstatedecider` (`dbid`,`accepted`,`active`,`amend_by_o`,`amend_by_r`,`assigned`,`cancelled`,`completed`,`created_by`,`created_date_time`,`element_name`,`orgcode`,`rejected`,`source_type`,`unassigned`,`updated_by`,`updated_date_time`)
VALUES (1,'O','O','R','R','O/R','O/R','NA','test_user_1','2023-06-30 09:00:00.000000','TEST_1','ZZZZ','NA','O','R',NULL,NULL);

INSERT INTO `tests`.`amendworkorderstatedecider` (`dbid`,`accepted`,`active`,`amend_by_o`,`amend_by_r`,`assigned`,`cancelled`,`completed`,`created_by`,`created_date_time`,`element_name`,`orgcode`,`rejected`,`source_type`,`unassigned`,`updated_by`,`updated_date_time`)
VALUES (2,'O','O','R','R','O/R','O/R','NA','test_user_1','2023-06-30 09:00:00.000000','TEST_2','ZZZZ','NA','O','R',NULL,NULL);

INSERT INTO `tests`.`updateworkorderstatedecider`(`dbid`,`accepted`,`active`,`amend_by_o`,`amend_by_r`,`assigned`,`cancelled`,`completed`,`created_by`,`created_date_time`,`element_name`,`orgcode`,`rejected`,`source_type`,`unassigned`,`updated_by`,`updated_date_time`)
VALUES (1,'R','R','O','O','NU','NU','O/R','test_user_1','2023-06-30 09:00:00.000000','TEST_1','ZZZZ','O/R','R','O',NULL,NULL);

INSERT INTO `tests`.`updateworkorderstatedecider`(`dbid`,`accepted`,`active`,`amend_by_o`,`amend_by_r`,`assigned`,`cancelled`,`completed`,`created_by`,`created_date_time`,`element_name`,`orgcode`,`rejected`,`source_type`,`unassigned`,`updated_by`,`updated_date_time`)
VALUES (2,'R','R','O','O','NU','NU','O/R','test_user_1','2023-06-30 09:00:00.000000','TEST_2','ZZZZ','O/R','R','O',NULL,NULL);
