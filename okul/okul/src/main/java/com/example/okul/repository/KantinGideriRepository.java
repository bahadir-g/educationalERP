package com.example.okul.repository;

import com.example.okul.base.repository.BaseRepository;
import com.example.okul.entity.KantinGideri;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface KantinGideriRepository extends BaseRepository<KantinGideri,Long> {

    @Query(value = "SELECT g FROM KantinGideri g WHERE g.tarih = :date ")
    List<KantinGideri> findKantinGideriRecords(@Param("date")Date date);

    // bir haftalik surecteki ogrencilerin hangi urunleri aldigini sirala
    @Query(value = "select kg from KantinGideri kg where kg.tarih between :birHaftaOncesi and :simdi ")
    List<KantinGideri> findSonHaftaSatilanKantin(@Param("birHaftaOncesi") Date birHaftaOncesi, @Param("simdi") Date simdi);

}
