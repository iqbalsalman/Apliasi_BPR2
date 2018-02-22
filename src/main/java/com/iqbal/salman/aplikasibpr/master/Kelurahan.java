package com.iqbal.salman.aplikasibpr.master;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "kelurahan_bandung")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kelurahan {

    @Id
    @GenericGenerator(name = "idkel", strategy = "uuid2")

    @GeneratedValue(generator = "idkel")
    @Column(name = "id_kelurahan")
    private String id;

    @Column(name = "nama_kelurahan", nullable = false, length = 50)
    private String nama_kel;

    @Column(name = "kode_pos_kel", nullable = false, length = 50)
    private String pos_kel;

    @ManyToOne
    @JoinColumn(name = "kecamatan_id ", nullable = false)
    private Kecamatan kecamatan;
}
