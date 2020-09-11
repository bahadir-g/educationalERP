package com.example.okul.service.impl;


import com.example.okul.base.service.impl.BaseServiceImpl;
import com.example.okul.entity.DersProgrami;
import com.example.okul.entity.Ogretmen;
import com.example.okul.model.DersProgramiModel;
import com.example.okul.model.SinifVeGunModel;
import com.example.okul.repository.DersProgramiRepository;
import com.example.okul.repository.DerslikRepository;
import com.example.okul.repository.OgretmenRepository;
import com.example.okul.repository.SinifRepository;
import com.example.okul.service.DersProgramiService;
import com.example.okul.specs.DersProgramiSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DersProgramiServiceImpl extends BaseServiceImpl<DersProgrami,Long> implements DersProgramiService {

    @Autowired
    DersProgramiRepository dersProgramiRepository;

    @Autowired
    SinifRepository sinifRepository;

    @Autowired
    DerslikRepository derslikRepository;

    @Autowired
    OgretmenRepository ogretmenRepository;

    @Override
    public DersProgrami create(DersProgramiModel dersProgramiModel){
        DersProgrami dersProgrami = new DersProgrami();

        dersProgrami.setSinifRef(sinifRepository.findById(dersProgramiModel.getSinifRef()).orElseThrow(EntityNotFoundException::new));
        dersProgrami.setDerslikRef(derslikRepository.findById(dersProgramiModel.getDerslikref()).orElseThrow(EntityNotFoundException::new));
        dersProgrami.setOgretmenRef1(ogretmenRepository.findById(dersProgramiModel.getDersOgretmen1()).orElseThrow(EntityNotFoundException::new));
        dersProgrami.setOgretmenRef2(ogretmenRepository.findById(dersProgramiModel.getDersOgretmen2()).orElseThrow(EntityNotFoundException::new));
        dersProgrami.setOgretmenRef3(ogretmenRepository.findById(dersProgramiModel.getDersOgretmen3()).orElseThrow(EntityNotFoundException::new));
        dersProgrami.setOgretmenRef4(ogretmenRepository.findById(dersProgramiModel.getDersOgretmen4()).orElseThrow(EntityNotFoundException::new));
        dersProgrami.setOgretmenRef5(ogretmenRepository.findById(dersProgramiModel.getDersOgretmen5()).orElseThrow(EntityNotFoundException::new));
        dersProgrami.setOgretmenRef6(ogretmenRepository.findById(dersProgramiModel.getDersOgretmen6()).orElseThrow(EntityNotFoundException::new));

        dersProgrami.setGun(dersProgramiModel.getGun());
        dersProgramiRepository.save(dersProgrami);
        return dersProgrami;
    }

    @Override
    public DersProgrami update(DersProgramiModel dersProgramiModel){
        DersProgrami dersProgrami = dersProgramiRepository.findById(dersProgramiModel.getId()).orElseThrow(EntityNotFoundException::new);
        dersProgrami.setSinifRef(sinifRepository.findById(dersProgramiModel.getSinifRef()).orElseThrow(EntityNotFoundException::new));
        dersProgrami.setDerslikRef(derslikRepository.findById(dersProgramiModel.getDerslikref()).orElseThrow(EntityNotFoundException::new));
        dersProgrami.setOgretmenRef1(ogretmenRepository.findById(dersProgramiModel.getDersOgretmen1()).orElseThrow(EntityNotFoundException::new));
        dersProgrami.setOgretmenRef2(ogretmenRepository.findById(dersProgramiModel.getDersOgretmen2()).orElseThrow(EntityNotFoundException::new));
        dersProgrami.setOgretmenRef3(ogretmenRepository.findById(dersProgramiModel.getDersOgretmen3()).orElseThrow(EntityNotFoundException::new));
        dersProgrami.setOgretmenRef4(ogretmenRepository.findById(dersProgramiModel.getDersOgretmen4()).orElseThrow(EntityNotFoundException::new));
        dersProgrami.setOgretmenRef5(ogretmenRepository.findById(dersProgramiModel.getDersOgretmen5()).orElseThrow(EntityNotFoundException::new));
        dersProgrami.setOgretmenRef6(ogretmenRepository.findById(dersProgramiModel.getDersOgretmen6()).orElseThrow(EntityNotFoundException::new));
        dersProgrami.setGun(dersProgramiModel.getGun());
        dersProgramiRepository.save(dersProgrami);
        return dersProgrami;
    }

    @Override
    public List<Ogretmen> sinifVeGuneGoreOgretmen(SinifVeGunModel sinifVeGunModel) {
        DersProgramiSpecs dersProgramiSpecs = new DersProgramiSpecs();
        DersProgrami dersProgrami = dersProgramiRepository.findOne(dersProgramiSpecs.getOgretmenBySinifAndGun(sinifVeGunModel)).orElseThrow(EntityNotFoundException::new);
        List<Ogretmen> ogretmenList = new ArrayList<Ogretmen>();
        ogretmenList.add(dersProgrami.getOgretmenRef1());
        ogretmenList.add(dersProgrami.getOgretmenRef2());
        ogretmenList.add(dersProgrami.getOgretmenRef3());
        ogretmenList.add(dersProgrami.getOgretmenRef4());
        ogretmenList.add(dersProgrami.getOgretmenRef5());
        ogretmenList.add(dersProgrami.getOgretmenRef6());
        return ogretmenList;
    }
}
