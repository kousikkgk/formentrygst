package com.kousik.formentrygst.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kousik.formentrygst.model.Purchase;


public interface PurchaseRepo extends JpaRepository<Purchase, Long> {
	
	@Query(value="select * from purchase WHERE invno= ?", nativeQuery = true)
	public Purchase findByInvno(String invNo);
	
	@Query(value="select * from purchase WHERE partygstno= ?1 and MONTH(invdate)= ?2 and YEAR(invdate) = ?3 ", nativeQuery = true)
	public List<Purchase> findByGstnoandinvdate(String gstNo,String month,String year);

	@Query(value="select SUM(taxval) from purchase WHERE partygstno= ?1 and MONTH(invdate)= ?2 and YEAR(invdate) = ?3 ", nativeQuery = true)
	public Optional<Double> findByTaxValMonthandYear(String gstNo,String month,String year);
	
	@Query(value="select SUM(igstval) from purchase WHERE partygstno= ?1  and MONTH(invdate)= ?2 and YEAR(invdate) = ?3", nativeQuery = true)
	public Optional<Double> findByIgstValMonthandYear(String gstNo,String date,String year);
	
	@Query(value="select SUM(sgstval) from purchase WHERE partygstno= ?1 and MONTH(invdate)= ?2 and YEAR(invdate) = ?3 ", nativeQuery = true)
	public Optional<Double> findBySgstValMonthandYear(String gstNo,String month,String year);
	
	@Query(value="select SUM(cgstval) from purchase WHERE partygstno= ?1 and MONTH(invdate)= ?2 and YEAR(invdate) = ?3 ", nativeQuery = true)
	public Optional<Double> findByCgstValMonthandYear(String gstNo,String month,String year);
	
	@Query(value="select SUM(cgstval) from purchase WHERE partygstno= ?1 and MONTH(invdate)= ?2 and YEAR(invdate) = ?3 ", nativeQuery = true)
	public List<Purchase> findyByInvNo();
	
	@Query(value="select * from purchase WHERE invno= ?1 and gstno= ?2 and partygstno= ?3 and MONTH(invdate)= ?4 and YEAR(invdate) = ?5 ", nativeQuery = true)
	public List<Purchase> findByInvNo(String invNo,String gstNo,String partyGstNo,String month,String year);
}
