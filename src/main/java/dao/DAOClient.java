package dao;

import model.ClientA;

public interface DAOClient extends DAO<ClientA,Integer> {
	
	public ClientA selectByAdresseMail(String adresseMail);
	
	public ClientA checkConnect(String login, String password);
	
	public void inscription(String login, String password, String adresseMail);
	
	public ClientA checkMail(String mail);
}
