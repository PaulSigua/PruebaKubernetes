package ec.edu.upd.sd.Universidades.dao;

import java.util.List;

import ec.edu.upd.sd.Universidades.model.Universidades;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UniversidadDAO {

	@PersistenceContext
private EntityManager em;
	
	public void insert(Universidades Universidades) {
		em.persist(Universidades);
	}
	
	public void update(Universidades Universidades) {
		em.merge(Universidades);
	}
	
	public void remove(int codigo) {
		Universidades Universidades = em.find(Universidades.class, codigo);
		em.remove(Universidades);
	}
	
	public Universidades read(int codigo) {
		Universidades Universidades = em.find(Universidades.class, codigo);
		return Universidades;
	}
	
	public List<Universidades> getAll(){
		String jpql = "SELECT c FROM Universidades c";
		Query q = em.createQuery(jpql, Universidades.class);
		return q.getResultList();
	}
}
