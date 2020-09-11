package com.example.okul.controller;

import com.example.okul.entity.Brans;
import com.example.okul.model.BransModel;
import com.example.okul.response.ResponsePayload;
import com.example.okul.service.BransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/brans")
public class BransController {

    @Autowired
    BransService bransService;

    @PostMapping("/add")
    public ResponseEntity<Object> create(@RequestBody BransModel bransModel) {
        Brans brans = bransService.create(bransModel);
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Kayıt oluşturuldu.", brans);
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> findAll() {
        List<Brans> brans = bransService.findAll();
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Tüm kayıtlar bulundu.", brans);
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Object> findById(@RequestBody Long pk) {
        Brans brans = bransService.findById(pk);
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Kayıt bulundu.", brans);
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody BransModel bransModel) {
        Brans brans = bransService.update(bransModel);
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Kayıt güncellendi.", brans);
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody Long pk) {
        bransService.delete(pk);
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Kayıt silindi!");
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }
}
