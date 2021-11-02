package it.prova.web.servlet.utente;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.model.StatoUtente;
import it.prova.model.Utente;
import it.prova.service.MyServiceFactory;
import it.prova.utility.UtilityForm;

@WebServlet("/admin/ExecuteInsertUtenteServlet")
public class ExecuteInsertUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertUtenteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String usernameParam = request.getParameter("username");
		String passwordParam = request.getParameter("password");
		String confermaPasswordParam = request.getParameter("conpassword");
		String creditoParam = request.getParameter("creditoResiduo");

		Utente example = new Utente(usernameParam, passwordParam, nomeParam, cognomeParam,
				Integer.parseInt(creditoParam));

		try {
			if (!passwordParam.equals(confermaPasswordParam)) {
				request.setAttribute("insert_utente_attr", example);
				request.setAttribute("ruoli_list_attribute", MyServiceFactory.getRuoloServiceInstance().listAll());
				request.setAttribute("errorMessage", "Attenzione, le due password non sono uguali!");
				request.getRequestDispatcher("/utente/insert.jsp").forward(request, response);
				return;
			}

			example.setDateCreated(new Date());
			example.setStato(StatoUtente.CREATO);

			if (!UtilityForm.validateUtenteBean(example)) {
				request.setAttribute("insert_utente_attr", example);
				request.setAttribute("ruoli_list_attribute", MyServiceFactory.getRuoloServiceInstance().listAll());
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
				request.getRequestDispatcher("/utente/insert.jsp").forward(request, response);
				return;
			}

			MyServiceFactory.getUtenteServiceInstance().inserisciNuovo(example);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("").forward(request, response);
			return;
		}
		response.sendRedirect("ExecuteListUtenteServlet?operationResult=SUCCESS");
	}
}
