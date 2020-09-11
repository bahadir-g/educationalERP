package com.example.okul.repository;

import com.example.okul.base.repository.BaseRepository;
import com.example.okul.entity.Brans;
import com.example.okul.entity.Sinif;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinifRepository extends BaseRepository<Sinif,Long> {
}
