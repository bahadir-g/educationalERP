package com.example.okul.service;

import com.example.okul.base.service.BaseService;
import com.example.okul.entity.DersProgrami;
import com.example.okul.entity.Ogretmen;
import com.example.okul.model.DersProgramiModel;
import com.example.okul.model.SinifVeGunModel;

import java.util.List;

public interface DersProgramiService extends BaseService<DersProgrami, Long> {

    DersProgrami create(DersProgramiModel dersProgramiModel);

    DersProgrami update(DersProgramiModel dersProgramiModel);

    List<Ogretmen> sinifVeGuneGoreOgretmen(SinifVeGunModel sinifVeGunModel);
}
