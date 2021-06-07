package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPADaoFactory extends DaoFactory{
	
	@Override
	public PersonaDao getPersonaDao() {
		return JPAPersonaDao.getInstance();
	}
	
	public static EntityManager getManager() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("EsempioPersona");
			return emf.createEntityManager();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
