package com.iqbal.salman.aplikasibpr.repository;

import com.iqbal.salman.aplikasibpr.master.Kecamatan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KecamatanRepository extends CrudRepository<Kecamatan, String> {
    List<Kecamatan> findAll();
}
