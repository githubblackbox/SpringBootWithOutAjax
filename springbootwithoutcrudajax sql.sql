create database withoutajax;
use withoutajax;
desc woajax;
select * from woajax;

create table woajax(id int primary key auto_increment,bname varchar(50),author varchar(50),price int);
insert into woajax(bname,author,price)value('sonnet 116','shakespeare',1500);
insert into woajax(bname,author,price)value('The Rape of Lucrece','shakespeare',1200);
insert into woajax(bname,author,price)value('A Lover Complaint','shakespeare',1300);





