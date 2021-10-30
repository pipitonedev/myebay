package it.prova.dao.categoria;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import it.prova.model.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {
	
	private EntityManager entityManager;

	@Override
	public List<Categoria> list() throws Exception {
		return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
	}

	@Override
	public Optional<Categoria> findOne(Long id) throws Exception {
		Categoria result = entityManager.find(Categoria.class, id);
		return result != null ? Optional.of(result) : Optional.empty();
	}

	@Override
	public void update(Categoria input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Categoria input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Categoria input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		// TODO Auto-generated method stub
		
	}

}
