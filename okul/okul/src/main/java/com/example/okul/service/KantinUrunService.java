package com.example.okul.service;

import com.example.okul.annotation.TcKimlik;
import com.example.okul.base.service.BaseService;
import com.example.okul.entity.KantinUrun;
import com.example.okul.model.KantinUrunModel;

import javax.transaction.Transactional;

@Transactional
public interface KantinUrunService extends BaseService<KantinUrun, Long> {

    KantinUrun create(KantinUrunModel kantinUrunModel);
    KantinUrun update(KantinUrunModel kantinUrunModel);

}
