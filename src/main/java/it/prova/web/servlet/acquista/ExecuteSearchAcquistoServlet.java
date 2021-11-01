package it.prova.web.servlet.acquista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.model.Acquisto;
import it.prova.model.Utente;
import it.prova.utility.UtilityForm;
import it.prova.service.MyServiceFactory;

@WebServlet("/user/ExecuteSearchAcquistoServlet")
public class ExecuteSearchAcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteSearchAcquistoServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String descrizioneParam = request.getParameter("descrizione");
		String prezzoParam = request.getParameter("prezzo");
		String dataInserimentoParam = request.getParameter("data");

		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			Utente utenteInSessione = (Utente) httpRequest.getSession().getAttribute("userInfo");
			Acquisto example = new Acquisto(descrizioneParam, Integer.parseInt(prezzoParam),
					UtilityForm.parseDateArrivoFromString(dataInserimentoParam), utenteInSessione);

			request.setAttribute("acquisto_list_attribute",
					MyServiceFactory.getAcquistoServiceInstance().findByExampleEager(example));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/acquista/cerca.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/acquista/lista.jsp").forward(request, response);
	}

}
