package com.example.okul.entity;

import com.example.okul.annotation.TcKimlik;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ogrenci")
public class Ogrenci implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "soyad")
    private String soyad;

    @Column(name = "tc_numara")
    @TcKimlik
    private String tcNumara;

    @ManyToOne
    @JoinColumn(name = "sinif_ref")
    private Sinif sinifRef;

    @ManyToOne
    @JoinColumn(name = "derslik_ref")
    private Derslik derslikRef;

    @ManyToOne
    @JoinColumn(name = "veli_ref_1")
    private Veli veliRef1;

    @ManyToOne
    @JoinColumn(name = "veli_ref_2")
    private Veli veliRef2;






}
