package com.example.server.service;

 

import org.springframework.data.jpa.repository.JpaRepository;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.server.model.LocationModel;
 
@Repository
@Transactional
public interface PetLocationInterface extends JpaRepository<LocationModel, Integer>{
   
}