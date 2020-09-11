package com.example.okul.service.impl;

import com.example.okul.base.service.impl.BaseServiceImpl;
import com.example.okul.entity.Veli;
import com.example.okul.model.VeliModel;
import com.example.okul.repository.VeliRepository;
import com.example.okul.service.VeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class VeliServiceImpl extends BaseServiceImpl<Veli,Long> implements VeliService {

    @Autowired
    VeliRepository veliRepository;

    @Override
    public Veli create(VeliModel veliModel) {
        Veli veli = new Veli();
        veli.setAd(veliModel.getAd());
        veli.setSoyad(veliModel.getSoyad());
        veli.setEmail(veliModel.getEmail());
        veli.setTelefon(veliModel.getTelefon());
        veliRepository.save(veli);
        return veli;
    }


    @Override
    public Veli update(VeliModel veliModel) {
        Veli veli = veliRepository.findById(veliModel.getId()).orElseThrow(EntityNotFoundException::new);
        veli.setAd(veliModel.getAd());
        veli.setSoyad(veliModel.getSoyad());
        veli.setEmail(veliModel.getEmail());
        veli.setTelefon(veliModel.getTelefon());
        veliRepository.save(veli);
        return veli;
    }

}
