package com.kousik.formentrygst.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kousik.formentrygst.model.Register;

public interface RegisterRepo extends JpaRepository<Register, String>{
	@Query(value="select partyname from  partymaster WHERE partygstno= ?", nativeQuery = true)
	public String findBygstnumber(String gstNo);
}
