package it.prova.web.servlet.annuncio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.exceptions.ElementNotFoundException;
import it.prova.model.Annuncio;
import it.prova.service.MyServiceFactory;

@WebServlet("/user/ExecuteDeleteAnnuncioServlet")
public class ExecuteDeleteAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ExecuteDeleteAnnuncioServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idAnnuncioParam = request.getParameter("idAnnuncio");

		if (!NumberUtils.isCreatable(idAnnuncioParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore. (id)");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}

		try {
			Annuncio annuncioInstance = MyServiceFactory.getAnnuncioServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idAnnuncioParam));
			if (!annuncioInstance.isAperto()) {
				request.setAttribute("errorMessage", "Attenzione l'annuncio non è più disponibile!");
				request.getRequestDispatcher("/home").forward(request, response);
				return;
			}

			MyServiceFactory.getAnnuncioServiceInstance().rimuovi(Long.parseLong(idAnnuncioParam));
		} catch (ElementNotFoundException e) {
			request.getRequestDispatcher("ExecuteListAnnuncioUtenteServlet?operationResult=NOT_FOUND").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		response.sendRedirect("ExecuteListAnnuncioUtenteServlet?operationResult=SUCCESS");
	}

}
