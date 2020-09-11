package com.example.okul.service.impl;

import com.example.okul.base.service.impl.BaseServiceImpl;
import com.example.okul.entity.Ogrenci;
import com.example.okul.model.OgrenciModel;
import com.example.okul.repository.DerslikRepository;
import com.example.okul.repository.OgrenciRepository;
import com.example.okul.repository.SinifRepository;
import com.example.okul.repository.VeliRepository;
import com.example.okul.service.OgrenciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OgrenciServiceImpl extends BaseServiceImpl<Ogrenci,Long> implements OgrenciService {

    @Autowired
    OgrenciRepository ogrenciRepository;

    @Autowired
    SinifRepository sinifRepository;

    @Autowired
    DerslikRepository derslikRepository;

    @Autowired
    VeliRepository veliRepository;

    @Override
    public Ogrenci create(OgrenciModel ogrenciModel) {
        Ogrenci ogrenci = new Ogrenci();
        ogrenci.setAd(ogrenciModel.getAd());
        ogrenci.setSoyad(ogrenciModel.getSoyad());
        ogrenci.setTcNumara(ogrenciModel.getTcNumara());
        ogrenci.setSinifRef(sinifRepository.findById(ogrenciModel.getSinifRef()).orElseThrow(EntityNotFoundException::new));
        ogrenci.setDerslikRef(derslikRepository.findById(ogrenciModel.getDerslikRef()).orElseThrow(EntityNotFoundException::new));
        ogrenci.setVeliRef1(veliRepository.findById(ogrenciModel.getVeliRef1()).orElseThrow(EntityNotFoundException::new));
        ogrenci.setVeliRef2(veliRepository.findById(ogrenciModel.getVeliRef2()).orElseThrow(EntityNotFoundException::new));
        ogrenciRepository.save(ogrenci);
        return ogrenci;
    }


    @Override
    public Ogrenci update(OgrenciModel ogrenciModel) {
        Ogrenci ogrenci = ogrenciRepository.findById(ogrenciModel.getId()).orElseThrow(EntityNotFoundException::new);
        ogrenci.setAd(ogrenciModel.getAd());
        ogrenci.setSoyad(ogrenciModel.getSoyad());
        ogrenci.setTcNumara(ogrenciModel.getTcNumara());
        ogrenci.setSinifRef(sinifRepository.findById(ogrenciModel.getSinifRef()).orElseThrow(EntityNotFoundException::new));
        ogrenci.setDerslikRef(derslikRepository.findById(ogrenciModel.getDerslikRef()).orElseThrow(EntityNotFoundException::new));
        ogrenci.setVeliRef1(veliRepository.findById(ogrenciModel.getVeliRef1()).orElseThrow(EntityNotFoundException::new));
        ogrenci.setVeliRef2(veliRepository.findById(ogrenciModel.getVeliRef2()).orElseThrow(EntityNotFoundException::new));
        ogrenciRepository.save(ogrenci);
        return ogrenci;
    }

    @Override
    public List<Ogrenci> findOgrenciBySinif(String sinifName) {
        return ogrenciRepository.findOgrenciBySinifName(sinifName);
    }
}
