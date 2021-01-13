package com.kousik.formentrygst.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kousik.formentrygst.model.Sales;


public interface SalesRepo extends JpaRepository<Sales, Long>{
	
	 public static final EntityManager entityManager = null;
	@Query(value="select * from sales WHERE invno= ?", nativeQuery = true)
	public Sales findByInvno(String invNo);
	
	@Query(value="select * from sales WHERE partygstno= ?1 and MONTH(invdate)= ?2 and YEAR(invdate) = ?3 ", nativeQuery = true)
	public List<Sales> findByGstnoandinvdate(String gstNo,String month,String year);
	
	@Query(value="select SUM(taxval) from sales WHERE partygstno= ?1 and MONTH(invdate)= ?2 and YEAR(invdate) = ?3", nativeQuery = true)
	public Optional<Double> findByTaxValMonthandYear(String gstNo,String month,String year);

	@Query(value="select SUM(igstval) from sales WHERE partygstno= ?1 and MONTH(invdate)= ?2 and YEAR(invdate) = ?3", nativeQuery = true)
	public Optional<Double> findByIgstValMonthandYear(String gstNo,String date,String year);
	
	@Query(value="select SUM(sgstval) from sales WHERE partygstno= ?1 and MONTH(invdate)= ?2 and YEAR(invdate) = ?3", nativeQuery = true)
	public Optional<Double> findBySgstValMonthandYear(String gstNo,String month,String year);
	
	@Query(value="select SUM(cgstval) from sales WHERE partygstno= ?1 and  MONTH(invdate)= ?2 and YEAR(invdate) = ?3", nativeQuery = true)
	public Optional<Double> findByCgstValMonthandYear(String gstNo,String month,String year);
	
	@Query(value="select * from sales WHERE invno= ?1 and gstno= ?2 and partygstno= ?3 and MONTH(invdate)= ?4 and YEAR(invdate) = ?5 ", nativeQuery = true)
	public List<Sales> findByInvNo(String invNo,String gstNo,String partyGstNo,String month,String year);
}
