package it.prova.web.servlet.annuncio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrepareSearchAnnuncioServlet")
public class PrepareSearchAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareSearchAnnuncioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/annuncio/cerca.jsp").forward(request, response);
	}

}
