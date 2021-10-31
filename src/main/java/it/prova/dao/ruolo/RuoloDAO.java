package it.prova.dao.ruolo;

import it.prova.dao.IBaseDAO;
import it.prova.model.Ruolo;

public interface RuoloDAO extends IBaseDAO<Ruolo> {
	
	public Ruolo findByDescrizioneAndCodice(String descrizione, String codice) throws Exception;
}
