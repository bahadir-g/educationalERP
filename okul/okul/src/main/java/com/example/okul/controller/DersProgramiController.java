package com.example.okul.controller;

import com.example.okul.entity.DersProgrami;
import com.example.okul.entity.Ogretmen;
import com.example.okul.model.DersProgramiModel;
import com.example.okul.model.SinifVeGunModel;
import com.example.okul.service.DersProgramiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/ders-programi")
public class DersProgramiController {
    @Autowired
    DersProgramiService dersProgramiService;

    @PostMapping("/add")
    public DersProgrami create(@RequestBody DersProgramiModel dersProgramiModel) {
        return dersProgramiService.create(dersProgramiModel);
    }

    @GetMapping("/find-by-id")
    public DersProgrami findById(@RequestBody Long pk){
        return dersProgramiService.findById(pk);
    }
    @GetMapping("/all")
    public List<DersProgrami> findAll() {
        return dersProgramiService.findAll();
    }

    @GetMapping("/spec")
    public List<Ogretmen> sinifVeGuneGoreOgretmen(@RequestBody SinifVeGunModel sinifVeGunModel){
       return dersProgramiService.sinifVeGuneGoreOgretmen(sinifVeGunModel);
    }

    @PutMapping("/update")
    public DersProgrami update(@RequestBody DersProgramiModel dersProgramiModel) {
        return dersProgramiService.update(dersProgramiModel);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Long pk) {
        dersProgramiService.delete(pk);
    }
}
