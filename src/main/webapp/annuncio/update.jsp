<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Ricerca</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Modifica Elemento</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="${pageContext.request.contextPath}/user/ExecuteUpdateAnnuncioServlet" class="row g-3" >
							
								<input type="hidden" name="idAnnuncio" value="${update_annuncio_attr.id}">
								<div class="col-md-6">
									<label>Testo Annuncio<span class="text-danger">*</span></label>
									<input type="text" name="testoAnnuncio" id="testoAnnuncio" class="form-control" placeholder="Inserire il testo dell'annuncio " value="${update_annuncio_attr.testoAnnuncio}" >
								</div>
								
								<div class="col-md-6">
									<label>Prezzo:<span class="text-danger">*</span></label>-
									<input type="text" name="prezzo" id="prezzo" class="form-control" placeholder="Inserire il prezzo" value="${update_annuncio_attr.prezzo }" >
								</div>
								
								<div class="col-md-6">
								<label>Categorie<span class="text-danger">*</span></label><br>
								<c:forEach items="${categorie_list_attribute}" var="categoriaItem">
										<input type="checkbox" name="categoria" value="${categoriaItem.id}">${categoriaItem.descrizione}<br>
									</c:forEach>
								</div>
								
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
								 <a href="ExecuteListAnnuncioUtenteServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a>
							</div>
		
						</form>
  
				    
				    
					<!-- end card-body -->			   
				    </div>
				<!-- end card -->
				
				</div>		
					  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>