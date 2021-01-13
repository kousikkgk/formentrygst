package com.kousik.formentrygst.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kousik.formentrygst.dao.ServiceResponse;
import com.kousik.formentrygst.model.Sales;
import com.kousik.formentrygst.service.SalesService;

@Controller
public class SalesController {

	@Autowired
	SalesService salService;
	
	@RequestMapping("/sales")
	public ResponseEntity<Object> addBook(@RequestBody List<Sales> sales,HttpSession session){
	
		ServiceResponse<List<Sales>> response;
		
		List<Sales> objPur=salService.saveBook(session,sales);
		System.out.println(objPur);
		
		if (objPur.isEmpty()==false) {
			response=new ServiceResponse<>("Error",objPur);
		}else {
			response=new ServiceResponse<>("success",objPur);
		}
		
		return new ResponseEntity<Object>(response,HttpStatus.OK);			
	
	}
}

