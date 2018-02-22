package com.iqbal.salman.aplikasibpr.master;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kecamatan_bandung")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "kecamatan")
public class Kecamatan {
    @Id
    @GenericGenerator(name = "idkec", strategy = "uuid2")

    @GeneratedValue(generator = "idkec")
    @Column(name = "id_kecamatan")
    private String id;

    @Column(name = "nama_kecamatan", nullable = false, length = 50)
    private String nama;

    @Column(name = "kode_pos", nullable = false, length = 50)
    private String pos;

    @Column(name = "created_by", length = 50)
    private String createdBy;

    @NotNull(message = "belum dipilih!")
    @ManyToOne
    @JoinColumn(name = "kabupaten_id", nullable = false)
    private KotaKabupaten kec;

    @OneToMany(mappedBy = "kecamatan")
    private List<Kelurahan> kecamatan = new ArrayList<>();
}
