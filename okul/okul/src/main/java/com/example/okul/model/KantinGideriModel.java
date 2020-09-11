package com.example.okul.model;

import lombok.Data;

import java.sql.Date;


@Data
public class KantinGideriModel {

    private Long id;
    private Long ogrenciRef;
    private Date tarih;
    private Long kantinUrunRef;
}
