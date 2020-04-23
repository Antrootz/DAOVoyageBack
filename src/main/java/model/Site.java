package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.DAOClient;
import dao.DAOVille;
import dao.jdbc.DAOClientJDBC;
import dao.jdbc.DAOVilleJDBC;

public class Site {

    LinkedList<Voyage> voyage = new LinkedList();
    LinkedList<Voyage> panier = new LinkedList();
    private Connection connection=null;
    private static Site _instance=null;
    
    private DAOClient daoC = new DAOClientJDBC();
    private DAOVille daoV = new DAOVilleJDBC();

    private Site() {
    }

    public DAOClient getDaoC() {
        return daoC;
    }

    public DAOVille getDaoV() {
        return daoV;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");
        return connection;
    }

    public LinkedList<Voyage> getVoyage() {
		return voyage;
	}

	public void setVoyage(LinkedList<Voyage> voyage) {
		this.voyage = voyage;
	}

	public LinkedList<Voyage> getPanier() {
		return panier;
	}

	public void setPanier(LinkedList<Voyage> panier) {
		this.panier = panier;
	}

	public static Site getInstance() {

        if(_instance==null) {
            _instance = new Site();
        }
        return _instance;
    }

    public LinkedList<Voyage> getRecherche() {
        return voyage;
    }

    public Client checkConnect(String login, String password) {
        DAOClientJDBC daoC = new DAOClientJDBC();
        Client c = daoC.checkConnect(login, password);
        return c;
    }
    
    public void listVilleDispo() {
    	DAOVilleJDBC daoV = new DAOVilleJDBC();
		List<Ville> ville = daoV.selectAll();
		int i = 0;
		for (Ville v : ville) {
			i++;
			System.out.println(i+"- "+v.getNom());
		}
    }
    
    public void inscription(ClientA c) {
        DAOClientJDBC daoC = new DAOClientJDBC();
        daoC.insert(c);
    }
    
    public void research(Ville v1){

        DAOVilleJDBC daoV = new DAOVilleJDBC();
        List<Ville> ville = daoV.selectAll();

        for(Ville v2 : ville)
        {
            if(!v2.getNom().equals(v1.getNom()))
            {
                for (Transport t : Transport.values())
                {
                    Voyage voy = new Voyage(v1,v2,t);
                    Site.getInstance().voyage.add(voy);
                }
            }
        }
    }
	
	public void research(Ville v1,Ville v2) {

        for (Transport t : Transport.values())
        {
        Voyage v = new Voyage(v1,v2,t);
        Site.getInstance().voyage.add(v);
        }
    }
	
	public void research(Ville v1,Ville v2,Transport t) {
        Voyage v = new Voyage(v1,v2,t);
        Site.getInstance().voyage.add(v);
    }
	
	public void choix(Voyage voy)
    {
        Site.getInstance().panier.add(voy);
        System.out.println("Panier garni !");
    }
	
	public void paiement () {
		System.out.println("Paiement effectué ! Merci Jordan.");
		Site.getInstance().getPanier().clear();
	}
	

}