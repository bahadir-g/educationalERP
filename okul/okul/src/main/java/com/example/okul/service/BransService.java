package com.example.okul.service;

import com.example.okul.base.service.BaseService;
import com.example.okul.entity.Brans;
import com.example.okul.model.BransModel;

import javax.transaction.Transactional;

@Transactional
public interface BransService extends BaseService<Brans, Long> {

    Brans create(BransModel bransModel);

    Brans update(BransModel bransModel);
}
