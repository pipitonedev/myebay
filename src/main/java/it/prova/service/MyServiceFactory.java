package it.prova.service;

import it.prova.dao.acquisto.AcquistoDAO;
import it.prova.dao.acquisto.AcquistoDAOImpl;
import it.prova.dao.annuncio.AnnuncioDAO;
import it.prova.dao.annuncio.AnnuncioDAOImpl;
import it.prova.dao.categoria.CategoriaDAO;
import it.prova.dao.categoria.CategoriaDAOImpl;
import it.prova.dao.ruolo.RuoloDAO;
import it.prova.dao.ruolo.RuoloDAOImpl;
import it.prova.dao.utente.UtenteDAO;
import it.prova.dao.utente.UtenteDAOImpl;
import it.prova.service.acquisto.AcquistoService;
import it.prova.service.acquisto.AcquistoServiceImpl;
import it.prova.service.annuncio.AnnuncioService;
import it.prova.service.annuncio.AnnuncioServiceImpl;
import it.prova.service.categoria.CategoriaService;
import it.prova.service.categoria.CategoriaServiceImpl;
import it.prova.service.ruolo.RuoloService;
import it.prova.service.ruolo.RuoloServiceImpl;
import it.prova.service.utente.UtenteService;
import it.prova.service.utente.UtenteServiceImpl;

public class MyServiceFactory {
	
	private static AcquistoService ACQUISTO_SERVICE_INSTANCE;
	private static AcquistoDAO ACQUISTO_DAO_INSTANCE;
	private static UtenteService UTENTE_SERVICE_INSTANCE;
	private static UtenteDAO UTENTE_DAO_INSTANCE = null;
	private static RuoloService RUOLO_SERVICE_INSTANCE;
	private static RuoloDAO RUOLO_DAO_INSTANCE = null;
	private static AnnuncioService ANNUNCIO_SERVICE_INSTANCE = null;
	private static AnnuncioDAO ANNUNCIO_DAO_INSTANCE = null;
	private static CategoriaService CATEGORIA_SERVICE_INSTANCE = null;
	private static CategoriaDAO CATEGORIA_DAO_INSTANCE = null;
	
	
	public static AcquistoService getAcquistoServiceInstance() {
		if (ACQUISTO_SERVICE_INSTANCE == null)
			ACQUISTO_SERVICE_INSTANCE = new AcquistoServiceImpl();

		if (ACQUISTO_DAO_INSTANCE == null)
			ACQUISTO_DAO_INSTANCE = new AcquistoDAOImpl();

		ACQUISTO_SERVICE_INSTANCE.setAcquistoDAO(ACQUISTO_DAO_INSTANCE);

		return ACQUISTO_SERVICE_INSTANCE;
	}
	
	public static UtenteService getUtenteServiceInstance() {
		if (UTENTE_SERVICE_INSTANCE == null)
			UTENTE_SERVICE_INSTANCE = new UtenteServiceImpl();

		if (UTENTE_DAO_INSTANCE == null)
			UTENTE_DAO_INSTANCE = new UtenteDAOImpl();
		
		if (RUOLO_SERVICE_INSTANCE == null)
			RUOLO_SERVICE_INSTANCE = new RuoloServiceImpl();
		
		if (RUOLO_DAO_INSTANCE == null)
			RUOLO_DAO_INSTANCE = new RuoloDAOImpl();
		
		UTENTE_SERVICE_INSTANCE.setUtenteDAO(UTENTE_DAO_INSTANCE);
		UTENTE_SERVICE_INSTANCE.setRuoloDAO(RUOLO_DAO_INSTANCE);
		return UTENTE_SERVICE_INSTANCE;
	}
	
	public static RuoloService getRuoloServiceInstance() {
		if (RUOLO_SERVICE_INSTANCE == null)
			RUOLO_SERVICE_INSTANCE = new RuoloServiceImpl();

		if (RUOLO_DAO_INSTANCE == null)
			RUOLO_DAO_INSTANCE = new RuoloDAOImpl();

		RUOLO_SERVICE_INSTANCE.setRuoloDAO(RUOLO_DAO_INSTANCE);
		return RUOLO_SERVICE_INSTANCE;
	}
	
	public static AnnuncioService getAnnuncioServiceInstance() {
		if (ANNUNCIO_SERVICE_INSTANCE == null)
			ANNUNCIO_SERVICE_INSTANCE = new AnnuncioServiceImpl();

		if (ANNUNCIO_DAO_INSTANCE == null)
			ANNUNCIO_DAO_INSTANCE = new AnnuncioDAOImpl();

		ANNUNCIO_SERVICE_INSTANCE.setAnnuncioDAO(ANNUNCIO_DAO_INSTANCE);

		return ANNUNCIO_SERVICE_INSTANCE;
	}
	
	public static CategoriaService getCategoriaServiceInstance() {
		if (CATEGORIA_SERVICE_INSTANCE == null)
			CATEGORIA_SERVICE_INSTANCE = new CategoriaServiceImpl();

		if (CATEGORIA_DAO_INSTANCE == null)
			CATEGORIA_DAO_INSTANCE = new CategoriaDAOImpl();

		CATEGORIA_SERVICE_INSTANCE.setCategoriaDAO(CATEGORIA_DAO_INSTANCE);

		return CATEGORIA_SERVICE_INSTANCE;
	}


}
