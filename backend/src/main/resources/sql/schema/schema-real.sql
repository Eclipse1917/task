create table if not exists real
(
  vkey     varchar(4)  not null
    constraint real_pkey
    primary key,
  real     varchar(4),
  name_ogr varchar(60) not null
);


