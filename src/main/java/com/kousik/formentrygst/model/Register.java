package com.kousik.formentrygst.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="partymaster")
public class Register {
	@Id
	@Column(name="partygstno")
	private String gstnumber;
	
	@Column(name="partyname")
	private String partyname;
	
	public String getGstnumber() {
		return gstnumber;
	}
	public void setGstnumber(String gstnumber) {
		this.gstnumber = gstnumber;
	}
	public String getPartyname() {
		return partyname;
	}
	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}
	@Override
	public String toString() {
		return "Register [gstnumber=" + gstnumber + ", partyname=" + partyname + "]";
	}
	
	
}
