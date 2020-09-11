package com.example.okul.base.service;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface BaseService<C,ID> {

    C findById(ID pk);

    List<C> findAll();

    void delete(ID pk);
}
