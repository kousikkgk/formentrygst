package com.kousik.formentrygst.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kousik.formentrygst.model.Purchase;
import com.kousik.formentrygst.model.Sales;

@Component
public class BulkInsert {

	@Autowired
	PurchaseRepo pRepo;
	
	@Autowired
	SalesRepo sRepo;
	
	public void process() {
		List<Purchase> purList = new ArrayList<>(10000);
		List<Sales> salList = new ArrayList<>(10000);
		
//		for(int i = 0; i < 10000; i++) {
//	        myEntities.add(podamFactory.manufacturePojo(MyEntity.class));
//	    }

	}



}
