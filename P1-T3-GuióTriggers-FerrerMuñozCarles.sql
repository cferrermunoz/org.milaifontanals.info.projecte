drop index idx_ruta_titol;
drop index idx_ruta_usu;
drop index idx_comen_usu;
drop index idx_comen_ruta;
drop trigger trig_comentari_feta;
drop trigger trig_companys;
drop trigger trig_temps_comentari;
drop trigger trig_fetes_temps;
drop trigger trig_comen_prop;
drop trigger trig_companys_prop;
drop table PUNT;
drop table COMPANYS;
drop table FETES;
drop table COMENTARI;
drop table RUTA;
drop table USUARI;
drop table TIPUS;

create table TIPUS(
    id_tipus NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    nom_tipus VARCHAR2(30) unique constraint nn_nom_tipus not null,
    icona_tipus BLOB,
    constraint pk_tipus primary key (id_tipus)
);

create table USUARI(
    login_usuari varchar2(60) constraint usuari_pk primary key,
    email_usuari varchar2(60) constraint sk_usuari_email unique, 
    contrasenya_usuari varchar2(100) constraint nn_usu_contra not null,
    foto_usuari BLOB
);

create table RUTA(
    id_ruta NUMBER(3) GENERATED BY DEFAULT ON NULL AS IDENTITY,
    titol_ruta varchar2(60) constraint nn_titol_ruta not null,
    descrip_ruta varchar2(60) constraint nn_descrip_ruta not null,
    text_long_ruta CLOB constraint nn_text_long_desc not null,
    distancia_ruta DECIMAL constraint nn_dist_ruta not null,
    temps_ruta DECIMAL CONSTRAINT nn_temps_ruta not null,
    desn_pos_ruta decimal(7,3) CONSTRAINT nn_desn_pos_ruta not null,
    desn_neg_ruta decimal(7,3) CONSTRAINT nn_desn_neg_ruta not null,
    dificultat_ruta number constraint nn_dif_ruta not null,
    mom_temp_ruta timestamp default SYSTIMESTAMP,
    num_com_ruta number default 0,
    sum_val_ruta number default 0,
    fet_com_ruta number default 0,
    v_pais_ruta number default 0,
    v_seg_ruta number default 0,
    v_dif_ruta number default 0,
    id_usuari_ruta varchar2(60) constraint fk_usu_ruta REFERENCES USUARI,
    constraint pk_ruta primary key (id_ruta),
    CONSTRAINT ck_dist_ruta check (distancia_ruta > 0), 
    CONSTRAINT ck_temps_ruta check (temps_ruta > 0),
    CONSTRAINT ck_desn_neg_ruta check (desn_neg_ruta > 0),
    CONSTRAINT ck_desn_pos_ruta check (desn_pos_ruta > 0),
    constraint ck_dif_ruta check (dificultat_ruta in (1,2,3,4,5))
);

create table PUNT(
    id_punt NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    id_ruta_punt number(3) constraint fk_punt_ruta references RUTA on delete cascade,
    num_punt number(3) constraint nn_num_punt not null,
    nom_punt varchar2(60) constraint nn_nom_punt not null,
    desc_punt varchar2(60) constraint nn_desc_punt not null,
    foto_punt BLOB,
    lat_punt number(6,3) CONSTRAINT nn_lat_punt not null,
    lon_punt number(6,3) CONSTRAINT nn_lon_punt not null,
    alt_punt number(7,3),
    tipus_punt NUMBER constraint fk_tipus_punt references TIPUS,
    constraint check_lat_punt check (lat_punt between -90 and 90),
    constraint check_lon_punt check (lon_punt between -180 and 180),
    constraint pk_punt PRIMARY key (id_punt),
    constraint uk_punt UNIQUE (id_ruta_punt, num_punt)
);

create table COMENTARI(
    id_comen NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY,
    CONSTRAINT pk_comentari primary key (id_comen),
    text_comen CLOB,
    valor_info_comen number constraint nn_valor_info_comen not null,
    feta_comen number CONSTRAINT nn_feta_comen not null,
    dific_comen number check (dific_comen in (1,2,3,4,5,null)),
    constraint ck_valor_info_comen check (valor_info_comen in (1,2,3,4,5)),
    v_pais_comen number check (v_pais_comen in (1,2,3,4,5,null)),
    v_seg_comen number check (v_seg_comen in (1,2,3,4,5,null)),
    mom_temp_comen timestamp default SYSTIMESTAMP,
    id_usu_comen varchar2(60) constraint fk_usu_comen REFERENCES USUARI,
    id_ruta_comen number(3) constraint fk_ruta_comen REFERENCES RUTA
);

