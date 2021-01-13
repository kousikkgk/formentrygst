package com.kousik.formentrygst.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Purchase {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="invno")
	private String inv_no;
	
	@Transient
	private String date;

	@Column(name="invdate")
	private LocalDate loclaDate;
	
	@Column(name="party")
	private String party_name;
	
	@Column(name="gstno")
	private String gst_no;
	
	@Column(name="taxval")
	private double tax_val;
	
	@Column(name="taxper")
	private double tax_per;
	
	@Column(name="cgstval")
	private double cgst_val;
	
	@Column(name="sgstval")
	private double sgst_val;
	
	@Column(name="igstval")
	private double igst_val;
	
	@Column(name="total")
	private double total;
	
	@Column(name="state")
	private String state;
	
	@Column(name="partygstno")
	private String partygstno;
	
	public String getInv_no() {
		return inv_no;
	}
	public void setInv_no(String inv_no) {
		this.inv_no = inv_no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public LocalDate getLoclaDate() {
		return loclaDate;
	}
	public void setLoclaDate(LocalDate loclaDate) {
		this.loclaDate = loclaDate;
	}
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	public String getGst_no() {
		return gst_no;
	}
	public void setGst_no(String gst_no) {
		this.gst_no = gst_no;
	}
	public double getTax_val() {
		return tax_val;
	}
	public void setTax_val(double tax_val) {
		this.tax_val = tax_val;
	}
	public double getTax_per() {
		return tax_per;
	}
	public void setTax_per(double tax_per) {
		this.tax_per = tax_per;
	}
	public double getCgst_val() {
		return cgst_val;
	}
	public void setCgst_val(double cgst_val) {
		this.cgst_val = cgst_val;
	}
	public double getSgst_val() {
		return sgst_val;
	}
	public void setSgst_val(double sgst_val) {
		this.sgst_val = sgst_val;
	}
	public double getIgst_val() {
		return igst_val;
	}
	public void setIgst_val(double igst_val) {
		this.igst_val = igst_val;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPartygstno() {
		return partygstno;
	}
	public void setPartygstno(String partygstno) {
		this.partygstno = partygstno;
	}
	@Override
	public String toString() {
		return "Purchase [inv_no=" + inv_no + ", date=" + date + ", loclaDate=" + loclaDate + ", party_name="
				+ party_name + ", gst_no=" + gst_no + ", tax_val=" + tax_val + ", tax_per=" + tax_per + ", cgst_val="
				+ cgst_val + ", sgst_val=" + sgst_val + ", igst_val=" + igst_val + ", total=" + total + ", state="
				+ state + ", partygstno=" + partygstno + "]";
	}
	
	
}
