package com.semainier.model;

import javax.persistence.*;

@Entity
@Table(name="tblusers")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, columnDefinition = "varchar(45)")
	private String username;

	@Column(nullable = false, columnDefinition = "varchar(64)")
	private String password;

	@Column(nullable = false, columnDefinition = "varchar(45)")
	private String role;

	@Column(nullable = true, columnDefinition = "int")
	private Integer enabled;

	public Users() {}
	public Users(Integer id) {
		this.id = id;
	}

	public Users(String username, String password, String role, Integer enabled) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Localite " +
				"[id=" + id +
				", username=" + username +
				", password=" + password +
				", role=" + role +
				", enabled=" + enabled + "]";
	}

}
