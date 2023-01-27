package com.servidor.keyserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servidor.keyserver.entity.KeyEntity;

@Repository
public interface KeyRepository extends JpaRepository<KeyEntity, Long>{

}
