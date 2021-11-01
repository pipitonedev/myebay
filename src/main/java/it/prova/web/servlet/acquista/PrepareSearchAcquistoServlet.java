package it.prova.web.servlet.acquista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PrepareSearchAcquistoServlet")
public class PrepareSearchAcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public PrepareSearchAcquistoServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/acquista/cerca.jsp").forward(request, response);
	}


}
