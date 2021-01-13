package com.kousik.formentrygst.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kousik.formentrygst.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
