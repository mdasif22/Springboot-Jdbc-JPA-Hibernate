/*
create table Course
(
	id integer not null,
	name varchar(255) not null,
	primary key(id)
);
*/

insert into Course(id,name) values (101,'Java');
insert into Course(id,name) values (102,'Python');
insert into Course(id,name) values (103,'SpringBoot');

insert into Passport(id,number) values (4001,'A456');
insert into Passport(id,number) values (4002,'123A');
insert into Passport(id,number) values (4003,'7003');

insert into Student(id,name,passport_id) values (2001,'Chanda',4001);
insert into Student(id,name,passport_id) values (2002,'Afjal',4002);
insert into Student(id,name,passport_id) values (2003,'Aftab',4003);



insert into review(id,rating,description,course_id) values (5001,'3','Gud',101);
insert into review(id,rating,description,course_id) values (5002,'5','Nice',101);
insert into review(id,rating,description,course_id) values (5003,'1','Bad',103);















