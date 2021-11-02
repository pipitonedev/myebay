package it.prova.service.annuncio;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import it.prova.dao.acquisto.AcquistoDAO;
import it.prova.dao.annuncio.AnnuncioDAO;
import it.prova.dao.categoria.CategoriaDAO;
import it.prova.dao.utente.UtenteDAO;
import it.prova.exceptions.CreditoInsufficiente;
import it.prova.exceptions.ElementNotFoundException;
import it.prova.model.Acquisto;
import it.prova.model.Annuncio;
import it.prova.model.Utente;
import it.prova.web.listener.LocalEntityManagerFactoryListener;

public class AnnuncioServiceImpl implements AnnuncioService {
	private AnnuncioDAO annuncioDAO;
	private CategoriaDAO categoriaDAO;
	private AcquistoDAO acquistoDAO;
	private UtenteDAO utenteDAO;

	@Override
	public List<Annuncio> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			annuncioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return annuncioDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Annuncio caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			annuncioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return annuncioDAO.findOne(id).orElse(null);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Annuncio annuncioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			annuncioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			annuncioDAO.update(annuncioInstance);

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
	public void inserisciNuovo(Annuncio annuncioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			annuncioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			annuncioDAO.insert(annuncioInstance);

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
	public void rimuovi(Annuncio annuncioInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			annuncioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			annuncioDAO.delete(annuncioInstance);

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
	public void setAnnuncioDAO(AnnuncioDAO annuncioDAO) {
		this.annuncioDAO = annuncioDAO;
	}

	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}

	@Override
	public List<Annuncio> findByExample(Annuncio example) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			annuncioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return annuncioDAO.findByExample(example);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Annuncio> findByExampleEager(Annuncio example, String[] categorie) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			annuncioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return annuncioDAO.findByExampleEager(example, categorie);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Annuncio> findByUtente(Utente example) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			annuncioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return annuncioDAO.findByUtente(example);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovoConCategorie(Annuncio annuncioInstance, String[] categorieInstance) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			annuncioDAO.setEntityManager(entityManager);
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			annuncioDAO.insert(annuncioInstance);

			for (String categoriaItem : categorieInstance) {
				annuncioInstance.getCategorie().add(categoriaDAO.findOne(Long.parseLong(categoriaItem)).orElse(null));
			}

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
	public Annuncio caricaSingoloElementoEager(Long id) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			annuncioDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return annuncioDAO.findOneEager(id).orElse(null);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void setUtenteDAO(UtenteDAO utenteDAO) {
		this.utenteDAO = utenteDAO;

	}

	@Override
	public void setAcquistoDAO(AcquistoDAO acquistoDAO) {
		this.acquistoDAO = acquistoDAO;

	}

	@Override
	public void rimuovi(Long idAnnuncioToRemove) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			annuncioDAO.setEntityManager(entityManager);
			Annuncio annuncioToRemove = annuncioDAO.findOne(idAnnuncioToRemove).orElse(null);
			if (annuncioToRemove == null)
				throw new ElementNotFoundException("Annuncio con id: " + idAnnuncioToRemove + " non trovato.");

			annuncioDAO.delete(annuncioToRemove);
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
	public void acquista(String id, Utente utenteInstance) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			annuncioDAO.setEntityManager(entityManager);
			acquistoDAO.setEntityManager(entityManager);
			utenteDAO.setEntityManager(entityManager);

			Annuncio annuncioDaAcquistare = annuncioDAO.findOne(Long.parseLong(id)).orElse(null);

			if (annuncioDaAcquistare == null)
				throw new ElementNotFoundException("Annuncio con id: " + id + " non trovato.");

			if (utenteInstance.getCreditoResiduo() < annuncioDaAcquistare.getPrezzo())
				throw new CreditoInsufficiente("Credito Residuo Insufficiente per effettuare l'acquisto");

			int sottrazioneCredito = utenteInstance.getCreditoResiduo() - annuncioDaAcquistare.getPrezzo();

			utenteInstance.setCreditoResiduo(sottrazioneCredito);

			utenteDAO.update(utenteInstance);

			annuncioDaAcquistare.setAperto(false);

			Acquisto acquistoDaCreare = new Acquisto(annuncioDaAcquistare.getTestoAnnuncio(),
					annuncioDaAcquistare.getPrezzo(), new Date(), utenteInstance);

			acquistoDAO.insert(acquistoDaCreare);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}
}
