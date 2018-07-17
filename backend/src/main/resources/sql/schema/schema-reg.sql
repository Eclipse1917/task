create table if not exists reg
(
  vkey   varchar(2)  not null
    constraint table_name_pkey
    primary key,
  rgn    varchar(2)  not null,
  name   varchar(45) not null,
  center varchar(30),
  namet  varchar(45) not null
);

create unique index if not exists table_name_rgn_uindex
  on reg (rgn);

create unique index if not exists table_name_name_uindex
  on reg (name);

create unique index if not exists table_name_namet_uindex
  on reg (namet);


