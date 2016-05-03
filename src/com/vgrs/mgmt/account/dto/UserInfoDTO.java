package com.vgrs.mgmt.account.dto;

public class UserInfoDTO {

	private String username;
	private String password;
	private String email;
	private String name;
	private String role;
	private String status;

	public UserInfoDTO() {
	}

	public UserInfoDTO(String username, String password, String email, String name, String role, String status) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.role = role;
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return username + " = (" + name + ", " + email + ", " + role + ")";
	}
}
