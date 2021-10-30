package it.prova.service.utente;

import java.util.List;

import it.prova.dao.ruolo.RuoloDAO;
import it.prova.dao.utente.UtenteDAO;
import it.prova.model.Ruolo;
import it.prova.model.Utente;

public class UtenteServiceImpl implements UtenteService {
	
	private UtenteDAO utenteDAO;
	private RuoloDAO ruoloDAO;

	@Override
	public List<Utente> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente caricaSingoloElemento(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Utente utenteInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserisciNuovo(Utente utenteInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rimuovi(Utente utenteInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aggiungiRuolo(Utente utenteEsistente, Ruolo ruoloInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utente findByUsernameAndPassword(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente accedi(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findByExample(Utente example) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserisciNuovoUtenteConRuoli(Utente utenteInstance, String[] ruoli) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUtenteDAO(UtenteDAO utenteDAO) {
		this.utenteDAO = utenteDAO;
		
	}

	@Override
	public void setRuoloDAO(RuoloDAO ruoloDAO) {
		this.ruoloDAO = ruoloDAO;
		
	}

}
