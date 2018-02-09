/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iqbal.salman.aplikasibpr.service;

import com.iqbal.salman.aplikasibpr.master.Agama;
import com.iqbal.salman.aplikasibpr.repository.AgamaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author iqbal
 */
@Repository
@Transactional(readOnly = true)
public class AgamaService {

    @Autowired
    private AgamaRepository repo;

    @Transactional(readOnly = false)
    public Agama save(Agama x) {
        return repo.save(x);
    }

    public Agama findById(String kode) {
        return repo.findOne(kode);
    }

    public List<Agama> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = false)
    public void delete(Agama x) {
        this.repo.delete(x);
    }

    @Transactional(readOnly = false)
    public void delete(String x) {
        this.repo.delete(x);
    }

    @Transactional(readOnly = false)
    public void delete(List<Agama> list) {
        this.repo.delete(list);
    }

    public Agama findByNama(String nama) {
        return this.repo.findByNama(nama);
    }

    public List<Agama> mencariBerdasarkanNamaAtauDeskripsi(String input) {
        return this.repo.findByNamaOrDeskripsi(input, input);
    }

    @Transactional(readOnly = false)
    public void updateById(String id, String nama, String description) {
        this.repo.updateNamaAndDescription(id,nama, description);
    }

}
