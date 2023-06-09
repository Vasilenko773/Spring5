--liquibase formatted sql

--changeset vasilenko:1
create table if not exists company
(
    id   serial primary key,
    name varchar(64) not null unique
    );
--rollback DROP TABLE company

--changeset vasilenko:2
create table if not exists company_locales
(
    company_id  int references company (id),
    lang        varchar(25),
    desctiption varchar(255) not null,
    primary key (company_id, lang)
    );
--rollback DROP TABLE company_locales

--changeset vasilenko:3
create table if not exists users
(
    id         serial primary key,
    username   varchar(64) not null unique,
    birth_date date,
    firstname  varchar(64),
    lastname   varchar(64),
    role       varchar(32),
    company_id int references company (id)
    )
--rollback DROP TABLE users