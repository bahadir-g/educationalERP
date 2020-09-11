package com.example.okul.repository;

import com.example.okul.base.repository.BaseRepository;
import com.example.okul.entity.Brans;
import com.example.okul.entity.Derslik;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DerslikRepository extends BaseRepository<Derslik,Long> {
}
