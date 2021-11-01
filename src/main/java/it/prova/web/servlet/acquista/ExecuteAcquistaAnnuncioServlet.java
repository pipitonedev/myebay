package it.prova.web.servlet.acquista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.exceptions.CreditoInsufficiente;
import it.prova.exceptions.ElementNotFoundException;
import it.prova.model.Acquisto;
import it.prova.model.Utente;
import it.prova.service.MyServiceFactory;

@WebServlet("/user/ExecuteAcquistaAnnuncioServlet")
public class ExecuteAcquistaAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteAcquistaAnnuncioServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParam = request.getParameter("idAnnuncio");

		if (!NumberUtils.isCreatable(idParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore. (id)");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;

			MyServiceFactory.getAnnuncioServiceInstance().acquista(idParam,
					(Utente) httpRequest.getSession().getAttribute("userInfo"));

			Utente utenteInSessione = (Utente) httpRequest.getSession().getAttribute("userInfo");
			Acquisto example = new Acquisto(utenteInSessione);

			request.setAttribute("successMessage", "Acquisto effettuato con successo!");
			request.setAttribute("acquisto_list_attribute",
					MyServiceFactory.getAcquistoServiceInstance().findByExampleEager(example));
		} catch (ElementNotFoundException e) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		} catch (CreditoInsufficiente e) {
			request.setAttribute("errorMessage", "Attenzione, credito residuo insufficiente.");
			request.getRequestDispatcher("/acquista/acquista.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/acquista/lista.jsp").forward(request, response);
	}

}
