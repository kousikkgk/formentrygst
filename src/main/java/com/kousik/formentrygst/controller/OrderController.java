package com.kousik.formentrygst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kousik.formentrygst.dao.CutomerRepo;
import com.kousik.formentrygst.dao.OrderRequest;
import com.kousik.formentrygst.dao.ProductRepo;
import com.kousik.formentrygst.model.Customer;

@RestController
public class OrderController {

	@Autowired
	private CutomerRepo custRepo;
	
	@Autowired
	private ProductRepo prodRepo;
	
	@PostMapping("/	")
	public Customer placeOrder(@RequestBody OrderRequest orderRequest) {
		return custRepo.save(orderRequest.getCustomer());
	}
	
	@GetMapping("/findAllOrders")
	public List<Customer> findAllOrders(){
		return custRepo.findAll();
	}
}
