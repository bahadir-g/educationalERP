package com.example.okul.controller;

import com.example.okul.entity.Idare;
import com.example.okul.model.IdareModel;
import com.example.okul.service.IdareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/idare")
public class IdareController {

    @Autowired
    IdareService idareService;

    @PostMapping("/add")
    public Idare create(@RequestBody IdareModel idareModel) {
        return idareService.create(idareModel);
    }

    @GetMapping("/find-by-id")
    public Idare findById(@RequestBody Long pk){
        return idareService.findById(pk);
    }

    @GetMapping("/all")
    public List<Idare> findAll() {
        return idareService.findAll();
    }

    @PutMapping("/update")
    public Idare update(@RequestBody IdareModel idareModel) {
        return idareService.update(idareModel);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody Long pk) {
        idareService.delete(pk);
    }
}
