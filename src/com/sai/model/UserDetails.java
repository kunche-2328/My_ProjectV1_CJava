package com.sai.model;

public class UserDetails {
	private String first_name;
	private String last_name;
	private String mobile_number;
	private String gender;
	private String email_id;
	private String password;
	private int faild_count;
	private String status;
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name=first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name=last_name;
	}
	public String getMobile_namber() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number=mobile_number;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender=gender;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id=email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public int getFaild_count() {
		return faild_count;
	}
	public void setFaild_count(int faild_count) {
		this.faild_count=faild_count;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	public UserDetails(String first_name, String last_name, String mobile_number, String gender, String email_id,
			String password, int faild_count, String status) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile_number = mobile_number;
		this.gender = gender;
		this.email_id = email_id;
		this.password = password;
		this.faild_count = faild_count;
		this.status = status;
	}
	@Override
	public String toString() {
		return "UserDetails [first_name=" + first_name + ", last_name=" + last_name + ", mobile_number=" + mobile_number
				+ ", gender=" + gender + ", email_id=" + email_id + ", password=" + password + ", faild_count="
				+ faild_count + ", status=" + status + "]";
	}

}