create table COMPANYS(
    id_usu_compis varchar2(60) constraint fk_usu_compis REFERENCES USUARI,
    id_comen_compis number constraint fk_comen_compis REFERENCES COMENTARI,
    CONSTRAINT pk_compis primary key (id_usu_compis,id_comen_compis)
);

create table FETES(
    id_usu_fetes varchar2(60) constraint fk_usu_fetes REFERENCES USUARI,
    mom_temp_fetes timestamp default SYSTIMESTAMP,
    id_ruta_fetes NUMBER constraint fk_ruta_fetes REFERENCES RUTA,
    constraint pk_fetes primary key (id_usu_fetes,mom_temp_fetes)
);

create index idx_ruta_titol on Ruta (titol_ruta);

create index idx_ruta_usu on RUTA (id_usuari_ruta);

create index idx_comen_usu on COMENTARI(id_usu_comen);

create index idx_comen_ruta on COMENTARI(id_ruta_comen);

commit;


--si canvia valor feta en comentari canviar valors de dific_comen, v_pais_comen, v_seg_comen

create or replace trigger trig_comentari_feta before update or insert on COMENTARI
for each row
begin
    if :new.feta_comen = 0  then
            :new.dific_comen := null;
            :new.v_pais_comen := null;
            :new.v_seg_comen := null;
            delete from companys where id_comen_compis = :new.id_comen;
    else 
        if
            :new.dific_comen is null or :new.v_pais_comen is null or :new.v_seg_comen is null then
                raise_application_error(-20000, 'No es pot fer un comentari de ruta sense valorar-la');
        end if;
    end if;
end;
/

create or replace trigger trig_companys before update or insert on COMPANYS
for each row
declare
    cursor c_comen is select * from comentari where id_comen = :new.id_comen_compis;
begin
    for r_comen in c_comen loop
        if r_comen.feta_comen = 0 then
            raise_application_error(-20000, 'No hi pot haver companys en una ruta no feta');
        end if;
    end loop;
end;
/

create or replace trigger trig_temps_comentari before update or insert on COMENTARI
for each row
begin
    if inserting then
        :new.mom_temp_comen := sysdate;
    end if;
    if updating then
        :new.mom_temp_comen := :old.mom_temp_comen;
    end if;
end;
/

create or replace trigger trig_fetes_temps before update or insert on FETES
for each row
begin
    if :new.mom_temp_fetes > sysdate then
        raise_application_error(-20000, 'No es pot fer una ruta en el futur');
    end if;
end;
/

create or replace trigger trig_comen_prop before update or insert on COMENTARI
for each row
declare
    cursor c_ruta is select * from ruta where id_ruta = :new.id_ruta_comen;
begin
    for r_ruta in c_ruta loop
        if :new.id_usu_comen = r_ruta.id_usuari_ruta then
            raise_application_error(-20000, 'No es pot comentar una ruta propia');
        end if;
    end loop;
end;
/

create or replace trigger trig_companys_prop before update or insert on COMPANYS
for each row
declare
    cursor c_comen is select * from comentari where id_comen = :new.id_comen_compis;
begin
    for r_comen in c_comen loop
        if :new.id_usu_compis = r_comen.id_usu_comen then
            raise_application_error(-20000, 'No es pot ser company d''un mateix');
        end if;
    end loop;
end;
/

create or replace trigger trig_calcular_columnes after insert on COMENTARI
for each row
begin
    if :new.feta_comen = 1 then
        update ruta set num_com_ruta = num_com_ruta + 1, sum_val_ruta = sum_val_ruta + :new.valor_info_comen, 
        fet_com_ruta = fet_com_ruta + 1, v_pais_ruta = v_pais_ruta + :new.v_pais_comen, v_seg_ruta = v_seg_ruta + :new.v_seg_comen,
        v_dif_ruta = v_dif_ruta + :new.dific_comen  where id_ruta = :new.id_ruta_comen;
    else
        update ruta set num_com_ruta = num_com_ruta + 1, sum_val_ruta = sum_val_ruta + :new.valor_info_comen where id_ruta = :new.id_ruta_comen;
    end if;
end;
/
commit;