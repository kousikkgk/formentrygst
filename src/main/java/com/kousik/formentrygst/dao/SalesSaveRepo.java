package com.kousik.formentrygst.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kousik.formentrygst.model.Sales;

@Repository
public class SalesSaveRepo extends SimpleJpaRepository<Sales, String> {

	private EntityManager entityManager;

	public SalesSaveRepo(EntityManager entityManager) {
		super(Sales.class, entityManager);
		this.entityManager = entityManager;
	}
	
	 @Transactional
	    public List<Sales> save(List<Sales> sales) {
	        sales.forEach(sale -> entityManager.persist(sale));
	        return sales;
	    }

}
