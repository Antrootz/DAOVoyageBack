package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.DAOClient;
import model.Client;
import model.ClientA;
import model.ClientNA;
import model.Site;

public class DAOClientJDBC implements DAOClient {


	public void insert(ClientA c) {

		try (
				Connection connect=Site.getInstance().getConnection();
				PreparedStatement ps = connect.prepareStatement("INSERT INTO client (login, password, adresseMail) VALUES (?,?,?)");
				)
		{
			ps.setString(1,  c.getLogin());
			ps.setString(2,  c.getPassword());
			ps.setString(3,  c.getAdresseMail());

			ps.executeUpdate();
			System.out.println("Client ajouté à la base de données");
		}
		catch(Exception e) {System.out.println("Erreur -> Client non ajouté");}
	}


	public ClientA selectByAdresseMail(String adresseMail) {
		ClientA c=null;

		try (
				Connection connect=Site.getInstance().getConnection();
				PreparedStatement ps = connect.prepareStatement("SELECT * FROM client WHERE adresseMail=?");
				)    {
			ps.setString(1,  adresseMail);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c = new ClientA(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("adresseMail"));
			}
		}
		catch(Exception e) {System.out.println("Erreur -> Vérification de l'adresse mail ne marche pas");}
		return c;
	}
	public List<ClientA> selectAll() {
		//nope
		return null;
	}

	public void update(ClientA c) {
		//plus tard
	}

	public void delete(Integer adresseMail) {
		//plus tard
	}

	public ClientA checkConnect(String login, String password) {
		ClientA c = null;
		try (
				Connection connect=Site.getInstance().getConnection();
				PreparedStatement ps = connect.prepareStatement("SELECT * FROM client WHERE login=? and password=?");
				)    {

			ps.setString(1,  login);
			ps.setString(2,  password);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				c = new ClientA(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("adresseMail"));}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erreur -> Connexion impossible");}
		return c;
	}

	@Override
	public ClientA selectById(Integer id) {
		//Pas recherche de client via l'id ..
		return null;
	}

	public void inscription(String login, String password, String adresseMail) {

		try (
				Connection connect=Site.getInstance().getConnection();
				PreparedStatement ps = connect.prepareStatement("INSERT INTO client (login,password,adresseMail) VALUES (?,?,?)");
				)
		{
			ps.setString(1,  login);
			ps.setString(2,  password);
			ps.setString(3,  adresseMail);

			ps.executeUpdate();
			System.out.println("Client ajouté à la base de données");
		}
		catch(Exception e) {System.out.println("Erreur -> Client non ajouté");}
	}

	public ClientA checkMail(String mail) {
		ClientA c = null;
		try (
				Connection connect=Site.getInstance().getConnection();
				PreparedStatement ps = connect.prepareStatement("SELECT * FROM client WHERE adresseMail=?");
				)    {
			ps.setString(1,  mail);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c = new ClientA(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("adresseMail"));}
		}
		catch(Exception e) {System.out.println("Erreur -> trycatch checkMail DAOClient");}
		return c;
	}
}
