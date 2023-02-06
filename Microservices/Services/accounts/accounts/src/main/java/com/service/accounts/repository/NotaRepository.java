package com.service.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.accounts.entity.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long>{

}
