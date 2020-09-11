package com.example.okul.service;

import com.example.okul.base.service.BaseService;
import com.example.okul.entity.KantinGideri;
import com.example.okul.model.KantinGideriModel;
import javax.transaction.Transactional;

import java.sql.Date;
import java.util.List;

@Transactional
public interface KantinGideriService extends BaseService<KantinGideri, Long> {

     KantinGideri create(KantinGideriModel kantinGideriModel);

     KantinGideri update(KantinGideriModel kantinGideriModel);

     List<KantinGideri> findRecords(Date date);

     List<KantinGideri> haftalikBul();
}
