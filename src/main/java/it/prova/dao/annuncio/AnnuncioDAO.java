package it.prova.dao.annuncio;

import java.util.List;

import it.prova.dao.IBaseDAO;
import it.prova.model.Annuncio;

public interface AnnuncioDAO extends IBaseDAO<Annuncio> {
	
	List<Annuncio> findByExample(Annuncio example) throws Exception;
}
