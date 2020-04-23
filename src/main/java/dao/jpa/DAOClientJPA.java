package dao.jpa;

import java.util.List;

import dao.DAOClient;
import model.ClientA;

public class DAOClientJPA implements DAOClient {

	@Override
	public void insert(ClientA t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClientA selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientA> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ClientA t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClientA selectByAdresseMail(String adresseMail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientA checkConnect(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inscription(String login, String password, String adresseMail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClientA checkMail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

}
