package it.prova.web.servlet.annuncio;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import it.prova.model.Annuncio;
import it.prova.model.Utente;
import it.prova.service.MyServiceFactory;


@WebServlet("/user/ExecuteUpdateAnnuncioServlet")
public class ExecuteUpdateAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExecuteUpdateAnnuncioServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("idAnnuncio");
		String testoAnnuncioParam = request.getParameter("testoAnnuncio");
		String prezzoParam = request.getParameter("prezzo");
		String[] categorieParam = request.getParameterValues("categoria");
		
		Annuncio example = new Annuncio(Long.parseLong(idParam), testoAnnuncioParam, Integer.parseInt(prezzoParam));

		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			if(StringUtils.isBlank(example.getTestoAnnuncio()) || example.getPrezzo() < 0){
				request.setAttribute("update_annuncio_attr", example);
				request.setAttribute("categorie_list_attribute",
						MyServiceFactory.getCategoriaServiceInstance().listAll());
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
				request.getRequestDispatcher("/annuncio/update.jsp").forward(request, response);
				return;
			}
			Annuncio annuncioInstance = MyServiceFactory.getAnnuncioServiceInstance().caricaSingoloElemento(Long.parseLong(idParam));
			if (!annuncioInstance.isAperto()) {
				request.setAttribute("errorMessage", "Attenzione l'annuncio non è più disponibile!");
				request.getRequestDispatcher("/home").forward(request, response);
				return;
			}
			
			example.setDataAnnuncio(new Date());
			example.setAperto(true);
			example.setUtenteInserimento((Utente)httpRequest.getSession().getAttribute("userInfo"));
			
			for (String categoriaItem : categorieParam) {
				example.getCategorie().add(MyServiceFactory.getCategoriaServiceInstance().caricaSingoloElemento(Long.parseLong(categoriaItem)));
			}
			
			MyServiceFactory.getAnnuncioServiceInstance().aggiorna(example);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/home").forward(request, response);
			return;
		}
		response.sendRedirect("ExecuteListAnnuncioUtenteServlet?operationResult=SUCCESS");
	}
}
