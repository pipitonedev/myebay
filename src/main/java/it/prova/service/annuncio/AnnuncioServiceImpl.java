package it.prova.service.annuncio;

import java.util.List;

import it.prova.dao.annuncio.AnnuncioDAO;
import it.prova.model.Annuncio;

public class AnnuncioServiceImpl implements AnnuncioService {
	
	private AnnuncioDAO annuncioDAO;

	@Override
	public List<Annuncio> listAllElements() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Annuncio caricaSingoloElemento(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Annuncio caricaSingoloElementoConAcquisto(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Annuncio annuncioInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserisciNuovo(Annuncio annuncioInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rimuovi(Annuncio annuncioInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Annuncio> findByExample(Annuncio example) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rimuovi(Long idAnnuncioToRemove) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAnnuncioDAO(AnnuncioDAO annuncioDAO) {
		this.annuncioDAO = annuncioDAO;
		
	}

}
