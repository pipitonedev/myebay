package it.prova.web.servlet.utente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.model.Utente;
import it.prova.utility.UtilityForm;
import it.prova.service.MyServiceFactory;


@WebServlet("/admin/ExecuteSearchUtenteServlet")
public class ExecuteSearchUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExecuteSearchUtenteServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String usernameParam = request.getParameter("username");
		String dataCreazioneParam = request.getParameter("dataCreazione");

		Utente example = new Utente(usernameParam, nomeParam, cognomeParam, 
				UtilityForm.parseDateArrivoFromString(dataCreazioneParam));

		try {
			request.setAttribute("utente_list_attribute",
					MyServiceFactory.getUtenteServiceInstance().findByExample(example));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/utente/search.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/utente/lista.jsp").forward(request, response);
	}

}
