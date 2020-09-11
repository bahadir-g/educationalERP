package com.example.okul.service.impl;

import com.example.okul.base.service.impl.BaseServiceImpl;
import com.example.okul.entity.KantinGideri;
import com.example.okul.model.KantinGideriModel;
import com.example.okul.repository.KantinGideriRepository;
import com.example.okul.repository.KantinUrunRepository;
import com.example.okul.repository.OgrenciRepository;
import com.example.okul.service.KantinGideriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class KantinGideriServiceImpl extends BaseServiceImpl<KantinGideri,Long> implements KantinGideriService {

    @Autowired
    KantinGideriRepository kantinGideriRepository;

    @Autowired
    OgrenciRepository ogrenciRepository;

    @Autowired
    KantinUrunRepository kantinUrunRepository;

    @Override
    public KantinGideri create(KantinGideriModel kantinGideriModel){

        KantinGideri kantinGideri = new KantinGideri();
        kantinGideri.setOgrenciRef(ogrenciRepository.findById(kantinGideriModel.getOgrenciRef()).orElseThrow(EntityNotFoundException::new));
        kantinGideri.setKantinUrunRef(kantinUrunRepository.findById(kantinGideriModel.getKantinUrunRef()).orElseThrow(EntityNotFoundException::new));
        kantinGideri.setTarih(kantinGideriModel.getTarih());
        kantinGideriRepository.save(kantinGideri);
        return kantinGideri;
    }

    @Override
    public KantinGideri update(KantinGideriModel kantinGideriModel){
        KantinGideri kantinGideri = kantinGideriRepository.findById(kantinGideriModel.getId()).orElseThrow(EntityNotFoundException::new);
        kantinGideri.setOgrenciRef(ogrenciRepository.findById(kantinGideriModel.getOgrenciRef()).orElseThrow(EntityNotFoundException::new));
        kantinGideri.setKantinUrunRef(kantinUrunRepository.findById(kantinGideriModel.getKantinUrunRef()).orElseThrow(EntityNotFoundException::new));
        kantinGideri.setTarih(kantinGideriModel.getTarih());
        kantinGideriRepository.save(kantinGideri);
        return kantinGideri;
    }

    @Override
    public List<KantinGideri> findRecords(Date date) {
        return kantinGideriRepository.findKantinGideriRecords(date);
    }

    @Override
    public List<KantinGideri> haftalikBul() {
        LocalDate result = LocalDate.now().minus(1, ChronoUnit.WEEKS);
        Date beforeaweek = Date.valueOf(result);
        return kantinGideriRepository.findSonHaftaSatilanKantin(beforeaweek,Date.valueOf(LocalDate.now()));

    }
}
