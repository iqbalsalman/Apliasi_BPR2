/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iqbal.salman.aplikasibpr.repository;

import com.iqbal.salman.aplikasibpr.master.Nasabah;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author iqbal
 */
public interface NasabahRepository extends CrudRepository<Nasabah, String> {
    public List<Nasabah> findAll();
}
