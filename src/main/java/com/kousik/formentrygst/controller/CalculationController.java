package com.kousik.formentrygst.controller;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kousik.formentrygst.dao.PurchaseRepo;
import com.kousik.formentrygst.dao.SalesRepo;
import com.kousik.formentrygst.dao.ServiceResponse;
import com.kousik.formentrygst.model.Purchase;
import com.kousik.formentrygst.model.Sales;
import com.kousik.formentrygst.service.ReportService;

@Controller
public class CalculationController {

	@Autowired
	PurchaseRepo pRepo;
	
	@Autowired
	SalesRepo sRepo;
	
	@Autowired
	ReportService reportService;
//	@RequestMapping("/calculation")
//	public String showCalculationPage() {
//		return "calculation";
//	}
//	
	@RequestMapping(value="/showgstr3b")
	public ModelAndView savePurchaseEntries(@RequestParam("gstr3bdate") String dateVal,HttpSession session)
	{
		System.out.println(dateVal);
		String month=dateVal.substring(0, 2);
		String year=dateVal.substring(3, 7);
		
		String gstNo=(String) session.getAttribute("partygstno");
		System.out.println("Month"+month+"||Year"+year+"||"+gstNo);
	
		//Gstr3B Purchase values
		Double purtaxVal=pRepo.findByTaxValMonthandYear(gstNo,month, year).orElse(0.0);
		Double purcgstVal=pRepo.findByCgstValMonthandYear(gstNo,month, year).orElse(0.0);
		Double pursgstVal=pRepo.findBySgstValMonthandYear(gstNo,month, year).orElse(0.0);
		Double purigstVal=pRepo.findByIgstValMonthandYear(gstNo,month, year).orElse(0.0);
		
		//Gstr3B Sales Values
		Double saltaxVal = sRepo.findByTaxValMonthandYear(gstNo,month, year).orElse(0.0);
		Double salcgstVal=sRepo.findByCgstValMonthandYear(gstNo,month, year).orElse(0.0);		
		Double salsgstVal=sRepo.findBySgstValMonthandYear(gstNo,month, year).orElse(0.0);
		Double saligstVal=sRepo.findByIgstValMonthandYear(gstNo,month, year).orElse(0.0);

		double purtotal=purtaxVal+purcgstVal+pursgstVal+purigstVal;
		double saltotal=saltaxVal+salcgstVal+salsgstVal+saligstVal;
		
		System.out.println("Purchase: "+purtaxVal+"-"+purcgstVal+"-"+pursgstVal+"-"+purigstVal);
		System.out.println("Sales: "+saltaxVal+"-"+salcgstVal+"-"+salsgstVal+"-"+saligstVal);
		
		ModelAndView mav = new ModelAndView("gstr3b");
		mav.addObject("purtaxVal", purtaxVal);
		mav.addObject("purigstVal", purigstVal);
		mav.addObject("purcgstVal", purcgstVal);
		mav.addObject("pursgstVal", pursgstVal);
		
		//round off
		mav.addObject("purtotal", new DecimalFormat("#.00").format(purtotal));
		
		
		mav.addObject("saltaxVal", saltaxVal);
		mav.addObject("saligstVal", saligstVal);
		mav.addObject("salcgstVal", salcgstVal);
		mav.addObject("salsgstVal", salsgstVal);
		//round off
		mav.addObject("saltotal", new DecimalFormat("#.00").format(saltotal));
		return mav;
	}
//	@RequestMapping("/editpurchase")
//	public ModelAndView showEditPage() {
//		List<Purchase> purchase= pRepo.findAll();
//		ModelAndView mav=new ModelAndView("editpurchase");
//		mav.addObject("purchase",purchase);
//		return mav;
//	}
	@PostMapping("/editpurchase")
	public ModelAndView showGetEditpurchasePage(@RequestParam("editformdate") String selDate,HttpSession session) {
		System.out.println(selDate);
		//List<Purchase> purchase= pRepo.findAll();
		String gstNo=(String) session.getAttribute("partygstno");
		String month=selDate.substring(0, 2);
		String year=selDate.substring(3, 7);
		System.out.println(gstNo+"-"+month+"-"+year);
		List<Purchase> purchase =pRepo.findByGstnoandinvdate(gstNo, month, year);
		System.out.println(purchase);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("editpurchase");
		mav.addObject("purchase", purchase);
		return mav;
	}
	@PostMapping("/editsales")
	public ModelAndView showGetEditsalesPage(@RequestParam("editformdate") String selDate,HttpSession session) {
		System.out.println(selDate);
		String gstNo=(String) session.getAttribute("partygstno");
		String month=selDate.substring(0, 2);
		String year=selDate.substring(3, 7);
		System.out.println(gstNo+"-"+month+"-"+year);
		List<Sales> sales =sRepo.findByGstnoandinvdate(gstNo, month, year);
		System.out.println(sales);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("editpurchase");
		mav.addObject("purchase", sales);
		return mav;
	}
	@RequestMapping(value="/edit/{inv_no}",method=RequestMethod.GET)   
	public String editPurchase(@PathVariable("inv_no") String invNo, Model model) {
		Purchase purchase = pRepo.findByInvno(invNo);   
        model.addAttribute("command",purchase);  
        return "editpurchaseform";    
    } 
//	@RequestMapping(value="/editsave")    
//	public ResponseEntity<Object> editSave(@RequestBody List<Purchase> purchase,HttpSession session){		
//		ServiceResponse<List<Purchase>> response;	
//       pRepo.save(purchase);    
//        return "editpurchase";    
//    }    
	@RequestMapping(value="/editsavepurchase",method=RequestMethod.GET)
	public String updatePurchase(@PathVariable("inv_no") String invNo, @Valid Purchase purchase, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        purchase.setInv_no(invNo);
	        return "editpurchase";
	    }
	         
	   pRepo.save(purchase);
	    model.addAttribute("purchase", pRepo.findAll());
	    return "editpurchase";
	}
	     
	@GetMapping("/delete/{inv_no}")
	public String deletePurchase(@PathVariable("inv_no") String invNo, Model model) {
	    Purchase purchase = pRepo.findByInvno(invNo);
	    pRepo.delete(purchase);
	    model.addAttribute("purchase", pRepo.findAll());
	    return "editpurchase";    
	}
	
	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format,HttpSession session) {
		
		return reportService.exportReport(session,format);
	}
}
