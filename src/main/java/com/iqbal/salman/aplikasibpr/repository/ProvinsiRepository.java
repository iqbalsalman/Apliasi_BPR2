/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iqbal.salman.aplikasibpr.repository;

import com.iqbal.salman.aplikasibpr.master.Provinsi;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author iqbal
 */
public interface ProvinsiRepository extends CrudRepository<Provinsi, String> {
    
      public Iterable<Provinsi> findAll();
    
}
