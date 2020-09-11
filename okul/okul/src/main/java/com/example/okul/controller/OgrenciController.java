package com.example.okul.controller;

import com.example.okul.entity.Ogrenci;
import com.example.okul.model.OgrenciModel;
import com.example.okul.response.ResponsePayload;
import com.example.okul.service.OgrenciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/ogrenci")
public class OgrenciController {

    @Autowired
    OgrenciService ogrenciService;

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody OgrenciModel ogrenciModel) {
        Ogrenci ogrenci = ogrenciService.create(ogrenciModel);
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Ogrenci kaydı oluşturuldu.", ogrenci);
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody OgrenciModel ogrenciModel) {
        Ogrenci ogrenci = ogrenciService.update(ogrenciModel);
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Öğrenci kaydı güncellendi.", ogrenci);
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Object> findById(@RequestBody Long pk) {
        Ogrenci ogrenci = ogrenciService.findById(pk);
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Öğrenci kaydı bulundu.", ogrenci);
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> findAll() {
        List<Ogrenci> ogrenci = ogrenciService.findAll();
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Tüm kayıtlar bulundu.", ogrenci);
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody Long pk) {
        ogrenciService.delete(pk);
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Öğrenci kaydı silindi.");
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @GetMapping("/find-by-sinifName")
    public ResponseEntity<Object> findbySinif(@RequestBody String sinifName) {
        List<Ogrenci> ogrenciList = ogrenciService.findOgrenciBySinif(sinifName);
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), sinifName + " sınıfına kayıtlı öğrenciler bulundu.", ogrenciList);
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

}
