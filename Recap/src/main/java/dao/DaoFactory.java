package dao;

public abstract class DaoFactory {
	public abstract PersonaDao getPersonaDao();
	
	public static DaoFactory getDaoFactory() {
		return new JPADaoFactory();
	}
}
