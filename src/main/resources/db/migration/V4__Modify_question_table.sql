alter table QUESTION alter column ID BIGINT auto_increment;

alter table QUESTION
	add constraint QUESTION_pk
		primary key (ID);