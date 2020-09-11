package com.example.okul.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sinif")
public class Sinif implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "sinif_adi")
    private String sinifAdi;

}
