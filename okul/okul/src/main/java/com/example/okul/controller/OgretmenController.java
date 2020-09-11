package com.example.okul.controller;

import com.example.okul.entity.Ogretmen;
import com.example.okul.model.OgretmenModel;
import com.example.okul.service.OgretmenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/ogretmen")
public class OgretmenController {

    @Autowired
    OgretmenService ogretmenService;

    @PostMapping("/add")
    public Ogretmen create(@RequestBody OgretmenModel ogretmenModel) {
        return ogretmenService.create(ogretmenModel);
    }

    @GetMapping("/find-by-id")
    public Ogretmen findById(@RequestBody Long pk){
        return ogretmenService.findById(pk);
    }

    @GetMapping("/all")
    public List<Ogretmen> findAll() {
        return ogretmenService.findAll();
    }

    @PutMapping("/update")
    public Ogretmen update(@RequestBody OgretmenModel ogretmenModel) {
        return ogretmenService.update(ogretmenModel);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Long pk) {
        ogretmenService.delete(pk);
    }
}
