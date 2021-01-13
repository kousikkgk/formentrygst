package com.kousik.formentrygst.dao;

public class ServiceResponse<T> {
	private String response;
	private T data;
	
	
	public ServiceResponse(String response, T data) {
		super();
		this.response = response;
		this.data = data;
	}
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "ServiceResponse [response=" + response + ", data=" + data + "]";
	}
	
	
}
