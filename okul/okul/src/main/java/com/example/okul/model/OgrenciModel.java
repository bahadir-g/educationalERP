package com.example.okul.model;

import lombok.Data;

@Data
public class OgrenciModel {

    private Long id;
    private String ad;
    private String soyad;
    private String tcNumara;
    private Long sinifRef;
    private Long derslikRef;
    private Long veliRef1;
    private Long veliRef2;
}
