package dao;

import java.util.List;

import entity.Persona;

public interface PersonaDao {
	List<Persona> selectAll();
	Persona findById(long id);
	boolean insert(Persona p);
	boolean update(Persona p);
	boolean delete(Persona p);
}
