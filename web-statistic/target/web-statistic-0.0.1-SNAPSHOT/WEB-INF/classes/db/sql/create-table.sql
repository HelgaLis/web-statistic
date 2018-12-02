drop table statistic if exists;
create table static(
id bigint identity primary key,
user_id varchar(50),
page_id varchar(50),
visit_date date
);