package com.iqbal.salman.aplikasibpr.repository;

import com.iqbal.salman.aplikasibpr.master.Kecamatan;
import com.iqbal.salman.aplikasibpr.master.Kelurahan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KelurahanRepository extends CrudRepository<Kelurahan, String> {
    List<Kelurahan> findAll();
}
