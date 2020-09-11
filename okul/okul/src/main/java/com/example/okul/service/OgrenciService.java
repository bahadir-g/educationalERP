package com.example.okul.service;

import com.example.okul.base.service.BaseService;
import com.example.okul.entity.Ogrenci;
import com.example.okul.model.OgrenciModel;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OgrenciService extends BaseService<Ogrenci, Long> {

    Ogrenci create(OgrenciModel ogrenciModel);

    Ogrenci update(OgrenciModel ogrenciModel);

    List<Ogrenci> findOgrenciBySinif(String sinifName);


}
