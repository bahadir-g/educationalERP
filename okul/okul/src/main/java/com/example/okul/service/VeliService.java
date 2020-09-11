package com.example.okul.service;

import com.example.okul.base.service.BaseService;
import com.example.okul.entity.Veli;
import com.example.okul.model.VeliModel;

import javax.transaction.Transactional;

@Transactional
public interface VeliService extends BaseService<Veli, Long> {

    Veli create(VeliModel veliModel);

    Veli update(VeliModel veliModel);


}
