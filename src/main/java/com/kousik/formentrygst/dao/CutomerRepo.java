package com.kousik.formentrygst.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kousik.formentrygst.model.Customer;

public interface CutomerRepo extends JpaRepository<Customer, Integer> {

}
