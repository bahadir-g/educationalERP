package com.example.okul.service.impl;

import com.example.okul.base.service.impl.BaseServiceImpl;
import com.example.okul.entity.Ogretmen;
import com.example.okul.model.OgretmenModel;
import com.example.okul.repository.BransRepository;
import com.example.okul.repository.OgretmenRepository;
import com.example.okul.service.OgretmenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OgretmenServiceImpl extends BaseServiceImpl<Ogretmen,Long> implements OgretmenService {

    @Autowired
    OgretmenRepository ogretmenRepository;

    @Autowired
    BransRepository bransRepository;

    @Override
    public Ogretmen create(OgretmenModel ogretmenModel) {
        Ogretmen ogretmen = new Ogretmen();
        ogretmen.setAd(ogretmenModel.getAd());
        ogretmen.setSoyad(ogretmenModel.getSoyad());
        ogretmen.setBransRef(bransRepository.findById(ogretmenModel.getBransRef()).orElseThrow(EntityNotFoundException::new));
        ogretmenRepository.save(ogretmen);
        return ogretmen;
    }


    @Override
    public Ogretmen update(OgretmenModel ogretmenModel) {
        Ogretmen ogretmen = ogretmenRepository.findById(ogretmenModel.getId()).orElseThrow(EntityNotFoundException::new);
        ogretmen.setAd(ogretmenModel.getAd());
        ogretmen.setSoyad(ogretmenModel.getSoyad());
        ogretmen.setBransRef(bransRepository.findById(ogretmenModel.getBransRef()).orElseThrow(EntityNotFoundException::new));
        ogretmenRepository.save(ogretmen);
        return ogretmen;
    }

}
