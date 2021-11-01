package it.prova.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.model.Annuncio;
import it.prova.utility.UtilityForm;
import it.prova.service.MyServiceFactory;

@WebServlet("/ExecuteSearchAnnuncioServlet")
public class ExecuteSearchAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExecuteSearchAnnuncioServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String testoAnnuncioParam = request.getParameter("testoAnnuncio");
		String prezzoParam = request.getParameter("prezzo");
		String[] categoriaInputParam = request.getParameterValues("categoria");

		try {
			
			
			Annuncio example = new Annuncio( testoAnnuncioParam, Integer.parseInt(prezzoParam));
			request.setAttribute("annunci_list_attribute", MyServiceFactory.getAnnuncioServiceInstance().findByExample(example));
			request.setAttribute("categorie_list_attribute", MyServiceFactory.getCategoriaServiceInstance().listAll());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/listaAnnunci.jsp").forward(request, response);
	}


}
