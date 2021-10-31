package it.prova.web.listener;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import it.prova.model.Ruolo;
import it.prova.model.StatoUtente;
import it.prova.model.Utente;
import it.prova.service.MyServiceFactory;
import it.prova.service.ruolo.RuoloService;
import it.prova.service.utente.UtenteService;

@WebListener
public class LocalEntityManagerFactoryListener implements ServletContextListener {

	private static EntityManagerFactory entityManagerFactory;

	public void contextDestroyed(ServletContextEvent sce) {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	}

	public void contextInitialized(ServletContextEvent sce) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("myebay_unit");
			// questa chiamata viene fatta qui per semplicità ma in genere è meglio trovare
			// altri modi per fare init
			initAdminUserAndRuoli();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			throw new IllegalStateException("Context is not initialized yet.");
		}
		return entityManagerFactory.createEntityManager();

	}

	public static void closeEntityManager(EntityManager em) {
		if (em != null) {
			try {
				if (em.isOpen()) {
					em.close();
				}
			} catch (PersistenceException ex) {
				System.err.println("Could not close JPA EntityManager" + ex);
			} catch (Throwable ex) {
				System.err.println("Unexpected exception on closing JPA EntityManager" + ex);
			}
		}
	}

	private void initAdminUserAndRuoli() throws Exception {
		RuoloService ruoloServiceInstance = MyServiceFactory.getRuoloServiceInstance();
		UtenteService utenteServiceInstance = MyServiceFactory.getUtenteServiceInstance();

		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN") == null) {
			ruoloServiceInstance.inserisciNuovo(new Ruolo("Administrator", "ROLE_ADMIN"));
		}

		if (ruoloServiceInstance.cercaPerDescrizioneECodice("User", "CLASSIC_USER_ROLE") == null) {
			ruoloServiceInstance.inserisciNuovo(new Ruolo("User", "CLASSIC_USER_ROLE"));
		}

		if (utenteServiceInstance.findByUsernameAndPassword("admin", "admin") == null) {
			Utente admin = new Utente("admin", "admin", "Mario", "Rossi", new Date(), 100);
			admin.setStato(StatoUtente.ATTIVO);
			utenteServiceInstance.inserisciNuovo(admin);
			utenteServiceInstance.aggiungiRuolo(admin,
					ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN"));
		}

		if (utenteServiceInstance.findByUsernameAndPassword("user", "user") == null) {
			Utente user = new Utente("user", "user", "Francesco", "Totti", new Date(), 1000);
			user.setStato(StatoUtente.ATTIVO);
			utenteServiceInstance.inserisciNuovo(user);
			utenteServiceInstance.aggiungiRuolo(user,
					ruoloServiceInstance.cercaPerDescrizioneECodice("user", "CLASSIC_USER_ROLE"));
		}
	}

}