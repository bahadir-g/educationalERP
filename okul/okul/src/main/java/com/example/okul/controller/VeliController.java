package com.example.okul.controller;

import com.example.okul.entity.Veli;
import com.example.okul.model.VeliModel;
import com.example.okul.service.VeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/veli")
public class VeliController {

    @Autowired
    VeliService veliService;

    @PostMapping("/add")
    public Veli create(@RequestBody VeliModel veliModel) {
        return veliService.create(veliModel);
    }

    @GetMapping("/find-by-id")
    public Veli findById(@RequestBody Long pk){
        return veliService.findById(pk);
    }

    @GetMapping("/all")
    public List<Veli> findAll() {
        return veliService.findAll();
    }

    @PutMapping("/update")
    public Veli update(@RequestBody VeliModel veliModel) {
        return veliService.update(veliModel);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Long pk) {
        veliService.delete(pk);
    }
}
