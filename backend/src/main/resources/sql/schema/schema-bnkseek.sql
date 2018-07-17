create table if not exists bnkseek
(
  vkey    serial      not null
    constraint bnkseek_pkey
    primary key,
  real    varchar(4),
  pzn     varchar(2)
    constraint bnkseek_pzn_pzn_fk
    references pzn (pzn)
      on update cascade,
  uer     varchar(1)  not null
    constraint bnkseek_uer_uer_fk
    references uer (uer)
      on update cascade,
  rgn     varchar(2)  not null
    constraint bnkseek_reg_rgn_fk
    references reg (rgn)
      on update cascade,
  ind     varchar(6),
  tnp     varchar(1)
    constraint bnkseek_tnp_tnp_fk
    references tnp (tnp)
      on update cascade,
  nnp     varchar(25),
  adr     varchar(30),
  rkc     varchar(9),
  namep   varchar(45) not null,
  namen   varchar(30) not null,
  newks   varchar(9),
  permfo  varchar(6),
  srok    varchar(2)  not null,
  at1     varchar(7),
  at2     varchar(7),
  telef   varchar(25),
  regn    varchar(9),
  okpo    varchar(8),
  dt_izm  date        not null,
  cks     varchar(6),
  ksnp    varchar(20),
  date_in date        not null,
  date_ch date,
  vkeydel varchar(8)
    constraint bnkseek_bnkseek_vkey_fk
    references bnkseek
      on update cascade
      on delete set null
      deferrable initially deferred,
  dt_izmr date,
  newnum  varchar(9)  not null
);

create unique index if not exists bnkseek_newnum_uindex
  on bnkseek (newnum);


