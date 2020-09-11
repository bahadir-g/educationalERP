package com.example.okul.repository;

import com.example.okul.base.repository.BaseRepository;
import com.example.okul.entity.Ogrenci;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OgrenciRepository extends BaseRepository<Ogrenci,Long> {

    @Query("SELECT o FROM Ogrenci o WHERE o.sinifRef.sinifAdi = :sinifName ")
    List<Ogrenci> findOgrenciBySinifName(@Param("sinifName") String sinifName);
}
