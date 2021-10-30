package it.prova.dao.ruolo;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import it.prova.model.Ruolo;

public class RuoloDAOImpl implements RuoloDAO {
	
	private EntityManager entityManager;

	@Override
	public List<Ruolo> list() throws Exception {
		return entityManager.createQuery("from Ruolo", Ruolo.class).getResultList();
	}

	@Override
	public Optional<Ruolo> findOne(Long id) throws Exception {
		Ruolo result = entityManager.find(Ruolo.class, id);
		return result != null ? Optional.of(result) : Optional.empty();
	}

	@Override
	public void update(Ruolo input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Ruolo input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Ruolo input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		// TODO Auto-generated method stub
		
	}

}
