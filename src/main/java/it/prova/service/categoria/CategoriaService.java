package it.prova.service.categoria;

import java.util.List;

import it.prova.dao.categoria.CategoriaDAO;
import it.prova.model.Categoria;

public interface CategoriaService {
	
	public List<Categoria> listAllElements() throws Exception;

	public Categoria caricaSingoloElemento(Long id) throws Exception;
	
	public void aggiorna(Categoria categoriaInstance) throws Exception;

	public void inserisciNuovo(Categoria categoriaInstance) throws Exception;

	public void rimuovi(Categoria categoriaInstance) throws Exception;
	
	public Categoria cercaPerDescrizioneECodice(String descrizione, String codice) throws Exception;
	
	//per injection
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);

}
