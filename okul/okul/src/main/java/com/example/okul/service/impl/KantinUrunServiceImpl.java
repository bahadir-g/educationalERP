package com.example.okul.service.impl;

import com.example.okul.base.service.impl.BaseServiceImpl;
import com.example.okul.entity.KantinUrun;
import com.example.okul.model.KantinUrunModel;
import com.example.okul.repository.KantinUrunRepository;
import com.example.okul.service.KantinUrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service
public class KantinUrunServiceImpl extends BaseServiceImpl<KantinUrun,Long> implements KantinUrunService {

    @Autowired
    KantinUrunRepository kantinUrunRepository;

    @Override
    public KantinUrun create(KantinUrunModel kantinUrunModel){
        KantinUrun kantinUrun = new KantinUrun();
        kantinUrun.setUrunAdi(kantinUrunModel.getUrunAdi());
        kantinUrun.setFiyat(kantinUrunModel.getFiyat());
        kantinUrunRepository.save(kantinUrun);
        return kantinUrun;
    }


    @Override
    public KantinUrun update(KantinUrunModel kantinUrunModel) {
        KantinUrun kantinUrun = kantinUrunRepository.findById(kantinUrunModel.getId()).orElseThrow(EntityNotFoundException::new);
        kantinUrun.setUrunAdi(kantinUrunModel.getUrunAdi());
        kantinUrun.setFiyat(kantinUrunModel.getFiyat());
        kantinUrunRepository.save(kantinUrun);
        return kantinUrun;
    }

}
