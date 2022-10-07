
create table PERSON
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birthdate timestamp,
	primary key(id)
);



insert into PERSON(id,name,location,birthdate) values(101,'Md Asif','Pune',sysdate());
insert into PERSON(id,name,location,birthdate) values(102,'Md Raju','Bihar',sysdate());
insert into PERSON(id,name,location,birthdate) values(103,'Javed Alam','Goa',sysdate());

