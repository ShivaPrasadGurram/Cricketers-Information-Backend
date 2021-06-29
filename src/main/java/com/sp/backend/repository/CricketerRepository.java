package com.sp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.backend.model.Cricketer;

@Repository
public interface CricketerRepository extends JpaRepository<Cricketer, Long>{

}
