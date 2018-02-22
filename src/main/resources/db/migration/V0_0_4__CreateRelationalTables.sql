/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  iqbal
 * Created: Feb 6, 2018
 */

create table master_provinsi(
  kode_provinsi CHARACTER VARYING(255) not null unique primary key,
  nama_provinsi CHARACTER VARYING(50) not null,
  created_date TIMESTAMP not null,
  created_by CHARACTER VARYING(20)
);

create table master_kota_kabupaten(
  kode_kota CHARACTER VARYING(255) not null UNIQUE  primary key,
  nama_kota CHARACTER VARYING(50) not null,
  created_date TIMESTAMP not null,
  created_by CHARACTER VARYING(20),
  provinsi_id CHARACTER VARYING(255) not null REFERENCES master_provinsi(kode_provinsi)
);

CREATE TABLE kecamatan_bandung (
id_kecamatan  CHARACTER VARYING(50) primary key not null,
nama_kecamatan  CHARACTER VARYING(50)  NOT NULL UNIQUE,
kode_pos CHARACTER VARYING(10),
created_by CHARACTER VARYING(20),
kabupaten_id CHARACTER VARYING(225) NOT NULL  REFERENCES master_kota_kabupaten(kode_kota)
);

CREATE TABLE kelurahan_bandung (
id_kelurahan  CHARACTER VARYING(50) primary key not null,
nama_kelurahan  CHARACTER VARYING(50)  NOT NULL UNIQUE,
kode_pos_kel CHARACTER VARYING(10),
kecamatan_id CHARACTER VARYING(255) not null REFERENCES kecamatan_bandung(id_kecamatan)
);

