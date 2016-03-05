package de.sauriel.nexus.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class DbUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email", unique = true, length = 30)
	private String email;

	@Column(name = "hash", length = 60)
	private String hash;

	@Column(name = "register_date")
	private Date registerDate;

	@Column(name = "active")
	private boolean active;

	public DbUser() {
	}

	public DbUser(String email, String hash) {
		this.email = email;
		this.hash = hash;
		this.registerDate = new Date();
		this.active = true;
	}

	public DbUser(int id, String email, String hash, Date registerDate, boolean active) {
		this.id = id;
		this.email = email;
		this.hash = hash;
		this.registerDate = registerDate;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
