package com.example.okul.entity;

import lombok.Data;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "brans")
public class Brans{

    @Id
    @NotNull
    @GeneratedValue
    private Long id;

    @Column(name ="brans_adi")
    private String bransAdi;
}
