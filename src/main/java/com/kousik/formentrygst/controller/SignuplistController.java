package com.kousik.formentrygst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kousik.formentrygst.dao.SignuplistRepo;
import com.kousik.formentrygst.model.Signuplist;

@Controller
public class SignuplistController {

	@Autowired
	SignuplistRepo singupRepo;
	
	@RequestMapping("/signuplist")
	public ModelAndView showLoginPage() {

		List<Signuplist> signupList = singupRepo.findAll();
		
		ModelAndView mav = new ModelAndView("signuplist");
		mav.addObject("signuplist",signupList);
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.GET)   
	public String editSignup(@RequestParam(value="gstId") String gstId,Model model) {
		Signuplist signuplist = singupRepo.getOne(gstId); 
        model.addAttribute("signuplist",signuplist);  
        System.out.println(gstId);
		return "signuplist";    
    } 
	
	@GetMapping("/delete/{gstId}")
	public String deletePurchase(@PathVariable("inv_no") String gstId) {
	    singupRepo.deleteById(gstId);
	    return "editpurchase";    
	}
}
