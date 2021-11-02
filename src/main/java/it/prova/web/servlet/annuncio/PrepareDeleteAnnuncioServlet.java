package it.prova.web.servlet.annuncio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.model.Annuncio;
import it.prova.service.MyServiceFactory;

@WebServlet("/user/PrepareDeleteAnnuncioServlet")
public class PrepareDeleteAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrepareDeleteAnnuncioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAnnuncioParam = request.getParameter("idAnnuncio");

		if (!NumberUtils.isCreatable(idAnnuncioParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("").forward(request, response);
			return;
		}

		try {
			Annuncio annuncioInstance = MyServiceFactory.getAnnuncioServiceInstance()
					.caricaSingoloElementoEager(Long.parseLong(idAnnuncioParam));

			if (annuncioInstance == null) {
				request.setAttribute("errorMessage", "Elemento non trovato.");
				request.getRequestDispatcher("ExecuteListAnnuncioUtenteServlet?operationResult=NOT_FOUND").forward(request,
						response);
				return;
			}

			request.setAttribute("show_annuncio_attr", annuncioInstance);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/annuncio/delete.jsp").forward(request, response);
	}


}
