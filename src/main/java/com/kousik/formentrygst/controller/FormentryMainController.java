package com.kousik.formentrygst.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kousik.formentrygst.dao.RegisterRepo;
import com.kousik.formentrygst.model.Register;

@Controller
public class FormentryMainController {

	@Autowired
	RegisterRepo rRepo;

	@RequestMapping("/")
	public String showLoginPage() {

		return "login";
	}
	
	@RequestMapping("/student")
	public String showIndexPage() {

		return "student";
	}
	
	@RequestMapping("/book")
	public String showBookPage() {

		return "book";
	}
	
	@GetMapping("/home")
	public String showGETHomePage() {
		return "index";
	}

	@PostMapping("/home")
	public ModelAndView showPOSTHomePage(@RequestParam("gstnumber") String gstNoInp, HttpSession session) {
		/* Remove comma from input */
		String gstNo = gstNoInp.replaceAll(",", "");
		String partyName = rRepo.findBygstnumber(gstNo);

		session.setAttribute("partyname", partyName);
		session.setAttribute("partygstno", gstNo);

		String partyGstNo = (String) session.getAttribute("partygstno");

		ModelAndView mav = new ModelAndView();

		if (partyName != null) {
			mav.addObject("partygstno", partyGstNo);
			mav.setViewName("index");
			return mav;
		} else {
			/* show error message */
			// String err="Gst number invalid....! Register the Correct GST number with
			// Party name....";
			// mav.addObject("loginerror",partyGstNo);
			mav.setViewName("redirect:/");
			return mav;
		}
	}

	@PostMapping("/register")
	public String saveRegisterPage(@ModelAttribute Register register) {

		register.setGstnumber(register.getGstnumber().replaceAll(",", ""));

		if (register.getGstnumber().isEmpty()) {
			System.out.println("Gst number is empty");
		} else if (register.getPartyname().isEmpty()) {
			System.out.println("Partyname is empty");
		} else {
			rRepo.save(register);
		}
		return "redirect:/";
	}

	@GetMapping("/calculation")
	public String showCalculationPage() {
		return "calculation";
	}

	@GetMapping("/editform")
	public String showEditPage() {

		return "editpurchase";
	}
	
//	@GetMapping("/editpurchase")
//	public String showEditPutchasePage() {
//
//		return "editpurchase";
//	}

	@GetMapping("/gstr3b")
	public String showgstr3bPage() {

		return "gstr3b";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		return "redirect:/";
	}

}
