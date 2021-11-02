package it.prova.dao.annuncio;

import java.util.List;
import java.util.Optional;

import it.prova.dao.IBaseDAO;
import it.prova.model.Annuncio;
import it.prova.model.Utente;

public interface AnnuncioDAO extends IBaseDAO<Annuncio>{
	public Optional<Annuncio> findOneEager(Long id) throws Exception;
	
	public List<Annuncio> findByExample(Annuncio example) throws Exception;
	
	public List<Annuncio> findByExampleEager(Annuncio example, String[] categorie) throws Exception;
	
	public List<Annuncio> findByUtente(Utente example) throws Exception;
	
}
