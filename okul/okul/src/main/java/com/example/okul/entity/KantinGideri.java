package com.example.okul.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;

import java.sql.Date;



@Data
@Entity
@Table(name = "kantin_gideri")
public class KantinGideri implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ogrenci_ref")
    private Ogrenci ogrenciRef;

    @ManyToOne
    @JoinColumn(name = "kantin_urun_ref")
    private KantinUrun kantinUrunRef;

    @Column(name = "tarih")
    private Date tarih;
}
