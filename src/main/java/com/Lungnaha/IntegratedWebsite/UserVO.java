package com.Lungnaha.IntegratedWebsite;

// 회원 정보를 관리하는 VO 클래스
public class UserVO {
	// 데이터는 보안을 강화하기 위해 private로 관리하기!
	private String id;
	private String password;
	private String name;
	private String role;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	// 데이터 출력을 위해 오버라이딩 -> 이것을 해주지 않으면 객체 주소를 출력
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}
	
	
}
