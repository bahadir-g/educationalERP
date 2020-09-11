package com.example.okul.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ogretmen")
public class Ogretmen implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "soyad")
    private String soyad;

    @ManyToOne
    @JoinColumn(name = "brans_ref")
    private Brans bransRef;

}
