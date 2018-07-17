create table if not exists tnp
(
  vkey      varchar(2) not null
    constraint tnp_pkey
    primary key,
  tnp       varchar(1) not null,
  fullname  varchar(45),
  shortname varchar(5)
);

create unique index if not exists tnp_tnp_uindex
  on tnp (tnp);


