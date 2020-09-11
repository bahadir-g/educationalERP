package com.example.okul.repository;

import com.example.okul.base.repository.BaseRepository;
import com.example.okul.entity.Brans;
import com.example.okul.entity.KantinUrun;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KantinUrunRepository extends BaseRepository<KantinUrun,Long> {
}
