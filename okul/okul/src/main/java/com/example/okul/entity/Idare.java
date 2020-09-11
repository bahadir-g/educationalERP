package com.example.okul.entity;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "idare")
public class Idare implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ogretmen_ref")
    private Ogretmen ogretmenRef;

    @Column(name = "unvan")
    private String unvan;
}
