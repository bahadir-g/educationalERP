package com.example.okul.controller;

import com.example.okul.entity.KantinGideri;
import com.example.okul.entity.Ogrenci;
import com.example.okul.model.KantinGideriModel;
import com.example.okul.response.ResponsePayload;
import com.example.okul.service.KantinGideriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/kantin-gideri")
public class KantinGideriController {
    @Autowired
    KantinGideriService kantinGideriService;

    @PostMapping("/add")
    public KantinGideri create(@RequestBody KantinGideriModel kantinGideriModel) {
        return kantinGideriService.create(kantinGideriModel);
    }

    @GetMapping("/find-by-id")
    public KantinGideri findById(@RequestBody Long pk){
        return kantinGideriService.findById(pk);
    }

    @GetMapping("/all")
    public List<KantinGideri> findAll() {
        return kantinGideriService.findAll();
    }
    @GetMapping("/haftalik-gider")
    public List<KantinGideri> findHaftalikGider() {
        return kantinGideriService.haftalikBul();
    }

    @PutMapping("/update")
    public KantinGideri update(@RequestBody KantinGideriModel kantinGideriModel) {
        return kantinGideriService.update(kantinGideriModel);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Long pk) {
        kantinGideriService.delete(pk);
    }

    @GetMapping("/records")
    public ResponseEntity<Object> findRecords(@RequestBody Date date){
        List<KantinGideri> kantinGideriList = kantinGideriService.findRecords(date);
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(),  date + " tarihine ait kayıtlar bulundu.", kantinGideriList);
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }
}
