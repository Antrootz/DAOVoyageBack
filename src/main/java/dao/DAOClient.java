package dao;

import model.ClientA;

public interface DAOClient extends DAO<ClientA,Integer> {
	
	public ClientA selectByAdresseMail(String adresseMail);
	
	public ClientA selectByLoginPassword(String login, String password);
	
}
