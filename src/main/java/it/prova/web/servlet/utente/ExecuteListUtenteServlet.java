package it.prova.web.servlet.utente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import it.prova.service.MyServiceFactory;

@WebServlet("/admin/ExecuteListUtenteServlet")
public class ExecuteListUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteListUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String operationResult = request.getParameter("operationResult");
			if (StringUtils.isNotBlank(operationResult) && operationResult.equalsIgnoreCase("SUCCESS"))
				request.setAttribute("successMessage", "Operazione effettuata con successo");

			request.setAttribute("utente_list_attribute", MyServiceFactory.getUtenteServiceInstance().listAll());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/utente/lista.jsp").forward(request, response);
	}

}
