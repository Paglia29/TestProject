package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Persona;

public class JPAPersonaDao implements PersonaDao{
	private static JPAPersonaDao instance;
	private JPAPersonaDao() {}
	public static JPAPersonaDao getInstance() {
		if(instance==null) {
			instance = new JPAPersonaDao();
		}
		return instance;
	}

	@Override
	public List<Persona> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Persona p) {
		EntityManager em = JPADaoFactory.getManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(p);
			t.commit();
			return true;
		}catch(Exception e) {
			t.rollback();
		}finally {
			em.close();
		}
		return false;
	}

	@Override
	public boolean update(Persona p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Persona p) {
		// TODO Auto-generated method stub
		return false;
	}

}
