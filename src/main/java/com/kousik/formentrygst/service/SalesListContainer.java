package com.kousik.formentrygst.service;

import java.util.List;

import com.kousik.formentrygst.model.Sales;

public class SalesListContainer {
	
	private List<Sales> salesList;

	public List<Sales> getSalesList() {
		return salesList;
	}

	public void setSalesList(List<Sales> salesList) {
		this.salesList = salesList;
	}

	@Override
	public String toString() {
		return "SalesListContainer [salesList=" + salesList + "]";
	}
	
	
}
