/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iqbal.salman.aplikasibpr.service;

import com.iqbal.salman.aplikasibpr.master.Kecamatan;
import com.iqbal.salman.aplikasibpr.master.Kelurahan;
import com.iqbal.salman.aplikasibpr.master.KotaKabupaten;
import com.iqbal.salman.aplikasibpr.master.Provinsi;
import com.iqbal.salman.aplikasibpr.repository.KecamatanRepository;
import com.iqbal.salman.aplikasibpr.repository.KelurahanRepository;
import com.iqbal.salman.aplikasibpr.repository.KotaKabupatenRepository;
import com.iqbal.salman.aplikasibpr.repository.ProvinsiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author iqbal
 */
@Service
@Transactional(readOnly = true)
public class WilayahService {

    @Autowired
    private KotaKabupatenRepository kotaRepository;
    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private KelurahanRepository kelurahanRepository;

    public List<Provinsi> findAllProvinsi() {
        return (List<Provinsi>) this.provinsiRepository.findAll();
    }
    @Transactional(readOnly = false)
    public List<KotaKabupaten> findAllKotaKabupaten() {
        return this.kotaRepository.findAll();
    }

    @Transactional(readOnly = false)
    public List<Kecamatan>findAllKecamatan(){
        return this.kecamatanRepository.findAll();
    }

    @Transactional(readOnly = false)
    public  List<Kelurahan>findAllKelurahan(){
        return  this.kelurahanRepository.findAll();
    }


    @Transactional(readOnly = false)
    public  Kecamatan simpan(Kecamatan x){
        return this.kecamatanRepository.save(x);
    }

    @Transactional(readOnly = false)
    public void hapus(String kodekec){
        this.kecamatanRepository.delete(kodekec);
    }

    @Transactional(readOnly = false)
    public Kelurahan saved(Kelurahan x){
        return this.kelurahanRepository.save(x);
    }

    @Transactional(readOnly = false)
    public KotaKabupaten save(KotaKabupaten x){
        return this.kotaRepository.save(x);
    }

    @Transactional(readOnly = false)
    public KotaKabupaten findById(String kode) {
        return kotaRepository.findOne(kode);
    }

    @Transactional(readOnly = false)
    public  Kelurahan findbyIdkel(String kodekel){
        return kelurahanRepository.findOne(kodekel);
    }

    @Transactional(readOnly = false)
    public Kecamatan finbyIdkec(String kodekec){
        return  kecamatanRepository.findOne(kodekec);
    }

    @Transactional(readOnly = false)
    public  Provinsi findbyid(String id){
        return  provinsiRepository.findOne(id);
    }

    @Transactional(readOnly = false)
    public Provinsi savep(Provinsi x){
        return this.provinsiRepository.save(x);
    }

    @Transactional(readOnly = false)
    public void delete(String del){
        this.kotaRepository.delete(del);
    }
    @Transactional(readOnly = false)
    public  void deletek(String idkel){
        this.kelurahanRepository.delete(idkel);
    }

    @Transactional(readOnly = false)
    public  void deletedata(String idu){
        this.provinsiRepository.delete(idu);
    }

}
