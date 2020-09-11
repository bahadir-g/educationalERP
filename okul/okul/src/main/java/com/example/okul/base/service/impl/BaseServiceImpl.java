package com.example.okul.base.service.impl;

import com.example.okul.base.repository.BaseRepository;
import com.example.okul.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<C, ID extends Serializable> implements BaseService<C,ID> {


    @Autowired
    private BaseRepository<C,ID> baseRepository;

    @Override
    public C findById(ID pk){
        return baseRepository.findById(pk).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<C> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public void delete(ID pk) {
        baseRepository.deleteById(pk);
    }
}
