package com.example.okul.repository;


import com.example.okul.base.repository.BaseRepository;
import com.example.okul.entity.Brans;
import com.example.okul.entity.DersProgrami;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DersProgramiRepository extends BaseRepository<DersProgrami,Long> {
}
