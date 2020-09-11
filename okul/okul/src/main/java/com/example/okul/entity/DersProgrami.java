package com.example.okul.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ders_programi")
public class DersProgrami implements Serializable {

    @Id

    @GeneratedValue
    private Long id;

    @Column(name = "gun")
    private String gun;

    @ManyToOne
    @JoinColumn(name = "sinif_ref")
    private Sinif sinifRef;

    @ManyToOne
    @JoinColumn(name = "derslik_ref")
    private Derslik derslikRef;

    @ManyToOne
    @JoinColumn(name = "ders_1_ogretmen")
    private Ogretmen ogretmenRef1;

    @ManyToOne
    @JoinColumn(name = "ders_2_ogretmen")
    private Ogretmen ogretmenRef2;

    @ManyToOne
    @JoinColumn(name = "ders_3_ogretmen")
    private Ogretmen ogretmenRef3;

    @ManyToOne
    @JoinColumn(name = "ders_4_ogretmen")
    private Ogretmen ogretmenRef4;

    @ManyToOne
    @JoinColumn(name = "ders_5_ogretmen")
    private Ogretmen ogretmenRef5;

    @ManyToOne
    @JoinColumn(name = "ders_6_ogretmen")
    private Ogretmen ogretmenRef6;



}
