package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class ClientA extends Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "adresse_mail")
	private String adresseMail;
	
	//---------------------------------------------------------//
	//---------------------------------------------------------//
	//---------------------------------------------------------//
	//---------------------------------------------------------//
	
	public ClientA(int id, String login, String password, String adresseMail) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.adresseMail = adresseMail;
	}
	
	public ClientA(String login, String password, String adresseMail) {
		this.login = login;
		this.password = password;
		this.adresseMail = adresseMail;
	}
	
	public ClientA() {
		
	}
	
	//---------------------------------------------------------//
	//---------------------------------------------------------//
	//---------------------------------------------------------//
	//---------------------------------------------------------//	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	
	//---------------------------------------------------------//
	//---------------------------------------------------------//
	//---------------------------------------------------------//
	//---------------------------------------------------------//	

	public void connect (String l, String p) {
		
	}
	
	//---------------------------------------------------------//
	//---------------------------------------------------------//
	//---------------------------------------------------------//
	//---------------------------------------------------------//	

	@Override
	public String toString() {
		return "ClientA [id=" + id + ", login=" + login + ", password=" + password + ", adresseMail=" + adresseMail
				+ "]";
	}
	
	
}
