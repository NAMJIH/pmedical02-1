package com.jihoon.pmedical.vo;

public class PmedicalVo {
	private long no;
	private String name;
	private String gender;
	private String tel;
	private String status;
	private String date;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "PmedicalVo [no=" + no + ", name=" + name + ", gender=" + gender + ", tel=" + tel + ", status=" + status
				+ ", date=" + date + "]";
	}
	
	
}
