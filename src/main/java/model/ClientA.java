package model;

public class ClientA extends Client {
	
	private int id;
	private String login, password, adresseMail;
	
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
