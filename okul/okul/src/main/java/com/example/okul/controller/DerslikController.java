package com.example.okul.controller;

import com.example.okul.entity.Derslik;
import com.example.okul.model.DerslikModel;
import com.example.okul.response.ResponsePayload;
import com.example.okul.service.DerslikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/derslik")
public class DerslikController {

    @Autowired
    private DerslikService derslikService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody DerslikModel derslikModel) {
        Derslik derslik = derslikService.create(derslikModel);
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Kayıt oluşturuldu.", derslik);
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Object> findById(@RequestBody Long pk){
        Derslik derslik = derslikService.findById(pk);
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Kayıt bulundu.", derslik);
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> findAll() {
        List<Derslik> derslik = derslikService.findAll();
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Tüm kayıtlar bulundu.", derslik);
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody DerslikModel derslikModel) {
        Derslik derslik = derslikService.update(derslikModel);
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Kayıt güncellendi.", derslik);
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody Long pk) {
        derslikService.delete(pk);
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "Kayıt silindi.");
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }
}
