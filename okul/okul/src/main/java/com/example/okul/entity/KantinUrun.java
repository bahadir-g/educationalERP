package com.example.okul.entity;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "kantin_urun")
public class KantinUrun implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "urun_adi")
    private String urunAdi;

    @Column(name = "fiyat")
    private Long fiyat;
}
