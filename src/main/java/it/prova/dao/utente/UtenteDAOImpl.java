package it.prova.dao.utente;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import it.prova.model.Utente;

public class UtenteDAOImpl implements UtenteDAO {
	
	private EntityManager entityManager;

	@Override
	public List<Utente> list() throws Exception {
		return entityManager.createQuery("from Utente", Utente.class).getResultList();
	}

	@Override
	public Optional<Utente> findOne(Long id) throws Exception {
		Utente result = entityManager.find(Utente.class, id);
		return result != null ? Optional.of(result) : Optional.empty();
	}

	@Override
	public void update(Utente input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Utente input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Utente input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		// TODO Auto-generated method stub
		
	}

}
