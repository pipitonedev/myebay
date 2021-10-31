package it.prova.service.acquisto;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.dao.acquisto.AcquistoDAO;
import it.prova.model.Acquisto;
import it.prova.web.listener.LocalEntityManagerFactoryListener;

public class AcquistoServiceImpl implements AcquistoService {

	private AcquistoDAO acquistoDAO;

	@Override
	public List<Acquisto> listAllElements() throws Exception {
		
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			acquistoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return acquistoDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Acquisto caricaSingoloElemento(Long id) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			acquistoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return acquistoDAO.findOne(id).get();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Acquisto caricaSingoloElementoConUtente(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Acquisto acquistoInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserisciNuovo(Acquisto acquistoInstance) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			acquistoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			acquistoDAO.insert(acquistoInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void rimuovi(Acquisto acquistoInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Acquisto> findByExample(Acquisto example) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rimuovi(Long idAcquistoToRemove) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAcquistoDAO(AcquistoDAO acquistoDAO) {
		this.acquistoDAO = acquistoDAO;

	}

}
