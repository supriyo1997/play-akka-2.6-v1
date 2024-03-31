# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table employee (
  id                            integer auto_increment not null,
  name                          varchar(255),
  dept                          varchar(255),
  salary                        integer,
  constraint pk_employee primary key (id)
);


# --- !Downs

drop table if exists employee;

