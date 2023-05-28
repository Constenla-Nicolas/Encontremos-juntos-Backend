package com.example.server.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Productos.model.ProductModel;
@Repository
@Transactional
public interface RepositoryInterface extends JpaRepository<ProductModel, Integer>{
    ProductModel findByName(String name);
}