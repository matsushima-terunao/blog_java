--2013/11/01
drop table user_mst if exists;
create text table user_mst (
id integer generated by default as identity (start with 1),
loginid varchar(255),
password varchar(255),
name varchar(255),
primary key (id));
set table user_mst source 'user_mst.csv;encoding=UTF-8';
