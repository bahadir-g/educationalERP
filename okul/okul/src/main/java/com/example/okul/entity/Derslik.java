package com.example.okul.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "derslik")
public class Derslik implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "derslik_adi")
    private String derslikAdi;

}
