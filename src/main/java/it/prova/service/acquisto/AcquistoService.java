package it.prova.service.acquisto;

import java.util.List;

import it.prova.dao.acquisto.AcquistoDAO;
import it.prova.model.Acquisto;

public interface AcquistoService {
	public List<Acquisto> listAll() throws Exception;

	public Acquisto caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Acquisto acquistoInstance) throws Exception;

	public void inserisciNuovo(Acquisto acquistoInstance) throws Exception;

	public void rimuovi(Acquisto acquistoInstance) throws Exception;
	
	public List<Acquisto> findByExampleEager(Acquisto example) throws Exception;
	
	// per injection
	public void setAcquistoDAO(AcquistoDAO acquistoDAO);
}
