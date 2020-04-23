package app;

import dao.DAOClient;
import dao.jpa.DAOJpa;
import model.ClientA;
import model.Site;

public class TestEmf {

	public static void main(String[] args) {
		DAOClient daoC = Site.getInstance().getDaoClient();
		
		ClientA c = (ClientA) Site.getInstance().checkConnect("LeBizut", "ajc");
		System.out.println(c);
		
		
		
//		Medecin medecin = (Medecin) daoCompte.selectById(2);
//		
//		Patient patient = new Patient(487569354, "Potter", "Harry");
//		Visite visite = new Visite(medecin,patient);
//		
//		daoPatient.insert(patient);
//		daoVisite.insert(visite);

		

		DAOJpa.close();
		
	
	
	}
	

}
