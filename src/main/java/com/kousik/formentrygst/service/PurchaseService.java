package com.kousik.formentrygst.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kousik.formentrygst.dao.PurchaseRepo;
import com.kousik.formentrygst.model.Purchase;

@Service
public class PurchaseService {
	@Autowired
	PurchaseRepo pRepo;
	
	public List<Purchase> saveBook(HttpSession session, List<Purchase> purchase) {
		List<Purchase> data = null;
		for (Purchase obj : purchase) {
			
			obj.setPartygstno((String) session.getAttribute("partygstno"));
			
			//convert the date into java8 local date for SQL insert
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate today = LocalDate.parse(obj.getDate(), dateTimeFormatter);
			obj.setLoclaDate(today);
			
			//Check for duplicate entries
			data = pRepo.findByInvNo(obj.getInv_no(), obj.getGst_no(), obj.getPartygstno(),
					obj.getDate().substring(3, 5), obj.getDate().substring(6, 10));
			
			//insert the data if the entries is empty
			if(data.isEmpty()==true) {
				System.out.println("Service"+data);
				pRepo.save(obj);
			}
			
		}
		return data;
		
	}
}
