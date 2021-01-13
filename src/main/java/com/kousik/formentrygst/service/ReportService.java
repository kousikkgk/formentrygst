package com.kousik.formentrygst.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kousik.formentrygst.dao.PurchaseRepo;
import com.kousik.formentrygst.dao.StudentDao;
import com.kousik.formentrygst.model.Purchase;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Service
public class ReportService {
	
	@Autowired
	private StudentDao pRepo;
	
	@Autowired
	private PurchaseRepo purRepo;
	
	public String exportReport(HttpSession session, String reportFormat) {
//		List<Student> purchase=pRepo.findAll();
		List<Purchase> purchase=purRepo.findAll();
		
		String outPath = "C:\\Users\\kkousik\\Documents\\My Received Files\\Jasper\\"+"Jasper_out1.pdf";
		String outPath1 = "C:\\Users\\kkousik\\Documents\\My Received Files\\Jasper\\"+"purchase.pdf";
		LocalDate date = null;
		for(Purchase purObj:purchase) {
			date = purObj.getLoclaDate();
		}
		System.out.println(date.getMonth());
		System.out.println(date.getYear());
		System.out.println(date.getMonthValue());
		JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(purchase);
		Map<String, Object> map = new HashMap<>();
//		map.put("CollectionBeanParam", source);
		
		map.put("monthyear", date.getMonth()+" "+date.getYear());
		map.put("title", session.getAttribute("partyname"));
		map.put("PParam", source);
		
		try {
			InputStream stream = new FileInputStream(new File("C:\\Users\\kkousik\\Documents\\My Received Files\\Jasper\\Purchase.jrxml"));
			JasperDesign design = JRXmlLoader.load(stream);
			JasperReport report = JasperCompileManager.compileReport(design);
			JasperPrint print = JasperFillManager.fillReport(report, map,new JREmptyDataSource());
			JasperExportManager.exportReportToPdfFile(print,outPath1);
//			JasperViewer.viewReport(print);
		} catch (FileNotFoundException | JRException e) {
			e.printStackTrace();
		}
		
		return "report generated print,\"C:\\\\Users\\\\kkousik\\\\Documents\\\\My Received Files\\\\Jasper";
	}
}
