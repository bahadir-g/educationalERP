package com.example.okul.model;

import com.example.okul.annotation.TcKimlik;
import lombok.Data;

@Data
public class KantinUrunModel {

    private Long id;
    private String urunAdi;
    private Long fiyat;
}
