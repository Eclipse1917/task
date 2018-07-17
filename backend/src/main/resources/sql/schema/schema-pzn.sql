create table if not exists pzn
(
  vkey    varchar(2)  not null
    constraint pzn_pkey
    primary key,
  pzn     varchar(2),
  imy     varchar(4),
  name    varchar(45) not null,
  cb_date date,
  ce_date date
);

create unique index if not exists pzn_pzn_uindex
  on pzn (pzn);


