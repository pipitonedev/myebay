package it.prova.service.acquisto;

import java.util.List;

import it.prova.dao.acquisto.AcquistoDAO;
import it.prova.model.Acquisto;

public class AcquistoServiceImpl implements AcquistoService {
	
	private AcquistoDAO acquistoDAO;

	@Override
	public List<Acquisto> listAllElements() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acquisto caricaSingoloElemento(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
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
