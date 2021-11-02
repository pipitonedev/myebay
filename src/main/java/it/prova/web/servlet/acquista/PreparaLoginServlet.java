package it.prova.web.servlet.acquista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

@WebServlet("/PreparaLoginServlet")
public class PreparaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PreparaLoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idAnnuncioInput = request.getParameter("idAnnuncio");

		if (!NumberUtils.isCreatable(idAnnuncioInput)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("").forward(request, response);
			return;
		}

		try {
			request.setAttribute("id_annuncio_attr", idAnnuncioInput);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("").forward(request, response);
			return;
		}

		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
