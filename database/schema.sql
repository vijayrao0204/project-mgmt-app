create table PROJECT (
	ID bigint NOT NULL AUTO_INCREMENT, 
	CREATED_AT datetime(6), 
	DESCRIPTION varchar(255), 
	END_DATE datetime(6), 
	PROJECT_NAME varchar(255) NOT NULL, 
	PROJECT_SHORT_NAME varchar(255), 
	START_DATE datetime(6), 
	UPDATED_AT datetime(6), 
	primary key (ID)
) engine=InnoDB
