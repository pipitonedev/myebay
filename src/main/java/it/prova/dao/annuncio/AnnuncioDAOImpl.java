package it.prova.dao.annuncio;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import it.prova.model.Annuncio;

public class AnnuncioDAOImpl implements AnnuncioDAO {
	
	private EntityManager entityManager;

	@Override
	public List<Annuncio> list() throws Exception {
		return entityManager.createQuery("from Annuncio", Annuncio.class).getResultList();
	}

	@Override
	public Optional<Annuncio> findOne(Long id) throws Exception {
		Annuncio result = entityManager.find(Annuncio.class, id);
		return result != null ? Optional.of(result) : Optional.empty();
	}

	@Override
	public void update(Annuncio input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Annuncio input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Annuncio input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		// TODO Auto-generated method stub
		
	}

}
