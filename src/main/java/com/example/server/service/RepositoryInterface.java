package com.example.server.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.server.model.PetModel;
@Repository
@Transactional
public interface RepositoryInterface extends JpaRepository<PetModel, Integer>{
   
}