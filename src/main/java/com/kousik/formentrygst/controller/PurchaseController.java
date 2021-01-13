package com.kousik.formentrygst.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kousik.formentrygst.dao.ServiceResponse;
import com.kousik.formentrygst.model.Purchase;
import com.kousik.formentrygst.service.PurchaseService;

@RestController
public class PurchaseController {
	
	
	@Autowired
	PurchaseService purService;
	
	@RequestMapping("/purchase")
	public ResponseEntity<Object> addBook(@RequestBody List<Purchase> purchase,HttpSession session){
		
		ServiceResponse<List<Purchase>> response;
		
		List<Purchase> objPur=purService.saveBook(session,purchase);
		
		if (objPur.isEmpty()==false) {
			response=new ServiceResponse<>("Error",objPur);
		}else {
			response=new ServiceResponse<>("success",objPur);
		}
		
		return new ResponseEntity<Object>(response,HttpStatus.OK);		
		
	}
}
