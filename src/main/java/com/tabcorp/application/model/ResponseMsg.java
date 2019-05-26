package com.tabcorp.application.model;

public class ResponseMsg {

	private Integer returnCode;
	private String status;
	private String message;
	private Object data;
	
	public ResponseMsg() {
		
	}
	
	public ResponseMsg(Integer returnCode, String status, String message, Object data) {
		super();
		this.returnCode = returnCode;
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	public Integer getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
