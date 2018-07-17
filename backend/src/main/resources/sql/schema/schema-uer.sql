create table if not exists uer
(
  vkey    varchar(2) not null
    constraint uer_pkey
    primary key,
  uer     varchar(1) not null,
  uername varchar(70)
);

create unique index if not exists uer_uer_uindex
  on uer (uer);


