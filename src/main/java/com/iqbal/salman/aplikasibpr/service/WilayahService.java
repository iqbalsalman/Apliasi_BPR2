/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iqbal.salman.aplikasibpr.service;

import com.iqbal.salman.aplikasibpr.master.KotaKabupaten;
import com.iqbal.salman.aplikasibpr.master.Provinsi;
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

    public List<Provinsi> findAllProvinsi() {
        return this.provinsiRepository.findAll();
    }
    @Transactional(readOnly = false)
    public List<KotaKabupaten> findAllKotaKabupaten() {
        return this.kotaRepository.findAll();
    }

    @Transactional(readOnly = false)
    public KotaKabupaten save(KotaKabupaten x){
        return this.kotaRepository.save(x);
    }

    public KotaKabupaten findById(String kode) {
        return kotaRepository.findOne(kode);
    }

    @Transactional(readOnly = false)
    public void delete(String del){
        this.kotaRepository.delete(del);
    }

}
