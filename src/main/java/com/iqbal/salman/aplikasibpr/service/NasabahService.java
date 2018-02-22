/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iqbal.salman.aplikasibpr.service;

import com.iqbal.salman.aplikasibpr.master.Nasabah;
import com.iqbal.salman.aplikasibpr.master.NasabahBadanUsaha;
import com.iqbal.salman.aplikasibpr.master.NasabahPerorangan;
import com.iqbal.salman.aplikasibpr.repository.NasabahBadanUsahaRepository;
import com.iqbal.salman.aplikasibpr.repository.NasabahPeroranganRepository;
import com.iqbal.salman.aplikasibpr.repository.NasabahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author iqbal
 */
@Service
@Transactional(readOnly = false)
public class NasabahService {

    @Autowired
    private NasabahRepository nasabahRepository;

    @Autowired
    private NasabahPeroranganRepository peroranganRepository;

    @Autowired
    private NasabahBadanUsahaRepository badanUsahaRepository;

    @Transactional
    public NasabahPerorangan save(NasabahPerorangan nasabah) {
        return this.nasabahRepository.save(nasabah);
    }

    @Transactional
    public NasabahBadanUsaha save(NasabahBadanUsaha nasabah) {
        return this.nasabahRepository.save(nasabah);
    }

    @Transactional
    public void delete(Nasabah nasabah) {
        this.nasabahRepository.delete(nasabah);
    }
    @Transactional
    public void delete(String idup) {
        this.nasabahRepository.delete(idup);
    }
    @Transactional
    public void delete(NasabahBadanUsaha nasabah) {
        this.nasabahRepository.delete(nasabah);
    }

    @Transactional(readOnly = false)
    public NasabahPerorangan findById(String kode) {
        return this.peroranganRepository.findOne(kode);
    }

    public NasabahBadanUsaha findBadanUsahaById(String id) {
        return this.badanUsahaRepository.findOne(id);
    }
    @Transactional
    public Nasabah save(Nasabah nasabah) {
        return this.nasabahRepository.save(nasabah);
    }
    @Transactional(readOnly = false)
    public List<Nasabah> findAll(Nasabah nasabah) {
        return this.nasabahRepository.findAll();
    }

    @Transactional(readOnly = false)
    public List<NasabahPerorangan> findAllNasabahPerorangan() {
        return this.peroranganRepository.findAll();
    }

    @Transactional(readOnly = false)
    public List<NasabahBadanUsaha> findAllNasabahBadan() {
        return this.badanUsahaRepository.findAll();

    }

}
