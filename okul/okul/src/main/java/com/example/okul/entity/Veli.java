package com.example.okul.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "veli")
public class Veli implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "soyad")
    private String soyad;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "email")
    private String email;
}
