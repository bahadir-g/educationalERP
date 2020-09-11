package com.example.okul.service;

import com.example.okul.base.service.BaseService;
import com.example.okul.entity.Sinif;
import com.example.okul.model.SinifModel;

import javax.transaction.Transactional;

@Transactional
public interface SinifService extends BaseService<Sinif, Long> {

    Sinif create(SinifModel sinifModel);

    Sinif update(SinifModel sinifModel);


}
