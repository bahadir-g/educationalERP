package com.example.okul.controller;


import com.example.okul.entity.KantinUrun;
import com.example.okul.model.KantinUrunModel;
import com.example.okul.response.ResponsePayload;
import com.example.okul.service.KantinUrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/kantin-urun")
public class KantinUrunController {

    @Autowired
    KantinUrunService kantinUrunService;

    @PostMapping("/add")
    public KantinUrun create(@RequestBody KantinUrunModel kantinUrunModel) {
        return kantinUrunService.create(kantinUrunModel);
    }

    @GetMapping("/find-by-id")
    public KantinUrun findById(@RequestBody Long pk){
        return kantinUrunService.findById(pk);
    }

    @GetMapping("/all")
    public List<KantinUrun> findAll() {
        return kantinUrunService.findAll();
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update( @RequestBody KantinUrunModel kantinUrunModel) {
        KantinUrun kantinUrun = kantinUrunService.update(kantinUrunModel);
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(), "kantin urun updated", kantinUrun);
        return new ResponseEntity<>(responsePayload, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Long pk) {
        kantinUrunService.delete(pk);
    }
}
