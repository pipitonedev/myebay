package it.prova.web.servlet.annuncio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.model.Annuncio;
import it.prova.model.Utente;
import it.prova.service.MyServiceFactory;
import it.prova.utility.UtilityForm;


@WebServlet("/user/ExecuteCercaAnnunciUtenteServlet")
public class ExecuteCercaAnnunciUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteCercaAnnunciUtenteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String testoAnnuncioParam = request.getParameter("testoAnnuncio");
		String prezzoParam = request.getParameter("prezzo");
		String dataInserimentoParam = request.getParameter("data");

		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			Utente utenteInSessione = (Utente) httpRequest.getSession().getAttribute("userInfo");
			Annuncio example = new Annuncio(testoAnnuncioParam, Integer.parseInt(prezzoParam),
					UtilityForm.parseDateArrivoFromString(dataInserimentoParam), utenteInSessione);

			request.setAttribute("annuncio_list_attribute",
					MyServiceFactory.getAnnuncioServiceInstance().findByExampleEager(example));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/annuncio/cerca.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/annuncio/listaannunciutente.jsp").forward(request, response);
	}

}
