package com.kousik.formentrygst.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Party {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="partygstno")
	private String partygstno;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="party_id",referencedColumnName = "id")
    private List<Purchase> purchases= new ArrayList<Purchase>();;

    
    
	public Party() {
	}

	public Party(String partygstno, List<Purchase> purchases) {
		super();
		this.partygstno = partygstno;
		this.purchases = purchases;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPartygstno() {
		return partygstno;
	}

	public void setPartygstno(String partygstno) {
		this.partygstno = partygstno;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	@Override
	public String toString() {
		return "Party [id=" + id + ", partygstno=" + partygstno + ", purchases=" + purchases + "]";
	}
	
	
}
