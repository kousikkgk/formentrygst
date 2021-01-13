package com.kousik.formentrygst.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kousik.formentrygst.dao.SalesRepo;
import com.kousik.formentrygst.model.Sales;

@Service
public class SalesService {
	
	@Autowired
	SalesRepo sRepo;
	
	public List<Sales> saveBook(HttpSession session, List<Sales> sales) {
		List<Sales> data=null;
		for (Sales obj : sales) {
			
			obj.setPartygstno((String) session.getAttribute("partygstno"));
			
			//convert the date into java8 local date for SQL insert
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate today = LocalDate.parse(obj.getDate(), dateTimeFormatter);
			obj.setLoclaDate(today);
			
			//Check for duplicate entries
			data = sRepo.findByInvNo(obj.getInv_no(), obj.getGst_no(), obj.getPartygstno(),
					obj.getDate().substring(3, 5), obj.getDate().substring(6, 10));
			
			System.out.println(obj.getInv_no()+"-"+ obj.getGst_no()+"-"+ obj.getPartygstno()+"-"+obj.getDate().substring(3, 5)+"-"+obj.getDate().substring(6, 10));
			//insert the data if the entries is empty
			if(data.isEmpty()==true) {
				System.out.println("Service"+data);
				sRepo.save(obj);
			}
			
		}
		return data;
		
	}
}
