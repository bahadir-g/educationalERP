package com.example.okul.service;

import com.example.okul.base.service.BaseService;
import com.example.okul.entity.Derslik;
import com.example.okul.entity.Ogrenci;
import com.example.okul.model.DerslikModel;
import com.example.okul.model.OgrenciModel;

import javax.transaction.Transactional;

@Transactional
public interface DerslikService extends BaseService<Derslik, Long> {

    public Derslik create(DerslikModel derslikModel);

    public Derslik update(DerslikModel derslikModel);
}
