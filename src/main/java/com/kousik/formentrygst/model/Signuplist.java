package com.kousik.formentrygst.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="signuplist")
public class Signuplist {
	
	@Column(name="partyname")
	private String partyName;
	
	@Column(name="mobileno")
	private String mobileNo;
	
	@Id
//	@GeneratedValue(generator = "uuid")
//	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="gstuserid")
	private String gstId;
	
	@Column(name="password")
	private String gstPass;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mailpass")
	private String emailPass;

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGstId() {
		return gstId;
	}

	public void setGstId(String gstId) {
		this.gstId = gstId;
	}

	public String getGstPass() {
		return gstPass;
	}

	public void setGstPass(String gstPass) {
		this.gstPass = gstPass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailPass() {
		return emailPass;
	}

	public void setEmailPass(String emailPass) {
		this.emailPass = emailPass;
	}

	@Override
	public String toString() {
		return "Signuplist [partyName=" + partyName + ", mobileNo=" + mobileNo + ", gstId=" + gstId + ", gstPass="
				+ gstPass + ", email=" + email + ", emailPass=" + emailPass + "]";
	}
	
	
}
