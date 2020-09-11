package com.example.okul.service.impl;

import com.example.okul.base.service.impl.BaseServiceImpl;
import com.example.okul.entity.Brans;
import com.example.okul.model.BransModel;
import com.example.okul.repository.BransRepository;
import com.example.okul.service.BransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class BransServiceImpl extends BaseServiceImpl <Brans,Long> implements BransService {

    @Autowired
    BransRepository bransRepository;

    @Override
    public Brans create(BransModel bransModel){
        Brans brans = new Brans();
    brans.setBransAdi(bransModel.getBransAdi());
    bransRepository.save(brans);
    return brans;
    }

    @Override
    public Brans update(BransModel bransModel){
        Brans brans = bransRepository.findById(bransModel.getId()).orElseThrow(EntityNotFoundException::new);
        brans.setBransAdi(bransModel.getBransAdi());
        bransRepository.save(brans);
        return brans;

    }

}
