/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  iqbal
 * Created: Feb 6, 2018
 */

INSERT INTO master_provinsi
(kode_provinsi, nama_provinsi, created_date, created_by)
VALUES
  ('001', 'Jawa Barat', now(), 'migration'),
  ('002', 'Jawa Timur', now(), 'migration');

INSERT INTO master_kota_kabupaten (kode_kota, nama_kota, created_date, created_by, provinsi_id)
VALUES
  ('001', 'Bandung', now(), 'migration', '001'),
  ('002', 'Jakarta', now(), 'migration', '002'),
  ('003', 'Banten', now(), 'migration', '001');


INSERT INTO kecamatan_bandung (id_kecamatan , nama_kecamatan,
kode_pos, created_by, kabupaten_id)
VALUES
  ('001', 'Buah Batu', '4056', 'migration', '001');





