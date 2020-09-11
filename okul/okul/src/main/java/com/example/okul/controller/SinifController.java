package com.example.okul.controller;

import com.example.okul.base.service.BaseService;
import com.example.okul.entity.Sinif;
import com.example.okul.model.SinifModel;
import com.example.okul.service.SinifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/sinif")
public class SinifController {

    @Autowired
    SinifService sinifService;

    @PostMapping("/add")
    public Sinif create(@RequestBody SinifModel sinifModel) {
        return sinifService.create(sinifModel);
    }

    @GetMapping("/find-by-id")
    public Sinif findById(@RequestBody Long pk) throws Throwable {
        return sinifService.findById(pk);
    }

    @GetMapping("/all")
    public List<Sinif> findAll() {
        return sinifService.findAll();
    }

    @PutMapping("/update")
    public Sinif update(@RequestBody SinifModel sinifModel) {
        return sinifService.update(sinifModel);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Long pk) {
        sinifService.delete(pk);
    }
}
