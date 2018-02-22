/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iqbal.salman.aplikasibpr.master;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author iqbal
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "master_kota_kabupaten")
@ToString(exclude = "kec")
public class KotaKabupaten {

    @Id
    @GenericGenerator(name = "uuid_kotakab", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_kotakab")
    @Column(name = "kode_kota", nullable = false, unique = true)
    private String id;

    @NotEmpty(message = "Tidak boleh kosong")
    @Column(name = "nama_kota", nullable = false, length = 50)
    private String nama;
    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;
    @Column(name = "created_by", length = 20)
    private String createBy;

    @NotNull(message = "belum dipilih!")
    @ManyToOne
    @JoinColumn(name = "provinsi_id", nullable = false)
    private Provinsi kota;

    @OneToMany(mappedBy = "kec")
    private List<Kecamatan> kec = new ArrayList<>();
}
