package it.prova.service.annuncio;

import java.util.List;

import it.prova.dao.acquisto.AcquistoDAO;
import it.prova.dao.annuncio.AnnuncioDAO;
import it.prova.dao.categoria.CategoriaDAO;
import it.prova.dao.utente.UtenteDAO;
import it.prova.model.Annuncio;
import it.prova.model.Utente;

public interface AnnuncioService {
	public List<Annuncio> listAll() throws Exception;

	public Annuncio caricaSingoloElemento(Long id) throws Exception;
	
	public Annuncio caricaSingoloElementoEager(Long id) throws Exception;

	public void aggiorna(Annuncio annuncioInstance) throws Exception;

	public void inserisciNuovo(Annuncio annuncioInstance) throws Exception;
	
	public void inserisciNuovoConCategorie(Annuncio annuncioInstance, String[] categorieInstance) throws Exception;

	public void rimuovi(Annuncio annuncioInstance) throws Exception;
	
	public List<Annuncio> findByExample(Annuncio example) throws Exception;
	
	public List<Annuncio> findByExampleEager(Annuncio example) throws Exception;
	
	public List<Annuncio> findByUtente(Utente example) throws Exception;
	
	public void rimuovi(Long idAnnuncioToRemove) throws Exception;
	
	public void acquista (String id, Utente utenteInstance) throws Exception;
	
	
	// per injection
	public void setAnnuncioDAO(AnnuncioDAO annuncioDAO);
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
	public void setUtenteDAO(UtenteDAO utenteDAO);
	public void setAcquistoDAO(AcquistoDAO acquistoDAO);
}
