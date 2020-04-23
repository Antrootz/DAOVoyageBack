package dao.jpa;

import java.util.List;

import dao.DAOClient;
import model.ClientA;
import model.Ville;
import model.ClientA;

public class DAOClientJPA extends DAOJpa implements DAOClient {

	@Override
	public void insert(ClientA object) {
		try {
			this.em.getTransaction().begin();		//On pense à démarrer la transaction
			this.em.persist(object);
			this.em.getTransaction().commit();		//On pense à commit la transaction
		}
		catch (Exception e) {this.em.getTransaction().rollback();System.out.println("insert ClientA pas marcher");}
	}

	@Override
	public ClientA selectById(Integer id) {
		return this.em.find(ClientA.class, id);
	}

	@Override
	public List<ClientA> selectAll() {
		return this.em.createQuery("select c from ClientA c", ClientA.class).getResultList();
	}

	@Override
	public void update(ClientA object) {
		try {
			this.em.getTransaction().begin();
			this.em.merge(object);
			this.em.getTransaction().commit();
		}
		catch (Exception e) {this.em.getTransaction().rollback();System.out.println("update ClientA pas marcher");}
	}

	@Override
	public void delete(Integer id) {
		try {
			ClientA ClientAToRemove = new ClientA();
			ClientAToRemove.setId(id);

			this.em.getTransaction().begin();
			this.em.remove(this.em.merge(ClientAToRemove));		//On attache car le ClientA n'est pas attaché
			this.em.getTransaction().commit();
		}
		catch (Exception e) {this.em.getTransaction().rollback();System.out.println("delete ClientA pas marcher");}
	}

	@Override
	public ClientA selectByAdresseMail(String adresseMail) {
		try {
			return this.em.createQuery("select c from ClientA c where c.adresseMail=?1", ClientA.class).setParameter(1, adresseMail).getSingleResult();
		} catch (Exception e) {return null;}
	}

	@Override
	public ClientA selectByLoginPassword(String login, String password) {
		try {
			return this.em.createQuery("select c from ClientA c where c.login=?1 and c.password=?2", ClientA.class).setParameter(1, login).setParameter(2, password).getSingleResult();
		} catch (Exception e) {return null;}
	}

}
