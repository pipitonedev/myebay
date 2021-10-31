package it.prova.dao.categoria;

import it.prova.dao.IBaseDAO;
import it.prova.model.Categoria;

public interface CategoriaDAO extends IBaseDAO<Categoria> {
	
	public Categoria findByDescrizioneAndCodice(String descrizione, String codice) throws Exception;

}
