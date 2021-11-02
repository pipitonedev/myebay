package it.prova.web.servlet.annuncio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.prova.service.MyServiceFactory;

@WebServlet("/user/PrepareUpdateAnnuncioServlet")
public class PrepareUpdateAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareUpdateAnnuncioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idAnnuncioInput = Long.parseLong(request.getParameter("idAnnuncio"));

		try {
			request.setAttribute("update_annuncio_attr",
					MyServiceFactory.getAnnuncioServiceInstance().caricaSingoloElemento(idAnnuncioInput));
			request.setAttribute("categorie_list_attribute", MyServiceFactory.getCategoriaServiceInstance().listAll());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/annuncio/update.jsp").forward(request, response);
	}

}
