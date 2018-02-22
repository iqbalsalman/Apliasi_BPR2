/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iqbal.salman.aplikasibpr.repository;

import com.iqbal.salman.aplikasibpr.master.NasabahPerorangan;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author iqbal
 */
public interface NasabahPeroranganRepository extends CrudRepository<NasabahPerorangan, String> {

    public List<NasabahPerorangan> findAll();
}
