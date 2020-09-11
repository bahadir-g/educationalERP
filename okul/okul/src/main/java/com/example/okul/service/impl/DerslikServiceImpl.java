package com.example.okul.service.impl;

import com.example.okul.base.service.impl.BaseServiceImpl;
import com.example.okul.entity.Derslik;
import com.example.okul.model.DerslikModel;
import com.example.okul.repository.DerslikRepository;
import com.example.okul.service.DerslikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class DerslikServiceImpl extends BaseServiceImpl<Derslik,Long> implements DerslikService {

    @Autowired
    DerslikRepository derslikRepository;

    @Override
    public Derslik create(DerslikModel derslikModel){
        Derslik derslik = new Derslik();
        derslik.setDerslikAdi(derslikModel.getDerslikAdi());
        derslikRepository.save(derslik);
        return derslik;
    }

    @Override
    public Derslik update(DerslikModel derslikModel){
        Derslik derslik = derslikRepository.findById(derslikModel.getId()).orElseThrow(EntityNotFoundException::new);
        derslik.setDerslikAdi(derslikModel.getDerslikAdi());
        derslikRepository.save(derslik);
        return derslik;

    }

}
