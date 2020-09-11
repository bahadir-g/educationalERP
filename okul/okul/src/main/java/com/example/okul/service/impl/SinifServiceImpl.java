package com.example.okul.service.impl;

import com.example.okul.base.service.impl.BaseServiceImpl;
import com.example.okul.entity.Sinif;
import com.example.okul.model.SinifModel;
import com.example.okul.repository.SinifRepository;
import com.example.okul.service.SinifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SinifServiceImpl extends BaseServiceImpl<Sinif,Long> implements SinifService {

    @Autowired
    SinifRepository sinifRepository;

    @Override
    public Sinif create(SinifModel sinifModel) {
        Sinif sinif = new Sinif();
        sinif.setSinifAdi(sinifModel.getSinifAdi());
        sinifRepository.save(sinif);
        return sinif;
    }


    @Override
    public Sinif update(SinifModel sinifModel) {
        Sinif sinif = sinifRepository.findById(sinifModel.getId()).orElseThrow(EntityNotFoundException::new);
        sinif.setSinifAdi(sinifModel.getSinifAdi());
        sinifRepository.save(sinif);
        return sinif;
    }

}
