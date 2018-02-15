/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iqbal.salman.aplikasibpr.master;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author iqbal
 */
@Data
@Entity
@Table(name = "data_nasabah", schema = "nasabah")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipe_nasabah", discriminatorType = DiscriminatorType.STRING, length = 50)
public class Nasabah {

    @Id
    @GenericGenerator(name = "nasabah_uuid", strategy = "uuid2")
    @Column(name = "nasabah_id", nullable = false, unique = true, length = 64)
    @GeneratedValue(generator = "nasabah_uuid")
    private String id;

    @Column(name = "nama_lengkap", nullable = false, length = 50)
    private String namaLengkap;

    @Column(name = "alamat_rumah")
    private String alamat;

}
