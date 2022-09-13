package com.sang.ManageEmployee.model.DTO;

import java.util.Date;

public class JsonTokenResponse {
	private String token;
	private Date expiredDate;

	public JsonTokenResponse() {

	}

	public JsonTokenResponse(String token, Date expiredDate) {
		this.token = token;
		this.expiredDate = expiredDate;
	}

	public String getToken() {
		return token;
	}

//	public void setToken(String token) {
//		this.token = token;
//	}
	public Date getExpiredDate() {
		return expiredDate;
	}
//	public void setExpiredDate(Date expiredDate) {
//		this.expiredDate = expiredDate;
//	}

}
