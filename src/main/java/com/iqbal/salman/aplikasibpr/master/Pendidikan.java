/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iqbal.salman.aplikasibpr.master;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author iqbal
 *
 */
@Entity
@Table(name = "master_pendidikan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pendidikan {

    @Id
    @Column(name = "kode_pendidikan", nullable = false, unique = true, length = 5)
    private String id;

    @Column(name = "nama_pendidikan", nullable = false, length = 50)
    private String nama;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "is_active")
    private Boolean active;

}
