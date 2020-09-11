package com.example.okul.service.impl;

import com.example.okul.base.service.impl.BaseServiceImpl;
import com.example.okul.entity.Idare;
import com.example.okul.model.IdareModel;
import com.example.okul.repository.IdareRepository;
import com.example.okul.repository.OgretmenRepository;
import com.example.okul.service.IdareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class IdareServiceImpl extends BaseServiceImpl<Idare,Long> implements IdareService {

    @Autowired
    IdareRepository idareRepository;

    @Autowired
    OgretmenRepository ogretmenRepository;

    @Override
    public Idare create(IdareModel idareModel){
        Idare idare = new Idare();
        idare.setOgretmenRef(ogretmenRepository.findById(idareModel.getOgretmenRef()).orElseThrow(EntityNotFoundException::new));
        idare.setUnvan(idareModel.getUnvan());
        idareRepository.save(idare);
        return idare;
    }

    @Override
    public Idare update(IdareModel idareModel){
        Idare idare = idareRepository.findById(idareModel.getId()).orElseThrow(EntityNotFoundException::new);
        idare.setOgretmenRef(ogretmenRepository.findById(idareModel.getOgretmenRef()).orElseThrow(EntityNotFoundException::new));
        idare.setUnvan(idareModel.getUnvan());
        idareRepository.save(idare);
        return idare;
    }

}
