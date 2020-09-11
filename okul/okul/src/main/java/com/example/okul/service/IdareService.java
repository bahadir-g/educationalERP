package com.example.okul.service;

import com.example.okul.base.service.BaseService;
import com.example.okul.entity.Idare;
import com.example.okul.model.IdareModel;

import javax.transaction.Transactional;

@Transactional
public interface IdareService extends BaseService<Idare, Long> {
    Idare create(IdareModel idareModel);

    Idare update(IdareModel idareModel);
}
