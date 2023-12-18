package model;

public class Member {
	private String id;
	private String password;
	private String passcheck;
	private String name;
	private String email;
	private String nickname;
	private String tel;
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
	public String getPassCheck() {
		return passcheck;
	}
	public void setPassCheck(String passcheck) {
		this.passcheck = passcheck;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", passcheck=" + passcheck + ", name=" + name + ", email="
				+ email + ", nickname=" + nickname + ", tel=" + tel + "]";
	}
	
	
	
	
}

