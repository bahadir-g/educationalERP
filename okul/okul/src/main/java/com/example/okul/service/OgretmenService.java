package com.example.okul.service;

import com.example.okul.base.service.BaseService;
import com.example.okul.entity.Ogretmen;
import com.example.okul.model.OgretmenModel;

import javax.transaction.Transactional;

@Transactional
public interface OgretmenService extends BaseService<Ogretmen, Long> {


    Ogretmen create(OgretmenModel ogretmenModel);

    Ogretmen update(OgretmenModel ogretmenModel);
}
