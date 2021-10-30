package it.prova.dao.acquisto;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import it.prova.model.Acquisto;

public class AcquistoDAOImpl implements AcquistoDAO {
	
	private EntityManager entityManager;

	@Override
	public List<Acquisto> list() throws Exception {
		return entityManager.createQuery("from Acquisto", Acquisto.class).getResultList();
	}

	@Override
	public Optional<Acquisto> findOne(Long id) throws Exception {
		Acquisto result = entityManager.find(Acquisto.class, id);
		return result != null ? Optional.of(result) : Optional.empty();
	}

	@Override
	public void update(Acquisto input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Acquisto input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Acquisto input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}

}
